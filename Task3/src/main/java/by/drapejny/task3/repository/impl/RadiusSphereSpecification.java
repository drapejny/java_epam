package by.drapejny.task3.repository.impl;

import by.drapejny.task3.entity.Sphere;
import by.drapejny.task3.repository.SphereSpecification;

public class RadiusSphereSpecification implements SphereSpecification {

    private double minRadius;
    private double maxRadius;

    public RadiusSphereSpecification(double minRadius, double maxRadius){
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }

    @Override
    public boolean specify(Sphere sphere) {
        boolean result = sphere.getRadius() >= minRadius && sphere.getRadius() <= maxRadius;
        return result;
    }
}
