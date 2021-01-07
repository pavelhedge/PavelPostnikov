package hw4.main.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LogItem extends AbstractMenu {

    @FindBy(css = "ul.panel-body-list.logs>li")
    private List<WebElement> initItems;

    public LogItem(WebDriver driver){
        super(driver);
        this.items = initItems;
    }
}
