package com.epam.task2.parser;

import com.epam.task2.entity.*;

import java.util.HashSet;
import java.util.Set;

public class SentenceToWordAndMarkParser {
    private final String WORD_ELEMENTS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvw" +
            "xyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'\\";
    private final String END_OF_SENTENCE_MARK = ".!?…";
    private final String PUNCTUATION_MARK = "<>:;\'\"@#№$%^&*)({}][—=+/~,|-•";
    Set wordElementsSet = new HashSet();


    private void saveWord(CompositeStringPart sentence, StringBuilder word) {
        sentence.addComponentToList(new Word(word.toString()));
    }

    private void saveMark(CompositeStringPart sentence, char mark) {
        sentence.addComponentToList(new PunctuationMark(String.valueOf(mark)));
    }

    public Sentence parseSentenсeToWordAndMark(String sentenceInString) {
        StringBuilder word = new StringBuilder();
        Sentence sentence = new Sentence();
        char previousElement = '0';
        int counter = 0;
        for (char element : WORD_ELEMENTS.toCharArray()) {
            wordElementsSet.add(element);
        }
        char[] sentenceInChar = sentenceInString.toCharArray();
        for (char element : sentenceInChar) {
            counter++;
            if (wordElementsSet.contains(element) || (element == '-' && wordElementsSet.contains(previousElement))) {
                word.append(element);
            } else if (element == ' ' && word.length() != 0) {
                saveWord(sentence, word);
                saveMark(sentence, element);
                word.setLength(0);
            } else if (element == ' ' && word.length() == 0) {
                saveMark(sentence, element);
            } else if (PUNCTUATION_MARK.contains(String.valueOf(element)) && word.length() != 0) {
                saveWord(sentence, word);
                saveMark(sentence, element);
                word.setLength(0);
            } else if (PUNCTUATION_MARK.contains(String.valueOf(element)) && word.length() == 0) {
                saveMark(sentence, element);
            } else if (END_OF_SENTENCE_MARK.contains(String.valueOf(element)) && word.length() != 0 && sentenceInChar.length > counter) {
                word.append(element);
            } else if ((END_OF_SENTENCE_MARK.contains(String.valueOf(element)) && word.length() != 0 && sentenceInChar.length == counter)) {
                saveWord(sentence, word);
                saveMark(sentence, element);
            }
            previousElement = element;
        }
        return sentence;
    }
}