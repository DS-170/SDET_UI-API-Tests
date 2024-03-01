package tests.api;

import api.pojo.Entity;
import api.requests.CreateRequest;
import api.requests.DeleteRequest;
import api.requests.GetRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


@Feature("API: Проверка Get запросов")
public class GetTest {
    private String id;
    private Response getResponseId;
    private List<Entity> entityList;

    @BeforeEach
    public void setUp() {
        Response createResponse = CreateRequest.createEntity(Entity.builder().build());
        id = createResponse.getBody().asString();
        getResponseId = GetRequest.getEntityById(id);
        entityList = GetRequest.getEntityAll().jsonPath().getList("entity", Entity.class);
    }

    @AfterEach
    public void tearDown() {
        DeleteRequest.deleteEntityByID(id);
    }

    @Test
    @Story("Get запрос по ID")
    public void apiGetByIdTest() {
        Assertions.assertEquals(id, getResponseId.path("id").toString());
    }

    @Test
    @Story("Get запрос всех сущностей")
    public void apiGetAllTest() {
        Assertions.assertTrue(entityList.size() > 0);
    }
}
