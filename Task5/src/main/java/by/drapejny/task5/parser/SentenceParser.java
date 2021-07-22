package by.drapejny.task5.parser;

import by.drapejny.task5.entity.AbstractTextComponent;
import by.drapejny.task5.entity.TextComponentType;
import by.drapejny.task5.entity.TextComposite;

public class SentenceParser implements TextParser{

    private static final String SENTENCE_SPLIT_REGEX = "(?<=\\!|\\?|\\.{3}|\\.)\\s|$";
    private TextParser nextParser = new LexemeParser();

    @Override
    public void parse(AbstractTextComponent component, String data) {
        String[] sentences = data.split(SENTENCE_SPLIT_REGEX);
        for(String sentence : sentences){
            TextComposite sentenceComposite = new TextComposite(TextComponentType.SENTENCE);
            component.add(sentenceComposite);
            nextParser.parse(sentenceComposite,sentence);
        }
    }
}
