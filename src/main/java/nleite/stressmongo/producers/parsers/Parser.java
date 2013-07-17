package nleite.stressmongo.producers.parsers;

public interface Parser<T, I> {

    public T parse(I in);
}
