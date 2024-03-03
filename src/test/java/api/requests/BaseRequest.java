package api.requests;

import helpers.ConfPropertiesReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseRequest {
    public static RequestSpecification baseRequest = given().contentType(ContentType.JSON);

    static {
        RestAssured.baseURI = ConfPropertiesReader.getProperty("API_URL");
    }
}
