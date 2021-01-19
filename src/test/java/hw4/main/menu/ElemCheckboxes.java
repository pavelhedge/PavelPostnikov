package hw4.main.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ElemCheckboxes extends AbstractMenu {

    @FindBy(xpath = "//input[@type='checkbox']//parent::label")
    private List<WebElement> initItems;

    public ElemCheckboxes(WebDriver driver){
        super(driver);
        this.items = initItems;
    }
}
