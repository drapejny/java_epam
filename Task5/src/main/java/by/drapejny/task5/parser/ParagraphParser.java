package by.drapejny.task5.parser;

import by.drapejny.task5.entity.AbstractTextComponent;
import by.drapejny.task5.entity.TextComponentType;
import by.drapejny.task5.entity.TextComposite;

public class ParagraphParser extends AbstractParser {

    private static final String PARAGRAPH_SPLIT_REGEX = "\n\\s{4}";

    public ParagraphParser() {
    }

    public ParagraphParser(AbstractParser parser) {
        nextParser = parser;
    }

    @Override
    public void parse(AbstractTextComponent component, String data) {
        String[] paragraphs = data.split(PARAGRAPH_SPLIT_REGEX);
        for (String paragraph : paragraphs) {
            TextComposite paragraphComposite = new TextComposite(TextComponentType.PARAGRAPH);
            component.add(paragraphComposite);
            nextParser.parse(paragraphComposite, paragraph);
        }
    }
}
