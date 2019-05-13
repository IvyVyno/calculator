package ParsersTests;

import com.alevel.parser.RpnParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RpnParserTest {
    private Deque<String> parsedExpressionExample;
    private Deque<String> parsedExpression;

    @Before
    public void listInitializer() {
        this.parsedExpression = RpnParser
                .parseInfixNotationToReversePolishNotation(Arrays.asList(("5 * ( 3 + 2 )")
                        .split(" "))).getOutputStack();
        this.parsedExpressionExample = new ArrayDeque<>();
        this.parsedExpressionExample.addLast("5");
        this.parsedExpressionExample.addLast("3");
        this.parsedExpressionExample.addLast("2");
        this.parsedExpressionExample.addLast("+");
        this.parsedExpressionExample.addLast("*");
    }

    @Test
    public void parseTest() {
        for(String token : parsedExpressionExample) {
            Assert.assertTrue(token.equals(parsedExpression.pollFirst()));
        }
        Assert.assertTrue(parsedExpression.isEmpty());
    }
}
