package banking.authentication;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import services.banking.AuthenticationService;

public class ForgotPasswordTest {

    @Test(description = "Verify that the user is able to do reset of password successfully.")
    public void resetPassword(){
        AuthenticationService authenticationService = new AuthenticationService();
        Response response = authenticationService.forgotPassword("mehersuman111@gmail.com");
        System.out.println(response.prettyPrint());
    }
}
