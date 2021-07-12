package by.drapejny.task3;

import by.drapejny.task3.comparator.SphereRadiusComparator;
import by.drapejny.task3.entity.Point;
import by.drapejny.task3.entity.Sphere;
import by.drapejny.task3.entity.SphereParameter;
import by.drapejny.task3.entity.SphereWarehouse;
import by.drapejny.task3.exception.SphereException;
import by.drapejny.task3.observer.impl.SphereObserverImpl;
import by.drapejny.task3.repository.SphereRepository;
import by.drapejny.task3.repository.impl.IdSphereSpecification;
import by.drapejny.task3.service.CalculateSphereService;
import by.drapejny.task3.service.impl.CalculateSphereServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) throws SphereException {
        SphereWarehouse warehouse = SphereWarehouse.getInstance();
        CalculateSphereService service = new CalculateSphereServiceImpl();
        SphereRepository repository = new SphereRepository();
        Sphere s1 = new Sphere(1, 1, 1, 1);
        Sphere s2 = new Sphere(2, 2, 2, 2);
        Sphere s3 = new Sphere(3, 3, 3, 3);
        Sphere s4 = new Sphere(4, 4, 4, 4);
        repository.add(s1);
        repository.add(s3);
        repository.add(s2);
        repository.add(s4);
        warehouse.put(s1.getId(), new SphereParameter(service.calculateSurfaceArea(s1), service.calculateVolume(s1)));
        s1.attach(new SphereObserverImpl());
        repository.sort(new SphereRadiusComparator());
        System.out.println(repository.getSpheres());
        System.out.println(warehouse.get(s1.getId()));
        s1.setRadius(55);
        System.out.println(warehouse.get(s1.getId()));
        List<Sphere> list = repository.query(new IdSphereSpecification(2,3));
        System.out.println(list);

    }
}
