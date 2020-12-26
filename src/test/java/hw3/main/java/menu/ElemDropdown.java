package hw3.main.java.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ElemDropdown {

    @FindBy(css = "select.uui-form-element")
    private WebElement dropdownWE;
    private Select dropdown;

    public ElemDropdown(WebDriver driver){
        PageFactory.initElements(driver, this);
        dropdown = new Select(dropdownWE);
    }


    public void selectMenuItem(String menuItem){
        dropdown.selectByVisibleText(menuItem);
    }
}
