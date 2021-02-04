package hw_API_2.tests;

import hw_API_2.BasicTest;
import hw_API_2.SpellerTestData;
import hw_API_2.DTO.RequestDTO;
import hw_API_2.DTO.ErrorDTO;
import static hw_API_2.SpellerAssertions.*;
import org.testng.annotations.Test;

public class YandexSpellerBasicTest extends BasicTest {

    @Test(dataProvider = "spellerBasicTestData", dataProviderClass = SpellerTestData.class)
    void yaSpellerGetWithDTO(String word, String correctWord) {
        RequestDTO requestDTO = new RequestDTO().text(word);
        ErrorDTO[] errors = service.checkTextGet(requestDTO);
        assertWord(errors, correctWord);
    }

    @Test(dataProvider = "spellerBasicTestData", dataProviderClass = SpellerTestData.class)
    void yaSpellerPost (String word, String correctWord) {
        ErrorDTO[] errors = service.checkTextPost(word);
        assertWord(errors, correctWord);
    }

    @Test(dataProvider = "spellerBasicTestData", dataProviderClass = SpellerTestData.class)
    void yaSpellerPostWithDTO (String word, String correctWord) {
        RequestDTO request = new RequestDTO().text(word);
        ErrorDTO[] errors = service.checkTextPost(request);
        assertWord(errors, correctWord);
    }
}
