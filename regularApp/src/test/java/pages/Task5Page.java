package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Task5Page {
    private WebDriver driver;

    public Task5Page(WebDriver driver) {
        this.driver = driver;
    }

    private By taskButton = By.cssSelector("[href='/task_5']");
    private By uploadFileButton = By.xpath("//input[@type='file']");
    private By row = By.xpath("//td");
    private By tableBody = By.xpath(".//tbody");

    public void clickTaskButton() {
        driver.findElement(taskButton).click();
    }

    public void uploadFile(String filePath) {
        driver.findElement(uploadFileButton).sendKeys(filePath);
    }

    public Alert getAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    public List<WebElement> getRows() {
        return driver.findElements(row);
    }

    public boolean fileIsUploaded(String filePath) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOfElementLocated(tableBody));
        } catch(TimeoutException toe){
            toe.printStackTrace();
        }
        String line;
        List<WebElement> rows = getRows();
        if (rows.size() == 0) {
            return false;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                for (int i = 0; i < data.length; i++) {
                    if (!data[i].equals(rows.get(0).getText())) {
                        return false;
                    }
                    rows.remove(0);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
