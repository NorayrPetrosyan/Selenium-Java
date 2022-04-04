package PageObjects;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class TaskThreePage {

    private final BaseClass base;

    public TaskThreePage(BaseClass base) {
        this.base = base;
    }

    By taskButton = By.cssSelector("[href='/task_3']");
    By menu = By.className("dropdown-toggle");
    By form = By.className("caret-right");
    By edit = By.id("start-edit");
    By nameField = By.id("in-name");
    By surnameField = By.id("in-surname");
    By noteField = By.id("in-notes");
    By telephoneField = By.id("in-phone");
    By uploadFileButton = By.id("in-file");
    By saveButton = By.id("save-btn");
    By photoPreview = By.className("preview-photo");
    By inputFields = By.className("form-control");
    By message = By.className("notifyjs-bootstrap-base");

    public void clickTaskButton() {
        base.driver.findElement(taskButton).click();
    }

    public void makeFormEditable() {
        Actions actions = new Actions(base.driver);
        actions.moveToElement(base.driver.findElement(menu)).perform();
        actions.moveToElement(base.driver.findElement(form)).perform();
        base.driver.findElement(edit).click();
    }

    public void typeName(String name) {
        base.driver.findElement(nameField).clear();
        base.driver.findElement(nameField).sendKeys(name);
    }

    public void typeSurname(String surname) {
        base.driver.findElement(surnameField).clear();
        base.driver.findElement(surnameField).sendKeys(surname);
    }

    public void typeNote(String note) {
        base.driver.findElement(noteField).sendKeys(note);
    }

    public void typeTelNumber(String telNumber) {
        base.driver.findElement(telephoneField).clear();
        base.driver.findElement(telephoneField).sendKeys(telNumber);
    }

    public List<WebElement> getInputFields() {
        return base.driver.findElements(inputFields);
    }

    public void uploadFile(String filePath) {
        base.driver.findElement(uploadFileButton).sendKeys(filePath);
    }

    public void clickSaveButton() {
        base.driver.findElement(saveButton).click();
    }

    public WebElement getMessage() {
        return base.driver.findElement(message);
    }

    public String getPhotoSrc() {
        return base.driver.findElement(photoPreview).getAttribute("src");
    }

    public boolean saveButtonIsDisabled() {
        return !base.driver.findElement(saveButton).isEnabled();
    }
}
