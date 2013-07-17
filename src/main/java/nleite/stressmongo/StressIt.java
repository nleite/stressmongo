package nleite.stressmongo;

import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import nleite.stressmongo.producers.FileInsertProducer;
import nleite.stressmongo.producers.Producer;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class StressIt {

    private final InputStreamReader in;
    private final PrintStream out;

    /**
     * Collect the full in and out streams for further and better unit testing.
     * 
     * @param in
     * @param out
     */
    public StressIt(InputStreamReader in, PrintStream out) {
        super();
        this.in = in;
        this.out = out;
    }

    public void parseArguments(String[] args) {

        // JSAP jsap = new JSAP();
        // FlaggedOption numberOfThreads = new FlaggedOption("--threads")
        // .setStringParser(JSAP.INETADDRESS_PARSER);
        //
        //
        //
        //
        // try {
        // jsap.registerParameter(numberOfThreads);
        // } catch (JSAPException e) {
        // out.printf("this is wrong {0}", args);
        // }
        // JSAPResult config = jsap.parse(args);
        //

    }

    public void execute() throws Exception {
        out.println("ok");

        String dbname = "test";
        String collectionName = "coll";
        // ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(arg0, arg1,
        // arg2, arg3, arg4)

        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
        MongoClient mc = new MongoClient();

        DBCollection collection = mc.getDB(dbname).getCollection(collectionName);
        
        String filePath = "/Users/norberto/Desktop/data/twitter.json";
        
        Producer producer = new FileInsertProducer(filePath, queue, collection);
        
        Thread th = new Thread(producer);
        th.start();
        
        
        out.println( "size of the queue "+ queue.size());
        ThreadPoolExecutor executor = new StressThreadPoolExecuter(2000, 2000, 2, TimeUnit.SECONDS, queue);
        
        executor.prestartAllCoreThreads();
        
        Thread.sleep(2000);
        
        out.println( "size of the queue "+ queue.size());
    }

}
