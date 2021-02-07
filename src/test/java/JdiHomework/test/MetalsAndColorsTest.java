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

        metalsAndColorsPage.form.submit(dataset);
        assertEquals(metalsAndColorsPage.results.getDataset(), dataset);
    }
}
