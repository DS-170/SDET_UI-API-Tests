package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListPage extends BasePage {
    public final By firstNameColumn = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/thead/tr/td[1]/a");

    public ListPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> getRows() {
        WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']"));
        wait.waitForVisibility(table);
        return table.findElements(By.xpath(".//tbody//tr"));
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
        List<String> names = getFNameList();

        double averageLength = names.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0.0);

        return getRows().stream()
                .min(Comparator.comparingDouble(name ->
                        Math.abs(name.getText().length() - averageLength)))
                .orElse(null);
    }

    @Step("Получение списка пользователей")
    public List<String> getFNameList() {
        return getRows().stream()
                .map(row -> row.findElement(By.xpath(".//td[1]")).getText())
                .collect(Collectors.toList());
    }
}
