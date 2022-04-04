package PageObjects;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TaskEightPage {

    private final BaseClass base;

    public TaskEightPage(BaseClass base) {
        this.base = base;
    }

    By taskButton = By.cssSelector("[href='/task_8']");
    By drpCardTypes = By.id("task8_form_cardType");
    By nameField = By.id("task8_form_name");
    By cardNoField = By.id("task8_form_cardNumber");
    By cvvCodeField = By.id("task8_form_cardCvv");
    By drpMonths = By.id("task8_form_cardInfo_month");
    By drpYears = By.id("task8_form_cardInfo_year");
    By payButton = By.cssSelector("[type='submit']");
    By successMessage = By.cssSelector("[class='alert alert-success']");
    By expirationMessage = By.cssSelector("[class='alert alert-danger']");
    By infoSign = By.cssSelector("[class='glyphicon glyphicon-info-sign']");
    By cvvInfo = By.cssSelector("[class='tooltip fade top in']");
    By cvvCodeErrorMessage = By.xpath("//li[text()=' Nieprawidłowy format CVV.']");


    public void clickTaskButton() {
        base.driver.findElement(taskButton).click();
    }

    public void selectCardType(String cardType) {
        Select cardTypes = new Select(base.driver.findElement(drpCardTypes));
        cardTypes.selectByVisibleText(cardType);
    }

    public void typeFullName(String name) {
        base.driver.findElement(nameField).sendKeys(name);
    }

    public void typeCardNo(String cardNo) {
        base.driver.findElement(cardNoField).sendKeys(cardNo);
    }

    public void typeCvvCode(String cvvCode) {
        base.driver.findElement(cvvCodeField).sendKeys(cvvCode);
    }

    public void selectMonth(String month) {
        Select months = new Select(base.driver.findElement(drpMonths));
        months.selectByVisibleText(month);
    }

    public void selectYear(String year) {
        Select years = new Select(base.driver.findElement(drpYears));
        years.selectByVisibleText(year);
    }

    public void clickPayButton() {
        JavascriptExecutor js = (JavascriptExecutor) base.driver;
        js.executeScript("window.scrollBy(0,350)", "");
        base.driver.findElement(payButton).click();
    }

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

    public WebElement getCvvInfo() {
        return base.driver.findElement(cvvInfo);
    }

    public String getCardNoFieldMessage() {
        return base.driver.findElement(cardNoField).getAttribute("validationMessage");
    }

    public WebElement getCvvCodeFieldMessage() {
        return base.driver.findElement(cvvCodeErrorMessage);
    }
}
