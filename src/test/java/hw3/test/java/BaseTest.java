package hw3.test.java;

import hw3.main.java.utils.DriverManager;
import hw3.main.java.utils.PropertiesManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    WebDriver driver;
    SoftAssert testAssert;
    PropertiesManager properties;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = DriverManager.setupDriver();
        driver.manage().window().maximize();
        testAssert = new SoftAssert();
        properties = new PropertiesManager();
    }

    @AfterMethod
    public void tearDownDriver() {
        testAssert.assertAll();
        DriverManager.closeDriver();
    }
}
