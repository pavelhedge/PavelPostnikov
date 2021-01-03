package hw2.ex1;

import hw2.AbstractHW2Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ex1Test extends AbstractHW2Test {

    @Test
    void ex1Test() throws InterruptedException {


// 1: Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
// 2: Assert Browser title
        testAssert.assertEquals(driver.getTitle(), "Home Page");
// 3: Perform login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-icon")));
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
// 4: Assert Username is loggined
        testAssert.assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");
// 5: Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> menuItems = driver.findElements(By.cssSelector("ul.uui-navigation.nav>li>a"));
        String[] expectedItems = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS" };
        testAssert.assertEquals(menuItems.size(), expectedItems.length);
        for(int i = 0; i < expectedItems.length; i++){
            testAssert.assertEquals(menuItems.get(i).getText(), expectedItems[i]);
        }
// 6: Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefits = driver.findElements(By.className("benefit"));
        testAssert.assertEquals(benefits.size(), 4);
        for(WebElement benefit : benefits)
        {
            testAssert.assertTrue(benefit.findElement(By.cssSelector("div>span")).isDisplayed());
        }
// 7: Assert that there are 4 texts on the Index Page under icons and they have proper text
        String[] benefitsText = {"To include good practices\n" +
                "and ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\n" +
                        "some external projects),\nwish to get more…"};

        for (int i = 0; i < 4; i++){
            testAssert.assertEquals(benefits.get(i).getText(), benefitsText[i]);
        }
// 8: Assert that there is the iframe with “Frame Button” exist
        testAssert.assertTrue(driver.findElement(By.id("frame")).isDisplayed());
// 9: Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        testAssert.assertTrue(driver.findElement(By.id("frame-button")).isDisplayed());
// 10: Switch to original window back
        driver.switchTo().defaultContent();
// 11: Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sideMenuItems = driver.findElements(By.cssSelector("ul.sidebar-menu>li"));
        String[] expSideItems = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        testAssert.assertEquals(menuItems.size(), expectedItems.length);
        for(int i = 0; i < expectedItems.length; i++){
            testAssert.assertEquals(menuItems.get(i).getText(), expSideItems[i]);
        }
// 12: Close Browser
        testAssert.assertAll();
       driver.quit();
    }
}
