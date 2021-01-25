package hw6.main.subElements;

import hw6.main.utils.DriverManager;
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
    }

    private void initSelect(){
        if (dropdown == null) dropdown = new Select(dropdownWE);
    }

    public void select(String itemName){
        initSelect();
        dropdown.selectByVisibleText(itemName);
    }

    public List<String> getItemsText(){
        initSelect();
        List<WebElement> items = dropdown.getOptions();
        List<String> itemsText = new ArrayList<>(items.size());
        for (WebElement item : items){
            itemsText.add(item.getText());
        }
        return itemsText;
    }
}