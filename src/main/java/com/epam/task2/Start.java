package com.epam.task2;

import com.epam.task2.entity.CompositeStringPart;
import com.epam.task2.parser.TextToWordCompositeParser;
import com.epam.task2.service.TextFromFileReaderWriter;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException {
        String textFromFile = TextFromFileReaderWriter.readTextFromFile("src\\main\\resources\\text.txt");
        CompositeStringPart text;
        TextToWordCompositeParser parser = new TextToWordCompositeParser();
        text = parser.parseTextToWord(textFromFile);
        System.out.println(text.returnString());
    }
}
