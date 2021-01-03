package hw2.ex2;

import hw2.AbstractHW2Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ex2Test extends AbstractHW2Test {

    @Test
    void ex2Test() throws InterruptedException {

// 1: Open test site by URL
        testAssert.assertTrue(false);
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
// 2: Assert Browser title
        testAssert.assertEquals(driver.getTitle(), "Home Page");
// 3: Perform login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-icon")));
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
// 4: Assert User name in the left-top side of screen that user is loggined
        testAssert.assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");
// 5: Open through the header menu Service -> Different Elements Page
        driver.findElement(By.xpath("//span[text()='Service']")).click();
        driver.findElement(By.cssSelector(".sidebar-menu a[href='different-elements.html']")).click();

        testAssert.assertEquals(driver.getTitle(), "Different Elements");
// 6: Select checkboxes Water, Wind
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=checkbox]")));
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type=checkbox]"));
        checkboxes.get(0).click();
        checkboxes.get(2).click();
        testAssert.assertTrue(checkboxes.get(0).isSelected());
        testAssert.assertTrue(checkboxes.get(2).isSelected());
// 7: Select radio
        WebElement selenRadio = driver.findElements(By.cssSelector("input[type=radio]")).get(3);
        selenRadio.click();
        testAssert.assertTrue(selenRadio.isSelected());

// 8: Select in dropdown
        Select dropdown = new Select(driver.findElement(By.cssSelector(("select.uui-form-element"))));
        dropdown.selectByVisibleText("Yellow");
        testAssert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Yellow");
//  9: Assert that log has corresponding records
        String[] keywords = {"Yellow", "Selen", "Wind", "Water"};
            List<WebElement> logs = driver.findElements(By.cssSelector("ul.panel-body-list.logs>li"));
        for (int i = 0; i < logs.size(); i++) {
            testAssert.assertTrue(logs.get(i).getText().contains(keywords[i]));
        }
        testAssert.assertAll();
// 10: Close Browser
        //driver.quit();
    }
}
