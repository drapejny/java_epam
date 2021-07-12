package by.drapejny.task3.reader;

import by.drapejny.task3.exception.SphereException;

import java.util.List;

public interface FileLinesReader {

    public List<String> readFileLines(String path) throws SphereException;
}
