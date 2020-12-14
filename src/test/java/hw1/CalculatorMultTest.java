package hw1;

import org.testng.annotations.Test;
import hw1.testData.MultiplicationDataProvider;

import static org.testng.Assert.assertEquals;

public class CalculatorMultTest extends AbstractCalculatorTest {

    @Test(dataProvider = "Multiplication Data Provider", dataProviderClass = MultiplicationDataProvider.class)
    public void dataMultTest(double a, double b, double expected) {
        System.out.println("Mult test run");
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected, 0.000001);
    }
}
