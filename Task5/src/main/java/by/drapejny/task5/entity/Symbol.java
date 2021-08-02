package by.drapejny.task5.entity;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Symbol extends AbstractTextComponent {

    String value;

    public Symbol(String value) {
        this.value = value;
        setComponentType(TextComponentType.SYMBOL);
    }

    @Override
    public boolean add(AbstractTextComponent component) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends AbstractTextComponent> items) {
        return false;
    }

    @Override
    public boolean remove(AbstractTextComponent component) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<? extends AbstractTextComponent> items) {
        return false;
    }

    @Override
    public void sort(Comparator comparator) {
    }

    @Override
    public List<AbstractTextComponent> getChildren() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Symbol symbol = (Symbol) o;
        return symbol.value.equals(value);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = prime + value.hashCode();
        return result;
    }

    @Override
    public String toString(){
        return value;
    }
}
