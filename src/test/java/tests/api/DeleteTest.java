package tests.api;

import api.requests.DeleteRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.notNullValue;

@Feature("API: Проверка Delete запросов")
public class DeleteTest extends BaseTest {
    private static Response deleteResponse;

    @BeforeAll
    public static void localSetUp() {
        deleteResponse = DeleteRequest.deleteEntityByID(id);
    }

    @Test
    @Story("Delete запрос по ID")
    public void deleteById() {
        deleteResponse
                .then()
                .statusCode(204)
                .body(notNullValue());
    }
}
