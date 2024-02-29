package api.requests;

import helpers.ConfPropertiesReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseRequest {
    static {
        RestAssured.baseURI = ConfPropertiesReader.getProperty("API_URL");
    }

    static RequestSpecification baseRequest =
            given()
                    .contentType(ContentType.JSON);
}
