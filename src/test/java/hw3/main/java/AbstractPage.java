package hw3.main.java;

import hw3.main.java.menu.HeaderMenu;
import hw3.main.java.menu.HeaderServiceDropdown;
import hw3.main.java.menu.Selectable;
import hw3.main.java.menu.SideMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    WebDriver driver;

    public Selectable headerMenu;
    public Selectable sideMenu;
    public Selectable headerServiceDropdown;
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

    public AbstractPage(WebDriver driver) {
        headerMenu = new HeaderMenu(driver);
        sideMenu = new SideMenu(driver);
        headerServiceDropdown = new HeaderServiceDropdown(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AbstractPage(WebDriver driver, String url){
        this(driver);
        this.driver.get(url);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String getUserName(){
        return userNameText.getText();
    }

    public void login(String username, String password){
        showLoginForm.click();
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
}
