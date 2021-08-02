package by.drapejny.task5.parser;

import by.drapejny.task5.entity.AbstractTextComponent;
import by.drapejny.task5.entity.Symbol;

public class SymbolParser extends BaseParser {

    @Override
    public void parse(AbstractTextComponent component, String data) {
        char[] symbols = data.toCharArray();
        for(char symbolValue : symbols){
            Symbol symbol = new Symbol(String.valueOf(symbolValue));
            component.add(symbol);
        }
    }
}
