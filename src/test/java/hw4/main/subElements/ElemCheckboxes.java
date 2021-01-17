package hw4.main.subElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ElemCheckboxes extends AbstractMenu {

    @FindBy(xpath = "//input[@type='checkbox']//parent::label")
    private List<WebElement> initItems;

    public ElemCheckboxes(){
        this.items = initItems;
    }
}
