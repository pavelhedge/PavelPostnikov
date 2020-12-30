package hw3.main.java.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HeaderServiceDropdown extends AbstractMenu {

    @FindBy(css = "ul.uui-navigation.nav .dropdown-menu>li")
    private List<WebElement> initItems;

    public HeaderServiceDropdown(WebDriver driver){
        super(driver);
        this.items = initItems;
    }
}
