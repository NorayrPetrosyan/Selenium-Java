package PageObjects;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TaskFourPage {

    private final BaseClass base;

    public TaskFourPage(BaseClass base) {
        this.base = base;
    }

    By message = By.xpath("//h1[text()='Wiadomość została wysłana']");

    public void switchToForm() {
        for(String winHandle : base.driver.getWindowHandles()){
            base.driver.switchTo().window(winHandle);
        }
        base.driver.switchTo().frame(0);
    }

    public WebElement getMessage() {
        return base.driver.findElement(message);
    }

    public WebElement getErrorMessage(String message) {
        String errorXpath = String.format("//span[text()='%s']", message);
        return base.driver.findElement(By.xpath(errorXpath));
    }

    public String getCurrentURL() {
        return base.driver.getCurrentUrl();
    }
}
