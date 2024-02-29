package tests.api;

import api.pojo.Entity;
import api.requests.GetRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;


@Feature("API: Проверка Get запросов")
public class GetTest extends BaseTest {
    private static Response getResponse;
    private static Response getAllResponse;

    @BeforeAll
    public static void localSetUp() {
        getResponse = GetRequest.getEntityById(id);
        getAllResponse = GetRequest.getEntityAll();
    }

    @Test
    @Story("Get запрос по ID")
    public void apiGetByIdTest() {
        Assertions.assertEquals(id, getResponse.path("id").toString());
    }

    @Test
    @Story("Get запрос всех сущностей")
    public void apiGetAll() {
        List<Entity> entityList = getAllResponse.jsonPath().getList("entity", Entity.class);

        Assertions.assertFalse(entityList.isEmpty());
    }
}
