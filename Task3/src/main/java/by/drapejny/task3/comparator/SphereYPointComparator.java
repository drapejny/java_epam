package by.drapejny.task3.comparator;

import by.drapejny.task3.entity.Sphere;

import java.util.Comparator;

public class SphereYPointComparator implements Comparator<Sphere> {
    @Override
    public int compare(Sphere sphere1, Sphere sphere2) {
        int result = Double.compare(sphere1.getCenter().getY(), sphere2.getCenter().getY());
        return result;
    }
}
