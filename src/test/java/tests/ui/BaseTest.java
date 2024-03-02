package tests.ui;

import helpers.ConfPropertiesReader;
import helpers.Waiting;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.AddCustPage;
import ui.pages.ListPage;

public class BaseTest {
    protected final String pageAddress = ConfPropertiesReader.getProperty("mainpage_URL");
    protected final By appLogo = By.xpath(ConfPropertiesReader.getProperty("app_logo"));
    protected WebDriver driver;
    Waiting wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(pageAddress);
        wait = new Waiting(driver);
        wait.waitForVisibility(appLogo);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
