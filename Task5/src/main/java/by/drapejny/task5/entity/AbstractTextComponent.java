package by.drapejny.task5.entity;

public abstract class AbstractTextComponent {

    private TextComponentType componentType;

    public TextComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(TextComponentType componentType) {
        this.componentType = componentType;
    }

    public abstract boolean add(AbstractTextComponent component);

    public abstract boolean remove(AbstractTextComponent component);

}
