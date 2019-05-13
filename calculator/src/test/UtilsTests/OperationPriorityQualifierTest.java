package UtilsTests;

import com.alevel.utils.OperationPriorityQualifier;
import org.junit.Assert;
import org.junit.Test;

public class OperationPriorityQualifierTest {

    @Test
    public void defineOperationPriorityTest() {
        Assert.assertEquals(1, OperationPriorityQualifier.defineOperationPriority("+"));
        Assert.assertEquals(1, OperationPriorityQualifier.defineOperationPriority("-"));
        Assert.assertEquals(2, OperationPriorityQualifier.defineOperationPriority("*"));
        Assert.assertEquals(2, OperationPriorityQualifier.defineOperationPriority("/"));
        Assert.assertEquals(2, OperationPriorityQualifier.defineOperationPriority("sqrt"));
    }
}
