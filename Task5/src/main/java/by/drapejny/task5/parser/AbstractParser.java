package by.drapejny.task5.parser;

import by.drapejny.task5.entity.AbstractTextComponent;

public abstract class AbstractParser {

    protected AbstractParser nextParser;

    public AbstractParser getNextParser(){
        return nextParser;
    }

    public void setNextParser(AbstractParser nextParser){
        this.nextParser = nextParser;
    }

    public abstract void parse(AbstractTextComponent component,String data);
}
