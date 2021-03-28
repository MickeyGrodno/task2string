package com.epam.task2.entity;

import java.util.ArrayList;
import java.util.List;

public class Text implements CompositeStringPart{
    private ArrayList<CompositeStringPart> listOfParagraphsOfText = new ArrayList<>();

    public String returnString() {
        StringBuilder text = new StringBuilder();
        listOfParagraphsOfText.forEach(a -> text.append(a.returnString()));
        return text.toString().replaceAll("( )+", " ");
    }

    public void addComponentToList(CompositeStringPart element) {
        listOfParagraphsOfText.add(element);
    }

    public ArrayList<CompositeStringPart> getListOfComponents() {
        return listOfParagraphsOfText;
    }
}
