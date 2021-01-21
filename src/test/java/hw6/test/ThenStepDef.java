package hw6.test;

import hw6.main.DifferentElementsPage;
import hw6.main.UserTablePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class ThenStepDef extends AbstractBaseStepDef {

    @Then("{int} log row has {string} text in log section")
    public void logRowHasTextInLogSection(int logRowNumber, String logText) {
        List<String> logRows;
        if (page instanceof DifferentElementsPage ) {
             logRows = ((DifferentElementsPage) page).getLog();
        }else if (page instanceof UserTablePage ){
            logRows = ((UserTablePage) page).getLog();
        }else throw new IllegalStateException("Must be on page that has log item");
        assertTrue(logRows.get(logRowNumber - 1).contains(logText));
    }

    @Then("{string} page shall be opened")
    public void pageShouldBeOpened(String title){
        assertEquals(page.getTitle(), title);
    }

    @Then("{int} Number Type Dropdowns shall be displayed on Users Table on User Table Page")
    public void dropdownsDisplayedOnUsersTable(int itemsNumber) {
        if (page instanceof UserTablePage) {
            UserTablePage userTablePage = ((UserTablePage) page);
            assertEquals(userTablePage.getNumberTypeDropdownNumber(), itemsNumber);
            assertTrue(userTablePage.checkNumberTypeDropdownsVisible());
        } else throw new IllegalStateException("Must be on User Table Page");
    }

    @Then("{int} Usernames shall be displayed on Users Table on User Table Page")
    public void usernamesDisplayedOnUsersTable(int itemsNumber) {
        if (page instanceof UserTablePage) {
            UserTablePage userTablePage = ((UserTablePage) page);
            assertEquals(userTablePage.getUsernamesNumber(), itemsNumber);
            assertTrue(userTablePage.checkUsernamesVisible());
        } else throw new IllegalStateException("Must be on User Table Page");
    }

    @Then("{int} Description texts under images shall be displayed on Users Table on User Table Page")
    public void DescriptionTextsDisplayedOnUsersTable(int itemsNumber) {
        if (page instanceof UserTablePage) {
            UserTablePage userTablePage = ((UserTablePage) page);
            assertEquals(userTablePage.getDescriptionNumber(), itemsNumber);
            assertTrue(userTablePage.checkDescriptionsVisible());
        } else throw new IllegalStateException("Must be on User Table Page");
    }

    @Then("{int} checkboxes shall be displayed on Users Table on User Table Page")
    public void checkboxesDisplayedOnUsersTable(int itemsNumber) {
        if (page instanceof UserTablePage) {
            UserTablePage userTablePage = ((UserTablePage) page);
            assertEquals(userTablePage.getCheckboxesNumber(), itemsNumber);
            assertTrue(userTablePage.checkCheckboxesVisible());
        } else throw new IllegalStateException("Must be on User Table Page");
    }

    @Then("User Table shall contain following values:")
    public void userTableShallContainFollowingValues(DataTable dataTable){
        if (page instanceof UserTablePage) {
            UserTablePage userTablePage = ((UserTablePage) page);
            List<String> numbers = userTablePage.getNumberTexts();
            List<String> usernames = userTablePage.getUsernameTexts();
            List<String> descriptions = userTablePage.getDescritionTexts();

            List<List<String>> dataRows = dataTable.cells();
            System.out.println();

            for (int i = 1; i < dataRows.size(); i++){
                assertEquals(numbers.get(i-1), dataRows.get(i).get(0));
                assertEquals(usernames.get(i-1), dataRows.get(i).get(1));
                assertEquals(descriptions.get(i-1).replaceAll("\n", " "), dataRows.get(i).get(2));
            }
        }else throw new IllegalStateException("Must be on User Table Page");
    }

    @Then("droplist shall contain values in column Type for user {string}")
    public void droplistShallContainValuesInColumnTypeForUser(String username, DataTable dataTable){
        if (page instanceof UserTablePage) {
            UserTablePage userTablePage = ((UserTablePage) page);
            List<String> options = userTablePage.getNumberTypeDropdownOptionsForUser(username);

            List<String> dataRows = dataTable.asList(String.class);

            for (int i = 1; i < dataRows.size(); i++){
                assertEquals(options.get(i-1), dataRows.get(i));
            }
        }else throw new IllegalStateException("Must be on User Table Page");
    }

}
