package nleite.stressmongo.producers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import nleite.stressmongo.Inserter;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class FileInsertProducer extends FileProducer {

    private final BlockingQueue<Runnable> queue;
    private final DBCollection collection;

    public FileInsertProducer(final String filePath, final BlockingQueue<Runnable> queue, final DBCollection collection)
            throws FileNotFoundException {
        super(filePath);
        this.queue = queue;
        this.collection = collection;
    }

    public void produce() {

        String line;
        try {
            line = reader.readLine();
            while (line != null) {
                
                DBObject document = (DBObject) this.parser.parse(line);
                Runnable job = new Inserter(collection, document, null);
                if ( !queue.offer(job))
                    //we will offer till there's room 
                if ( queue.offer(job)){
                    line = reader.readLine();
                } else {
                    System.out.println("NO ROOM LEFT Waiting ");
                    Thread.sleep(100);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        produce();
        
    }

}
