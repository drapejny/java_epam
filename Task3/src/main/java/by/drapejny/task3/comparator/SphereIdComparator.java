package by.drapejny.task3.comparator;

import by.drapejny.task3.entity.Sphere;

import java.util.Comparator;

public class SphereIdComparator implements Comparator<Sphere> {
    @Override
    public int compare(Sphere sphere1, Sphere sphere2) {
        int result = Long.compare(sphere1.getId(), sphere2.getId());
        return result;
    }
}
