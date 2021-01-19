package hw6.main.subElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ElemRadio extends AbstractMenu {

    @FindBy(xpath = "//input[@type='radio']//parent::label")
    private List<WebElement> initItems;

    public ElemRadio(){
        super();
        this.items = initItems;
    }
}
