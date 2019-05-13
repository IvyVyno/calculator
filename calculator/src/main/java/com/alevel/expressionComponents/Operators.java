package com.alevel.expressionComponents;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Operators {

    MULTIPLY("*"),
    DIVIDE("/"),
    ADD("+"),
    SUBTRACT("-");

    private String operator;

    Operators (String requestedOperator) {
        this.operator = requestedOperator;
    }

    public String getOperator() {
        return operator;
    }

    public static List<String> getListOfOperators() {
        List<String> operators = new ArrayList<>();
        for(Operators operator : Operators.values()) {
            operators.add(operator.getOperator());
        }
        return Collections.unmodifiableList(operators);
    }

}
