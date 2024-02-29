package tests.ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

@Feature("Тестирование удаления клиента")
public class ListPageTest extends BaseTest {

    @Test
    @Story("Успешное удаление пользователя")
    public void deleteCustomer() {
        listPage.clickWithWait(listPage.customersBtn, listPage.firstNameColumn);
        listPage.sortByFirstName();

        String doDeleteAndGetName = listPage.deleteByName();

        Assertions.assertNotEquals(
                doDeleteAndGetName, listPage.getName()
                        .findElement(By.xpath(".//td[1]")).getText());
    }
}
