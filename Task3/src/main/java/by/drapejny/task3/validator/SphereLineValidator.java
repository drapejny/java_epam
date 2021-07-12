package by.drapejny.task3.validator;

public class SphereLineValidator {
    private static final String CORRECT_SPHERE_LINE_REGEX = "^(-?\\d+\\.\\d+ +){3}\\d+\\.\\d+$";

    private SphereLineValidator() {
    }

    public static boolean isCorrectSphereLine(String line) {
        return line.matches(CORRECT_SPHERE_LINE_REGEX);
    }

}
