package tests.api;

import api.pojo.Entity;
import api.requests.CreateRequest;
import api.requests.DeleteRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.notNullValue;

@Feature("API: Проверка Create запросов")
public class CreateTest {
    private String id;
    private Response createResponse;

    @BeforeEach
    public void setUp() {
        createResponse = CreateRequest.createEntity(Entity.builder().build());
        id = createResponse.getBody().asString();
    }

    @AfterEach
    public void tearDown() {
        DeleteRequest.deleteEntityByID(id);
    }

    @Test
    @Story("Create запрос")
    public void createEntityTest() {

        createResponse
                .then()
                .statusCode(200)
                .body(notNullValue());
    }
}
