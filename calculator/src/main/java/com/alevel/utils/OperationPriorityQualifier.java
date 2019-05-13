package com.alevel.utils;

public class OperationPriorityQualifier {

    public static int defineOperationPriority(String operation) {
        if (operation.equals("+") || operation.equals("-")) {
            return 1;
        } else return 2;
    }

}
