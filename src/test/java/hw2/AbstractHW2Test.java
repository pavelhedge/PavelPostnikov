package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class AbstractHW2Test {


    protected static String username = "Roman";
    protected static String password = "Jdi1234";
    protected WebDriver driver;
    protected SoftAssert testAssert;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        testAssert = new SoftAssert();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null) driver.quit();
        testAssert.assertAll();
    }

}
