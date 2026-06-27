package banking.authentication;

import io.restassured.response.Response;
import models.banking.request.authentication.SignupRequest;
import org.testng.annotations.Test;
import services.banking.AuthenticationService;

public class AccountCreationTest {

    @Test(description = "Verify the account creation")
    public void createAccountTest(){
        SignupRequest signupRequest = new SignupRequest.Builder()
                                                        .username("TestUser02").password("Test@123")
                                                        .email("test@techwithjatin.com")
                                                        .firstName("Test").lastName("Engineer")
                                                        .mobileNumber(8390202002L).build();
        AuthenticationService authenticationService = new AuthenticationService();
        Response response = authenticationService.signup(signupRequest);
        System.out.println(response.asPrettyString());
    }
}
