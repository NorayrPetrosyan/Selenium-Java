package StepDefinitions;

import BaseClass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks extends BaseClass {

    private final BaseClass base;

    public Hooks(BaseClass base) {
        this.base = base;
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\driver\\chromedriver.exe");
        base.driver = new ChromeDriver();
        base.driver.get(base.baseURL);
    }

    @After
    public void tearDown() {
        base.driver.quit();
    }
}
