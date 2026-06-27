package framework.base;

import constants.BaseURI;
import constants.HttpStatus;
import io.restassured.RestAssured;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.anyOf;

public class BaseTest {

    @BeforeSuite
    public void checkServerAvailability(){
        try{
            RestAssured.given()
                            .baseUri(BaseURI.BANKING_BASE_URI)
                    .when()
                            .head("/")
                    .then()
                            .statusCode(anyOf(is(HttpStatus.OK.getCode()),is(HttpStatus.NO_CONTENT.getCode())));
        } catch (Exception e) {
            throw new SkipException("Service is not reachable, So skipping the suite execution...", e);
        }
    }
}