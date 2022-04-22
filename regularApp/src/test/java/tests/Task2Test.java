package tests;

import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.Task2Page;
import java.util.List;

@Feature("Filtering products by category")
public class Task2Test {

    private WebDriver driver;
    private Task2Page task2Page;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        task2Page = new Task2Page(driver);
        driver.get("https://testingcup.pgs-soft.com/");
        task2Page.clickTaskButton();
    }

    @Test(description = "Filter products")
    public void filterProducts() {
        List<String> filtersNames = task2Page.getFiltersNamesInList();
        for (String filterName : filtersNames) {
            task2Page.setProductsCategory(filterName);
            for (WebElement category : task2Page.getProductsCategories()) {
                Assert.assertEquals(filterName, category.getText());
            }
        }
    }

    @Test(description = "Search for an existing filter")
    public void searchForExistingFilter() {
        String searchedFilter = "Sport";
        task2Page.searchFilter(searchedFilter);
        for (WebElement filter : task2Page.getFilters()) {
            Assert.assertTrue(filter.getText().toLowerCase().contains(searchedFilter.toLowerCase()));
        }
    }

    @Test(description = "Check the search field is case-sensitive")
    public void caseSensitivityOfSearchField() {
        String searchedFilter = "sport";
        task2Page.searchFilter(searchedFilter);
        for (WebElement filter : task2Page.getFilters()) {
            Assert.assertTrue(filter.getText().toLowerCase().contains(searchedFilter.toLowerCase()));
        }
    }

    @Test(description = "Search an invalid filter")
    public void searchInvalidFilter() {
        task2Page.searchFilter("Dance");
        Assert.assertTrue(task2Page.getFilters().size() == 1 && task2Page.getFilters().get(0).getText().equals("No results found"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
