package api.requests;

import api.pojo.Entity;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class CreateRequest extends BaseRequest {

    @Step("Запрос: /create (1)")
    public static Response createEntity(Entity entity) {
        return given()
                .spec(baseRequest)
                .body(entity)
                .when()
                .post(baseURI + "/create");
    }
}
