package by.drapejny.task3.entity;

import by.drapejny.task3.util.GeneratorID;

public abstract class Shape {
    private long id;

    public Shape() {
        id = GeneratorID.generateID();
    }

    public long getId() {
        return id;
    }
}
