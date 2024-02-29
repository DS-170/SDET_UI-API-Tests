package api.requests;

import api.pojo.Entity;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class CreateRequest extends BaseRequest {
    private static final int STATUS_CODE = 200;

    @Step("Запрос: /create (1)")
    public static Response createEntity() {
        return given()
                .spec(baseRequest)
                .body(baseEntity)
                .when()
                .post(baseURI + "/create")
                .then()
                .statusCode(STATUS_CODE)
                .extract().response();
    }

    @Step("Запрос: /create (2)")
    public static Response createEntity(Entity entity) {
        return given()
                .spec(baseRequest)
                .body(entity)
                .when()
                .post(baseURI + "/create")
                .then()
                .statusCode(STATUS_CODE)
                .extract().response();
    }
}
