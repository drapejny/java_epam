package by.drapejny.task3.repository;

import by.drapejny.task3.entity.Sphere;

import java.util.*;

public class SphereRepository {

    private static SphereRepository instance = null;

    private List<Sphere> spheres = new ArrayList<>();

    public static SphereRepository getInstance() {
        if (instance == null) {
            instance = new SphereRepository();
        }
        return instance;
    }

    public List<Sphere> getSpheres() {
        return spheres;
    }

    public boolean add(Sphere sphere) {
        return spheres.add(sphere);
    }

    public boolean addAll(Collection<? extends Sphere> c) {
        return spheres.addAll(c);
    }

    public boolean remove(Sphere element) {
        return spheres.remove(element);
    }

    public boolean removeAll(Collection<?> c) {
        return spheres.removeAll(c);
    }

    public Sphere get(int index) {
        return spheres.get(index);
    }

    public Sphere set(int index, Sphere element) {
        return spheres.set(index, element);
    }

    public void sort(Comparator<? super Sphere> comparator){
        spheres.sort(comparator);
    }

    public List<Sphere> query(SphereSpecification specification) {
        List<Sphere> result = new ArrayList<>();
        for (Sphere sphere : spheres) {
            if (specification.specify(sphere)) {
                result.add(sphere);
            }
        }
        return result;
    }


}
