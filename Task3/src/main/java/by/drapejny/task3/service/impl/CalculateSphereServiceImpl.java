package by.drapejny.task3.service.impl;

import by.drapejny.task3.Main;
import by.drapejny.task3.entity.Point;
import by.drapejny.task3.entity.Sphere;
import by.drapejny.task3.exception.SphereException;
import by.drapejny.task3.service.CalculateSphereService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculateSphereServiceImpl implements CalculateSphereService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public double calculateSquare(Sphere sphere) {
        double square = 4 * Math.PI * Math.pow(sphere.getRadius(), 2);
        return square;
    }

    @Override
    public double calculateVolume(Sphere sphere) {
        double volume = 4 * Math.PI * Math.pow(sphere.getRadius(), 3) / 3;
        return volume;
    }

    @Override
    public double calculateSurfaceArea(Sphere sphere) {
        double surfaceArea = 4 * Math.PI * sphere.getRadius() * sphere.getRadius();
        return surfaceArea;
    }

    @Override
    public double calculateSegmentRatio(Sphere sphere, Point point1, Point point2, Point point3) throws SphereException {
        double mx = sphere.getCenter().getX();
        double my = sphere.getCenter().getY();
        double mz = sphere.getCenter().getZ();
        double d1 = ((point2.getY() - point1.getY()) * (point3.getZ() - point1.getZ())) -
                ((point3.getY() - point1.getY()) * (point2.getZ() - point1.getZ()));
        double d2 = ((point2.getX() - point1.getX()) * (point3.getZ() - point1.getZ())) -
                ((point3.getX() - point1.getX()) * (point2.getZ() - point1.getZ()));
        double d3 = ((point2.getX() - point1.getX()) * (point3.getY() - point1.getY())) -
                ((point3.getX() - point1.getX()) * (point2.getY() - point1.getY()));
        double a = d1;
        double b = -d2;
        double c = d3;
        double d = -point1.getX() * d1 + point1.getY() * d2 - point1.getZ() * d3;
        double distance = Math.abs(a * mx + b * my + c * mz + d) /
                Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
        double ratio = 0;
        if (distance > sphere.getRadius()) {
            double r = Math.sqrt(Math.pow(sphere.getRadius(), 2) - Math.pow(distance, 2));
            double h = sphere.getRadius() - distance;
            double segmentVolume = Math.PI * h * (3 * r * r + h * h) / 6;
            ratio = segmentVolume / (calculateVolume(sphere) - segmentVolume);
        } else {
            logger.error("The plane does not intersect the sphere");
            throw new SphereException();
        }
        return ratio;
    }

    @Override
    public boolean isSphereTouchPlanes(Sphere sphere) {
        Point center = sphere.getCenter();
        double radius = sphere.getRadius();
        if (center.getX() == radius || center.getX() == -radius ||
                center.getY() == radius || center.getY() == -radius ||
                center.getZ() == radius || center.getZ() == -radius) {
            return true;
        }
        return false;
    }

}
