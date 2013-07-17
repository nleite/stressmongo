package nleite.stressmongo.producers.parsers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParserFactoryTest {

    
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGiveMeAParserJSON() {
        String extension = "json";
        Parser actual = ParserFactory.giveMeAParser(extension);
        
        assertTrue( actual instanceof JSONLineParser );
    }
    
    @Test
    public void testGiveMeAParserTXT(){
        String extension = "txt";
        Parser actual = ParserFactory.giveMeAParser(extension);
        
        assertNull(actual);
    }

}
