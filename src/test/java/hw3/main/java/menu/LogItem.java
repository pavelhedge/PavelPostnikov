package hw3.main.java.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;


public class LogItem {

    @FindBy(css = "ul.panel-body-list.logs>li")
    private List<WebElement> logItems;

    public LogItem(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public List<String> getMenuItemsText() {
        List<String> result = new ArrayList(logItems.size());
        for (WebElement menuItem : logItems) {
            result.add(menuItem.getText());
        }
        return result;
    }
}
