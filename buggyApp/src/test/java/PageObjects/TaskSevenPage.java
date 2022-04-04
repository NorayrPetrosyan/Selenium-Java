package PageObjects;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class TaskSevenPage {

    private final BaseClass base;

    public TaskSevenPage(BaseClass base) {
        this.base = base;
    }

    By taskButton = By.cssSelector("[href='/task_7']");
    By inputFields = By.className("form-control");
    By draggablePhotos = By.cssSelector("[class='draggable ui-draggable ui-draggable-handle']");
    By placeToDrop = By.cssSelector("[class='panel-body']");

    public void clickTaskButton() {
        base.driver.findElement(taskButton).click();
    }

    public void addProductToBasket(int productNo, int quantity) {
        base.driver.findElements(inputFields).get(productNo -1).clear();
        base.driver.findElements(inputFields).get(productNo -1).sendKeys(quantity+"");
        Actions action = new Actions(base.driver);
        action.dragAndDrop(base.driver.findElements(draggablePhotos).get(productNo -1), base.driver.findElement(placeToDrop)).build().perform();
        action.dragAndDrop(base.driver.findElements(draggablePhotos).get(productNo -1), base.driver.findElement(placeToDrop)).build().perform();
    }
}
