package hw4.test.steps;

import hw4.main.DifferentElementsPage;
import hw4.main.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep{

    @Step("Открыть домашнуюю страницу")
    public void openHomePage(){
        homePage.open();
    }

    @Step("Залогиниться")
    public void logInToPage(String username, String password) {
        homePage.login(username, password);
    }


    public void switchToHomePageFrame(){
        homePage.switchToFrame("frame");
    }

    @Step("Перейти обратно на страницу")
    public void switchBackToHomePage() {
        homePage.switchToDefault();
    }

    @Step("Открыть в меню хэдера {0} -> {2}")
    public void selectInHeaderMenu(String itemName, String subItemName) {
        homePage.HeaderMenuSelect(itemName, subItemName);
        elemPage = new DifferentElementsPage();
    }

    @Step("Отметить чекбокс '{itemName}'")
    public void selectCheckBoxOnDiifferentElements(String itemName) {
        elemPage.selectCheckbox(itemName);
    }

    @Step("Выбрать радио '{itemName}'")
    public void selectRadioOnDiifferentElements(String itemName) {
        elemPage.selectRadio(itemName);
    }

    @Step("Выбрать в дропдаун '{itemName}'")
    public void selectDropDownOnDiifferentElements(String itemName) {
        elemPage.selectDropdown(itemName);
    }
}
