package by.drapejny.task5.parser;

import by.drapejny.task5.entity.AbstractTextComponent;
import by.drapejny.task5.entity.TextComponentType;
import by.drapejny.task5.entity.TextComposite;

public class LexemeParser extends BaseParser {

    private static final String LEXEME_SPLIT_REGEX = "\\s+";

    public LexemeParser() {
    }

    public LexemeParser(BaseParser parser) {
        nextParser = parser;
    }

    @Override
    public void parse(AbstractTextComponent component, String data) {
        String[] lexemes = data.split(LEXEME_SPLIT_REGEX);
        for(String lexeme : lexemes){
            TextComposite lexemeComposite = new TextComposite(TextComponentType.LEXEME);
            component.add(lexemeComposite);
            nextParser.parse(lexemeComposite, lexeme);
        }

    }
}
