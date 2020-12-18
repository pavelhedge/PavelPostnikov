package hw1;

import org.testng.annotations.Test;
import hw1.testData.DivisionDataProvider;

import static org.testng.Assert.assertEquals;

public class CalculatorDivTest extends AbstractCalculatorTest {

    @Test(dataProvider = "Division Data Provider", dataProviderClass = DivisionDataProvider.class)
    public void dataDivTest(double a, double b, double expected) {
        System.out.println("Div test run");
        double actual = calculator.div(a, b);
        assertEquals(actual, expected, 0.000001);
    }
}
