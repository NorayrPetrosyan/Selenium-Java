package tests;

import io.qameta.allure.Feature;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.Task8Page;

@Feature("Payment by card")
public class Task8Test {

    private WebDriver driver;
    private Task8Page task8Page;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        task8Page = new Task8Page(driver);
        driver.manage().window().maximize();
        driver.get("https://testingcup.pgs-soft.com/");
        task8Page.clickTaskButton();
    }

    @Test(description = "Pay with valid card")
    public void payWithValidCard() {
        task8Page.selectCardType("Visa");
        task8Page.typeFullName("Tom Smith");
        task8Page.typeCardNo("4111111111111111");
        task8Page.typeCvvCode("123");
        task8Page.selectMonth("April");
        task8Page.selectYear("2024");
        task8Page.clickPayButton();
        Assert.assertTrue(task8Page.getSuccessMessage().isDisplayed());
    }

    @Test(description = "Pay with expired card")
    public void payWithExpiredCard() {
        task8Page.selectCardType("MasterCard");
        task8Page.typeFullName("Tom Black");
        task8Page.typeCardNo("5105105105105100");
        task8Page.typeCvvCode("321");
        task8Page.clickPayButton();
        Assert.assertTrue(task8Page.getExpirationMessage().isDisplayed());
    }

    @Test(description = "Check CVV information is displayed")
    public void cvvInfoIsDisplayed() {
        task8Page.hoverOverInfoSign();
        Assert.assertTrue(task8Page.getCvvInfo().isDisplayed());
    }

    @Test(description = "Pay with not matching card No")
    public void notMatchingCardNo() {
        task8Page.selectCardType("MasterCard");
        task8Page.typeFullName("Tom Black");
        task8Page.typeCardNo("51051");
        task8Page.typeCvvCode("321");
        task8Page.clickPayButton();
        Assert.assertEquals("Please match the requested format.", task8Page.getCardNoFieldMessage());
    }

    @Test(description = "Pay with invalid CVV code")
    public void invalidCvvCode() {
        task8Page.selectCardType("Switch/Solo (Paymentech)");
        task8Page.typeFullName("Tom Black");
        task8Page.typeCardNo("6331101999990016");
        task8Page.typeCvvCode("3212");
        task8Page.clickPayButton();
        Assert.assertTrue(task8Page.getCvvCodeFieldMessage().isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
