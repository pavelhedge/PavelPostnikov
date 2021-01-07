package hw4.main.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SideMenu extends AbstractMenu {

    @FindBy(css = "ul.sidebar-menu>li")
    private List<WebElement> initItems;

    public SideMenu(WebDriver driver){
        super(driver);
        this.items = initItems;
    }
}
