package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Task2Page {

    private WebDriver driver;

    public Task2Page(WebDriver driver) {
        this.driver = driver;
    }

    private By taskButton = By.cssSelector("[href='/task_2']");
    private By filterContainer = By.className("select2-selection__rendered");
    private By filters = By.xpath("//li[contains(@class, 'select2-results__option')]");
    private By productsCategories = By.cssSelector("strong");
    private By searchField = By.cssSelector("[type='search']");

    public void clickTaskButton() {
        driver.findElement(taskButton).click();
    }

    public void setProductsCategory(String categoryName) {
        driver.findElement(filterContainer).click();
        String categoryXpath = String.format("//li[text()='%s']", categoryName);
        driver.findElement(By.xpath(categoryXpath)).click();
    }

    public List<WebElement> getProductsCategories() {
        return driver.findElements(productsCategories);
    }

    public void searchFilter(String filterName) {
        driver.findElement(filterContainer).click();
        driver.findElement(searchField).sendKeys(filterName);
    }

    public List<String> getFiltersNamesInList() {
        List<String> filtersList = new ArrayList<>();
        driver.findElement(filterContainer).click();
        for (WebElement filter: driver.findElements(filters)){
            filtersList.add(filter.getText());
        }
        driver.findElement(filterContainer).click();
        return filtersList;
    }

    public List<WebElement> getFilters() {
        return driver.findElements(filters);
    }

}