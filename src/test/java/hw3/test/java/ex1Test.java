package hw3.test.java;

import hw3.main.java.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;


public class ex1Test extends BaseTest{

    @Test
    public void ex1TestMethod() {
        //WebDriver driver = new ChromeDriver();
        //1. Open test site by URL
        HomePage hp = new HomePage(driver, properties.get("url"));

        //2. Assert Browser title
        testAssert.assertEquals(hp.getTitle(), "Home Page");

        //3. Perform login
        hp.login(properties.get("username"), properties.get("password"));

        //4. Assert Username is loggined
        testAssert.assertEquals(hp.getUserName(), "ROMAN IOVLEV");
        // 5: Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> expectedHeaderItems = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<String> headerItems = hp.headerMenu.getMenuItemsText();
        testAssert.assertEquals(headerItems, expectedHeaderItems);

        // 6: Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitPics = hp.getBenefitPics();
        testAssert.assertEquals(benefitPics.size(), 4);
        for (WebElement pic : benefitPics) testAssert.assertTrue(pic.isDisplayed());

        // 7: Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> expectedText = Arrays.asList("To include good practices\n" +
                        "and ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\n" +
                        "some external projects),\nwish to get more…");
        hp.getBenefitTexts().equals(expectedText);

        // 8: Assert that there is the iframe with “Frame Button” exist
        testAssert.assertTrue(hp.frameExists());

        // 9: Switch to the iframe and check that there is “Frame Button” in the iframe
        hp.switchToFrame("frame");
        testAssert.assertTrue(hp.frameBtnExists());

        // 10: Switch to original window back
        hp.switchToDefault();

        // 11: Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<String> sideMenuItems = hp.sideMenu.getMenuItemsText();
        List<String> expectedSideItems = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        testAssert.assertEquals(sideMenuItems, expectedSideItems);

        //12. Close browser - @AfterTest in AbstractPage class
    }
}