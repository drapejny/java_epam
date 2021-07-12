package by.drapejny.task3.service;

import by.drapejny.task3.entity.Point;
import by.drapejny.task3.entity.Sphere;
import by.drapejny.task3.exception.SphereException;

public interface CalculateSphereService {

    public double calculateSquare(Sphere sphere);

    public double calculateVolume(Sphere sphere);

    public double calculateSurfaceArea(Sphere sphere);

    public double calculateSegmentRatio(Sphere sphere, Point p1, Point p2, Point p3) throws SphereException;

    public boolean isSphereTouchPlanes(Sphere sphere);
}
