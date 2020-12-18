package hw1.testData;

import org.testng.annotations.DataProvider;

public class DivisionDataProvider {

    @DataProvider(name = "Division Data Provider")
    public Object[][] divisionDataSet() {
        return new Object[][] {
                {2, 2, 1.0},
                {256, -1, -256.0},
                {0, 1, 0}
        };
    }

}
