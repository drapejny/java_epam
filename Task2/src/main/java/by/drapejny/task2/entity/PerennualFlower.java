package by.drapejny.task2.entity;

import java.util.Objects;

public class PerennualFlower extends Flower {

    private boolean isWintering;

    public PerennualFlower() {
        super();
    }

    public PerennualFlower(boolean isWintering) {
        this.isWintering = isWintering;
    }

    public PerennualFlower(String name, String origin, VisualAspect visualAspect, Soil soil, int growingTemperature, boolean isLightLoving, int watering, Multiplying multiplying, boolean isWintering) {
        super(name, origin, visualAspect, soil, growingTemperature, isLightLoving, watering, multiplying);
        this.isWintering = isWintering;
    }

    public boolean getIsWintering() {
        return isWintering;
    }

    public void setIsWintering(boolean wintering) {
        isWintering = wintering;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PerennualFlower perennualFlower = (PerennualFlower) o;
        return super.equals(perennualFlower) &&
                isWintering == perennualFlower.isWintering;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Boolean.hashCode(isWintering);
        return result;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("PerennualFlower{");
        int startIndex = 7;
        int endIndex = super.toString().lastIndexOf('}');
        sb.append(super.toString().substring(startIndex, endIndex));
        sb.append(",isWintering=");
        sb.append(isWintering);
        sb.append("}");
        return sb.toString();
    }
}
