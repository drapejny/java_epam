package by.drapejny.task5.parser;

import by.drapejny.task5.entity.AbstractTextComponent;

public interface TextParser {

    public abstract void parse(AbstractTextComponent component,String data);
}
