package hw_API_2;

import org.testng.annotations.BeforeClass;

public class BasicTest {
    public SpellerService service;

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        service = new SpellerService();
    }
}
