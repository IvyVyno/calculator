package com.alevel.utils;

import java.util.Arrays;
import java.util.List;

public class StringPreparator {

    public static List<String> prepareEntryString (String entryString) {
        entryString = entryString.trim();
        entryString = entryString.replace("(", "( ");
        entryString = entryString.replace(")", " )");
        return Arrays.asList(entryString.split(" "));
    }
}
