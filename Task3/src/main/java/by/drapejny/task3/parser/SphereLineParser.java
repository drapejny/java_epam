package by.drapejny.task3.parser;

import by.drapejny.task3.entity.Sphere;

import java.util.ArrayList;
import java.util.List;

public class SphereLineParser {

    private static final String SPLIT_SPHERE_LINE_REGEX = "\\s";

    public List<Double> parseSphereLine(String sphereLine) {
        List<Double> result = new ArrayList<>();
        String[] words = sphereLine.split(SPLIT_SPHERE_LINE_REGEX);
        for (int i = 0; i < words.length; i++) {
            result.add(Double.parseDouble(words[i]));
        }
        return result;
    }
}
