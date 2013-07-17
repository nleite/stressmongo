package nleite.stressmongo;

import java.util.Map;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteConcern;
import com.mongodb.WriteResult;

public abstract class BaseWriteOperation extends BaseOperation implements WritableOperation  {

    protected static final String UPSERT = "upsert";
    protected static final String MULTI = "multi";
    protected final Map<String, Object> flags;
    protected WriteConcern concern = WriteConcern.NONE;
    protected WriteResult result;
    protected final DBObject action;

    public BaseWriteOperation(final DBCollection collection, final DBObject action, final Map<String, Object> flags) {
        super(collection);
        this.flags = flags;
        this.action = action;
    }

    /* (non-Javadoc)
     * @see nleite.stressmongo.WritableOperation#setConcern(com.mongodb.WriteConcern)
     */
    public void setConcern(final WriteConcern concern) {
        this.concern = concern;
    }

    /* (non-Javadoc)
     * @see nleite.stressmongo.WritableOperation#getResult()
     */
    public WriteResult getResult() {
        return result;
    }

}
