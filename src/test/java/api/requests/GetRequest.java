package api.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class GetRequest extends BaseRequest {
    private static final int STATUS_CODE = 200;

    @Step("Запрос: /get/{id}")
    public static Response getEntityById(String id) {
        return given()
                .spec(baseRequest)
                .when()
                .get(baseURI + "/get/" + id)
                .then()
                .statusCode(STATUS_CODE)
                .extract().response();
    }

    @Step("Запрос: /get/{id} без проверки статускода")
    public static Response getEntityByIdNoStatusCheck(String id) {
        return given()
                .spec(baseRequest)
                .when()
                .get(baseURI + "/get/" + id)
                .then()
                .statusCode(STATUS_CODE)
                .extract().response();
    }

    @Step("Запрос: /getAll")
    public static Response getEntityAll() {
        return given()
                .spec(baseRequest)
                .when()
                .get(baseURI + "/getAll")
                .then()
                .statusCode(STATUS_CODE)
                .extract()
                .response();
    }
}
