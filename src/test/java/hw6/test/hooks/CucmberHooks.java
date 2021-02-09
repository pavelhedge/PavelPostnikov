package hw6.test.hooks;

import hw6.main.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucmberHooks {

    @After
    public void tearDown(){
        DriverManager.closeDriver();
    }
}
