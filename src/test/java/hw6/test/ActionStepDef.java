package hw6.test;

import hw6.main.AbstractPage;
import hw6.main.DifferentElementsPage;
import hw6.main.UserTablePage;
import io.cucumber.java.en.When;

public class ActionStepDef extends AbstractBaseStepDef{

    @When("I click on {string} button in Header")
    public void IClickOnButtonInHeader(String btnName){
        page.headerMenuSelect(btnName.toUpperCase());
    }

    @When("I click on {string} button in Service dropdown")
    public void iClickOnBtnInHeaderService(String btnName){
        page = page.headerServiceSubmenuSelect(btnName.toUpperCase());
    }

    @When("I select checkbox {string}")
    public void selectCheckboxOnDifferentElementsPage(String itemName){
        if (page instanceof DifferentElementsPage){
            ((DifferentElementsPage) page).selectCheckbox(itemName);
        }else throw new IllegalStateException("Must be on Different Elements Page");
    }

    @When("I select radio {string}")
    public void iSelectRadioOnDifferentElementsPage(String itemName){
        if (page instanceof DifferentElementsPage){
            ((DifferentElementsPage) page).selectRadio(itemName);
        }else throw new IllegalStateException("Must be on Different Elements Page");
    }

    @When("I select dropdown {string}")
    public void iSelectDropDownOnDifferentElementsPage(String itemName){
        if (page instanceof DifferentElementsPage) {
            ((DifferentElementsPage) page).selectDropdown(itemName);
        } else throw new IllegalStateException("Must be on Different Elements Page");
    }

    @When("I select 'vip' checkbox for {string}")
    public void iSelectCheckBoxFor(String username){
        if (page instanceof UserTablePage) {
            ((UserTablePage) page).selectCheckbox(username);
        }else throw new IllegalStateException("Must be on User Table Page");
    }
}
