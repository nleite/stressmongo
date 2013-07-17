package nleite.stressmongo;

import java.util.Map;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class Inserter extends BaseWriteOperation {

    public Inserter(DBCollection collection, DBObject document, Map<String, Object> flags) {
        super(collection, document, flags);
        
    }

    public void run() {
        
        result = collection.insert(action, concern);
        System.out.println("Running insert");
    }

}
