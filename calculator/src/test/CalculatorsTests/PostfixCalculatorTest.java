package CalculatorsTests;

import com.alevel.calculator.PostfixCalculator;
import javafx.geometry.Pos;
import org.junit.Assert;
import org.junit.Test;

public class PostfixCalculatorTest {

    @Test
    public void calculateTest() {
        Assert.assertTrue(Double
                .toString(25.0)
                .equals(Double.toString(new PostfixCalculator("5 * (3 + 2").calculate())));
    }
}
