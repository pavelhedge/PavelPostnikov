package hw4.main.subElements;

import hw4.main.AbstractPage;
import hw4.main.DifferentElementsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderSubMenu extends AbstractMenu {

    @FindBy(css = "ul.uui-navigation.nav .dropdown-menu>li")
    private List<WebElement> initItems;

    public HeaderSubMenu(){
        this.items = initItems;
    }

    public AbstractPage subSelect(String itemName){
        select(itemName);
        if (itemName.equals("DIFFERENT ELEMENTS")) {
            return new DifferentElementsPage();
        }
        else return null;
    }
}