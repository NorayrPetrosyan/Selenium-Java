package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.Task3Page;

@Feature("Editing the form")
public class Task3Test {

    Faker faker = new Faker();
    private WebDriver driver;
    private Task3Page task3Page;
    private String previousPhotoSrc;
    private String currentPhotoSrc;
    private String name = faker.name().firstName();
    private String surname = faker.name().lastName();
    private String telNumber = faker.numerify("###########");
    private String note = "something";
    private filePath = "C:\\Users\\User\\Documents\\Selenium-Java\\Testing Material\\";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        task3Page = new Task3Page(driver);
        driver.get("https://testingcup.pgs-soft.com/");
        task3Page.clickTaskButton();
        task3Page.makeFormEditable();
    }

    @Test(description = "Make form editable")
    public void makeFormEditable() {
        for (WebElement inputField: task3Page.getInputFields()) {
            Assert.assertTrue(inputField.isEnabled());
        }
    }

    @Test(description = "Upload a new photo")
    public void uploadPhoto() {
        previousPhotoSrc = task3Page.getPhotoSrc();
        task3Page.uploadFile(filePath+"image.png");
        currentPhotoSrc = task3Page.getPhotoSrc();
        Assert.assertNotEquals(previousPhotoSrc, currentPhotoSrc);
    }

    @Test(description = "Upload a wrong formatted file")
    public void uploadWrongFormattedFile() {
        previousPhotoSrc = task3Page.getPhotoSrc();
        task3Page.uploadFile(filePath+"wrongFileFormat.xlsx");
        Assert.assertEquals("Zły format pliku!", task3Page.getAlert().getText());
        task3Page.getAlert().accept();
        currentPhotoSrc = task3Page.getPhotoSrc();
        Assert.assertEquals(previousPhotoSrc, currentPhotoSrc);
    }

    @Test(description = "Fill form with valid data")
    public void fillFormWithValidData() {
        task3Page.typeName(name);
        task3Page.typeSurname(surname);
        task3Page.typeNote(note);
        task3Page.typeTelNumber(telNumber);
        task3Page.uploadFile(filePath+"image.png");
        task3Page.clickSaveButton();
        Assert.assertTrue(task3Page.getMessage().isDisplayed());
        for (WebElement inputField: task3Page.getInputFields()) {
            Assert.assertFalse(inputField.isEnabled());
        }
    }

    @Test(description = "Fills form with no data")
    public void fillFormWithNoData() {
        task3Page.typeName("");
        task3Page.typeSurname("");
        task3Page.typeTelNumber("");
        task3Page.clickSaveButton();
        Assert.assertTrue(task3Page.saveButtonIsDisabled());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
