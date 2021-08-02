package by.drapejny.task5.reader;

import by.drapejny.task5.exception.TextComponentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextFileReader {

    private static final Logger logger = LogManager.getLogger();

    public String read(String filePath) throws TextComponentException {
        Path path = Path.of(filePath);
        try {
            String result = Files.readString(path);
            return result;
        } catch (IOException e) {
            logger.error("Unable to open file: " + filePath);
            throw new TextComponentException();
        }
    }
}
