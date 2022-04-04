package tests;

import io.qameta.allure.Feature;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import pages.Task1Page;

@Feature("Adding a product to the cart")
public class Task1Test {

    private WebDriver driver;
    private Task1Page task1Page;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        task1Page = new Task1Page(driver);
        driver.get("https://testingcup.pgs-soft.com/");
        task1Page.clickTaskButton();
    }

    @Test(description = "Add products to the basket")
    public void addProductsToBasket() {
        int[] productsNo = {2, 3, 4};
        int[] productsQuantities = {8, 1, 11};
        for (int i = 0; i < productsNo.length; i++) {
            task1Page.addProductToBasket(productsNo[i], productsQuantities[i]);
        }
        for (int i = 1; i < task1Page.getNumberOfProductsInBasket(); i++) {
            Assert.assertTrue(task1Page.getBasketProductName(i).contains(task1Page.getProductName(productsNo[i-1])));
            Assert.assertEquals(task1Page.getBasketProductQuantity(i), productsQuantities[i-1]);
        }
    }

    @Test(description = "Delete all products from the basket")
    public void deleteProductsFromBasket() {
        task1Page.addProductToBasket(1, 20);
        task1Page.addProductToBasket(6, 50);
        task1Page.deleteAllProductsFromBasket();
        Assert.assertEquals(task1Page.getTotalProductsQuantities(), task1Page.getTotalNumberOfProducts());
    }

    @Test(description = "Check total number of products added to the basket")
    public void checkTotalNumberOfProducts() {
        task1Page.addProductToBasket(3, 5);
        task1Page.addProductToBasket(4, 6);
        Assert.assertEquals(task1Page.getTotalProductsQuantities(), task1Page.getTotalNumberOfProducts());
    }

    @Test(description = "Check total price of products added to the basket")
    public void checkProductsTotalPrice() {
        for (int i = 1; i < 5; i++) {
            task1Page.addProductToBasket(i, i+2);
        }
        Assert.assertEquals(task1Page.getTotalPrice(), task1Page.getProductsPrices(), 2);
    }

    @Test(description = "Check the limit of total number of products added to the basket")
    public void limitOfTotalNumberOfProducts() {
        task1Page.addProductToBasket(10, 100);
        task1Page.addProductToBasket(11, 1);
        Assert.assertEquals("Łączna ilość produktów w koszyku nie może przekroczyć 100.", task1Page.getAlert().getText());
        task1Page.getAlert().accept();
        Assert.assertTrue(task1Page.getTotalNumberOfProducts() < 101);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
