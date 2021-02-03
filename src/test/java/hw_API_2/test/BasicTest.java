package hw_API_2.test;

import hw_API_2.main.SpellerService;
import org.testng.annotations.BeforeClass;

public class BasicTest {
    SpellerService service;

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        service = new SpellerService();
    }
}
