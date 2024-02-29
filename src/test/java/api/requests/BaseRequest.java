package api.requests;

import api.pojo.Entity;
import helpers.ConfPropertiesReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class BaseRequest {
    public static Entity baseEntity;
    static ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    public static RequestSpecification baseRequest =
            given()
                    .contentType(ContentType.JSON);

    static {
        RestAssured.baseURI = ConfPropertiesReader.getProperty("API_URL");

        baseEntity = Entity.builder()
                .title("Test title")
                .verified(true)
                .important_numbers(integers)
                .addition(Entity.Addition.builder()
                        .additional_info("Test additional info")
                        .additional_number(1)
                        .build())
                .build();
    }
}
