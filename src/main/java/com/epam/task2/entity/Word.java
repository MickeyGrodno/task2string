package com.epam.task2.entity;

import java.util.ArrayList;

public class Word implements CompositeStringPart{
    private String word;

    public Word(String word) {
        this.word = word;
    }
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String returnString() {
        return word;
    }

    public void addComponentToList(CompositeStringPart element) {

    }

    public ArrayList<CompositeStringPart> getListOfString() {
        return null;
    }
}
