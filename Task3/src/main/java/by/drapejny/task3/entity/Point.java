package by.drapejny.task3.entity;

import java.util.Objects;

public class Point {
    private double x;
    private double y;
    private double z;

    public Point() {
    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0 &&
                Double.compare(point.z, z) == 0;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Double.valueOf(x).hashCode();
        result = 31 * result + Double.valueOf(y).hashCode();
        result = 31 * result + Double.valueOf(z).hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Point{");
        stringBuilder.append("x=").append(x).append(", ");
        stringBuilder.append("y=").append(y).append(", ");
        stringBuilder.append("z=").append(z);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
