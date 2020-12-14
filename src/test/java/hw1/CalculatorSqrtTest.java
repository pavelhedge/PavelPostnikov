package hw1;

import hw1.testData.SqrtDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSqrtTest extends AbstractCalculatorTest {

    @Test(dataProvider = "Square Root Data Provider", dataProviderClass = SqrtDataProvider.class)
    public void dataSqrtTest(double a, double expected) {
        System.out.println("Add test run");
        double actual = calculator.sqrt(a);
        assertEquals(actual, expected, 0.000001);
    }
}
