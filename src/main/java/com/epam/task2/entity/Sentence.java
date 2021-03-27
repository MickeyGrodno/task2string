package com.epam.task2.entity;

import org.checkerframework.checker.units.qual.Length;

import java.util.ArrayList;
import java.util.Objects;

public class Sentence implements CompositeStringPart{
    private ArrayList<CompositeStringPart> sentenceWordList = new ArrayList<>();

    public String returnString() {
        CompositeStringPart previousElementClass = new Word("");
        String marksWhithOneSpace = ".!?…";
        StringBuilder sentence = new StringBuilder();
        for(CompositeStringPart part : getListOfString()) {
            if (part instanceof PunctuationMark) {
                sentence.setLength(sentence.length()-1);
            }
            sentence.append(part.returnString()+" ");
        };
        return sentence.toString();
    }

    public void addComponentToList(CompositeStringPart element) {
        sentenceWordList.add(element);
    }

    public ArrayList<CompositeStringPart> getListOfString() {
        return sentenceWordList;
    }
}
