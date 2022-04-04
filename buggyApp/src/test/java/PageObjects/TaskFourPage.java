package PageObjects;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TaskFourPage {

    private final BaseClass base;

    public TaskFourPage(BaseClass base) {
        this.base = base;
    }

    By taskButton = By.cssSelector("[href='/task_4']");
    By applyButton = By.className("btn");
    By nameField = By.cssSelector("[name='name']");
    By emailField = By.cssSelector("[name='email']");
    By telNumberField = By.cssSelector("[name='phone']");
    By saveButton = By.id("save-btn");
    By message = By.xpath("//h1[text()='Wiadomość została wysłana']");

    public void clickTaskButton() {
        base.driver.findElement(taskButton).click();
    }

    public void clickApplyButton() {
        JavascriptExecutor js = (JavascriptExecutor) base.driver;
        js.executeScript("window.scrollBy(0,350)", "");
        base.driver.findElement(applyButton).click();
    }

    public void switchToForm() {
        for(String winHandle : base.driver.getWindowHandles()){
            base.driver.switchTo().window(winHandle);
        }
        base.driver.switchTo().frame(0);
    }

    public void typeName(String name) {
        base.driver.findElement(nameField).sendKeys(name);
    }

    public void typeEmail(String email) {
        base.driver.findElement(emailField).clear();
        base.driver.findElement(emailField).sendKeys(email);
    }

    public void typeTelNumber(String telNumber) {
        base.driver.findElement(telNumberField).clear();
        base.driver.findElement(telNumberField).sendKeys(telNumber);
    }

    public void clickSaveButton() {
        base.driver.findElement(saveButton).click();
    }

    public WebElement getMessage() {
        return base.driver.findElement(message);
    }

    public WebElement getErrorMessage(String message) {
        String errorXpath = String.format("//span[text()='%s']", message);
        return base.driver.findElement(By.xpath(errorXpath));
    }

    public String getCurrentURL() {
        return base.driver.getCurrentUrl();
    }
}
