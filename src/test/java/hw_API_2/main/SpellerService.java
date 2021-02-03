package hw_API_2.main;

import com.google.gson.Gson;
import hw_API_2.main.DTO.ErrorDTO;
import hw_API_2.main.DTO.RequestDTO;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SpellerService {

    private Gson gson;
    private String URL;

    public SpellerService(){
        gson = new Gson();
        URL = new PropertiesManager().get("url");
    }

    public RequestSpecification getSpecification(String s) {
        return new RequestSpecBuilder()
                .setBaseUri(s)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public ErrorDTO[] checkTextPost(RequestDTO requestDTO) {
        RequestSpecification requestSpecification = getSpecification(URL + "checkText");

        return gson.fromJson(
                given(requestSpecification)
                        .body(gson.toJson(requestDTO))
                        .post()
                        .asString(),
                ErrorDTO[].class);
    }

    public ErrorDTO[] checkTextPost(String text) {
        RequestSpecification requestSpecification = getSpecification(URL + "checkText");

        return gson.fromJson(
                given(requestSpecification)
                        .body("{\"text\": \""+ text +"\"}")
                        .post()
                        .asString(),
                ErrorDTO[].class);
    }

    public ErrorDTO[] checkTextGet(RequestDTO requestDTO) {
        RequestSpecification requestSpecification = getSpecification(URL + "checkText");

        return gson.fromJson(
                given(requestSpecification)
                        .params(requestDTO.toMap())
                        .get()
                        .asString(),
                ErrorDTO[].class);
    }

    public ErrorDTO[] checkTextGet(String text) {
        RequestSpecification requestSpecification = getSpecification(URL);

        return gson.fromJson(
                given(requestSpecification)
                        .params("text", text)
                        .get("checkText")
                        .asString(),
                ErrorDTO[].class);
    }

    public ErrorDTO[] checkTextGet( int options, String text) {
        RequestSpecification requestSpecification = getSpecification(URL);

        return gson.fromJson(
                given(requestSpecification)
                        .params("text", text)
                        .params("options", options)
                        .get("checkText")
                        .asString(),
                ErrorDTO[].class);
    }

    public ErrorDTO[][] checkTextsGet(int options, String ... texts) {
        RequestSpecification requestSpecification = getSpecification(URL);

        return gson.fromJson(
                given(requestSpecification)
                        .params("text", texts)
                        .params("options", options)
                        .get("checkText")
                        .asString(),
                ErrorDTO[][].class);
    }

    public void assertWord(ErrorDTO[] errors, String correctWord){
        assertTrue(errors.length > 0);
        assertTrue(errors[0].getS().length > 0);
        assertEquals(errors[0].getS()[0], correctWord);
    }
}
