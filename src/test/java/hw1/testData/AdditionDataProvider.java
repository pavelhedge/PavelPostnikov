package hw1.testData;

import org.testng.annotations.DataProvider;

public class AdditionDataProvider {

    @DataProvider(name = "Addition Data Provider")
    public Object[][] sumDataSet() {
        return new Object[][] {
                {2, 0, 2.0},
                {3.5, 4.4, 7.9},
                {-6, -0.9, -6.9},
                {4, 2, 6.0}
        };
    }

}
