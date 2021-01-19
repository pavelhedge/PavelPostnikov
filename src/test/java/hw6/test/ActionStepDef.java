package hw6.test;

import io.cucumber.java.en.When;

public class ActionStepDef extends AbstractBaseStepDef{

    @When("I select checkbox {string}")
    public void selectCheckboxOnDifferentElementsPage(String itemName){
        elemPage.selectCheckbox(itemName);
    }

    @When("I select radio {string}")
    public void iSelectRadioOnDifferentElementsPage(String itemName){
        elemPage.selectRadio(itemName);
    }

    @When("I select dropdown {string}")
    public void iSelectDropDownOnDifferentElementsPage(String itemName){
        elemPage.selectDropdown(itemName);
    }
}
