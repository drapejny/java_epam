package by.drapejny.task2.entity;

public class VisualAspect {

    private int size;
    private String leavesColor;
    private String blossomColor;

    public VisualAspect() {
    }

    public VisualAspect(int size, String leavesColor, String blossomColor) {
        this.size = size;
        this.leavesColor = leavesColor;
        this.blossomColor = blossomColor;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getLeavesColor() {
        return leavesColor;
    }

    public void setLeavesColor(String leavesColor) {
        this.leavesColor = leavesColor;
    }

    public String getBlossomColor() {
        return blossomColor;
    }

    public void setBlossomColor(String blossomColor) {
        this.blossomColor = blossomColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        VisualAspect visualAspect = (VisualAspect) o;
        return visualAspect.getSize() == size &&
                visualAspect.getBlossomColor().equals(blossomColor) &&
                visualAspect.getLeavesColor().equals(leavesColor);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.valueOf(size).hashCode();
        result = 31 * result + leavesColor.hashCode();
        result = 31 * result + blossomColor.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("VisualAspect{");
        sb.append("size=");
        sb.append(size);
        sb.append(",leavesColor=");
        sb.append(leavesColor);
        sb.append(",blossomColor=");
        sb.append(blossomColor);
        sb.append("}");
        return sb.toString();
    }
}
