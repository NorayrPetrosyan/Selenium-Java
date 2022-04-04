package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Task6Page {

    private WebDriver driver;

    public Task6Page(WebDriver driver) {
        this.driver = driver;
    }

    private By taskButton = By.cssSelector("[href='/task_6/logged']");
    private By loginField = By.id("LoginForm__username");
    private By passwordField = By.id("LoginForm__password");
    private By loginButton = By.id("LoginForm_save");
    private By logOutButton = By.id("logout");
    private By errorMessage = By.cssSelector("[class='alert alert-danger']");
    private By downloadLink = By.cssSelector("[href='/task_6/download']");

    public void clickTaskButton() {
        driver.findElement(taskButton).click();
    }

    public void typeLogin(String login) {
        driver.findElement(loginField).sendKeys(login);
    }

    public void typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickLogOutButton() {
        driver.findElement(logOutButton).click();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public boolean errorMessageIsDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public void clickOnDownloadLink() {
        driver.findElement(downloadLink).click();
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
