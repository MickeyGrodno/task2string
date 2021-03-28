package com.epam.task2.parser;

public class ParagraphToSentenсeParser {
    public String[] parseParagraphToSentence(String text) {
        String[] arr = text.split("(?=[А-Яа-яA-Za-z][.!?] [A-ZА-Я])");
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = arr[i].concat(".");
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i].substring(3);
        }
        return arr;
    }
}