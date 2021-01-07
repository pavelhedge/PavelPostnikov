package hw4.test;

import hw4.main.utils.DriverManager;
import hw4.main.utils.PropertiesManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class AbstractTest {

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
