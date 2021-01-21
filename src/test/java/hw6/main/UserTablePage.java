package hw6.main;

import hw6.main.subElements.UserEntry;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTablePage extends AbstractPage{

    @FindBy(css = "#user-table td:nth-child(1)")
    List<WebElement> numbers;
    @FindBy(css = "#user-table select")
    List<WebElement> numberTypeDropdowns;
    @FindBy(css = "#user-table a")
    List<WebElement> usernamesWE;
    List<String> usernames;
    @FindBy(css = "#user-table .user-descr span")
    List<WebElement> descriptions;
    @FindBy(css = "#user-table input")
    List<WebElement> checkboxes;
    @FindBy(css = ".logs li")
    List<WebElement> logRows;

    public UserTablePage(){
        super("User Table", "https://jdi-testing.github.io/jdi-light/user-table.html");
        usernames = new ArrayList<>(usernamesWE.size());
        for (WebElement usernameWE : usernamesWE) usernames.add(usernameWE.getText());
    }

    public int getNumberTypeDropdownNumber(){
        return numberTypeDropdowns.size();
    }

    public int getUsernamesNumber(){
        return usernames.size();
    }

    public int getDescriptionNumber(){
        return descriptions.size();
    }

    public int getCheckboxesNumber(){
        return checkboxes.size();
    }

    public boolean checkNumberTypeDropdownsVisible(){
        for(WebElement dropdown : numberTypeDropdowns) if (!dropdown.isDisplayed()) return false;
        return true;
    }

    public boolean checkUsernamesVisible(){
        for(WebElement usernameWE : usernamesWE) if (!usernameWE.isDisplayed()) return false;
        return true;
    }

    public boolean checkDescriptionsVisible(){
        for(WebElement description : descriptions) if (!description.isDisplayed()) return false;
        return true;
    }

    public boolean checkCheckboxesVisible(){
        for(WebElement checkbox : checkboxes) if (!checkbox.isDisplayed()) return false;
        return true;
    }

    public List<String> getNumberTexts(){
        List<String> result = new ArrayList<>(numbers.size());
        for(WebElement number : numbers) result.add(number.getText());
        return result;
    }

    public List<String> getUsernameTexts(){
        return usernames;
    }

    public List<String> getDescritionTexts(){
        List<String> result = new ArrayList<>(descriptions.size());
        for(WebElement description : descriptions) result.add(description.getText());
        return result;
    }

    public List<String> getNumberTypeDropdownOptionsForUser(String name){
        int userIndex = usernames.indexOf(name);
        WebElement dropdown = numberTypeDropdowns.get(userIndex);
        List<WebElement> options = new Select(dropdown).getOptions();
        List<String> optionTexts = new ArrayList<>(options.size());
        for (WebElement option : options) optionTexts.add(option.getText());
        return optionTexts;
    }

    public void selectCheckbox(String name){
        checkboxes.get(usernames.indexOf(name)).click();
    }

    public List<String> getLog(){
        List<String> stringRows = new ArrayList(logRows.size());
        for (WebElement logRow : logRows) stringRows.add(logRow.getText());
        return stringRows;
    }
}
