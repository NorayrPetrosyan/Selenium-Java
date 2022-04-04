package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Task3Page {

    private WebDriver driver;

    public Task3Page(WebDriver driver) {
        this.driver = driver;
    }

    private By taskButton = By.cssSelector("[href='/task_3']");
    private By menu = By.className("dropdown-toggle");
    private By form = By.className("caret-right");
    private By edit = By.id("start-edit");
    private By nameField = By.id("in-name");
    private By surnameField = By.id("in-surname");
    private By noteField = By.id("in-notes");
    private By telephoneField = By.id("in-phone");
    private By uploadFileButton = By.id("in-file");
    private By saveButton = By.id("save-btn");
    private By photoPreview = By.className("preview-photo");
    private By inputFields = By.className("form-control");
    private By message = By.className("notifyjs-bootstrap-base");

    public void clickTaskButton() {
        driver.findElement(taskButton).click();
    }

    public void makeFormEditable() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(menu)).perform();
        actions.moveToElement(driver.findElement(form)).perform();
        driver.findElement(edit).click();
    }

    public void typeName(String name) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }

    public void typeSurname(String surname) {
        driver.findElement(surnameField).clear();
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void typeNote(String note) {
        driver.findElement(noteField).sendKeys(note);
    }

    public void typeTelNumber(String telNumber) {
        driver.findElement(telephoneField).clear();
        driver.findElement(telephoneField).sendKeys(telNumber);
    }

    public List<WebElement> getInputFields() {
        return driver.findElements(inputFields);
    }

    public void uploadFile(String filePath) {
        driver.findElement(uploadFileButton).sendKeys(filePath);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public WebElement getMessage() {
        return driver.findElement(message);
    }

    public String getPhotoSrc() {
        return driver.findElement(photoPreview).getAttribute("src");
    }

    public Alert getAlert() {
        return driver.switchTo().alert();
    }

    public boolean saveButtonIsDisabled() {
        return !driver.findElement(saveButton).isEnabled();
    }

}
