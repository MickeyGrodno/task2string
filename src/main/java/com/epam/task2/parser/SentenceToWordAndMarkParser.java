package com.epam.task2.parser;

import com.epam.task2.entity.*;

import java.util.HashSet;
import java.util.Set;

public class SentenceToWordAndMarkParser {
    private final String WORD_ELEMENTS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvw" +
            "xyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'\\";
    private final String END_OF_SENTENCE_MARK = ".!?…";
    private final String PUNCTUATION_MARK = "<>:;\'\"@#№$%^&*)({}][-—=+/~,|";
    Set wordElementsSet = new HashSet();


    private void saveWord(CompositeStringPart sentence, StringBuilder word) {
        sentence.addComponentToList(new Word(word.toString()));
    }

    private void saveMark(CompositeStringPart sentence, char mark) {
        sentence.addComponentToList(new PunctuationMark(String.valueOf(mark)));
    }


    public CompositeStringPart parseSentenсeToWordAndMark(String sentenceInString) {
        StringBuilder word = new StringBuilder();
        CompositeStringPart sentence = new Sentence();

        for (char element : WORD_ELEMENTS.toCharArray()) {
            wordElementsSet.add(element);
        }
        int counter = 1;

        char[] sentenceInChar = sentenceInString.toCharArray();
        for (char element : sentenceInChar) {
            if (wordElementsSet.contains(element)) {
                word.append(element);
            }
            if (element == ' ' && word.length() != 0) {
                saveWord(sentence, word);
                saveMark(sentence, element);
                word.setLength(0);
            } else if (element == ' ' && word.length() == 0) {
                saveMark(sentence, element);
            }

            if (PUNCTUATION_MARK.contains(String.valueOf(element)) && word.length() != 0) {
                saveWord(sentence, word);
                saveMark(sentence, element);
                word.setLength(0);
            } else if (PUNCTUATION_MARK.contains(String.valueOf(element)) && word.length() == 0) {
                saveMark(sentence, element);
            }
            if (END_OF_SENTENCE_MARK.contains(String.valueOf(element)) && word.length() != 0 && sentenceInChar.length > counter) {
                word.append(element);
            } else if ((END_OF_SENTENCE_MARK.contains(String.valueOf(element)) && word.length()!=0 && sentenceInChar.length==counter)) {
                saveWord(sentence, word);
                saveMark(sentence, element);
                word.setLength(0);
            }
            counter++;
        }
        return sentence;
    }
}