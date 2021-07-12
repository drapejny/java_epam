package by.drapejny.task3.comparator;

import by.drapejny.task3.entity.Sphere;

import java.util.Comparator;

public class SphereXPointComparator implements Comparator<Sphere> {
    @Override
    public int compare(Sphere sphere1, Sphere sphere2) {
        int result = Double.compare(sphere1.getCenter().getX(), sphere2.getCenter().getX());
        return result;
    }
}
