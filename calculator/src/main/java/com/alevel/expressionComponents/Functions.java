package com.alevel.expressionComponents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Functions {

    SQRT("sqrt"),
    SIN("sin"),
    COS("cos");

    private String function;

    Functions(String requestedFunction) {
        this.function = requestedFunction;
    }

    public String getFunction() {
        return function;
    }

    public static List<String> getListOfFunctions() {
        List<String> functions = new ArrayList<>();
        for(Functions function : Functions.values()) {
            functions.add(function.getFunction());
        }
        return Collections.unmodifiableList(functions);
    }
}
