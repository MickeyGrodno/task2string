package com.epam.task2.parser;

import com.epam.task2.parser.interfaces.TextToParagraphParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextToParagraphParserImpl implements TextToParagraphParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(TextToParagraphParserImpl.class);
    public String[] parseTextToParagraph(String allText) {
        String[] text = allText.split("\n");
        LOGGER.info("Текст разделен на параграфы");
        return text;
    }
}
