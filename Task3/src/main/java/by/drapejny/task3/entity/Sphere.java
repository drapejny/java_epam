package by.drapejny.task3.entity;

import by.drapejny.task3.observer.Observable;
import by.drapejny.task3.observer.SphereEvent;
import by.drapejny.task3.observer.SphereObserver;
import by.drapejny.task3.util.GeneratorID;

public class Sphere extends Shape implements Observable {

    private Point center;
    private double radius;

    private SphereObserver observer;

    public Sphere() {
        super();
    }

    public Sphere(Point center, double radius) {
        super();
        this.center = center;
        this.radius = radius;
    }

    public Sphere(double x, double y, double z, double radius) {
        super();
        this.center = new Point(x, y, z);
        this.radius = radius;
    }


    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.radius, radius) == 0 &&
                center.equals(sphere.center);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + center.hashCode();
        result = 31 * result + Double.valueOf(radius).hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sphere{");
        stringBuilder.append("id=").append(getId()).append(", ");
        stringBuilder.append(center).append(", ");
        stringBuilder.append("radius=").append(radius);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public void attach(SphereObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detach(SphereObserver observer) {
        this.observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            observer.updateParameters(new SphereEvent(this));
        }
    }
}
