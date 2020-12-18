package hw1;

import hw1.testData.SubtractionDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubTest extends AbstractCalculatorTest {

    @Test(dataProvider = "Subtraction Data Provider", dataProviderClass = SubtractionDataProvider.class)
    public void dataSubTest(double a, double b, double expected) {
        System.out.println("Sub test run");
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected, 0.000001);
    }
}
