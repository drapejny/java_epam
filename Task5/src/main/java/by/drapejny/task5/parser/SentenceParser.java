package by.drapejny.task5.parser;

import by.drapejny.task5.entity.AbstractTextComponent;
import by.drapejny.task5.entity.TextComponentType;
import by.drapejny.task5.entity.TextComposite;

public class SentenceParser extends BaseParser  {

    private static final String SENTENCE_SPLIT_REGEX = "(?<=\\!|\\?|\\.{3}|\\.)\\s|$";

    public SentenceParser() {
    }

    public SentenceParser(BaseParser parser) {
        nextParser = parser;
    }


    @Override
    public void parse(AbstractTextComponent component, String data) {
        String[] sentences = data.split(SENTENCE_SPLIT_REGEX);
        for (String sentence : sentences) {
            TextComposite sentenceComposite = new TextComposite(TextComponentType.SENTENCE);
            component.add(sentenceComposite);
            nextParser.parse(sentenceComposite, sentence);
        }
    }
}
