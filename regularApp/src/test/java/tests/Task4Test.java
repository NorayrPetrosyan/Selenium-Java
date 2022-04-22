package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.Task4Page;

@Feature("Completing the form in a separate window")
public class Task4Test {

    Faker faker = new Faker();
    private WebDriver driver;
    private Task4Page task4Page;
    private String validName = faker.name().firstName();
    private String validEmail = faker.internet().emailAddress();
    private String validTelNumber = faker.numerify("###-###-###");


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        task4Page = new Task4Page(driver);
        driver.get("https://testingcup.pgs-soft.com/");
        task4Page.clickTaskButton();
        task4Page.clickApplyButton();
        task4Page.switchToForm();
    }

    @Test(description = "Open application form")
    public void OpenFormWindow() {
        Assert.assertEquals("about:blank", task4Page.getCurrentURL());
    }

    @Test(description = "Fill form with valid data")
    public void fillFormWithValidData() {
        task4Page.typeName(validName);
        task4Page.typeEmail(validEmail);
        task4Page.typeTelNumber(validTelNumber);
        task4Page.clickSaveButton();
        Assert.assertTrue(task4Page.getMessage().isDisplayed());
    }

    @Test(description = "Check validation messages of input fields")
    public void inputRequiredMessagesValidation() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (WebElement inputField: task4Page.getInputFields()) {
            boolean isRequired = (Boolean) js.executeScript("return arguments[0].required", inputField);
            Assert.assertTrue(isRequired);
        }

    }

    @Test(description = "Type an invalid name")
    public void nameErrorMessageValidation() {
        task4Page.typeName(" ");
        task4Page.typeEmail(validEmail);
        task4Page.typeTelNumber(validTelNumber);
        task4Page.clickSaveButton();
        Assert.assertTrue(task4Page.getErrorMessage("Brak imienia i nazwiska").isDisplayed());
    }

    @Test(description = "Type an invalid email")
    public void emailErrorMessageValidation() {
        task4Page.typeName(validName);
        task4Page.typeTelNumber(validTelNumber);

        String[] invalidEmails = task4Page.getInvalidEmailsList();
        for (int i = 0; i < invalidEmails.length; i++) {
            task4Page.typeEmail(invalidEmails[i]);
            task4Page.clickSaveButton();
            Assert.assertTrue(task4Page.getErrorMessage("Nieprawidłowy email").isDisplayed());
        }
    }

    @Test(description = "Type an invalid tel. number")
    public void telNumberErrorMessageValidation() {
        task4Page.typeName(validName);
        task4Page.typeEmail(validEmail);

        String[] invalidTelNumbers = task4Page.getInvalidTelNumbersList();
        for (int i = 0; i < invalidTelNumbers.length; i++) {
            task4Page.typeTelNumber(invalidTelNumbers[i]);
            task4Page.clickSaveButton();
            Assert.assertTrue(task4Page.getErrorMessage("Zły format telefonu - prawidłowy: 600-100-200").isDisplayed());
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
