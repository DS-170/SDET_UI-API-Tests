package tests.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.AddCustPage;
import ui.pages.ListPage;

public class BaseTest {
    protected AddCustPage addCustPage;
    protected ListPage listPage;
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        addCustPage = new AddCustPage(driver);
        listPage = new ListPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
