package ui.pages;

import helpers.ConfPropertiesReader;
import helpers.Waiting;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public final By addCustomerBtn = By.xpath(ConfPropertiesReader.getProperty("add_customer_btn"));
    public final By customersBtn = By.xpath(ConfPropertiesReader.getProperty("customers_btn"));
    WebDriver driver;
    Waiting wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waiting(driver);
    }

    @Step("Нажатие на кнопку и ожидание появления элемента")
    public void clickWithWait(By elementToClick, By elementToWait) {
        wait.waitForClickable(elementToClick).click();
        wait.waitForVisibility(elementToWait);
    }

    @Step("Нажатие на кнопку без следующего ожидания")
    public void clickWithWait(By elementToClick) {
        wait.waitForClickable(elementToClick).click();
    }
}
