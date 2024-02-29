package tests.api;

import api.requests.CreateRequest;
import api.requests.DeleteRequest;
import api.requests.GetRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@Feature("API: Проверка Delete запросов")
public class DeleteTest {
    private static String localId;

    @BeforeAll
    public static void localSetUp() {
        localId = CreateRequest.createEntity().getBody().asString();
    }

    @Test
    @Story("Delete запрос по ID")
    public void deleteById() {
        DeleteRequest.deleteEntityByID(localId);

        Assertions.assertEquals(
                "{\"error\":\"no rows in result set\"}",
                GetRequest.getEntityByIdNoStatusCheck(localId).getBody().asString());
    }
}
