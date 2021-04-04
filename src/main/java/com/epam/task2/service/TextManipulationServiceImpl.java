package com.epam.task2.service;

import com.epam.task2.entity.CompositeStringPart;
import com.epam.task2.entity.Sentence;
import com.epam.task2.entity.Text;
import com.epam.task2.entity.Word;
import com.epam.task2.service.interfaces.TextManipulationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TextManipulationServiceImpl implements TextManipulationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TextManipulationServiceImpl.class);

    private ArrayList<String> getAllWordsFromText(Text textComposite) {
        ArrayList<Word> allWordsList = (ArrayList) textComposite.getListOfComponents().stream().
                flatMap(paragraph -> paragraph.getListOfComponents().stream()).
                flatMap(sentence -> sentence.getListOfComponents().stream()).
                filter(word -> word instanceof Word).collect(Collectors.toList());
        ArrayList<String> allWordsInString = new ArrayList();
        allWordsList.forEach(o -> allWordsInString.add(o.getWord()));
        LOGGER.info("Все слова получены из текста и сохранены в список");
        return  allWordsInString;
    }

    private ArrayList<Sentence> getAllSentences(Text text) {
        Supplier<ArrayList> collectionFactory = ArrayList::new;
        ArrayList allSentences = collectionFactory.get();
        for (CompositeStringPart paragraph : text.getListOfComponents()) {
            if (paragraph.getListOfComponents() != null) {
                for (CompositeStringPart sentence : paragraph.getListOfComponents()) {
                    if (sentence.getListOfComponents() != null) {
                        allSentences.add(sentence);
                    }
                }
            }
        }
        LOGGER.info("Все предложения получены из текста и сохранены в список");
        return allSentences;
    }
//    2.	Вывести все предложения заданного текста в порядке возрастания
//    количества слов в каждом из них.

    public void printSortedSentencesByWordCount(Text text) {

        Map<Sentence, Integer> sortedSentences = new HashMap<>();
        ArrayList<Sentence> allSentences = getAllSentences(text);
        int wordsCount = 0;
        for(Sentence sentence : allSentences) {
            for (CompositeStringPart word : sentence.getListOfComponents()) {
                if (word instanceof Word) {
                    wordsCount++;
                }
            }
            sortedSentences.put(sentence,wordsCount);
            wordsCount = 0;
        }
        sortedSentences.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(map -> System.out.println(map.getKey().returnString()));
        LOGGER.info("Напечатаны предложения в порядке возрастания количества слов.");
    }

//    6.	Напечатать слова текста в алфавитном порядке по первой
//    букве. Слова, начинающиеся с новой буквы, печатать с красной строки.

    public void printAllSortedWords(Text text) {
        ArrayList<String> allWords = getAllWordsFromText(text);
        Collections.sort(allWords, String.CASE_INSENSITIVE_ORDER);
        char c = 'a';
        for(String word : allWords) {
            if ((Character.toLowerCase(word.charAt(0))) == c) {
                System.out.print(word+" ");
            } else {
                c = (Character.toLowerCase(word.charAt(0)));
                System.out.println();
                System.out.print(word+" ");
            }
        }
        LOGGER.info("Напечатаны слова текста в алфавитном порядке");
    }
}
