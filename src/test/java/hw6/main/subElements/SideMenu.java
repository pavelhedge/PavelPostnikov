package hw6.main.subElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SideMenu extends AbstractMenu {

    @FindBy(css = "ul.sidebar-menu>li>a")
    private List<WebElement> initItems;

    public SideMenu(){
        this.items = initItems;
    }
}
