package com.epam.task2.entity;

import java.util.ArrayList;

public class PunctuationMark implements CompositeStringPart{
    private String punctuationMark;

    public PunctuationMark(String punctuationMark) {
        this.punctuationMark = punctuationMark;
    }
    public String getPunctuationMark() {
        return punctuationMark;
    }
    public void setPunctuationMark(String punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    public String returnString() {
        return punctuationMark;
    }

    public void addComponentToList(CompositeStringPart element) {

    }

    public ArrayList<CompositeStringPart> getListOfComponents() {
        return null;
    }
}
