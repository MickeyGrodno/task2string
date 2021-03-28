package com.epam.task2.entity.parser;

import com.epam.task2.entity.*;

import javax.swing.plaf.IconUIResource;

public class SentenceToWordAndMarkParser {
    String wordElements = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvw" +
            "xyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'\\";
    String endOfSentenceMarks = ".!?…";
    String punctuationMarks = "<>:;\'\"@#№$%^&*)({}][-—=+/~,|";

    private void saveWord(CompositeStringPart sentence, StringBuilder word) {
        sentence.addComponentToList(new Word(word.toString()));
    }

    private void saveMark(CompositeStringPart sentence, char mark) {
        sentence.addComponentToList(new PunctuationMark(String.valueOf(mark)));
    }


    public CompositeStringPart parseSentenсeToWordAndMark(String sentenceInString) {
        StringBuilder word = new StringBuilder();
        CompositeStringPart sentence = new Sentence();
        int counter = 1;

        char[] sentenceInChar = sentenceInString.toCharArray();
        for (char element : sentenceInChar) {
            if (wordElements.contains(String.valueOf(element))) {
                word.append(element);
            }
            if (element == ' ' && word.length() != 0) {
                saveWord(sentence, word);
                saveMark(sentence, element);
                word.setLength(0);
            } else if (element == ' ' && word.length() == 0) {
                saveMark(sentence, element);
            }

            if (punctuationMarks.contains(String.valueOf(element)) && word.length() != 0) {
                saveWord(sentence, word);
                saveMark(sentence, element);
                word.setLength(0);
            } else if (punctuationMarks.contains(String.valueOf(element)) && word.length() == 0) {
                saveMark(sentence, element);
            }
            if (endOfSentenceMarks.contains(String.valueOf(element)) && word.length() != 0 && sentenceInChar.length > counter) {
                word.append(element);
            } else if ((endOfSentenceMarks.contains(String.valueOf(element)) && word.length()!=0 && sentenceInChar.length==counter)) {
                saveWord(sentence, word);
                saveMark(sentence, element);
                word.setLength(0);
            }
            counter++;
        }
        return sentence;
    }
}