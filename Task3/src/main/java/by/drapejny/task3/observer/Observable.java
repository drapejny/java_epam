package by.drapejny.task3.observer;

public interface Observable {

    void attach(SphereObserver observer);

    void detach(SphereObserver observer);

    void notifyObservers();
}
