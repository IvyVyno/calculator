package expressionComponentsTests;

import com.alevel.expressionComponents.Functions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListOfFunctionsGetterTest {

    private List<String> listOfAvailableFunctions;
    private List<String> listOfExpectedAvailableFunctions;

    @Before
    public void listsInitializer() {
        this.listOfAvailableFunctions = Functions.getListOfFunctions();
        this.listOfExpectedAvailableFunctions = new ArrayList<>();
        this.listOfExpectedAvailableFunctions.add("sqrt");
        this.listOfExpectedAvailableFunctions.add("sin");
        this.listOfExpectedAvailableFunctions.add("cos");
    }

    @Test
    public void getListOfFunctionsTest() {
        Assert.assertTrue(listOfAvailableFunctions.containsAll(listOfExpectedAvailableFunctions));
    }
}
