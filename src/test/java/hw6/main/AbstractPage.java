package hw6.main;

import hw6.main.subElements.HeaderMenu;
import hw6.main.subElements.SideMenu;
import hw6.main.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class AbstractPage {

    public final String title;
    public final String url;
    WebDriver driver;

    HeaderMenu headerMenu;
    SideMenu sideMenu;

    @FindBy(id = "user-icon")
    WebElement showLoginForm;
    @FindBy(id = "name")
    WebElement userNameInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "login-button")
    WebElement loginBtn;
    @FindBy(id = "user-name")
    WebElement userNameText;

    public AbstractPage(String title, String url) {
        headerMenu = new HeaderMenu();
        sideMenu = new SideMenu();
        this.driver = DriverManager.getDriver();
        //if (!driver.getTitle().equals(title)) throw new IllegalStateException("This is not the " + title + " page");
        PageFactory.initElements(DriverManager.getDriver(), this);
        this.title = title;
        this.url = url;
    }

    public void open(){
        driver.get(url);
    }

    public String getExpectedTitle(){ return title; }

    public String getTitle(){
        return driver.getTitle();
    }

    public String getUserName(){
        return userNameText.getText();
    }

    public void login(String username, String password){
        showLoginForm();
        enterUsername(username);
        enterPassword(password);
        clickLoginBtn();
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterUsername(String username) {
        userNameInput.sendKeys(username);
    }

    public void showLoginForm() {
        showLoginForm.click();
    }

    public void headerMenuSelect(String itemName, String subItemName){
        headerMenu.select(itemName, subItemName);
    }

    public void headerMenuSelect(String itemName){
        headerMenu.select(itemName);
    }

    public AbstractPage headerServiceSubmenuSelect(String subItemName){
        return headerMenu.subSelect(subItemName);
    }

    public List<String> getHeaderItems(){
        return headerMenu.getItemsText();
    }
}
