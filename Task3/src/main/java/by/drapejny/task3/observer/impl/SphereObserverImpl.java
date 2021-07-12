package by.drapejny.task3.observer.impl;

import by.drapejny.task3.entity.Sphere;
import by.drapejny.task3.entity.SphereParameter;
import by.drapejny.task3.entity.SphereWarehouse;
import by.drapejny.task3.observer.SphereEvent;
import by.drapejny.task3.observer.SphereObserver;
import by.drapejny.task3.service.CalculateSphereService;
import by.drapejny.task3.service.impl.CalculateSphereServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereObserverImpl implements SphereObserver {

    private static final Logger logger = LogManager.getLogger();

    private static SphereWarehouse warehouse = SphereWarehouse.getInstance();
    private static CalculateSphereService service = new CalculateSphereServiceImpl();

    @Override
    public void updateParameters(SphereEvent event) {
        Sphere sphere = event.getSource();
        double surfaceArea = service.calculateSurfaceArea(sphere);
        double volume = service.calculateVolume(sphere);
        SphereParameter sphereParameter = new SphereParameter(surfaceArea, volume);
        warehouse.put(sphere.getId(), sphereParameter);
        System.out.println("Parameters changed");
    }
}
