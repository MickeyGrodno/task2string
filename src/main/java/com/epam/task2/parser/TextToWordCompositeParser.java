package com.epam.task2.parser;

import com.epam.task2.entity.CompositeStringPart;
import com.epam.task2.entity.Paragraph;
import com.epam.task2.entity.Text;

public class TextToWordCompositeParser {
    CompositeStringPart compositeText = new Text();
    CompositeStringPart compositeParagraph = new Paragraph();
    CompositeStringPart compositeSentence;
    TextToParagraphParser textToParagraphParser = new TextToParagraphParser();
    ParagraphToSentenсeParser paragraphToSentenсeParser = new ParagraphToSentenсeParser();
    SentenceToWordAndMarkParser sentenceToWordAndMarkParser = new SentenceToWordAndMarkParser();

    public Text parseTextToWord(String fullText) {
        String[] paragraphArr = textToParagraphParser.parseTextToParagraph(fullText);
        for(String paragraphText : paragraphArr) {
            String[] sentenceArr = paragraphToSentenсeParser.parseParagraphToSentence(paragraphText);
            for (String sentence : sentenceArr) {
                compositeSentence = sentenceToWordAndMarkParser.parseSentenсeToWordAndMark(sentence);
                compositeParagraph.addComponentToList(compositeSentence);
            }
            compositeText.addComponentToList(compositeParagraph);
            compositeParagraph = new Paragraph();
        }
        return (Text) compositeText;
    }
}
