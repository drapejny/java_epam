package by.drapejny.task4.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Ferry {

    private static final Logger logger = LogManager.getLogger();
    private static final int MAX_WEIGHT = 20;
    private static final int MAX_AREA = 50;
    private static final int SECONDS_TO_TRANSFER = 1;
    private static final int MILLISECONDS_TO_UNLOAD = 100;
    private static Ferry instance;
    private static final ReentrantLock locker = new ReentrantLock();
    private static final Condition waiting = locker.newCondition();
    private int currentWeight;
    private int currentArea;
    private Queue<Car> carsOnPlatform = new LinkedList<>();

    private Ferry() {
    }

    public static Ferry getInstance() {
        if (instance == null) {
            try {
                locker.lock();
                instance = new Ferry();
            } finally {
                locker.unlock();
            }
        }
        return instance;
    }

    public void uploadCar(Car car) throws InterruptedException {
        locker.lock();
        try {
            while (currentArea + car.getArea() > MAX_AREA || currentWeight + car.getWeight() > MAX_WEIGHT) {
                waiting.await();
            }
            currentArea += car.getArea();
            currentWeight += car.getWeight();
            car.setState(Car.CarState.PROCCESSING);
            carsOnPlatform.offer(car);
        } finally {
            locker.unlock();
            TimeUnit.SECONDS.sleep(SECONDS_TO_TRANSFER);
        }
    }

    public void transferCars() throws InterruptedException {
        locker.lock();
        try {
            TimeUnit.MILLISECONDS.sleep(MILLISECONDS_TO_UNLOAD);
            while (currentArea != 0 && currentWeight != 0) {
                currentWeight -= carsOnPlatform.peek().getWeight();
                currentArea -= carsOnPlatform.peek().getArea();
                carsOnPlatform.peek().setState(Car.CarState.TRANSPORTED);
                carsOnPlatform.poll();
            }
        } finally {
            waiting.signalAll();
            locker.unlock();
        }
    }
}
