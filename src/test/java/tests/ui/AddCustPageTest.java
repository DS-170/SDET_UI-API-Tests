package tests.ui;

import helpers.ConfPropertiesReader;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Feature("Тест создания нового пользователя")
public class AddCustPageTest extends BaseTest {

    @Test
    @Story("Кейс успешного добавления пользователя")
    public void addCustomerTest() {
        addCustPage.doRegistration();

        Assertions.assertTrue(
                addCustPage.getConfirmTittle().contains(ConfPropertiesReader.getProperty("add_confirmation"))
        );
    }
}
