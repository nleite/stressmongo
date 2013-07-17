package nleite.stressmongo.producers.parsers;

public interface LineParser<T> extends Parser<T, String>{

    public T parse(final String line);
    
}
