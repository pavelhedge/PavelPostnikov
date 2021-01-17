package hw4.main.subElements;

import hw4.main.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderMenu extends AbstractMenu {

    @FindBy(css = "ul.uui-navigation.nav>li>a")
    private List<WebElement> initItems;

    HeaderSubMenu subMenu;

    public HeaderMenu(){
        this.items = initItems;
        this.subMenu = new HeaderSubMenu();
    }

    public AbstractPage select(String itemName, String subItemName){
        select(itemName);
        return subMenu.subSelect(subItemName);
    }
}