package hw3.test.java;



import hw3.main.java.utils.DriverManager;
import hw3.main.java.utils.PropertiesManager;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;


public class BaseTest {

    WebDriver driver;
    SoftAssert testAssert;
    PropertiesManager properties;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = DriverManager.setupDriver();
        properties = new PropertiesManager();
        testAssert = new SoftAssert();
    }

    @AfterTest
    public void tearDownDriver() {
        DriverManager.closeBrowser();
    }

}
