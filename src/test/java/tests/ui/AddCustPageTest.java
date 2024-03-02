package tests.ui;

import helpers.ConfPropertiesReader;
import helpers.GeneratingHelper;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ui.pages.AddCustPage;

@Feature("Тест создания нового пользователя")
public class AddCustPageTest extends BaseTest {
    private final By firstNameFld = By.xpath("//input[@ng-model='fName']");
    private final By lastNameFld = By.xpath("//input[@ng-model='lName']");
    private final By postNameFld = By.xpath("//input[@ng-model='postCd']");
    private final By submitBtn = By.xpath("//button[@class='btn btn-default' and contains(text(), 'Add Customer')]");
    private final String lastName = ConfPropertiesReader.getProperty("lastname");
    private final String postCode = GeneratingHelper.generatedPostCode();
    private AddCustPage addCustPage;

    @BeforeEach
    public void localSetUp() {
        addCustPage = new AddCustPage(driver);
    }

    @Test
    @Story("Кейс успешного добавления пользователя")
    public void addCustomerTest() {
        addCustPage.clickWithWait(addCustPage.addCustomerBtn, firstNameFld);
        wait.waitForClickable(addCustPage.addCustomerBtn).click();
        wait.waitForVisibility(firstNameFld).sendKeys(GeneratingHelper.generatedFirstName(postCode));
        wait.waitForVisibility(lastNameFld).sendKeys(lastName);
        wait.waitForVisibility(postNameFld).sendKeys(postCode);
        wait.waitForClickable(submitBtn).click();

        Assertions.assertTrue(
                addCustPage.getConfirmTitle().contains(ConfPropertiesReader.getProperty("add_confirmation"))
        );
    }
}
