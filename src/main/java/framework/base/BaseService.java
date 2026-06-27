package framework.base;

import constants.BaseURI;
import constants.HttpStatus;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class BaseService {

    private RequestSpecification requestSpecification;

    protected BaseService(){
        requestSpecification = RestAssured.given()
                                        .baseUri(BaseURI.BANKING_BASE_URI);
    }

    // Auth token setting
    protected void setAuthToken(String token){
        requestSpecification.header("Authorization","Bearer " + token);
    }

    // GET Request
    protected Response getRequest(String endpoint) {
        return requestSpecification.get(endpoint);
    }
    protected Response getRequestQP(String paramName, String paramValue,String endpoint){
        return requestSpecification.queryParam(paramName,paramValue).get(endpoint);
    }
    protected Response getRequestPP(String pathParamName, String pathParamValue, String endpoint){
        return requestSpecification.pathParam(pathParamName,pathParamValue).get(endpoint);
    }

    // POST Request
    protected Response postRequest(Object payload, String endpoint){
        return requestSpecification.contentType("application/json").body(payload).post(endpoint);
    }
    protected Response postRequest(Map payload, String endpoint){
        return requestSpecification.contentType("application/json").body(payload).post(endpoint);
    }

    // PUT Request
    protected Response putRequest(Object payload, String endpoint){
        return requestSpecification.contentType("application/json").body(payload).put(endpoint);
    }
}