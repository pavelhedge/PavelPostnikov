package hw6.test;

import io.cucumber.java.en.Given;

public class GivenStepDef extends AbstractBaseStepDef {


    @Given("I'm logged in")
    public void imLoggedIn(){
        homePage.open();
        homePage.login(properties.get("username"), properties.get("password"));
    }

    @Given("I'm on Different Elements Page")
    public void imOnDifferenElementsPage(){
        elemPage.open();
    }
}
