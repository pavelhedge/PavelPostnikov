package hw_API_2.tests;

import hw_API_2.BasicTest;
import hw_API_2.DTO.RequestDTO;
import hw_API_2.DTO.ErrorDTO;
import hw_API_2.DTO.RequestsDTO;
import hw_API_2.SpellerService;
import org.testng.annotations.Test;

import java.util.Arrays;

import static hw_API_2.DTO.subentities.Options.*;
import static hw_API_2.DTO.subentities.ErrorCodes.*;
import static org.testng.Assert.assertTrue;
import static hw_API_2.SpellerAssertions.assertError;

public class YandexSpellerFeaturesTest extends BasicTest {

	@Test
	void spellerOptions() {
		SpellerService service = new SpellerService();
		RequestDTO requestDTO = new RequestDTO("поезД едет едет на 4евер mail.ru",
				IGNORE_CAPITALIZATION,
				FIND_REPEAT_WORDS,
				IGNORE_DIGITS,
				IGNORE_URLS);
		ErrorDTO[] errorsCheck = new ErrorDTO[]{new ErrorDTO().setWord("едет")};
		assertTrue(Arrays.equals(errorsCheck, service.checkTextGet(requestDTO)));
	}

	@Test
	public void spellerErrorCodes(){
		RequestsDTO requestsDTO = new RequestsDTO()
				.setOptions(FIND_REPEAT_WORDS)
				.setText("карова")
				.setText("молоко молоко")
				.setText("иван петрович")
				.setText("флфваждлодлфыва");
		ErrorDTO[][] errors = service.checkTextGet(requestsDTO);
		assertError(errors[0][0], ERROR_UNKNOWN_WORD);
		assertError(errors[1][0], ERROR_REPEAT_WORD);
		assertError(errors[2][0], ERROR_CAPITALIZATION);
		assertError(errors[2][0], ERROR_TOO_MANY_ERRORS);
	}
}

