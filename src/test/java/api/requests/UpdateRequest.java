package api.requests;

import api.pojo.Entity;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class UpdateRequest extends BaseRequest {
    private static final int STATUS_CODE = 204;

    @Step("Запрос: /api/patch/{id}")
    public static Response updateEntityById(String id, Entity newEntity) {
        return given()
                .spec(baseRequest)
                .body(newEntity)
                .when()
                .patch(baseURI + "/patch/" + id)
                .then()
                .statusCode(STATUS_CODE)
                .extract().response();
    }
}
