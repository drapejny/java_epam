package by.drapejny.task3.util;

public class GeneratorID {
    private static long id = 0;

    private GeneratorID() {
    }

    public static long generateID() {
        return ++id;
    }
}
