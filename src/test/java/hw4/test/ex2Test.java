package hw4.test;

import hw4.main.DifferentElementsPage;
import hw4.main.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ex2Test extends AbstractTest {

    @Test
    @Feature("Проверка работы с элементами")
    @Story("Проверить работу разных элементов и логгирование на Different Elements")
    void ex2TestMethod() {

        //1. Open test site by URL
        actionStep.openHomePage();

        //2. Assert Browser title
        assertStep.checkTitle("Home Page");

        //3. Perform login
        actionStep.logInToPage(properties.get("username"), properties.get("password"));

        //4. Assert Username is loggined
        assertStep.checkUserIsLoggedIn("ROMAN IOVLEV");

        // 5: Open through the header menu Service -> Different Elements Page
        actionStep.selectInHeaderMenu("SERVICE", "DIFFERENT ELEMENTS");

        // 6: Select checkboxes Water, Wind
        actionStep.selectCheckBoxOnDiifferentElements("Water");
        actionStep.selectCheckBoxOnDiifferentElements("Wind");

        // 7: Select radio
        actionStep.selectRadioOnDiifferentElements("Selen");

        // 8: Select in dropdown
        actionStep.selectDropDownOnDiifferentElements("Yellow");

        //  9: Assert that log has corresponding records
        List<String> keywords = Arrays.asList("Yellow", "Selen", "Wind", "Water");
        assertStep.checkLogRecordsOnDifferentElementsPage(keywords);
    }
}