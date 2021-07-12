package by.drapejny.task3.repository.impl;

import by.drapejny.task3.entity.Sphere;
import by.drapejny.task3.repository.SphereSpecification;
import by.drapejny.task3.service.CalculateSphereService;
import by.drapejny.task3.service.impl.CalculateSphereServiceImpl;

public class SurfaceAreaSphereSpecification implements SphereSpecification {

    private double minSurfaceArea;
    private double maxSurfaceArea;

    private static final CalculateSphereService service = new CalculateSphereServiceImpl();

    public SurfaceAreaSphereSpecification(double minSurfaceArea, double maxSurfaceArea){
        this.minSurfaceArea = minSurfaceArea;
        this.maxSurfaceArea = maxSurfaceArea;
    }

    @Override
    public boolean specify(Sphere sphere) {
        double surfaceArea = service.calculateSurfaceArea(sphere);
        boolean result = surfaceArea >= minSurfaceArea && surfaceArea <= maxSurfaceArea;
        return result;
    }
}
