package com.epam.task2.entity.parser;

import com.epam.task2.entity.CompositeStringPart;
import com.epam.task2.entity.Text;

public class TextToParagraphParser {
    public String[] parseTextToParagraph(String allText) {
        return allText.split("\n");
    }
}
