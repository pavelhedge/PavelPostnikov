package hw3.main.java.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractMenu {

    private List<WebElement> menuItems;

    public AbstractMenu(List<WebElement> menuItems){
        this.menuItems = menuItems;
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
