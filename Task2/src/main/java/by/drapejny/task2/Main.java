package by.drapejny.task2;

import by.drapejny.task2.builder.SaxFlowerBuilder;
import by.drapejny.task2.exception.FlowerException;

public class Main {
    public static void main(String[] args) throws FlowerException {
  SaxFlowerBuilder builder = new SaxFlowerBuilder();
//        builder.buildFlowers("flowers.xml");
//        System.out.println(builder.getFlowers());
//        StaxFlowerBuilder builder = new StaxFlowerBuilder() ;
//        builder.buildFlowers("flowers.xml");
//        System.out.println(builder.getFlowers());
        System.out.println(builder instanceof Cloneable);
        String s = "ds";
    }
}
