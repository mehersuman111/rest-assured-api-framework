package services.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    private static final String BASE_URI = "http://64.227.160.186:8080";

    RequestSpecification requestSpecification;

    protected BaseService(){
        requestSpecification = RestAssured.given()
                                        .baseUri(BASE_URI);
    }

    // POST Request
    protected Response postRequest(Object payload, String endpoint){
        return requestSpecification.contentType("application/json").body(payload).post(endpoint);
    }
}