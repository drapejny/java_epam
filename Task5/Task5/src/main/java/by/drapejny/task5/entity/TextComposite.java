package by.drapejny.task5.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite extends AbstractTextComponent {

    private List<AbstractTextComponent> components = new ArrayList<>();

    public TextComposite(TextComponentType type){
        setComponentType(type);
    }

    @Override
    public boolean add(AbstractTextComponent component) {
        return components.add(component);
    }

    @Override
    public boolean remove(AbstractTextComponent component) {
       return components.remove(component);
    }
}
