package nleite.stressmongo.producers.parsers;

import java.text.MessageFormat;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class JSONLineParser implements LineParser<DBObject>{

//    final Logger log = LoggerFactory.getLogger(JSONLineParser.class);
    
    public DBObject parse(String line) {
        
        DBObject document = (DBObject) JSON.parse(line);
        
//        log.debug(MessageFormat.format(" Parsed {0} into {1} ", line, document ));
        System.out.println(MessageFormat.format(" Parsed {0} into {1} ", line, document ));
        return document;
        
    }
    
    
    
    
    
}
