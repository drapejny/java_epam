package by.drapejny.task5.parser;

import by.drapejny.task5.entity.AbstractTextComponent;

public abstract class BaseParser {

    protected BaseParser nextParser;

    public abstract void parse(AbstractTextComponent component,String data);
}
