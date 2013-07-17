package nleite.stressmongo;

import java.text.MessageFormat;
import java.util.Map;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class Updater extends BaseWriteOperation{

    private final DBObject query;
    public Updater(final DBCollection collection, final DBObject query, final DBObject update,
            final Map<String, Object> flags) {
        super(collection, update, flags);
        this.query = query;
    }

    public Updater(DBCollection collection, DBObject query, DBObject update) {
        this(collection, query, update, null);
    }

    public void run() {

        boolean upsert = false;
        boolean multi = false;
        if (this.flags != null) {
            upsert = (this.flags.containsKey(UPSERT) ? (Boolean) this.flags.get(UPSERT) : upsert);
            //we can only use multi on $ operator
            multi = (this.flags.containsKey(MULTI) ? (Boolean) this.flags.get(MULTI) && this.action.toString().contains("$") : multi);
        }
        this.result = this.collection.update(query, action, upsert, multi, concern);

        // TODO change this to log message
        System.out.println(MessageFormat.format(
                " Executed 'UPDATE' with result {0} given query:{1} update: {2} and flags: {3} ", result, query,
                action, flags));
    }

}
