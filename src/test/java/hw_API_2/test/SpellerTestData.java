package hw_API_2.test;

import org.testng.annotations.DataProvider;

public class SpellerTestData {
    @DataProvider
    public Object[][] spellerBasicTestData() {
        return new Object[][]{
                {"карова", "корова"},
                {"велоспед", "велосипед"},
                {"караввай", "каравай"},
                {"москва", "Москва"},
                {"сАНКТ-пЕТЕРБУРГ", "Санкт-Петербург"}
        };
    }
}
