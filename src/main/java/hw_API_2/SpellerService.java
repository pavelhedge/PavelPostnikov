package hw_API_2;

import com.google.gson.Gson;
import hw_API_2.DTO.ErrorDTO;
import hw_API_2.DTO.RequestDTO;
import hw_API_2.DTO.RequestsDTO;
import hw_API_2.utils.PropertiesManager;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class SpellerService {

    private Gson gson;
    private CommonService commonService;

    public final String TEXT = "checkText";
    public final String TEXTS = "checkTexts";

    public SpellerService(){
        gson = new Gson();
        commonService = new CommonService(new PropertiesManager().get("url"));
    }

    public ErrorDTO[] checkTextPost(RequestDTO requestDTO) {
        return gson.fromJson(
                commonService.post(TEXT, gson.toJson(requestDTO)),
                ErrorDTO[].class);
    }

    public ErrorDTO[] checkTextPost(String text) {
        return gson.fromJson(
                commonService.post(TEXT, "{\"text\": \""+ text +"\"}"),
                ErrorDTO[].class);
    }

    public ErrorDTO[] checkTextGet(RequestDTO requestDTO) {
        return gson.fromJson(
                commonService.get(TEXT, requestDTO.toMap()),
                ErrorDTO[].class);
    }

    public ErrorDTO[] checkTextGet(String text) {
        return gson.fromJson(
                commonService.get(TEXT, new HashMap<String, String>(){{put("text", text);}}),
                ErrorDTO[].class);
    }

    public ErrorDTO[][] checkTextGet(RequestsDTO requestsDTO) {
        return gson.fromJson(
                commonService.get(TEXTS, requestsDTO.toMap()),
                ErrorDTO[][].class);
    }
}
