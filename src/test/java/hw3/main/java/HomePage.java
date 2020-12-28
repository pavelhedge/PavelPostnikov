package hw3.main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;


public class HomePage extends AbstractPage{

    @FindBy(css = ".benefit>div>span")
    List<WebElement> benefitPics;
    @FindBy(className = "benefit")
    List<WebElement> benefitTexts;
    @FindBy(id = "frame")
    WebElement frame;
    @FindBy(id = "frame-button")
    WebElement frameBtn;

    public HomePage(WebDriver driver, String url){
        super(driver, url);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getBenefitPics(){
        return benefitPics;
    }

    public List<String> getBenefitTexts(){
        List<String> result = new ArrayList(headerMenu.getMenuItemsText().size());
        for (WebElement menuItem: benefitTexts) {
            result.add(menuItem.getText());
        }
        return result;
    }

    public boolean frameExists(){
        return frame.isDisplayed();
    }

    public void switchToFrame(String frame){
        driver.switchTo().frame(frame);
    }

    public void switchToDefault(){
        driver.switchTo().defaultContent();
    }

    public boolean frameBtnExists(){
        return frameBtn.isDisplayed();
    }

}
