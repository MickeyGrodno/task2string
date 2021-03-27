package com.epam.task2;

import com.epam.task2.entity.Text;
import com.epam.task2.service.TextFromFileReaderWriter;
import com.epam.task2.service.TextParser;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException {
        TextParser parser = new TextParser();
        String textFromFile = TextFromFileReaderWriter.readTextFromFile("src\\main\\resources\\text.txt");
        Text text = parser.parseTextToComponents(textFromFile);
        System.out.println();
        System.out.println();
        System.out.printf(text.returnString());
    }
}
