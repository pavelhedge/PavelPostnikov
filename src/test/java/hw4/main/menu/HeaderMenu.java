package hw4.main.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderMenu extends AbstractMenu {

    @FindBy(css = "ul.uui-navigation.nav>li>a")
    private List<WebElement> initItems;

    public HeaderMenu(WebDriver driver){
        super(driver);
        this.items = initItems;
    }
}
