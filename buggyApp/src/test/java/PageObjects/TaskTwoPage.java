package PageObjects;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class TaskTwoPage {

    private final BaseClass base;

    public TaskTwoPage(BaseClass base) {
        this.base = base;
    }

    By taskButton = By.cssSelector("[href='/task_2']");
    By filterContainer = By.className("select2-selection__rendered");
    By filters = By.xpath("//li[contains(@class, 'select2-results__option')]");
    By productsCategories = By.cssSelector("strong");
    By searchField = By.cssSelector("[type='search']");

    public void clickTaskButton() {
        base.driver.findElement(taskButton).click();
    }

    public void setProductsCategory(String categoryName) {
        base.driver.findElement(filterContainer).click();
        String categoryXpath = String.format("//li[text()='%s']", categoryName);
        base.driver.findElement(By.xpath(categoryXpath)).click();
    }

    public List<WebElement> getProductsCategories() {
        return base.driver.findElements(productsCategories);
    }

    public void searchFilter(String filterName) {
        base.driver.findElement(filterContainer).click();
        base.driver.findElement(searchField).sendKeys(filterName);
    }

    public List<WebElement> getFilters() {
        return base.driver.findElements(filters);
    }

}
