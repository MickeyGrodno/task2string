package com.epam.task2;

import com.epam.task2.entity.CompositeStringPart;
import com.epam.task2.entity.Text;
import com.epam.task2.parser.TextToWordCompositeParser;
import com.epam.task2.service.TextFromFileReaderWriter;
import com.epam.task2.service.TextManipulationService;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException {
        String textFromFile = TextFromFileReaderWriter.readTextFromFile("src\\main\\resources\\text.txt");
        Text text;
        TextManipulationService service = new TextManipulationService();
        TextToWordCompositeParser parser = new TextToWordCompositeParser();

        text = parser.parseTextToWord(textFromFile);

        service.printSortedSentencesByWordCount(text);
//        System.out.println(text.returnString());
    }
}
