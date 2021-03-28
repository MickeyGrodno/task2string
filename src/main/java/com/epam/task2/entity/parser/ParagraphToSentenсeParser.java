package com.epam.task2.entity.parser;

import com.epam.task2.entity.CompositeStringPart;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
//Обращение к статическому полю является корректным независимо от того, были ли порождены объекты от этого класса и в каком количестве. Например, стартовый метод main()  запускается до того, как программа создаст хотя бы один объект.
//Кроме полей и методов, статическими могут быть инициализаторы. Они также называются инициализаторами класса, в отличие от инициализаторов объекта, рассматривавшихся ранее. Их код выполняется один раз во время загрузки класса в память виртуальной машины. Их запись начинается с модификатора static:
}
