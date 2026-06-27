package banking.userManagement;

import io.restassured.response.Response;
import models.banking.request.authentication.LoginRequest;
import models.banking.response.authentication.LoginResponse;
import models.banking.response.userManagement.UserProfileResponse;
import org.testng.annotations.Test;
import services.banking.AuthenticationService;
import services.banking.UserManagementService;

public class GetUserProfileList {

    @Test(description = "To verify that the user is getting all the available profile list.")
    public void getProfileList(){

        LoginRequest loginRequest = new LoginRequest("mehersuman111","Suman@123");
        AuthenticationService authenticationService = new AuthenticationService();
        Response loginResponse = authenticationService.login(loginRequest);
        LoginResponse loginResponseObj = loginResponse.as(LoginResponse.class);
        String token = loginResponseObj.getToken();
        System.out.println(token);
        UserManagementService userManagementService = new UserManagementService();
        Response response = userManagementService.getUserProfile(token);
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        System.out.println(userProfileResponse.toString());
    }
}
