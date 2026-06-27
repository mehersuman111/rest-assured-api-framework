package services.banking;

import constants.EndPoints;
import io.restassured.response.Response;
import models.banking.request.authentication.LoginRequest;
import models.banking.request.authentication.SignupRequest;
import framework.base.BaseService;

import java.util.HashMap;

import static constants.ServicePath.AUTH;

public class AuthenticationService extends BaseService {

    //private static final String basePath = "/api/auth";

    public Response login(LoginRequest payload){
        return postRequest(payload, AUTH + EndPoints.LOGIN);
    }

    public Response signup(SignupRequest payload){
        return postRequest(payload,AUTH + EndPoints.SIGNUP);
    }

    public Response forgotPassword(String emailAddress){
        HashMap<String,String> payload = new HashMap<>();
        payload.put("email",emailAddress);
        return postRequest(payload,AUTH + EndPoints.FORGOT_PASSWORD);
    }

}
