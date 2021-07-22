package by.drapejny.task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    private static final int NUMBER_BROKERS = 30;

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        q.offer("2");
        q.offer("3");
        System.out.println(q.peek());
        q.poll();
        System.out.println(q.peek());
        q.poll();
        System.out.println(q.peek());
        logger.error("jjjj");
    }
}

