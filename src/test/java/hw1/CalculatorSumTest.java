package hw1;

import hw1.testData.AdditionDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumTest extends AbstractCalculatorTest {

    @Test(dataProvider = "Addition Data Provider", dataProviderClass = AdditionDataProvider.class)
    public void dataSumTest(double a, double b, double expected) {
        System.out.println("Add test run");
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected, 0.000001);
    }
}
