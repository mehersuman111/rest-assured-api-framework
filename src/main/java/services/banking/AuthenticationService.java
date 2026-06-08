package services.banking;

import io.restassured.response.Response;
import models.banking.request.authentication.LoginRequest;
import services.base.BaseService;

public class AuthenticationService extends BaseService {

    private static final String basePath = "/api/auth";

    public Response login(LoginRequest payload){
        return postRequest(payload,basePath+"/login");
    }
}
