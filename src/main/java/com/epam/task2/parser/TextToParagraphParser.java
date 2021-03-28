package com.epam.task2.parser;

public class TextToParagraphParser {
    public String[] parseTextToParagraph(String allText) {
        return allText.split("\n");
    }
}
