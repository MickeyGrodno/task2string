package com.epam.task2.entity;

import java.util.ArrayList;

public interface CompositeStringPart {
    String returnString();
    void addComponentToList(CompositeStringPart element);
    ArrayList<CompositeStringPart> getListOfComponents();

}
