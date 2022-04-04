package PageObjects;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TaskNinePage {

    private final BaseClass base;

    public TaskNinePage(BaseClass base) {
        this.base = base;
    }

    By taskButton = By.cssSelector("[href='/task_9']");
    By node = By.cssSelector("a.jstree-anchor");
    By title = By.xpath(".//h1");

    public void clickTaskButton() {
        base.driver.findElement(taskButton).click();
    }

    public void openAllNodes() {
        String path = "//li[@aria-expanded='false']";
        WebDriverWait wait = new WebDriverWait(base.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
        while (base.driver.findElements(By.xpath(path)).size() > 0) {
            for (WebElement jstreeIcon : base.driver.findElements(By.xpath(path+"/i[@class='jstree-icon jstree-ocl']"))) {
                jstreeIcon.click();
            }
        }
    }

    public List<WebElement> getNodes() {
        return base.driver.findElements(node);
    }

    public WebElement getTitle() {
        WebDriverWait wait = new WebDriverWait(base.driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(title));
        return base.driver.findElement(title);
    }
}
