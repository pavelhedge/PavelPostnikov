package hw6.test;

import io.cucumber.java.en.Then;

import static org.testng.Assert.assertTrue;

public class ThenStepDef extends AbstractBaseStepDef {

    @Then("Log row #{int} shall contain record with {string}")
    public void logRowShallContainRecord(int row, String itemName){
        assertTrue(elemPage.getLog().get(row - 1).contains(itemName));
    }
}
