package hw1.testData;

import org.testng.annotations.DataProvider;

public class MultiplicationDataProvider {

    @DataProvider(name = "Multiplication Data Provider")
    public Object[][] multiplicationDataSet() {
        return new Object[][] {
                {2, 0, 0.0},
                {3.5, 2.0, 7.0},
                {-5.0, -2, 10.0}
        };
    }

}
