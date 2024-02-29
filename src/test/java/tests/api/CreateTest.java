package tests.api;

import api.pojo.Entity;
import api.requests.CreateRequest;
import api.requests.DeleteRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static api.requests.BaseRequest.baseRequest;
import static api.requests.GetRequest.getEntityById;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Feature("API: Проверка Create запросов")
public class CreateTest {
    private static final ArrayList<Integer> newIntegers = new ArrayList<>(Arrays.asList(1, 1, 1));
    private static String localId;
    private static Response deleteResponse;

    private static Entity entityToCreate = Entity.builder()
            .title("Create test title")
            .verified(true)
            .important_numbers(newIntegers)
            .addition(Entity.Addition.builder()
                    .additional_info("Create test additional info")
                    .additional_number(0)
                    .build())
            .build();

    @BeforeAll
    public static void localSetUp() {
        localId = CreateRequest.createEntity(entityToCreate).getBody().asString();
    }

    @AfterAll
    public static void localTearDown() {
        deleteResponse = DeleteRequest.deleteEntityByID(localId);
    }

    @Test
    @Story("Create запрос")
    public void createEntity() {
        given()
                .spec(baseRequest)
                .when()
                .get(baseURI + "/get/" + localId)
                .then()
                .body(
                        "important_numbers", equalTo(entityToCreate.getImportant_numbers()),
                        "title", equalTo(entityToCreate.getTitle()),
                        "verified", equalTo(entityToCreate.getVerified()),
                        "addition.additional_info", equalTo(entityToCreate.getAddition().getAdditional_info())
                );
    }
}
