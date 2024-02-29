package api.requests;

import api.pojo.Entity;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class GetRequest extends BaseRequest {

    public static Response getEntityById(int id) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Entity entity = Entity.builder()
                .title("Test title")
                .verified(true)
                .important_numbers(integers)
                .addition(Entity.Addition.builder()
                        .additional_info("Test additional info")
                        .additional_number(1)
                        .build())
                .build();

        return given()
                .spec(baseRequest)
                .body(entity)
                .when()
                .post(baseURI + "/api/get/" + id)
                .then()
                .extract().response();
    }
}
