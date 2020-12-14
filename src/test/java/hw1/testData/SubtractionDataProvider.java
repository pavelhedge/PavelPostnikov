package hw1.testData;

import org.testng.annotations.DataProvider;

public class SubtractionDataProvider {

    @DataProvider(name = "Subtraction Data Provider")
    public Object[][] subDataSet() {
        return new Object[][] {
                {2, 2, 0.0},
                {3.5, 4.4, -0.9},
                {-6, -0.9, -5.1}
        };
    }

}
