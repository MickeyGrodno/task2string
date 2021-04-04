package com.epam.task2.parser;

import com.epam.task2.entity.CompositeStringPart;
import com.epam.task2.entity.Paragraph;
import com.epam.task2.entity.Text;
import com.epam.task2.parser.interfaces.ParagraphToSentenсeParser;
import com.epam.task2.parser.interfaces.SentenceToWordAndMarkParser;
import com.epam.task2.parser.interfaces.TextToParagraphParser;
import com.epam.task2.parser.interfaces.TextToWordParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextToWordParserImpl implements TextToWordParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(TextToParagraphParserImpl.class);
    CompositeStringPart compositeText = new Text();
    CompositeStringPart compositeParagraph = new Paragraph();
    CompositeStringPart compositeSentence;
    TextToParagraphParser textToParagraphParserImpl = new TextToParagraphParserImpl();
    ParagraphToSentenсeParser paragraphToSentenсeParserImpl = new ParagraphToSentenсeParserImpl();
    SentenceToWordAndMarkParser sentenceToWordAndMarkParserImpl = new SentenceToWordAndMarkParserImpl();

    public Text parseTextToWord(String fullText) {
        String[] paragraphArr = textToParagraphParserImpl.parseTextToParagraph(fullText);
        for(String paragraphText : paragraphArr) {
            String[] sentenceArr = paragraphToSentenсeParserImpl.parseParagraphToSentence(paragraphText);
            for (String sentence : sentenceArr) {
                compositeSentence = sentenceToWordAndMarkParserImpl.parseSentenсeToWordAndMark(sentence);
                compositeParagraph.addComponentToList(compositeSentence);
            }
            compositeText.addComponentToList(compositeParagraph);
            compositeParagraph = new Paragraph();
        }
        LOGGER.info("Произведена полная разборка текста");
        return (Text) compositeText;
    }
}