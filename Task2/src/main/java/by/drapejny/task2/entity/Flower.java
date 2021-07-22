package by.drapejny.task2.entity;

import java.io.ObjectOutputStream;

public abstract class Flower {

    private String name;
    private String origin;
    private VisualAspect visualAspect;
    private Soil soil;
    private int growingTemperature;
    private boolean isLightLoving;
    private int watering;
    private Multiplying multiplying;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public VisualAspect getVisualAspect() {
        return visualAspect;
    }

    public void setVisualAspect(VisualAspect visualAspect) {
        this.visualAspect = visualAspect;
    }

    public Soil getSoil() {
        return soil;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public int getGrowingTemperature() {
        return growingTemperature;
    }

    public void setGrowingTemperature(int growingTemperature) {
        this.growingTemperature = growingTemperature;
    }

    public boolean getIsLightLoving() {
        return isLightLoving;
    }

    public void setIsLightLoving(boolean lightLoving) {
        isLightLoving = lightLoving;
    }

    public int getWatering() {
        return watering;
    }

    public void setWatering(int watering) {
        this.watering = watering;
    }

    public Multiplying getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(Multiplying multiplying) {
        this.multiplying = multiplying;
    }

    public Flower() {
    }

    public Flower(String name, String origin, VisualAspect visualAspect,
                  Soil soil, int growingTemperature, boolean isLightLoving,
                  int watering, Multiplying multiplying) {
        this.name = name;
        this.origin = origin;
        this.visualAspect = visualAspect;
        this.soil = soil;
        this.growingTemperature = growingTemperature;
        this.isLightLoving = isLightLoving;
        this.watering = watering;
        this.multiplying = multiplying;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Flower flower = (Flower) o;
        return name.equals(flower.name) &&
                origin.equals(flower.origin) &&
                visualAspect.equals(flower.visualAspect) &&
                soil.equals(flower.soil) &&
                growingTemperature == flower.growingTemperature &&
                isLightLoving == flower.isLightLoving &&
                watering == flower.watering &&
                multiplying.equals(flower.multiplying);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + name.hashCode();
        result = result * 31 + origin.hashCode();
        result = result * 31 + visualAspect.hashCode();
        result = result * 31 + soil.hashCode();
        result = result * 31 + Integer.valueOf(growingTemperature).hashCode();
        result = result * 31 + Boolean.hashCode(isLightLoving);
        result = result * 31 + Integer.valueOf(watering).hashCode();
        result = result * 31 + multiplying.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Flower{name=");
        sb.append(name);
        sb.append(",origin=");
        sb.append(origin);
        sb.append(",visualAspect=");
        sb.append(visualAspect);
        sb.append(",soil=");
        sb.append(soil);
        sb.append(",growintTemperature=");
        sb.append(growingTemperature);
        sb.append(",isLightLoving=");
        sb.append(isLightLoving);
        sb.append(",watering=");
        sb.append(watering);
        sb.append(",multiplying=");
        sb.append(multiplying);
        sb.append("}");
        return sb.toString();
    }
}

