package by.drapejny.task2.builder;

import by.drapejny.task2.entity.Flower;
import by.drapejny.task2.exception.FlowerException;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractFlowerBuilder {
    protected Set<Flower> flowers;

    public AbstractFlowerBuilder() {
        flowers = new HashSet<>();
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

    public abstract void buildFlowers(String xmlPath);
}
