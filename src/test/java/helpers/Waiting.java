package helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiting {
    private static final long TIMEOUT_SECONDS = Long.parseLong(ConfPropertiesReader.getProperty("timeout"));
    private final WebDriver driver;

    public Waiting(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForVisibility(By element) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public WebElement waitForClickable(By element) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public Alert waitAlertIsPresent() {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS))
                .until(ExpectedConditions.alertIsPresent());
    }
}