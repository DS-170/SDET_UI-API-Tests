package tests.api;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.notNullValue;

@Feature("API: Проверка Create запросов")
public class CreateTest extends BaseTest {

    @Test
    @Story("Create запрос")
    public void createEntity() {

        createResponse
                .then()
                .statusCode(200)
                .body(notNullValue());
    }
}
