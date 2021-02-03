package hw_API_2.test;

import hw_API_2.main.DTO.ErrorDTO;
import hw_API_2.main.DTO.RequestDTO;
import hw_API_2.main.Options;
import hw_API_2.main.SpellerService;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class YandexSpellerMethodsTest extends BasicTest {

	@Test
	void yaSpellerRepeatWords() {
		SpellerService service = new SpellerService();
		RequestDTO requestDTO = new RequestDTO("поезД едет едет на се4ер",
				Options.IGNORE_CAPITALIZATION,
				Options.FIND_REPEAT_WORDS,
				Options.IGNORE_DIGITS);
		ErrorDTO[] errors = service.checkTextGet(requestDTO);
		assertEquals(errors[0].getWord(), "едет");
		assertEquals(errors[0].getCode(), 2);
		assertEquals(errors[0].getLen(), 4);
		assertEquals(errors[0].getPos(), 11);
	}


	// checkTexts не работает через Get
	@Test
	public void spellerCheckTextsTest(){
		SpellerService service = new SpellerService();
		ErrorDTO[][] errors = service.checkTextsGet(
				Options.IGNORE_CAPITALIZATION.getValue(),
				"каРова", "малако", "светафор");
		service.assertWord(errors[0], "корова");
		service.assertWord(errors[1], "молоко");
		service.assertWord(errors[2], "светофор");
	}
}

