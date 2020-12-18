package hw1.testData;

import org.testng.annotations.DataProvider;

public class SqrtDataProvider {

    @DataProvider(name = "Square Root Data Provider")
    public Object[][] sqrtDataSet() {
        return new Object[][] {
                {1, 1.0},
                {16, 4},
                {0, 0}
        };
    }

}
