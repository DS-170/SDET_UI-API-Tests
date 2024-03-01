package tests.api;

import api.pojo.Entity;
import api.requests.CreateRequest;
import api.requests.DeleteRequest;
import api.requests.UpdateRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Feature("API: Проверка Patch запросов")
public class PatchTest {
    private static final ArrayList<Integer> newIntegers = new ArrayList<>(Arrays.asList(3, 2, 2));

    private static final Entity entityToEdite = Entity.builder()
            .title("Edited title")
            .verified(false)
            .importantNumbers(newIntegers)
            .addition(Entity.Addition.builder()
                    .additionalInfo("Edited additional info")
                    .additionalNumber(2)
                    .build())
            .build();
    private String id;

    @BeforeEach
    public void setUp() {
        Response createResponse = CreateRequest.createEntity(entityToEdite);
        id = createResponse.getBody().asString();
        UpdateRequest.updateEntityById(id, entityToEdite);
    }

    @AfterEach
    public void tearDown() {
        DeleteRequest.deleteEntityByID(id);
    }

    @Test
    @Story("Patch запрос по ID")
    public void patchByIdTest() {
        given()
                .when()
                .get(baseURI + "/get/" + id)
                .then()
                .body(
                        "important_numbers", equalTo(entityToEdite.getImportantNumbers()),
                        "title", equalTo(entityToEdite.getTitle()),
                        "verified", equalTo(entityToEdite.getVerified()),
                        "addition.additional_info", equalTo(entityToEdite.getAddition().getAdditionalInfo())
                );
    }
}
