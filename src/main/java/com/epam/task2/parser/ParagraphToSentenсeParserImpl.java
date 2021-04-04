package com.epam.task2.parser;

import com.epam.task2.parser.interfaces.ParagraphToSentenсeParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParagraphToSentenсeParserImpl implements ParagraphToSentenсeParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParagraphToSentenсeParserImpl.class);
    public String[] parseParagraphToSentence(String text) {
        String[] arr = text.split("(?<=[A-Za-zА-Яа-я][.!?])\\s");
        LOGGER.info("Параграф разделен на предложения.");
        return arr;
    }
}