package hw6.main;

import hw6.main.subElements.UserEntry;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserTablePage extends AbstractPage{

    @FindBy(css = "#user-table td:nth-child(1)")
    List<WebElement> number;
    @FindBy(css = "#user-table select")
    List<WebElement> dropdown;
    @FindBy(css = "#user-table a")
    List<WebElement> username;
    @FindBy(css = "#user-table .user-descr span")
    List<WebElement> description;
    @FindBy(css = "#user-table input")
    List<WebElement> checkbox;

    public UserTablePage(){
        super("User Table", "https://jdi-testing.github.io/jdi-light/user-table.html");
    }

}
