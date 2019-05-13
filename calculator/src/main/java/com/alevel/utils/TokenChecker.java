package com.alevel.utils;

import java.util.List;

public class TokenChecker {

    public static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public static boolean isOperator(String token, List<String> operators) {
        for (String operator : operators) {
            if (operator.equals(token)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLeftBracket(String token) {
        return token.equals("(");
    }

    public static boolean isRightBracket(String token) {
        return token.equals(")");
    }

    public static boolean isFunction(String token, List<String> functions) {
        for (String function : functions) {
            if (function.equalsIgnoreCase(token)) {
                return true;
            }
        }
        return false;
    }

}
