package hw_API_2;

import hw_API_2.DTO.ErrorDTO;
import hw_API_2.DTO.subentities.ErrorCodes;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SpellerAssertions {
    public static  void assertWord(ErrorDTO[] errors, String correctWord){
        assertTrue(errors[0].getS().length > 0);
        assertEquals(errors[0].getS()[0], correctWord);
    }

    public static void assertError(ErrorDTO error, ErrorCodes errorCode){
        assertEquals(error.getCode(), errorCode.getValue(), "Error code differs from expected");
    }

}
