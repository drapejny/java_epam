package by.drapejny.task3.reader.impl;

import by.drapejny.task3.exception.SphereException;
import by.drapejny.task3.reader.FileLinesReader;
import by.drapejny.task3.validator.SphereLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileLinesReaderImpl implements FileLinesReader {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<String> readFileLines(String path) throws SphereException {
        List<String> lines;
        List<String> result = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new SphereException();
        }
        for (String line : lines) {
            if (SphereLineValidator.isCorrectSphereLine(line)) {
                result.add(line);
            }
        }
        return result;
    }
}
