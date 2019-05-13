package com.alevel.parser;

import com.alevel.expressionComponents.Functions;
import com.alevel.expressionComponents.Operators;

import java.util.*;

import static com.alevel.utils.OperationPriorityQualifier.defineOperationPriority;
import static com.alevel.utils.TokenChecker.*;

public class RpnParser {

    private final List<String> operators = Operators.getListOfOperators();
    private final List<String> functions = Functions.getListOfFunctions();

    private List<String> entryExpression;
    private Deque<String> outputStack;
    private Deque<String> stackOfOperations;

    private RpnParser(List<String> entryString) {
        this.entryExpression = entryString;
        this.outputStack = new ArrayDeque<>();
        this.outputStack.clear();
        this.stackOfOperations = new ArrayDeque<>();
        this.stackOfOperations.clear();
        parse();
    }

    public static RpnParser parseInfixNotationToReversePolishNotation(List<String> entryString) {
        return new RpnParser(entryString);
    }

    private void parse() {
        ListIterator<String> expressionIterator = entryExpression.listIterator();
        while (expressionIterator.hasNext()) {
            String token = expressionIterator.next();
            if (isNumber(token)) {
                outputStack.addLast(token);
            } else if (isFunction(token, functions)) {
                stackOfOperations.addLast(token);
            } else if (isOperator(token, operators)) {
                while (!stackOfOperations.isEmpty()
                        && isOperator(stackOfOperations.getLast(), operators)
                        && (defineOperationPriority(token)
                        <= defineOperationPriority(stackOfOperations.getLast()))) {
                    outputStack.addLast(stackOfOperations.pollLast());
                }
                stackOfOperations.addLast(token);
            } else if (isLeftBracket(token)) {
                stackOfOperations.addLast(token);
            } else if (isRightBracket(token)) {
                while (!stackOfOperations.isEmpty()
                        && !isLeftBracket(stackOfOperations.getLast())) {
                    outputStack.addLast(stackOfOperations.pollLast());
                }
                stackOfOperations.pollLast();
                if (isFunction(stackOfOperations.getLast(), functions)) {
                    outputStack.addLast(stackOfOperations.pollLast());
                }
            } else {
                System.out.println("Unexpected token: " + token);
                outputStack.clear();
                stackOfOperations.clear();
                return;
            }
        }
        while(!stackOfOperations.isEmpty()) {
            outputStack.addLast(stackOfOperations.pollLast());
        }
    }

    public Deque<String> getOutputStack() {
        return this.outputStack;
    }
}
