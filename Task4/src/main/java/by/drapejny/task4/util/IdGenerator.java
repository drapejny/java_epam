package by.drapejny.task4.util;

public class IdGenerator {

    private static long id = 0;

    private IdGenerator(){}
    
    public static long generateId() {
        return ++id;
    }
}
