package tests;

import io.qameta.allure.Feature;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.Task6Page;

@Feature("Loging in and downloading the file")
public class Task6Test {

    private WebDriver driver;
    private Task6Page task6Page;
    private String login = "tester";
    private String password = "123-xyz";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        task6Page = new Task6Page(driver);
        driver.get("https://testingcup.pgs-soft.com/");
        task6Page.clickTaskButton();
    }

    @Test(description = "Login with valid data")
    public void loginWithValidData() {
        task6Page.typeLogin(login);
        task6Page.typePassword(password);
        task6Page.clickLoginButton();
        Assert.assertEquals("https://testingcup.pgs-soft.com/task_6/logged", task6Page.getCurrentURL());
    }

    @Test(description = "Log out")
    public void logOut() {
        task6Page.typeLogin(login);
        task6Page.typePassword(password);
        task6Page.clickLoginButton();
        task6Page.clickLogOutButton();
        Assert.assertEquals("https://testingcup.pgs-soft.com/task_6", task6Page.getCurrentURL());
    }

    @Test(description = "Login with invalid data")
    public void loginWithInvalidData() {
        task6Page.typeLogin("login");
        task6Page.typePassword("password");
        task6Page.clickLoginButton();
        Assert.assertTrue(task6Page.errorMessageIsDisplayed());
    }

    @Test(description = "Login with no data")
    public void loginWithNoData() {
        task6Page.clickLoginButton();
        Assert.assertEquals("https://testingcup.pgs-soft.com/task_6", task6Page.getCurrentURL());
    }

    @Test(description = "Download the file")
    public void downloadTheFile() throws InterruptedException {
        task6Page.typeLogin(login);
        task6Page.typePassword(password);
        task6Page.clickLoginButton();
        task6Page.clickOnDownloadLink();
        Thread.sleep(10000);
        Assert.assertTrue(task6Page.isFileDownloaded("pgs_cv.jpg"));
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
