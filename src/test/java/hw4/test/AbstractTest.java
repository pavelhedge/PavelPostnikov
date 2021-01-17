package hw4.test;

import hw4.main.utils.AllureListener;
import hw4.main.utils.DriverManager;
import hw4.main.utils.PropertiesManager;
import hw4.test.steps.ActionStep;
import hw4.test.steps.AssertStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

@Listeners({AllureListener.class})
public abstract class AbstractTest {

    WebDriver driver;
    PropertiesManager properties;
    ActionStep actionStep;
    AssertStep assertStep;

    @BeforeMethod
    public void setUp(ITestContext testContext){
        driver = DriverManager.getDriver();
        actionStep = new ActionStep();
        assertStep = new AssertStep();
        testContext.setAttribute("driver", driver);
        properties = new PropertiesManager();
    }

    @AfterMethod
    public void shutDown() {
        DriverManager.closeDriver();
    }
}
