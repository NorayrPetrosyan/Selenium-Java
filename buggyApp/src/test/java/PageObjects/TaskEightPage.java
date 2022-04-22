package PageObjects;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TaskEightPage {

    private final BaseClass base;

    public TaskEightPage(BaseClass base) {
        this.base = base;
    }

    By cardNoField = By.id("task8_form_cardNumber");
    By successMessage = By.cssSelector("[class='alert alert-success']");
    By expirationMessage = By.cssSelector("[class='alert alert-danger']");
    By infoSign = By.cssSelector("[class='glyphicon glyphicon-info-sign']");
    By cvvCodeErrorMessage = By.xpath("//li[text()=' Nieprawidłowy format CVV.']");

    public WebElement getSuccessMessage() {
        return base.driver.findElement(successMessage);
    }

    public WebElement getExpirationMessage() {
        return base.driver.findElement(expirationMessage);
    }

    public void hoverOverInfoSign() {
        Actions actions = new Actions(base.driver);
        actions.moveToElement(base.driver.findElement(infoSign)).build().perform();
    }

    public String getCardNoFieldMessage() {
        return base.driver.findElement(cardNoField).getAttribute("validationMessage");
    }

    public WebElement getCvvCodeFieldMessage() {
        return base.driver.findElement(cvvCodeErrorMessage);
    }
}
