package hw6.test;

import hw6.main.HomePage;
import hw6.main.utils.CredentialsManager;
import io.cucumber.java.en.Given;

public class GivenStepDef extends AbstractBaseStepDef {



    @Given("I open JDI GitHub site")
    public void imOpenJDISite(){
        page = new HomePage();
        page.open();
    }

    @Given("I login as user {string}")
    public void imLoggedInAs(String username){
        page.login(CredentialsManager.getLogin(username), CredentialsManager.getPassword(username));
    }

}
