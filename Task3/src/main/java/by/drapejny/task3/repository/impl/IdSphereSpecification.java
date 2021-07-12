package by.drapejny.task3.repository.impl;

import by.drapejny.task3.entity.Sphere;
import by.drapejny.task3.repository.SphereSpecification;

public class IdSphereSpecification implements SphereSpecification {

    private long minId;
    private long maxId;

    public IdSphereSpecification(long minId, long maxId) {
        this.minId = minId;
        this.maxId = maxId;
    }

    @Override
    public boolean specify(Sphere sphere) {
        boolean result = sphere.getId() >= minId && sphere.getId() <= maxId;
        return result;
    }
}
