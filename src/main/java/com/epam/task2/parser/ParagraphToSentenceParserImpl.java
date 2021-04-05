package com.epam.task2.parser;

import com.epam.task2.parser.interfaces.ParagraphToSentenceParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParagraphToSentenceParserImpl implements ParagraphToSentenceParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParagraphToSentenceParserImpl.class);
    public String[] parseParagraphToSentence(String text) {
        String[] arr = text.split("(?<=[A-Za-zА-Яа-я][.!?])\\s[A-ZА-Я]");
        LOGGER.info("Параграф разделен на предложения.");
        return arr;
    }
}