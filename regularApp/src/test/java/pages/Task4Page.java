package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Task4Page {

    private WebDriver driver;

    public Task4Page(WebDriver driver) {
        this.driver = driver;
    }

    private By taskButton = By.cssSelector("[href='/task_4']");
    private By applyButton = By.className("btn");
    private By nameField = By.cssSelector("[name='name']");
    private By emailField = By.cssSelector("[name='email']");
    private By telNumberField = By.cssSelector("[name='phone']");
    private By saveButton = By.id("save-btn");
    private By message = By.xpath("//h1[text()='Wiadomość została wysłana']");
    private By inputFields = By.className("form-control");

    public void clickTaskButton() {
        driver.findElement(taskButton).click();
    }

    public void clickApplyButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(applyButton).click();
    }

    public void switchToForm() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        driver.switchTo().frame(0);
    }

    public void typeName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void typeEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void typeTelNumber(String telNumber) {
        driver.findElement(telNumberField).clear();
        driver.findElement(telNumberField).sendKeys(telNumber);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public WebElement getMessage() {
        return driver.findElement(message);
    }

    public List<WebElement> getInputFields() {
        return driver.findElements(inputFields);
    }

    public WebElement getErrorMessage(String message) {
        String errorXpath = String.format("//span[text()='%s']", message);
        return driver.findElement(By.xpath(errorXpath));
    }

    public String[] getInvalidEmailsList() {
        String[] invalidEmails = {
                "test2022@gmailcom",
                "test2022@gmail.",
                "test2022gmail.com",
                "test2022@gmail..com",
                "test2022@",
                "test2022",
        };
        return invalidEmails;
    }

    public String[] getInvalidTelNumbersList() {
        String[] invalidTelNumbers = {
                "123456789",
                "123-456789",
                "123456-789",
                "123-456-789-101",
                "test2022",
        };
        return invalidTelNumbers;
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}
