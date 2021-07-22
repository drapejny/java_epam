package by.drapejny.task2.entity;

import java.time.Month;
import java.util.Objects;

public class AnnualFlower extends Flower {

    private Month floweringPeriod;

    public AnnualFlower() {
        super();
    }

    public AnnualFlower(String name, String origin, VisualAspect visualAspect, Soil soil, int growingTemperature, boolean isLightLoving, int watering, Multiplying multiplying, Month floweringPeriod) {
        super(name, origin, visualAspect, soil, growingTemperature, isLightLoving, watering, multiplying);
        this.floweringPeriod = floweringPeriod;
    }

    public Month getFloweringPeriod() {
        return floweringPeriod;
    }

    public void setFloweringPeriod(Month floweringPeriod) {
        this.floweringPeriod = floweringPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AnnualFlower annualFlower = (AnnualFlower) o;
        return super.equals(annualFlower) &&
                floweringPeriod.equals(annualFlower.floweringPeriod);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + floweringPeriod.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AnnualFlower{");
        int startIndex = 7;
        int endIndex = super.toString().lastIndexOf('}');
        sb.append(super.toString().substring(startIndex, endIndex));
        sb.append(",floweringPeriod=");
        sb.append(floweringPeriod);
        sb.append("}");
        return sb.toString();
    }
}
