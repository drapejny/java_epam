package by.drapejny.task5.entity;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractTextComponent {

    protected TextComponentType componentType;

    public TextComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(TextComponentType componentType) {
        this.componentType = componentType;
    }

    public abstract boolean add(AbstractTextComponent component);

    public abstract boolean addAll(Collection<? extends AbstractTextComponent> items);

    public abstract boolean remove(AbstractTextComponent component);

    public abstract boolean removeAll(Collection<? extends AbstractTextComponent> items);

    public abstract void sort(Comparator<AbstractTextComponent> comparator);

    public abstract List<AbstractTextComponent> getChildren();
}
