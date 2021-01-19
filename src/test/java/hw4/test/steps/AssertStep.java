package hw4.test.steps;

import hw4.main.HomePage;
import io.qameta.allure.Step;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class AssertStep extends AbstractStep{

    @Step("Проверить имя страницы")
    public void checkTitle(String title){
        assertEquals(homePage.getTitle(), title);
    }

    @Step("Проверить, что выполнен вход как '{username}'")
    public void checkUserIsLoggedIn (String username){
        assertEquals(homePage.getUserName(), username);
    }

    @Step("Проверить элементы хедера")
    public void checkHeaderItems(List<String> expectedItems){
        assertEquals(homePage.getHeaderItems(), expectedItems);
    }

    @Step("Проверить, что видны {number} изображения")
    public void checkHomePageBenefitsImages(int number){
        assertEquals(homePage.getBenefitPicsAmount(), number);
        assertTrue(homePage.checkBenefitPicsDisplayed());
    }

    @Step("Проверить, что текст под бенефитами соответствует заданному")
    public void checkHomePageBenefitsText(List<String> expectedText){
        assertEquals(homePage.getBenefitTexts(), expectedText);
    }

    @Step("Проверить, что на странице есть фрейм")
    public void checkHomePageFrame(){
        assertTrue(homePage.frameExists());
    }

    @Step("Проверить, что в фрейме есть кнопка")
    public void checkHomePageFrameBtn(){
        assertTrue(homePage.frameBtnExists());
    }

    @Step("Проверить, что меню слева содержит нужные элементы")
    public void checkLeftSideMenuItems(List<String> expectedItems){
        assertEquals(homePage.sideMenu.getItemsText(), expectedItems);
    }

    @Step("Проверить, что в логе есть соответствующие записи")
    public void checkLogRecordsOnDifferentElementsPage(List<String> expectedItems){
        List<String> logTexts = elemPage.getLog();
        System.out.println(logTexts);
        for (int i = 0; i < logTexts.size(); i++) {
            assertTrue(logTexts.get(i).contains(expectedItems.get(i)));
        }
    }

}