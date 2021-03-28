package com.epam.task2.entity;

import java.util.ArrayList;

public class Paragraph implements CompositeStringPart{
    private ArrayList<CompositeStringPart> listOfParagraphSentences = new ArrayList<>();

    public String returnString() {
        StringBuilder paragraph = new StringBuilder();
        listOfParagraphSentences.forEach(a -> paragraph.append(a.returnString()));
        return paragraph.append('\n').toString();
    }

    public void addComponentToList(CompositeStringPart element) {
        listOfParagraphSentences.add(element);
    }

    public ArrayList<CompositeStringPart> getListOfComponents() {
        return listOfParagraphSentences;
    }
}
