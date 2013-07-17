package nleite.stressmongo.producers;

import static org.junit.Assert.*;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class FileInsertProducerTest {

    FileInsertProducer obj;
    DBCollection collection;
    BlockingQueue<Runnable> queue;
    @Before
    public void setUp() throws Exception {
        MongoClient mc = new MongoClient();
        
        queue = new ArrayBlockingQueue<Runnable>(5);
        
        collection = mc.getDB("test").getCollection(this.getClass().getCanonicalName());
        String filePath = "target/test-classes/FileInsertProducer.json";
        obj = new FileInsertProducer(filePath, queue, collection);
    }

    @Test
    public void testProducer() {
        obj.produce();
        int expected = 2;
        int actual = queue.size();
        
        assertEquals("Not in sync with the queue", expected, actual);
    }

    @After
    public void tearDown(){
        collection.drop();
    }
    
    
}
