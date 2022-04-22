package tests;

import io.qameta.allure.Feature;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.Task7Page;

@Feature("Adding a product to the cart via drag and drop")
public class Task7Test {

    private WebDriver driver;
    private Task7Page task7Page;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        task7Page = new Task7Page(driver);
        driver.get("https://testingcup.pgs-soft.com/");
        task7Page.clickTaskButton();
    }

    @Test(description = "Add products to the basket via drag and drop")
    public void addProductsToBasket() {
        int[] productsNo = {2, 3, 4};
        int[] productsQuantities = {8, 1, 11};
        for (int i = 0; i < productsNo.length; i++) {
            task7Page.addProductToBasket(productsNo[i], productsQuantities[i]);
        }
        for (int i = 1; i < task7Page.getNumberOfProductsInBasket(); i++) {
            Assert.assertTrue(task7Page.getBasketProductName(i).contains(task7Page.getProductName(productsNo[i-1])));
            Assert.assertEquals(task7Page.getBasketProductQuantity(i), productsQuantities[i-1]);
        }
    }

    @Test(description = "Delete all products from the basket")
    public void deleteProductsFromBasket() {
        task7Page.addProductToBasket(1, 20);
        task7Page.addProductToBasket(6, 50);
        task7Page.deleteAllProductsFromBasket();
        Assert.assertEquals(task7Page.getTotalProductsQuantities(), task7Page.getTotalNumberOfProducts());
    }

    @Test(description = "Check total number of products added to the basket")
    public void checkTotalNumberOfProducts() {
        task7Page.addProductToBasket(3, 5);
        task7Page.addProductToBasket(4, 6);
        Assert.assertEquals(task7Page.getTotalProductsQuantities(), task7Page.getTotalNumberOfProducts());
    }

    @Test(description = "Check total price of products added to the basket")
    public void checkProductsTotalPrice() {
        task7Page.addProductToBasket(1, 20);
        task7Page.addProductToBasket(6, 50);
        task7Page.addProductToBasket(3, 5);
        task7Page.addProductToBasket(4, 6);
        Assert.assertEquals(task7Page.getTotalPrice(), task7Page.getProductsPrices(), 2);
    }

    @Test(description = "Check the limit of total number of products added to the basket")
    public void limitOfTotalNumberOfProducts() {
        try {
            task7Page.addProductToBasket(10, 100);
            task7Page.addProductToBasket(11, 1);
            Assert.assertEquals("Łączna ilość produktów w koszyku nie może przekroczyć 100.", task7Page.getAlert().getText());
            task7Page.getAlert().accept();
            Assert.assertTrue(task7Page.getTotalNumberOfProducts() < 101);
        } catch (UnhandledAlertException e) {
            e.printStackTrace();
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
