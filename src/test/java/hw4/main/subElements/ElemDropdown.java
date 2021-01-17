package hw4.main.subElements;

import hw4.main.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ElemDropdown implements Selectable {

    @FindBy(css = "select.uui-form-element")
    private WebElement dropdownWE;

    private Select dropdown;

    public ElemDropdown(){
        WebDriver driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        dropdown = new Select(dropdownWE);
    }

    public void select(String itemName){
        dropdown.selectByVisibleText(itemName);
    }

    public List<String> getItemsText(){
        List<WebElement> items = dropdown.getOptions();
        List<String> itemsText = new ArrayList<>(items.size());
        for (WebElement item : items){
            itemsText.add(item.getText());
        }
        return itemsText;
    }
}