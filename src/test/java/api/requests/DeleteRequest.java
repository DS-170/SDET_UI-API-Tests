package api.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DeleteRequest extends BaseRequest {
    private static final int STATUS_CODE = 204;

    @Step("Запрос: /delete/{id}")
    public static Response deleteEntityByID(String id) {
        return given()
                .spec(baseRequest)
                .when()
                .delete(baseURI + "/delete/" + id)
                .then()
                .extract().response();
    }
}
