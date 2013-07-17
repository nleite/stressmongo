package nleite.stressmongo.producers.parsers;

public class ParserFactory {

    
    public static final Parser giveMeAParser(final String extension){
        FileExtensions fe = FileExtensions.find(extension);
        if (fe != null){
            return fe.getParser();
        }
        return null;
    }
    
}


enum FileExtensions {
    JSON("json", new JSONLineParser());
    
    public final String extension;
    private final Parser parser;
    
    private FileExtensions(final String extension, final Parser parser) {
        this.extension = extension;
        this.parser = parser;
    }
    
    public Parser getParser(){
        return this.parser;
    }
    
    public static FileExtensions find(String extension){
        if ( JSON.extension.equals(extension)){
            return JSON;
        }
        return null;
    }
}