package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AddCustPage extends BasePage {
    public AddCustPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получение текста подтверждения регистрации")
    public String getConfirmTitle() {
        return wait.waitAlertIsPresent().getText();
    }
}
