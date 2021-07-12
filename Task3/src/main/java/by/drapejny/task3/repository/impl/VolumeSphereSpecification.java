package by.drapejny.task3.repository.impl;

import by.drapejny.task3.entity.Sphere;
import by.drapejny.task3.repository.SphereSpecification;
import by.drapejny.task3.service.CalculateSphereService;
import by.drapejny.task3.service.impl.CalculateSphereServiceImpl;

public class VolumeSphereSpecification implements SphereSpecification {

    private double minVolume;
    private double maxVolume;

    private static final CalculateSphereService service = new CalculateSphereServiceImpl();

    public VolumeSphereSpecification(double minVolume, double maxVolume){
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }
    
    @Override
    public boolean specify(Sphere sphere) {
        double volume = service.calculateVolume(sphere);
        boolean result = volume >= minVolume && volume <= maxVolume;
        return result;
    }
}
