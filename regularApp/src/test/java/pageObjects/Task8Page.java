package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Task8Page {

    private WebDriver driver;

    public Task8Page(WebDriver driver) {
        this.driver = driver;
    }

    private By taskButton = By.cssSelector("[href='/task_8']");
    private By drpCardTypes = By.id("task8_form_cardType");
    private By nameField = By.id("task8_form_name");
    private By cardNoField = By.id("task8_form_cardNumber");
    private By cvvCodeField = By.id("task8_form_cardCvv");
    private By drpMonths = By.id("task8_form_cardInfo_month");
    private By drpYears = By.id("task8_form_cardInfo_year");
    private By payButton = By.cssSelector("[type='submit']");
    private By successMessage = By.cssSelector("[class='alert alert-success']");
    private By expirationMessage = By.cssSelector("[class='alert alert-danger']");
    private By infoSign = By.cssSelector("[class='glyphicon glyphicon-info-sign']");
    private By cvvInfo = By.cssSelector("[class='tooltip fade top in']");
    private By cvvCodeErrorMessage = By.xpath("//li[text()=' Nieprawidłowy format CVV.']");


    public void clickTaskButton() {
            driver.findElement(taskButton).click();
        }

    public void selectCardType(String cardType) {
        Select cardTypes = new Select(driver.findElement(drpCardTypes));
        cardTypes.selectByVisibleText(cardType);
    }

    public void typeFullName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void typeCardNo(String cardNo) {
        driver.findElement(cardNoField).sendKeys(cardNo);
    }

    public void typeCvvCode(String cvvCode) {
        driver.findElement(cvvCodeField).sendKeys(cvvCode);
    }

    public void selectMonth(String month) {
        Select months = new Select(driver.findElement(drpMonths));
        months.selectByVisibleText(month);
    }

    public void selectYear(String year) {
        Select years = new Select(driver.findElement(drpYears));
        years.selectByVisibleText(year);
    }

    public void clickPayButton() {
        driver.findElement(payButton).click();
    }

    public WebElement getSuccessMessage() {
        return driver.findElement(successMessage);
    }

    public WebElement getExpirationMessage() {
        return driver.findElement(expirationMessage);
    }

    public void hoverOverInfoSign() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(infoSign)).build().perform();
    }

    public WebElement getCvvInfo() {
        return driver.findElement(cvvInfo);
    }

    public String getCardNoFieldMessage() {
        return driver.findElement(cardNoField).getAttribute("validationMessage");
    }

    public WebElement getCvvCodeFieldMessage() {
        return driver.findElement(cvvCodeErrorMessage);
    }


}
