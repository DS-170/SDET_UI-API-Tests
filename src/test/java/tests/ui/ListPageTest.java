package tests.ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ui.pages.ListPage;

import java.util.Comparator;
import java.util.List;

@Feature("Тестирование удаления клиента")
public class ListPageTest extends BaseTest {
    private ListPage listPage;

    @BeforeEach
    public void localSetUp() {
        listPage = new ListPage(driver);
    }

    @Test
    @Story("Успешное удаление пользователя")
    public void deleteCustomerTest() {
        listPage.clickWithWait(listPage.customersBtn, listPage.firstNameColumn);
        listPage.sortByFirstName();

        String doDeleteAndGetName = listPage.deleteByName();

        Assertions.assertNotEquals(
                doDeleteAndGetName, listPage.getName()
                        .findElement(By.xpath(".//td[1]")).getText());
    }

    @Test
    @Story("Проверка сортировки пользователей")
    public void sortCustomersTest() {
        listPage.clickWithWait(listPage.customersBtn, listPage.firstNameColumn);

        List<String> names = listPage.getFNameList().stream().sorted(Comparator.reverseOrder()).toList();

        listPage.sortByFirstName();

        Assertions.assertEquals(names, listPage.getFNameList().stream().toList());
    }
}
