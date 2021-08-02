package by.drapejny.task5.parser;

import by.drapejny.task5.entity.AbstractTextComponent;

public abstract class BaseParser {

    protected BaseParser nextParser;

    public BaseParser getNextParser(){
        return nextParser;
    }

    public void setNextParser(BaseParser nextParser){
        this.nextParser = nextParser;
    }

    public abstract void parse(AbstractTextComponent component,String data);
}
