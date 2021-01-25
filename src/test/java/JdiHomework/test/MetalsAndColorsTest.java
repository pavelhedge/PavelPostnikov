package JdiHomework.test;

import JdiHomework.main.entities.MetalsAndColorsDataset;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import static JdiHomework.main.entities.headerMenuData.*;
import static JdiHomework.main.site.JdiTestSite.*;
import static JdiHomework.test.TestData.ROMAN;

public class MetalsAndColorsTest implements SimpleTestsInit {

    /*@BeforeMethod
    public void beforeMethod() {
        if (userName.isHidden()) {
            if (!homePage.isOpened()) homePage.open();
            if (loginForm.isHidden())
                userIcon.click();
            loginForm.loginAs(ROMAN);
        }
        if (!metalsAndColorsPage.isOpened()) headerMenu.select(MetalsColors);
    }*/

    @AfterMethod
    public void afterMethod(){
        if (!logout.isDisplayed()) userIcon.click();
        logout.click();
    }

    @Test(dataProvider = "datasets", dataProviderClass = TestData.class)
    public void fillFormAndCheckResults(MetalsAndColorsDataset dataset) {
        homePage.open();
        userIcon.click();
        loginForm.loginAs(ROMAN);
        homePage.checkOpened();
        headerMenu.select(MetalsColors);
        metalsAndColorsPage.checkOpened();

        metalsAndColorsPage.form.summary.select(dataset.summary);
        metalsAndColorsPage.form.elements.select(dataset.elements);
        metalsAndColorsPage.form.color.select(dataset.color);
        metalsAndColorsPage.form.metals.select(dataset.metals);
        metalsAndColorsPage.form.vegetables.select(dataset.vegetables);
        metalsAndColorsPage.form.submit.click();

        //metalsAndColorsPage.form.submit(dataset);

        assertEquals(metalsAndColorsPage.results.getDataset(), dataset);
    }
}
