package com.epam.task2;

import java.util.Objects;
import java.util.StringJoiner;

public class main {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("123456789");
        builder.setLength(builder.length()-5);
        System.out.println(builder.toString());
    }
}
