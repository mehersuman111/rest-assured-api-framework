package services.banking;

import constants.EndPoints;
import io.restassured.response.Response;
import models.banking.request.usermanagement.ProfileRequest;
import framework.base.BaseService;

import static constants.ServicePath.USERS;

public class UserManagementService extends BaseService {

    public Response getUserProfile(String token){
        setAuthToken(token);
        return getRequest(USERS+ EndPoints.PROFILE);
    }
    public Response updateProfile(String token, ProfileRequest payload){
        setAuthToken(token);
        return putRequest(payload,USERS+ EndPoints.PROFILE);
    }

}
