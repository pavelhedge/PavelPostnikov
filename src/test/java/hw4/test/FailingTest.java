package hw4.test;

import hw4.main.utils.AllureListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Listeners(AllureListener.class)
public class FailingTest extends AbstractTest {

    @Feature("Проверка элементов домашней страницы")
    @Story("Проверить меню заголовка, боковое меню и бенефиты на странице")
    @Test
    public void ex1TestMethod() {
        //1. Open test site by URL
        actionStep.openHomePage();

        //2. Assert Browser title
        assertStep.checkTitle("Home Page");

        //3. Perform login
        actionStep.logInToPage(properties.get("username"), properties.get("password"));

        //4. Assert Username is loggined
        assertStep.checkUserIsLoggedIn("ROMAN");

        // 5: Assert that there are 4 items on the header section are displayed and they have proper texts
        assertStep.checkHeaderItems(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));

        // 6: Assert that there are 4 images on the Index Page and they are displayed
        assertStep.checkHomePageBenefitsImages(4);

        // 7: Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> expectedText = Arrays.asList("To include good practices\n" +
                        "and ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\n" +
                        "some external projects),\nwish to get more…");
        assertStep.checkHomePageBenefitsText(expectedText);

        // 8: Assert that there is the iframe with “Frame Button” exist
       assertStep.checkHomePageFrame();

        // 9: Switch to the iframe and check that there is “Frame Button” in the iframe
        actionStep.switchToHomePageFrame();
        assertStep.checkHomePageFrameBtn();

        // 10: Switch to original window back
        actionStep.switchBackToHomePage();

        // 11: Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<String> expectedItems = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        assertStep.checkLeftSideMenuItems(expectedItems);

        //12. Close browser - @AfterTest in AbstractPage class
    }
}