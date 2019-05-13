package UtilsTests;

import com.alevel.expressionComponents.Functions;
import com.alevel.expressionComponents.Operators;
import com.alevel.utils.TokenChecker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TokenCheckerTest {

    private List<String> listOfOperators;
    private List<String> listOfFunctions;

    @Before
    public void listInitializer() {
        this.listOfOperators = Operators.getListOfOperators();
        this.listOfFunctions = Functions.getListOfFunctions();
    }

    @Test
    public void isNumberTest() {
        Assert.assertTrue(TokenChecker.isNumber("5"));
        Assert.assertFalse(TokenChecker.isNumber("+"));
    }

    @Test
    public void isOperatorTest() {
        Assert.assertTrue(TokenChecker.isOperator("+", listOfOperators));
        Assert.assertFalse(TokenChecker.isOperator("7", listOfOperators));
    }

    @Test
    public void isFunctionTest() {
        Assert.assertTrue(TokenChecker.isFunction("sqrt", listOfFunctions));
        Assert.assertFalse(TokenChecker.isFunction("7", listOfFunctions));
        Assert.assertFalse(TokenChecker.isFunction("*", listOfFunctions));
    }

    @Test
    public void isLeftBracketTest() {
        Assert.assertTrue(TokenChecker.isLeftBracket("("));
        Assert.assertFalse(TokenChecker.isLeftBracket(")"));
        Assert.assertFalse(TokenChecker.isLeftBracket("-"));
        Assert.assertFalse(TokenChecker.isLeftBracket("sin"));
    }

    @Test
    public void isRightBracketTest() {
        Assert.assertTrue(TokenChecker.isRightBracket(")"));
        Assert.assertFalse(TokenChecker.isRightBracket("("));
        Assert.assertFalse(TokenChecker.isRightBracket("/"));
        Assert.assertFalse(TokenChecker.isRightBracket("cos"));
    }
}
