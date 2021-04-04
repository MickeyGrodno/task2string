package com.epam.task2.service;

import com.epam.task2.service.interfaces.TextFromFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Scanner;

public class TextFromFileReaderImpl implements TextFromFileReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(TextFromFileReaderImpl.class);

    public static String readTextFromFile(String thePathToTheFile) {

        StringBuilder textFromFile = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new FileReader(thePathToTheFile));
            while (scanner.hasNext()) {
                textFromFile.append(scanner.nextLine() + "\n");
            }
            LOGGER.info("Чтение из файла произведено успешно");
        }
        catch (FileNotFoundException e) {
            LOGGER.error("Не удалось найти файл по указанному адресу", e);
        }
        return textFromFile.toString();
    }
}
