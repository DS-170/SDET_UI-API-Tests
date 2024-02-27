package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListPage extends BasePage {
    private final By firstNameColumn = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/thead/tr/td[1]/a");
    private final By customerTable = By.xpath("//table[@class='table table-bordered table-striped']//tbody//tr");

    public ListPage(WebDriver driver) {
        super(driver);
    }

    @Step("Сортировка по полю First Name")
    private void sortByFirstName() {
        clickWithWait(firstNameColumn);
    }

    @Step("Удаление клиента по имени")
    private void deleteByName() {
        getName().findElement(By.xpath(".//button[contains(text(), 'Delete')]")).click();
    }

    @Step("Получение имени для удаления")
    private WebElement getName() {
        List<WebElement> rows = driver.findElements(customerTable);
        ArrayList<String> names = new ArrayList<>();

        for (var row : rows) {
            WebElement firstNameElement = row.findElement(By.xpath(".//td[1]"));
            names.add(firstNameElement.getText());
        }

        double averageLength = names.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0.0);

        return rows.stream()
                .min((name1, name2) ->
                        (int) (Math.abs(name1.getText().length() - averageLength) - Math.abs(name2.getText().length() - averageLength)))
                .orElse(null);
    }

    @Step("Нахождение нужного имени и удаление")
    public void doDelete() {
        openAndWaitLogo();
        clickWithWait(customersBtn, firstNameColumn);
        sortByFirstName();
        deleteByName();
    }
}
