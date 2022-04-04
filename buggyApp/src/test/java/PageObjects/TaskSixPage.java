package PageObjects;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import java.io.File;

public class TaskSixPage {

    private final BaseClass base;

    public TaskSixPage(BaseClass base) {
        this.base = base;
    }

    By taskButton = By.cssSelector("[href='/task_6/logged']");
    By loginField = By.id("LoginForm__username");
    By passwordField = By.id("LoginForm__password");
    By loginButton = By.id("LoginForm_save");
    By logOutButton = By.id("logout");
    By errorMessage = By.cssSelector("[class='alert alert-danger']");
    By downloadLink = By.cssSelector("[href='/task_6/download']");

    public void clickTaskButton() {
        base.driver.findElement(taskButton).click();
    }

    public void typeLogin(String login) {
        base.driver.findElement(loginField).sendKeys(login);
    }

    public void typePassword(String password) {
        base.driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        base.driver.findElement(loginButton).click();
    }

    public String getCurrentURL() {
        return base.driver.getCurrentUrl();
    }

    public void clickLogOutButton() {
        base.driver.findElement(logOutButton).click();
    }

    public boolean errorMessageIsDisplayed() {
        return base.driver.findElement(errorMessage).isDisplayed();
    }

    public void clickOnDownloadLink() throws InterruptedException {
        base.driver.findElement(downloadLink).click();
        Thread.sleep(5000);
    }

    public boolean isFileDownloaded(String fileName) {
        File dir = new File("C:\\Users\\User\\Downloads");
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }
}
