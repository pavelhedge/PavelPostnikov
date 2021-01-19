package hw6.test;

import hw6.main.DifferentElementsPage;
import hw6.main.HomePage;
import hw6.main.utils.PropertiesManager;

public abstract class AbstractBaseStepDef {
    HomePage homePage;
    DifferentElementsPage elemPage;
    PropertiesManager properties;

    AbstractBaseStepDef(){
        homePage = new HomePage();
        elemPage = new DifferentElementsPage();
        properties = new PropertiesManager();
    }
}
