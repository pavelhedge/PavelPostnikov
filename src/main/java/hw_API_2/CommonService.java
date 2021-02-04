package hw_API_2;

import hw_API_2.DTO.RequestDTO;
import hw_API_2.DTO.RequestsDTO;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CommonService {
    private RequestSpecification requestSpecification;

    public CommonService(String URL) {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(URL)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public String post(String service, String json){
        return given(requestSpecification)
                .body(json)
                .post(service)
                .asString();
    }

    public String get(String service, Map<String, ?> request){
        return given(requestSpecification)
                .params(request)
                .get(service)
                .asString();
    }
}
