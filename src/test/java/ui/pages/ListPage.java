package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListPage extends BasePage {
    public final By firstNameColumn = By.xpath("//a[contains(text(), 'First Name')]");
    private final By customerTable = By.xpath("//table[@class='table table-bordered table-striped']");

    public ListPage(WebDriver driver) {
        super(driver);
    }

    @Step("Сортировка по полю First Name")
    public void sortByFirstName() {
        clickWithWait(firstNameColumn);
    }

    @Step("Удаление клиента по имени и возврат имени")
    public String deleteByName() {
        WebElement nameToDelete = getName();
        String nameText = nameToDelete.findElement(By.xpath(".//td[1]")).getText();

        nameToDelete.findElement(By.xpath(".//button[contains(text(), 'Delete')]")).click();

        return nameText;
    }

    @Step("Получение имени для удаления")
    public WebElement getName() {
        wait.waitForVisibility(customerTable);
        WebElement table = driver.findElement(customerTable);

        List<WebElement> rows = table.findElements(By.xpath(".//tbody//tr"));
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
                .min(Comparator.comparingDouble(name ->
                        Math.abs(name.getText().length() - averageLength)))
                .orElse(null);
    }
}
