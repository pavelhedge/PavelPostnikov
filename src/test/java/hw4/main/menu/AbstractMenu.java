package hw4.main.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMenu implements Selectable {

    List<WebElement> items;

    public AbstractMenu(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void select(String itemName){
        for(WebElement item : items){
            if(item.getText().equals(itemName)){
                item.click();
                break;
            }
        }
    }

    public List<String> getItemsText() {
        List<String> result = new ArrayList<>(items.size());
        for (WebElement menuItem : items) {
            result.add(menuItem.getText());
        }
        return result;
    }


}
