package by.drapejny.task5;

import by.drapejny.task5.entity.AbstractTextComponent;
import by.drapejny.task5.entity.TextComponentType;
import by.drapejny.task5.entity.TextComposite;
import by.drapejny.task5.exception.TextComponentException;
import by.drapejny.task5.parser.*;
import by.drapejny.task5.service.BitExpressionsCalculator;
import by.drapejny.task5.service.TextService;
import by.drapejny.task5.service.impl.TextServiceImpl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) throws TextComponentException {
//        PostfixNotationTransformer transformer = new PostfixNotationTransformer();
//        String infix = "4";//(7^5|1&2<<(~2|5>>2&71))|1200
//        String postfix = transformer.transform(infix);
//        int x = (7 ^ 5 | 1 & 2 << (~2 | 5 >> 2 & 71)) | 1200;
//        Interpreter interpreter = new Interpreter(postfix);
//        int y = interpreter.calculate();
//        System.out.println(x);
//        System.out.println(y);
        String text = "    It has survived - not only (five) centuries, but also the leap into 13<<2 electronic\n" +
                "typesetting, remaining 3>>5 essentially ~6&9|(3&4) unchanged. It was popularised in the\n" +
                "5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1) with the release of Letraset sheets containing\n" +
                "Lorem Ipsum passages, and more recently with desktop publishing software like Aldus\n" +
                "PageMaker including versions of Lorem Ipsum.\n" +
                "    It is a long established fact that a reader will be distracted by the readable content of a\n" +
                "page when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78\n" +
                "Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content\n" +
                "here), content here', making it look like readable English.\n" +
                "It is a (7^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page\n" +
                "when looking at its layout.\n" +
                "    Bye.";
        String s = "Abcd abcd d.\n" +
                "    Bbb b b. CCCC ccc";
        String t = BitExpressionsCalculator.calculate(text);
        WordPunctuationParser wordPunctuationParser = new WordPunctuationParser();
        LexemeParser lexemeParser = new LexemeParser(wordPunctuationParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        TextComposite composite = new TextComposite(TextComponentType.TEXT);
        paragraphParser.parse(composite,t);

        TextService textService = new TextServiceImpl();
        textService.sortParagraphsByNumberOfSentences(composite);
        System.out.println(composite);
        System.out.println(textService.countWordsOccurrences(composite));

        met();

    }

    public static void met() throws TextComponentException{
        try {
            throw new TextComponentException();
        } finally {
            System.out.println("finally");
        }
    }
}
