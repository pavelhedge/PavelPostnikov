package hw3.main.java.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;


public class SideMenu{

    @FindBy(css = "ul.sidebar-menu>li")
    private List<WebElement> menuItems;

    public SideMenu(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clickMenuItem(String menuItem){
        for(WebElement item : menuItems){
            if(item.getText().equals(menuItem)){
                item.click();
                break;
            }
        }
    }

    public List<String> getMenuItemsText() {
        List<String> result = new ArrayList(menuItems.size());
        for (WebElement menuItem : menuItems) {
            result.add(menuItem.getText());
        }
        return result;
    }
}
