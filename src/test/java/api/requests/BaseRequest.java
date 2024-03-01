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
    public static RequestSpecification baseRequest =
            given()
                    .contentType(ContentType.JSON);
    static Entity baseEntity;
    public static ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

    static {
        RestAssured.baseURI = ConfPropertiesReader.getProperty("API_URL");

        baseEntity = Entity.builder()
                .title("Test title")
                .verified(true)
                .importantNumbers(integers)
                .addition(Entity.Addition.builder()
                        .additionalInfo("Test additional info")
                        .additionalNumber(1)
                        .build())
                .build();
    }
}
