package ui.pages;

import helpers.ConfPropertiesReader;
import helpers.LetterSwitcher;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class AddCustPage extends BasePage {
    private final By firstNameFld = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private final By lastNameFld = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private final By postNameFld = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");
    private final String lastName = ConfPropertiesReader.getProperty("lastname");
    private final String postCode = generatedPostCode();

    public AddCustPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод данных нового пользователя и подтверждение формы")
    private void addCustomer(String lastName) {
        wait.until(ExpectedConditions.elementToBeClickable(addCustomerBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameFld)).sendKeys(generatedFirstName());
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameFld)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(postNameFld)).sendKeys(postCode);
        driver.findElement(postNameFld).submit();
    }

    @Step("Генерация имени на основе почтового кода")
    private String generatedFirstName() {
        int[] ints = new int[5];
        StringBuilder postCodeBuilder = new StringBuilder(postCode);
        StringBuilder newFirstName = new StringBuilder();

        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(postCodeBuilder.substring(i, i + 2));
            postCodeBuilder.delete(i, i + 1);
        }

        for (var i : ints) {
            newFirstName.append(LetterSwitcher.doLetterSwitch(i));
        }

        return newFirstName.toString();
    }

    @Step("Генерация почтового кода")
    private String generatedPostCode() {
        StringBuilder postCodeBuilder = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            postCodeBuilder.append(new Random().nextInt(10));
        }
        return postCodeBuilder.toString();
    }

    @Step("Получение текста подтверждения регистрации")
    public String getConfirmTittle() {
        return wait.until(ExpectedConditions.alertIsPresent()).getText();
    }

    @Step("Полный процесс регистрации нового пользователя")
    public void doRegistration() {
        openAndWaitLogo();
        clickWithWait(addCustomerBtn, firstNameFld);
        addCustomer(lastName);
    }
}
