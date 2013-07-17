package nleite.stressmongo;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

public class UpdaterTest {

    private BaseWriteOperation obj;
    DBCollection collection;
    MongoClient mc;
    
    @Before
    public void setUp() throws Exception{
        mc = new MongoClient();
        
        collection = mc.getDB("test").getCollection("updates");
        collection.insert(new BasicDBObject("name", "you"));
        
        DBObject query = new BasicDBObject();
        query.put("name", "you");
        DBObject update = new BasicDBObject();
        update.put( "name", "me");
        
        obj = new Updater(collection, query, update);
    }
    
    @Test
    public void testGetResult() {
        obj = new Updater(collection, new BasicDBObject("name", "a" ), new BasicDBObject("name", "b"));
        this.obj.run();
        int expected = 0;
        int actual = this.obj.getResult().getN();
        
        assertEquals("not the same result!", expected, actual);
    }

    @Test
    public void testRun() {
        this.obj.setConcern(WriteConcern.ACKNOWLEDGED);
        this.obj.run();
        int expected = 1;
        int actual = this.obj.getResult().getN();
        assertEquals("Did not update!", expected, actual);
    }
    
    @Test
    public void testUpdateMultiFalgWithout$(){
        Map<String, Object> flags = new HashMap<String, Object>();
        flags.put("multi", Boolean.TRUE);
        DBObject query = new BasicDBObject("name", "you");
        DBObject update = new BasicDBObject( "$set", new BasicDBObject("lastname", "all") );
        this.obj = new Updater(collection, query, update, flags);
        
        this.obj.run();
        
        int expected = 1;
        int actual = this.obj.getResult().getN();
        
        assertEquals("Did not update no multi!", expected, actual);
    }
    
    public void testMultiple(){
        
        Thread th = new Thread(obj);
        
        th.start();
        
        int expected = 1;
        int actual = obj.getResult().getN();
        
        assertEquals("Did not run correctly as Thread!", expected, actual);
    }

    
    @After
    public void tearDown(){
        mc.getDB("test").dropDatabase();
        
    }
}
