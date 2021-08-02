package by.drapejny.task5.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class TextComposite extends AbstractTextComponent {

    private List<AbstractTextComponent> components = new ArrayList<>();

    public TextComposite(TextComponentType type) {
        setComponentType(type);
    }

    @Override
    public boolean add(AbstractTextComponent component) {
        return components.add(component);
    }

    @Override
    public boolean addAll(Collection<? extends AbstractTextComponent> items) {
        return components.addAll(items);
    }

    @Override
    public boolean remove(AbstractTextComponent component) {
        return components.remove(component);
    }

    @Override
    public boolean removeAll(Collection<? extends AbstractTextComponent> items) {
        return components.removeAll(items);
    }

    @Override
    public void sort(Comparator comparator) {
        components.sort(comparator);
    }

    @Override
    public List<AbstractTextComponent> getChildren() {
        return new ArrayList<>(components);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (this == null || getClass() != o.getClass()) {
            return false;
        }
        TextComposite composite = (TextComposite) o;

        return composite.componentType.equals(componentType) &&
                composite.components.equals(components);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = result * prime + components.hashCode();
        result = result * prime + componentType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var component : components) {
            TextComponentType type = component.getComponentType();
            sb.append(type.getPrefix());
            sb.append(component);
            sb.append(type.getSuffix());
        }
        return sb.toString();
    }
}
