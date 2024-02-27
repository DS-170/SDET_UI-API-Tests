package ui.pages;

import helpers.ConfPropertiesReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final String pageAddress = ConfPropertiesReader.getProperty("mainpage_URL");
    protected final By appLogo = By.xpath(ConfPropertiesReader.getProperty("app_logo"));
    protected final By addCustomerBtn = By.xpath(ConfPropertiesReader.getProperty("add_customer_btn"));
    protected final By customersBtn = By.xpath(ConfPropertiesReader.getProperty("customers_btn"));
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfPropertiesReader.getProperty("timeout")))) {
        };
    }

    @Step("Открытие ссылки и ожидание появления логотипа")
    public void openAndWaitLogo() {
        driver.get(pageAddress);
        wait.until(ExpectedConditions.presenceOfElementLocated(appLogo));
    }

    @Step("Нажатие на кнопку и ожидание появления элемента")
    public void clickWithWait(By elementToClick, By elementToWait) {
        wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementToWait));
    }

    @Step("Нажатие на кнопку без следующего ожидания")
    public void clickWithWait(By elementToClick) {
        wait.until(ExpectedConditions.elementToBeClickable(elementToClick)).click();
    }
}
