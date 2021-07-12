package by.drapejny.task3.factory.impl;

import by.drapejny.task3.entity.Point;
import by.drapejny.task3.entity.Shape;
import by.drapejny.task3.entity.Sphere;
import by.drapejny.task3.exception.SphereException;
import by.drapejny.task3.factory.ShapeFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereFactory implements ShapeFactory {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Sphere create(double... params) throws SphereException {
        if (params.length != 4) {
            logger.error("Invalide number of params to create sphere");
            throw new SphereException();
        }
        if (params[3] <= 0) {
            logger.error("Negative radius");
            throw new SphereException();
        }
        Sphere sphere = new Sphere(params[0], params[1], params[2], params[3]);
        return sphere;
    }

    public Sphere create(Point center, double radius) throws SphereException {
        if(radius <= 0){
            logger.error("Negative radius");
            throw new SphereException();
        }
        Sphere sphere = new Sphere(center,radius);
        return sphere;
    }
}
