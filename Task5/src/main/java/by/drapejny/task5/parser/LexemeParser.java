package by.drapejny.task5.parser;

import by.drapejny.task5.entity.AbstractTextComponent;

public class LexemeParser extends BaseParser {

    private static final String LEXEME_SPLIT_REGEX = "\\s+";



    public LexemeParser() {
    }

    public LexemeParser(BaseParser parser) {
        nextParser = parser;
    }

    @Override
    public void parse(AbstractTextComponent component, String data) {

    }
}
