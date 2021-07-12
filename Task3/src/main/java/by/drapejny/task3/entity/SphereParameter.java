package by.drapejny.task3.entity;

import java.util.Objects;

public class SphereParameter {

    private double surfaceArea;
    private double volume;

    public SphereParameter(){}

    public SphereParameter(double surfaceArea, double volume){
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SphereParameter that = (SphereParameter) o;
        return Double.compare(that.surfaceArea, surfaceArea) == 0 &&
                Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(surfaceArea);
        result = 31 * result + Double.hashCode(volume);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SphereParameter{");
        stringBuilder.append("surfaceArea=");
        stringBuilder.append(surfaceArea);
        stringBuilder.append(", volume=");
        stringBuilder.append(volume);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
