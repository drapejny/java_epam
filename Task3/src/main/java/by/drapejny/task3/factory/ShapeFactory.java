package by.drapejny.task3.factory;

import by.drapejny.task3.entity.Shape;
import by.drapejny.task3.exception.SphereException;

public interface  ShapeFactory {

    public Shape create(double ... params) throws SphereException;
    
}
