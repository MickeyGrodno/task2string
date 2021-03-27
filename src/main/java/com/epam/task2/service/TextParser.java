package com.epam.task2.service;

import com.epam.task2.entity.*;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TextParser {
    public Text parseTextToComponents(String textString) {
        CompositeStringPart text = new Text();
        CompositeStringPart paragraph = new Paragraph();
        CompositeStringPart sentence = new Sentence();
        StringBuilder word = new StringBuilder();
        String wordElements = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvw" +
                "xyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'\\";
        String endOfSentenceMarks = ".!?…";
        String punctuationMarks = "<>:;\'\"@#№$%^&*)({}][-—=+/~,";
        char previousItem = '0';

        Set wordElementsSet = new HashSet();
        for (char element : wordElements.toCharArray()) {
            wordElementsSet.add(element);
        }
        char[] textToChar = textString.toCharArray();

        for (char element : textToChar) {
            if(element == '\f') {
                continue;
            }
            if(wordElementsSet.contains(element) || (element == '-' && wordElementsSet.contains(previousItem))) {
                word.append(element);
            } else {
                if(punctuationMarks.contains(String.valueOf(element))) {
                    sentence.addComponentToList(new Word(word.toString()));
                    sentence.addComponentToList(new PunctuationMark(String.valueOf(element)));
                    word.setLength(0);
                }
            }
            if(element == ' ' && word.length()!=0) {
                sentence.addComponentToList(new Word(word.toString()));
                word.setLength(0);
            }
            if(endOfSentenceMarks.contains(String.valueOf(element))) {
                sentence.addComponentToList(new Word(word.toString()));
                sentence.addComponentToList(new PunctuationMark(String.valueOf(element)));
                paragraph.addComponentToList(sentence);
                sentence = new Sentence();
                word.setLength(0);
            }
            if(element == '\n') {
                text.addComponentToList(paragraph);
                paragraph = new Paragraph();
            }
            previousItem = element;
        }
        return (Text) text;
    }
}
