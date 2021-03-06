package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task7Page {

    private WebDriver driver;

    public Task7Page(WebDriver driver) {
        this.driver = driver;
    }

    private By taskButton = By.cssSelector("[href='/task_7']");
    private By inputFields = By.className("form-control");
    private By deleteButtons = By.xpath("//button[@class='btn btn-sm' and text()='Usuń']");
    private By totalNumberOfProducts = By.className("summary-quantity");
    private By totalPrice = By.className("summary-price");
    private By productsQuantities = By.className("row-in-basket-quantity");
    private By productsNames = By.cssSelector("div.caption h4");
    private By basketProductsNames = By.className("col-md-9");
    private By basketProductsQuantities = By.className("row-in-basket-quantity");
    private By draggablePhotos = By.cssSelector("[class='draggable ui-draggable ui-draggable-handle']");
    private By placeToDrop = By.cssSelector("[class='panel-body']");


    public void clickTaskButton() {
        driver.findElement(taskButton).click();
    }

    public void addProductToBasket(int productNo, int quantity) {
        driver.findElements(inputFields).get(productNo -1).clear();
        driver.findElements(inputFields).get(productNo -1).sendKeys(quantity+"");
        Actions action = new Actions(driver);
        action.dragAndDrop(driver.findElements(draggablePhotos).get(productNo -1), driver.findElement(placeToDrop)).build().perform();
        action.dragAndDrop(driver.findElements(draggablePhotos).get(productNo -1), driver.findElement(placeToDrop)).build().perform();
    }

    public void deleteAllProductsFromBasket() {
        for (WebElement deleteButton: driver.findElements(deleteButtons)) {
            deleteButton.click();
        }
    }

    public int getTotalProductsQuantities() {
        int sum = 0;
        for (WebElement productQuantity: driver.findElements(productsQuantities)) {
            sum += Integer.parseInt(productQuantity.getText());
            System.out.println(Integer.parseInt(productQuantity.getText()));
        }
        return sum;
    }

    public String getProductName(int productNo) {
        return driver.findElements(productsNames).get(productNo -1).getText();
    }

    public String getBasketProductName(int productNo) {
        return driver.findElements(basketProductsNames).get(productNo-1).getText();
    }

    public int getBasketProductQuantity(int productNo) {
        return Integer.parseInt(driver.findElements(basketProductsQuantities).get(productNo-1).getText());
    }

    public int getNumberOfProductsInBasket() {
        return driver.findElements(basketProductsNames).size();
    }

    public Alert getAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    public int getTotalNumberOfProducts() {
        return Integer.parseInt(driver.findElement(totalNumberOfProducts).getText());
    }

    public float getTotalPrice() {
        int end = driver.findElement(totalPrice).getText().indexOf(" ");
        return Float.parseFloat(driver.findElement(totalPrice).getText().substring(0, end));
    }

    public float getProductsPrices() {
        float sum = 0;
        float productQuantity;
        float productPrice;
        String productName;
        int start;
        int end;
        for (int i = 0; i < driver.findElements(productsQuantities).size(); i++) {
            productName = this.getBasketProductName(i+1);
            start = productName.indexOf("(")+1;
            end = productName.indexOf(")");
            productQuantity = Float.parseFloat(driver.findElements(productsQuantities).get(i).getText());
            productPrice = Float.parseFloat(productName.substring(start, end));
            sum += productQuantity * productPrice;
        }
        return sum;
    }
}
