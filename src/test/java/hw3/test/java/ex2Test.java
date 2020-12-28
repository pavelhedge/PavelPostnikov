package hw3.test.java;

import hw3.main.java.DifferentElementsPage;
import hw3.main.java.HomePage;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class ex2Test extends BaseTest {

    @Test
    void ex2TestMethod() {

        //1. Open test site by URL
        if (properties == null) System.out.println("Props null");
        HomePage hp = new HomePage(driver, properties.get("url"));

        //2. Assert Browser title
        testAssert.assertEquals(hp.getTitle(), "Home Page");

        //3. Perform login
        hp.login(properties.get("username"), properties.get("password"));

        //4. Assert Username is logged in
        testAssert.assertEquals(hp.getUserName(), "ROMAN IOVLEV");

        // 5: Open through the header menu Service -> Different Elements Page
        hp.headerMenu.select("SERVICE");
        hp.headerServiceDropdown.select("DIFFERENT ELEMENTS");

        DifferentElementsPage difelp = new DifferentElementsPage(driver);
        testAssert.assertEquals(difelp.getTitle(), "Different Elements");

        // 6: Select checkboxes Water, Wind
        difelp.checkboxes.select("Water");
        difelp.checkboxes.select("Wind");

        // 7: Select radio
        difelp.radio.select("Selen");

        // 8: Select in dropdown
        difelp.dropdown.select("Yellow");

        //  9: Assert that log has corresponding records
        List<String> keywords = Arrays.asList("Yellow", "Selen", "Wind", "Water");
        List<String> logTexts = difelp.log.getItemsText();
        for (int i = 0; i < logTexts.size(); i++) {
            testAssert.assertTrue(logTexts.get(i).contains(keywords.get(i)));
        }
    }
}
