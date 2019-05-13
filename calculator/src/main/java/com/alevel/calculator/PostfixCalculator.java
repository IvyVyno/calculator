package com.alevel.calculator;

import com.alevel.expressionComponents.Functions;
import com.alevel.expressionComponents.Operators;
import com.alevel.parser.RpnParser;
import com.alevel.utils.StringPreparator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static com.alevel.utils.TokenChecker.*;

public class PostfixCalculator {

    private final List<String> operators = Operators.getListOfOperators();
    private final List<String> functions = Functions.getListOfFunctions();

    private String entryString;
    private Deque<String> stackOfCalculations;
    private Deque<String> parsedExpression;

    public PostfixCalculator(String entryString) {
        this.entryString = entryString;
        this.stackOfCalculations = new ArrayDeque<>();
        stackOfCalculations.clear();
        this.parsedExpression = RpnParser
                .parseInfixNotationToReversePolishNotation(StringPreparator
                        .prepareEntryString(this.entryString))
                .getOutputStack();
    }


    public double calculate() {
        while (!parsedExpression.isEmpty()) {
            String token = parsedExpression.pop();
            if (isNumber(token)) {
                stackOfCalculations.push(token);
            } else if (isOperator(token, operators)) {
                double firstOperand = Double.parseDouble(stackOfCalculations.pop());
                double secondOperand = Double.parseDouble(stackOfCalculations.pop());
                switch (token) {
                    case "+":
                        stackOfCalculations.push(String.valueOf(firstOperand + secondOperand));
                        break;
                    case "-":
                        stackOfCalculations.push(String.valueOf(secondOperand - firstOperand));
                        break;
                    case "*":
                        stackOfCalculations.push(String.valueOf(firstOperand * secondOperand));
                        break;
                    case "/":
                        stackOfCalculations.push(String.valueOf(secondOperand / firstOperand));
                        break;
                }
            } else if (isFunction(token, functions)) {
                double operand = Double.parseDouble(stackOfCalculations.pop());
                switch (token) {
                    case "sin":
                        stackOfCalculations.push(String.valueOf(Math.sin(Math.toRadians(operand))));
                        break;
                    case "cos":
                        stackOfCalculations.push(String.valueOf(Math.cos(Math.toRadians(operand))));
                        break;
                    case "sqrt":
                        stackOfCalculations.push(String.valueOf(Math.sqrt(operand)));
                        break;
                }

            }
        }
        return Double.parseDouble(stackOfCalculations.getLast());
    }
}
