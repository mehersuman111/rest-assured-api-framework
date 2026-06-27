package banking.userManagement;

import framework.base.BaseTest;
import io.restassured.response.Response;
import models.banking.request.authentication.LoginRequest;
import models.banking.request.usermanagement.ProfileRequest;
import models.banking.response.authentication.LoginResponse;
import models.banking.response.userManagement.UserProfileResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.banking.AuthenticationService;
import services.banking.UserManagementService;

public class UpdateProfileTest extends BaseTest {

    @Test(description = "Verify that the user is able to update the profile successfully.")
    public void updateProfile(){
        LoginRequest loginRequest = new LoginRequest("mehersuman111","Suman@123");
        AuthenticationService authenticationService = new AuthenticationService();
        Response response = authenticationService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        String token = loginResponse.getToken();

        ProfileRequest profileRequest = new ProfileRequest.Builder().email("mehersuman222@gmail.com").build();
        UserManagementService userManagementService = new UserManagementService();
        Response response1 = userManagementService.updateProfile(token,profileRequest);
        UserProfileResponse userProfileResponse = response1.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getEmail(),"mehersuman222@gmail.com");

    }


}
