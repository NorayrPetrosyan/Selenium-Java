package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Task9Page {

    private WebDriver driver;

    public Task9Page(WebDriver driver) {
        this.driver = driver;
    }

    private By taskButton = By.cssSelector("[href='/task_9']");
    private By node = By.cssSelector("a.jstree-anchor");
    private By title = By.xpath(".//h1");

    public void clickTaskButton() {
        driver.findElement(taskButton).click();
    }

    public void openAllNodes() {
        String path = "//li[@aria-expanded='false']";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
        while (driver.findElements(By.xpath(path)).size() > 0) {
            for (WebElement jstreeIcon : driver.findElements(By.xpath(path+"/i[@class='jstree-icon jstree-ocl']"))) {
                jstreeIcon.click();
            }
        }
    }

    public List<WebElement> getNodes() {
        return driver.findElements(node);
    }

    public WebElement getTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(title));
        return driver.findElement(title);
    }
}
