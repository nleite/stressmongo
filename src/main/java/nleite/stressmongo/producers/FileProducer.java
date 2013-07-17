package nleite.stressmongo.producers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.mongodb.DBObject;

import nleite.stressmongo.producers.parsers.Parser;
import nleite.stressmongo.producers.parsers.ParserFactory;

public abstract class FileProducer implements Producer {
    
    protected final BufferedReader reader;
    protected final Parser parser;
    
    
    public FileProducer(final String filePath) throws FileNotFoundException {
        super();
        String extension = getExtension(filePath);
        parser = ParserFactory.giveMeAParser(extension);
        reader = new BufferedReader( new FileReader(filePath));
    }

    private String getExtension(final String filePath) {
        String extension = "json";
        int i = filePath.lastIndexOf('.');
        if (i > 0) {
            extension = filePath.substring(i+1);
        }
        return extension;
    }
    
    
}
