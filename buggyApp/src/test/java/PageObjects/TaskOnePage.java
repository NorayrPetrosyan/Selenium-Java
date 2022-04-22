package PageObjects;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TaskOnePage extends BaseClass {

    private final BaseClass base;

    public TaskOnePage(BaseClass base) {
        this.base = base;
    }

    By inputFields = By.className("form-control");
    By addButtons = By.className("btn-sm");
    By deleteButtons = By.xpath("//button[@class='btn btn-sm' and text()='Usuń']");
    By totalNumberOfProducts = By.className("summary-quantity");
    By totalPrice = By.className("summary-price");
    By productsQuantities = By.className("row-in-basket-quantity");
    By productsNames = By.cssSelector("div.caption h4");
    By basketProductsNames = By.className("col-md-9");
    By basketProductsQuantities = By.className("row-in-basket-quantity");

    public void addProductToBasket(int productNo, int quantity) {
        base.driver.findElements(inputFields).get(productNo-1).clear();
        base.driver.findElements(inputFields).get(productNo-1).sendKeys(quantity+"");
        base.driver.findElements(addButtons).get(productNo-1).click();
    }

    public void deleteAllProductsFromBasket() {
        for (WebElement deleteButton: base.driver.findElements(deleteButtons)) {
            deleteButton.click();
        }
    }

    public int getTotalProductsQuantities() {
        int sum = 0;
        for (WebElement productQuantity: base.driver.findElements(productsQuantities)) {
            sum += Integer.parseInt(productQuantity.getText());
            System.out.println(Integer.parseInt(productQuantity.getText()));
        }
        return sum;
    }

    public String getProductName(int productNo) {
        return base.driver.findElements(productsNames).get(productNo-1).getText();
    }

    public int getBasketProductQuantity(int productNo) {
        return Integer.parseInt(base.driver.findElements(basketProductsQuantities).get(productNo-1).getText());
    }

    public String getBasketProductName(int productNo) {
        return base.driver.findElements(basketProductsNames).get(productNo-1).getText();
    }

    public int getNumberOfProductsInBasket() {
        return base.driver.findElements(basketProductsNames).size();
    }

    public int getTotalNumberOfProducts() {
        return Integer.parseInt(base.driver.findElement(totalNumberOfProducts).getText());
    }

    public float getTotalPrice() {
        int end = base.driver.findElement(totalPrice).getText().indexOf(" ");
        return Float.parseFloat(base.driver.findElement(totalPrice).getText().substring(0, end));
    }

    public float getProductsPrices() {
        float sum = 0;
        float productQuantity;
        float productPrice;
        String productName;
        int start;
        int end;
        for (int i = 0; i < base.driver.findElements(productsQuantities).size(); i++) {
            productName = this.getBasketProductName(i+1);
            start = productName.indexOf("(")+1;
            end = productName.indexOf(")");
            productQuantity = Float.parseFloat(base.driver.findElements(productsQuantities).get(i).getText());
            productPrice = Float.parseFloat(productName.substring(start, end));
            sum += productQuantity * productPrice;
        }
        return sum;
    }

}
