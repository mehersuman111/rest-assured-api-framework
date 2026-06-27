package banking.authentication.forgotpassword;

import io.restassured.response.Response;
import models.banking.request.authentication.LoginRequest;
import models.banking.response.authentication.LoginResponse;
import org.testng.annotations.Test;
import services.banking.AuthenticationService;

public class LoginAPITest {

    @Test(description = "Verify that the user is able to login successfully.")
    public void login() {
        // When we have not done the static import

        //RestAssured.baseURI = "http://64.227.160.186:8080/";

        /*
        RequestSpecification requestSpecification1 = RestAssured.given();
        RequestSpecification requestSpecification2 = requestSpecification1.header("Content-Type","application/json");
        RequestSpecification requestSpecification3 = requestSpecification2.body("{ \"username\": \"mehersuman111\", \"password\": \"Suman@123\" }");
        Response response = requestSpecification3.post();
         */

        // Bit improved version (Optimization)
        /*
        RequestSpecification requestSpecification1 = RestAssured.given()
                                                                    .header("Content-Type","application/json")
                                                                    .body("{ \"username\": \"mehersuman111\", \"password\": \"Suman@123\" }");
        Response response = requestSpecification1.post();
         */

        // Bit more optimization
        /*Response response = RestAssured.given()
                                        .header("Content-Type","application/json")
                                        .body("{ \"username\": \"mehersuman111\", \"password\": \"Suman@123\" }")
                                        .post();
        */

        // When static import have been done, we do not need to use the class name.method/variable name, we can simply write below
        //baseURI = "http://64.227.160.186:8080/";
        /*Response response = given()
                .baseUri("http://64.227.160.186:8080/")
                .header("Content-Type", "application/json")
                .body("{ \"username\": \"mehersuman111\", \"password\": \"Suman@123\" }")
                .post();

         */

        // Using the created Service Object Design Pattern


        LoginRequest loginRequest = new LoginRequest("mehersuman111","Suman@123");
        AuthenticationService authenticationService = new AuthenticationService();
        Response response = authenticationService.login(loginRequest);
        System.out.println(response.getBody());
        // Deserialization
        LoginResponse loginResponse =  response.as(LoginResponse.class);

        System.out.println(loginResponse.getToken());
    }
}