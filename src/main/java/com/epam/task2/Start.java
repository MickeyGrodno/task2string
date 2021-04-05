package com.epam.task2;

import com.epam.task2.entity.Text;
import com.epam.task2.parser.TextToWordParserImpl;
import com.epam.task2.parser.interfaces.TextToWordParser;
import com.epam.task2.service.TextFromFileReaderImpl;
import com.epam.task2.service.TextManipulationServiceImpl;
import com.epam.task2.service.interfaces.TextManipulationService;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException {
        String textFromFile = TextFromFileReaderImpl.readTextFromFile("src\\main\\resources\\text.txt");
        Text text;
        TextManipulationService service = new TextManipulationServiceImpl();
        TextToWordParser parser = new TextToWordParserImpl();

        text = parser.parseTextToWord(textFromFile);
        service.printAllSortedWords(text);
        System.out.println();
        System.out.println("_____________________________________________");
        service.printSortedSentencesByWordCount(text);
        System.out.println(text.returnString());
    }
}
