package hw4.main.subElements;

import hw4.main.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMenu implements Selectable, textGettable {

    List<WebElement> items;

    public AbstractMenu(){
        PageFactory.initElements(DriverManager.getDriver(), this);
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
