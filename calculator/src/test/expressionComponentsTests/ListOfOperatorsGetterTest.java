package expressionComponentsTests;

import com.alevel.expressionComponents.Operators;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListOfOperatorsGetterTest {

    private List<String> listOfAvailableOperators;
    private List<String> listOfExpectedAvailableOperators;

    @Before
    public void listInitializer() {
        this.listOfAvailableOperators = Operators.getListOfOperators();
        this.listOfExpectedAvailableOperators = new ArrayList<>();
        this.listOfExpectedAvailableOperators.add("*");
        this.listOfExpectedAvailableOperators.add("/");
        this.listOfExpectedAvailableOperators.add("+");
        this.listOfExpectedAvailableOperators.add("-");
    }

    @Test
    public void getListOfOperatorsTest() {
        Assert.assertTrue(listOfAvailableOperators.containsAll(listOfExpectedAvailableOperators));
    }
}
