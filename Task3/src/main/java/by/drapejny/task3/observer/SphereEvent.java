package by.drapejny.task3.observer;

import by.drapejny.task3.entity.Sphere;

import java.util.EventObject;

public class SphereEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public SphereEvent(Object source) {
        super(source);
    }

    @Override
    public Sphere getSource() {
        return (Sphere) super.getSource();
    }
}
