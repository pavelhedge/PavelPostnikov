package hw3.main.java.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ElemCheckboxes {

    @FindBy(xpath = "//input[@type='checkbox']//parent::label")
    private List<WebElement> checkboxItems;

    public ElemCheckboxes(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public void selectMenuItem(String menuItem){
        for(WebElement item : checkboxItems){
            if(item.getText().equals(menuItem)){
                item.click();
                break;
            }
        }
    }
}
