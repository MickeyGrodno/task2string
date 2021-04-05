package com.epam.task2.parser.interfaces;

import com.epam.task2.entity.Sentence;

public interface SentenceToWordAndMarkParser {
    Sentence parseSentenceToWordAndMark(String sentenceInString);
}
