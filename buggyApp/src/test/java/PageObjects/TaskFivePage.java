package PageObjects;

import BaseClass.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskFivePage {

    private final BaseClass base;

    public TaskFivePage(BaseClass base) {
        this.base = base;
    }

    By taskButton = By.cssSelector("[href='/task_5']");
    By uploadFileButton = By.xpath("//input[@type='file']");
    By row = By.xpath(".//td");
    By tableBody = By.xpath(".//tbody");

    public void clickTaskButton() {
        base.driver.findElement(taskButton).click();
    }

    public void uploadFile(String filePath) {
        base.driver.findElement(uploadFileButton).sendKeys(filePath);
    }

    public List<WebElement> getRows() {
        return base.driver.findElements(row);
    }

    public boolean fileIsUploaded(String filePath) {
        try {
            WebDriverWait wait = new WebDriverWait(base.driver, Duration.ofSeconds(2));
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
