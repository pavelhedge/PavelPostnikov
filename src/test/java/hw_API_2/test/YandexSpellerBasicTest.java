package hw_API_2.test;

import hw_API_2.main.DTO.RequestDTO;
import hw_API_2.main.DTO.ErrorDTO;
import hw_API_2.main.SpellerService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class YandexSpellerBasicTest extends BasicTest{

    @Test(dataProvider = "spellerBasicTestData", dataProviderClass = SpellerTestData.class)
    void yaSpellerGet(String word, String correctWord) {
        RequestDTO requestDTO = new RequestDTO().text(word);
        ErrorDTO[] errors = service.checkTextPost(requestDTO);
        service.assertWord(errors, correctWord);
    }

    @Test(dataProvider = "spellerBasicTestData", dataProviderClass = SpellerTestData.class)
    void yaSpellerGetWithDTO(String word, String correctWord) {
        RequestDTO requestDTO = new RequestDTO().text(word);
        ErrorDTO[] errors = service.checkTextGet(requestDTO);
        service.assertWord(errors, correctWord);
    }

    @Test(dataProvider = "spellerBasicTestData", dataProviderClass = SpellerTestData.class)
    void yaSpellerPost (String word, String correctWord) {
        ErrorDTO[] errors = service.checkTextPost(word);
        service.assertWord(errors, correctWord);
    }

    @Test(dataProvider = "spellerBasicTestData", dataProviderClass = SpellerTestData.class)
    void yaSpellerPostWithDTO (String word, String correctWord) {
        RequestDTO request = new RequestDTO().text(word);
        ErrorDTO[] errors = service.checkTextPost(request);
        service.assertWord(errors, correctWord);
    }
}
