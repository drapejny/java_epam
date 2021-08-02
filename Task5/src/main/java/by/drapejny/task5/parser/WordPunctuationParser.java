package by.drapejny.task5.parser;

import by.drapejny.task5.entity.AbstractTextComponent;
import by.drapejny.task5.entity.TextComponentType;
import by.drapejny.task5.entity.TextComposite;

public class WordPunctuationParser extends AbstractParser {

    private static final String WORD_PUNCTUATION_SPLIT_REXEX = "(?<=\\w)(?=\\W)|(?<=\\W)(?=\\w)|(?<=\\W)(?=\\W)";

    public WordPunctuationParser() {
        nextParser = new SymbolParser();
    }


    @Override
    public void parse(AbstractTextComponent component, String data) {
        String[] tokens = data.split(WORD_PUNCTUATION_SPLIT_REXEX);
        for (String token : tokens) {
            TextComposite composite;
            if (token.matches("\\w+")) {
                composite = new TextComposite(TextComponentType.WORD);
            } else {
                composite = new TextComposite(TextComponentType.PUNCTUATION);
            }
            component.add(composite);
            nextParser.parse(composite, token);
        }
    }
}
