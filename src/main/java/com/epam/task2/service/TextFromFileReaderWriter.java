package com.epam.task2.service;

import java.io.*;
import java.util.Scanner;

public class TextFromFileReaderWriter {
    public static String readTextFromFile(String thePathToTheFile) throws IOException {
        StringBuilder textFromFile = new StringBuilder();
        Scanner scanner = new Scanner(new FileReader(thePathToTheFile));
        while (scanner.hasNext()) {
            textFromFile.append(scanner.nextLine()+"\n");
        }

        return textFromFile.toString();
//        (Scanner in = new Scanner(new File(fileName)
    }
}
