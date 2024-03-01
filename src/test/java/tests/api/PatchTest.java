package tests.api;

import api.pojo.Entity;
import api.requests.UpdateRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Feature("API: Проверка Patch запросов")
public class PatchTest extends BaseTest {
    private static final ArrayList<Integer> newIntegers = new ArrayList<>(Arrays.asList(3, 2, 2));
    private static Response patchResponse;

    private static Entity entityToEdite = Entity.builder()
            .title("Edited title")
            .verified(false)
            .importantNumbers(newIntegers)
            .addition(Entity.Addition.builder()
                    .additionalInfo("Edited additional info")
                    .additionalNumber(2)
                    .build())
            .build();

    @BeforeAll
    public static void localSetUp() {
        patchResponse = UpdateRequest.updateEntityById(id, entityToEdite);
    }

    @Test
    @Story("Patch запрос по ID")
    public void patchById() {
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
