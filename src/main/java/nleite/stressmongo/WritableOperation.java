package nleite.stressmongo;

import com.mongodb.WriteConcern;
import com.mongodb.WriteResult;

public interface WritableOperation {

    public abstract void setConcern(WriteConcern concern);

    public abstract WriteResult getResult();

}