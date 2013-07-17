package nleite.stressmongo;

import com.mongodb.DBCollection;

public abstract class BaseOperation implements RunnableOperation {

    
    
    protected final DBCollection collection;

    public BaseOperation(DBCollection collection) {
        super();
        this.collection = collection;
    }

}
