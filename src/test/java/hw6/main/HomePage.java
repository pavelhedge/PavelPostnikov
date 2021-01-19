package hw6.main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(css = ".benefit>div>span")
    List<WebElement> benefitPics;
    @FindBy(className = "benefit")
    List<WebElement> benefitTexts;
    @FindBy(id = "frame")
    WebElement frame;
    @FindBy(id = "frame-button")
    WebElement frameBtn;

    public HomePage(){
        super( "Home Page", "https://jdi-testing.github.io/jdi-light/index.html");
        PageFactory.initElements(driver, this);
    }

    public void open(){
        driver.get(url);
    }

    public int getBenefitPicsAmount(){
        return benefitPics.size();
    }

    public boolean checkBenefitPicsDisplayed() {
        boolean result = true;
        for (WebElement pic : benefitPics) if (!pic.isDisplayed()) result = false;
        return result;
    }

    public List<String> getBenefitTexts(){
        List<String> result = new ArrayList<>(headerMenu.getItemsText().size());
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
