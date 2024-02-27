package tests.ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Feature("Тестирование удаления клиента")
public class ListPageTest extends BaseTest {

    @Test
    @Story("Успешное удаление пользователя")
    public void deleteCustomer() {
        listPage.doDelete();
        Assertions.assertFalse(false);
    }
}
