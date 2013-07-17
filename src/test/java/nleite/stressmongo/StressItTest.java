package nleite.stressmongo;

import static org.junit.Assert.*;

import java.io.InputStreamReader;

import org.junit.Before;
import org.junit.Test;

public class StressItTest {

    
    StressIt obj;
    
    @Before
    public void setUp(){
        InputStreamReader inReader = new InputStreamReader(System.in);
        obj = new StressIt(inReader, System.out);
    }
    
    @Test
    public void testExecute() throws Exception {
        obj.execute();
    }

}
