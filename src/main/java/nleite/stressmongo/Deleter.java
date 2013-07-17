package nleite.stressmongo;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class Deleter extends BaseWriteOperation {

    public Deleter(DBCollection collection, DBObject query) {
        super(collection, query, null);
    }

    public void run() {
        result = this.collection.remove(action, concern);
        //TODO set log message
    }

}
