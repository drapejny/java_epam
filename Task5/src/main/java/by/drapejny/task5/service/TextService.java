package by.drapejny.task5.service;

import by.drapejny.task5.entity.AbstractTextComponent;
import by.drapejny.task5.exception.TextComponentException;

import java.util.List;
import java.util.Map;

public interface TextService {

    void sortParagraphsByNumberOfSentences(AbstractTextComponent text) throws TextComponentException;

    List<AbstractTextComponent> findSentencesWithLongestWord(AbstractTextComponent text) throws TextComponentException;

    void removeSentenceWithWordCountLessThan(AbstractTextComponent text, int wordCount) throws TextComponentException;

    Map<String, Integer> countWordsOccurrences(AbstractTextComponent text) throws TextComponentException;

    int countVowelsInSentence(AbstractTextComponent sentence);

    int countСonsonantsInSentence(AbstractTextComponent sentence);
}
