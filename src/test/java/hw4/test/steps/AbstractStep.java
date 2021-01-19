package hw4.test.steps;

import hw4.main.AbstractPage;
import hw4.main.DifferentElementsPage;
import hw4.main.HomePage;
import hw4.main.utils.PropertiesManager;

public abstract class AbstractStep {

    PropertiesManager properties;
    static HomePage homePage;
    static DifferentElementsPage elemPage;

    AbstractStep(){
        homePage = new HomePage();
    }

}
