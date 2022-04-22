package tests;

import io.qameta.allure.Feature;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Task9Page;

@Feature("Folders tree")
public class Task9Test {

    private WebDriver driver;
    private Task9Page task9Page;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        task9Page = new Task9Page(driver);
        driver.get("https://testingcup.pgs-soft.com/");
        task9Page.clickTaskButton();
    }

    @Test(description = "Check all nodes have the same names and titles")
    public void allNodesHaveTheSameNamesAndTitles() {
        task9Page.openAllNodes();
        for (WebElement node: task9Page.getNodes()) {
            node.click();
            Assert.assertEquals(task9Page.getTitle().getText(),node.getText());
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
