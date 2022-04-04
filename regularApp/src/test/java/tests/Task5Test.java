package tests;

import io.qameta.allure.Feature;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.Task5Page;

@Feature("Uploading data to the application")
public class Task5Test {

    private WebDriver driver;
    private Task5Page task5Page;
    private String fileName;
    private final String filePath = "C:\\Users\\User\\Documents\\Selenium-Java\\Testing Material\\";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        task5Page = new Task5Page(driver);
        driver.get("https://testingcup.pgs-soft.com/");
        task5Page.clickTaskButton();
    }

    @Test(description = "Upload a properly formatted file")
    public void uploadProperFile() {
        fileName = "properFile.csv";
        task5Page.uploadFile(filePath+fileName);
        Assert.assertTrue(task5Page.fileIsUploaded(filePath+fileName));
    }

    @Test(description = "Upload an improperly formatted file")
    public void uploadImproperlyFormattedFile() {
        fileName = "wrongFileFormat.xlsx";
        task5Page.uploadFile(filePath+fileName);
        Assert.assertEquals("Zły format pliku", task5Page.getAlert().getText());
        task5Page.getAlert().accept();
        Assert.assertFalse(task5Page.fileIsUploaded(filePath+fileName));
    }

    @Test(description = "Upload a wrong formatted file")
    public void wrongFormattedFile() {
        fileName = "wrongFormattedFile.csv";
        task5Page.uploadFile(filePath+fileName);
        Assert.assertEquals("Źle sformatowany plik.", task5Page.getAlert().getText());
        task5Page.getAlert().accept();
        Assert.assertFalse(task5Page.fileIsUploaded(filePath+fileName));
    }

    @Test(description = "Upload a file with wrong formatted tel. numbers")
    public void wrongFormattedTelNumber() {
        fileName = "wrongTelNumber.txt";
        task5Page.uploadFile(filePath+fileName);
        Assert.assertEquals("Numer telefonu może zawierać tylko znaki numeryczne, musi mieć 9 znaków.", task5Page.getAlert().getText());
        task5Page.getAlert().accept();
        Assert.assertFalse(task5Page.fileIsUploaded(filePath+fileName));
    }


    @Test(description = "Upload a file that contains more than 20 lines")
    public void maximumLinesLimit() {
        fileName = "moreThan20Lines.txt";
        task5Page.uploadFile(filePath+fileName);
        Assert.assertEquals("Maksymalnie wprowadzić można 20 wierszy.", task5Page.getAlert().getText());
        task5Page.getAlert().accept();
        Assert.assertFalse(task5Page.fileIsUploaded(filePath+fileName));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
