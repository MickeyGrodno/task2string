package com.epam.task2.service;

import com.epam.task2.entity.CompositeStringPart;
import com.epam.task2.entity.Sentence;
import com.epam.task2.entity.Text;
import com.epam.task2.entity.Word;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TextManipulationService {
    private Set<Word> getAllWordsFromText(Text textComposite) {
        Set allWordsSet = textComposite.getListOfComponents().stream().
                flatMap(paragraph -> paragraph.getListOfComponents().stream()).
                flatMap(sentence -> sentence.getListOfComponents().stream()).
                filter(word -> word instanceof Word).collect(Collectors.toSet());
        return  allWordsSet;
    }

    private ArrayList<Sentence> getAllSentences(Text text) {
        ArrayList allSentences = text.getListOfComponents().stream().
                filter(paragraph -> paragraph.getListOfComponents() != null).
                flatMap(paragraph -> paragraph.getListOfComponents().stream()).
                filter(sentence -> sentence.getListOfComponents() != null).
                collect(Collectors.toCollection((Supplier<ArrayList>) ArrayList::new));
        return allSentences;
    }
    public void printSortedSentencesByWordCount(Text text) {

        Map<Sentence, Integer> sortedSenteces = new HashMap<>();
        ArrayList<Sentence> allSentences = getAllSentences(text);
        int wordsCount = 0;
        for(Sentence sentence : allSentences) {
            for (CompositeStringPart word : sentence.getListOfComponents()) {
                if (word instanceof Word) {
                    wordsCount++;
                }
            }
            sortedSenteces.put(sentence,wordsCount);
            wordsCount = 0;
        }
        sortedSenteces.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(map -> System.out.println(map.getKey().returnString()));

    }
}
