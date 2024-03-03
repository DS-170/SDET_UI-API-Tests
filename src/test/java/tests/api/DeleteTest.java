package tests.api;

import api.pojo.Entity;
import api.requests.CreateRequest;
import api.requests.DeleteRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.notNullValue;

@Feature("API: Проверка Delete запросов")
public class DeleteTest {
    private String id;


    @BeforeEach
    public void setUp() {
        Response createResponse = CreateRequest.createEntity(Entity.builder().build());
        id = createResponse.getBody().asString();
    }

    @Test
    @Story("Delete запрос по ID")
    public void deleteByIdTest() {
        Response deleteResponse = DeleteRequest.deleteEntityByID(id);

        deleteResponse
                .then()
                .statusCode(204)
                .body(notNullValue());
    }
}
