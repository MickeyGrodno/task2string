package com.epam.task2.entity;

import java.util.ArrayList;

public class Sentence implements CompositeStringPart{
    private ArrayList<CompositeStringPart> sentenceWordList = new ArrayList<>();

    public String returnString() {
        StringBuilder sentence = new StringBuilder();
        for(CompositeStringPart part : getListOfString()) {
            sentence.append(part.returnString());
        }
        return sentence.insert(0, " ").toString();
    }

    public void addComponentToList(CompositeStringPart element) {
        sentenceWordList.add(element);
    }

    public ArrayList<CompositeStringPart> getListOfString() {
        return sentenceWordList;
    }
}
