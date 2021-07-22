package by.drapejny.task5.parser;

import by.drapejny.task5.entity.AbstractTextComponent;

public class LexemeParser implements TextParser{

    private static final String LEXEME_SPLIT_REGEX = "\\s+";

    private TextParser nextParser = new SymbolParser();

    @Override
    public void parse(AbstractTextComponent component, String data) {

    }
}
