package PageObjects;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import java.io.File;

public class TaskSixPage {

    private final BaseClass base;

    public TaskSixPage(BaseClass base) {
        this.base = base;
    }

    By errorMessage = By.cssSelector("[class='alert alert-danger']");

    public String getCurrentURL() {
        return base.driver.getCurrentUrl();
    }

    public boolean errorMessageIsDisplayed() {
        return base.driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isFileDownloaded(String fileName) throws InterruptedException {
        Thread.sleep(5000);
        File dir = new File("C:\\Users\\User\\Downloads");
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }
}
