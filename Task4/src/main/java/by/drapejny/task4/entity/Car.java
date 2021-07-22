package by.drapejny.task4.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Car implements Runnable {

    private static final Logger logger = LogManager.getLogger();

    private long carId;
    private int weight;
    private int area;
    private CarState state;

    public enum  CarState {
        NEW, PROCCESSING, TRANSPORTED
    }

    public long getCarId() {
        return carId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public CarState getState() {
        return state;
    }

    public void setState(CarState state) {
        this.state = state;
    }



    @Override
    public void run() {

    }
}
