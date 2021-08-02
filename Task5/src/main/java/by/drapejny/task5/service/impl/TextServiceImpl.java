package by.drapejny.task5.service.impl;

import by.drapejny.task5.entity.AbstractTextComponent;
import by.drapejny.task5.entity.TextComponentType;
import by.drapejny.task5.exception.TextComponentException;
import by.drapejny.task5.service.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.regex.Pattern;

public class TextServiceImpl implements TextService {

    private static final Logger logger = LogManager.getLogger();

    private static final String VOWEL_REGEX = "[aeiouyAEIOUY]";
    private static final String CONSONANTS_REGEX = "[^aeiouyAEIOUY]";

    @Override
    public void sortParagraphsByNumberOfSentences(AbstractTextComponent text) throws TextComponentException {
        if (!text.getComponentType().equals(TextComponentType.TEXT)) {
            logger.error("Expected component of TEXT, but have:" + text.getComponentType());
            throw new TextComponentException();
        }
        text.sort(new ParagraphNumberOfSentencesComparator());
    }

    @Override
    public List<AbstractTextComponent> findSentencesWithLongestWord(AbstractTextComponent text) throws TextComponentException {
        if (!text.getComponentType().equals(TextComponentType.TEXT)) {
            logger.error("Expected component of TEXT, but have:" + text.getComponentType());
            throw new TextComponentException();
        }
        int maxWordLength = 0;
        List<AbstractTextComponent> sentencesWithLongestWord = new ArrayList<AbstractTextComponent>();
        List<AbstractTextComponent> paragraphs = text.getChildren();
        for (var paragraph : paragraphs) {
            List<AbstractTextComponent> sentences = paragraph.getChildren();
            for (var sentence : sentences) {
                List<AbstractTextComponent> lexemes = sentence.getChildren();
                for (var lexeme : lexemes) {
                    List<AbstractTextComponent> components = lexeme.getChildren();
                    for (var component : components) {
                        if (component.getComponentType().equals(TextComponentType.WORD)) {
                            String word = component.toString();
                            if (word.length() > maxWordLength) {
                                sentencesWithLongestWord.clear();
                                sentencesWithLongestWord.add(sentence);
                                maxWordLength = word.length();
                            }
                            if (word.length() == maxWordLength && !sentencesWithLongestWord.contains(sentence)) {
                                sentencesWithLongestWord.add(sentence);
                            }
                        }
                    }
                }
            }
        }
        return sentencesWithLongestWord;
    }

    @Override
    public void removeSentenceWithWordCountLessThan(AbstractTextComponent text, int wordCount) throws TextComponentException {
        if (!text.getComponentType().equals(TextComponentType.TEXT)) {
            logger.error("Expected component of TEXT, but have:" + text.getComponentType());
            throw new TextComponentException();
        }
        List<AbstractTextComponent> paragraphs = text.getChildren();
        for (var paragraph : paragraphs) {
            List<AbstractTextComponent> sentences = paragraph.getChildren();
            List<AbstractTextComponent> removeSentences = new ArrayList<>();
            for (var sentence : sentences) {
                int counter = 0;
                List<AbstractTextComponent> lexemes = sentence.getChildren();
                for (var lexeme : lexemes) {
                    List<AbstractTextComponent> components = lexeme.getChildren();
                    for (var component : components) {
                        if (component.getComponentType().equals(TextComponentType.WORD)) {
                            counter++;
                        }
                    }
                }
                if (counter < wordCount) {
                    removeSentences.add(sentence);
                }
            }
            paragraph.removeAll(removeSentences);
        }
    }

    @Override
    public Map<String, Integer> countWordsOccurrences(AbstractTextComponent text) throws TextComponentException {
        if (!text.getComponentType().equals(TextComponentType.TEXT)) {
            logger.error("Expected component of TEXT, but have:" + text.getComponentType());
            throw new TextComponentException();
        }
        Map<String, Integer> map = new HashMap<>();
        List<AbstractTextComponent> paragraphs = text.getChildren();
        for (var paragraph : paragraphs) {
            List<AbstractTextComponent> sentences = paragraph.getChildren();
            for (var sentence : sentences) {
                List<AbstractTextComponent> lexemes = sentence.getChildren();
                for (var lexeme : lexemes) {
                    List<AbstractTextComponent> components = lexeme.getChildren();
                    for (var component : components) {
                        if (component.getComponentType().equals(TextComponentType.WORD)) {
                            String word = component.toString().toLowerCase(Locale.ROOT);
                            int value = 0;
                            if (map.containsKey(word)) {
                                value = map.get(word);
                            }
                            value++;
                            map.put(word, value);
                        }
                    }
                }
            }
        }
        return map;
    }

    @Override
    public int countVowelsInSentence(AbstractTextComponent sentence) {
        int vowelsCounter = (int) sentence.getChildren()
                .stream()
                .filter(textComponent -> textComponent.getComponentType() == TextComponentType.WORD)
                .flatMap(textComponent -> textComponent.getChildren().stream())
                .filter(symbol -> Pattern.matches(VOWEL_REGEX, symbol.toString()))
                .count();
        return vowelsCounter;
    }

    @Override
    public int countСonsonantsInSentence(AbstractTextComponent sentence) {
        int consonantsCounter = (int) sentence.getChildren()
                .stream()
                .filter(textComponent -> textComponent.getComponentType() == TextComponentType.WORD)
                .flatMap(textComponent -> textComponent.getChildren().stream())
                .filter(symbol -> Pattern.matches(CONSONANTS_REGEX, symbol.toString()))
                .count();
        return consonantsCounter;
    }

    private static class ParagraphNumberOfSentencesComparator implements Comparator<AbstractTextComponent> {
        @Override
        public int compare(AbstractTextComponent o1, AbstractTextComponent o2) {
            int numberOfSentences1 = o1.getChildren().size();
            int numberOfSentences2 = o2.getChildren().size();
            return Integer.compare(numberOfSentences1, numberOfSentences2);
        }
    }
}
