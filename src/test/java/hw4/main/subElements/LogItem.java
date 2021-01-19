package hw4.main.subElements;

import hw4.main.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LogItem implements textGettable {

    @FindBy(css = "ul.panel-body-list.logs>li")
    private List<WebElement> items;

    public LogItem(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public List<String> getItemsText() {
        List<String> result = new ArrayList<>(items.size());
        for (WebElement menuItem : items) {
            result.add(menuItem.getText());
        }
        return result;
    }
}
