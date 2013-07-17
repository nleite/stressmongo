package nleite.stressmongo.producers.parsers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSONParseException;

public class JSONLineParserTest {
    
    JSONLineParser obj;

    @Before
    public void setUp() throws Exception {
        
        obj = new JSONLineParser();
    }

    @Test
    public void testParse() {
        String line = "{\"name\":\"fromJson\"}";
        DBObject actual = obj.parse(line);
        DBObject expected = new BasicDBObject("name", "fromJson");
        assertEquals("Not equaly parsed", expected, actual);
    }
    
    @Test
    public void testParse$setOperatorAsName() {
        String line = "{\"$set\":\"fromJson\"}";
        DBObject actual = obj.parse(line);
        DBObject expected = new BasicDBObject("$set", "fromJson");
        assertEquals("Not equaly parsed", expected, actual);
    }

    @Test(expected=JSONParseException.class)
    public void testParseIncorrectLine(){
        String notJsonLine = "orayti";
        obj.parse(notJsonLine);
    }
    
}
