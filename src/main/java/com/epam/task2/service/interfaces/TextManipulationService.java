package com.epam.task2.service.interfaces;

import com.epam.task2.entity.Text;

public interface TextManipulationService {
    void printSortedSentencesByWordCount(Text text);
    void printAllSortedWords(Text text);
}
