package StepDefinitions;

import BaseClass.BaseClass;
import PageObjects.TaskOnePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.UnhandledAlertException;

import static org.assertj.core.api.Assertions.*;

public class TaskOneSteps extends TaskOnePage {

    public TaskOneSteps(BaseClass base) {
        super(base);
    }
    @Given("User is on Task One page")
    public void clickOnTaskButton() {
        super.clickTaskButton();
    }

    @When("User adds products to the basket")
    public void addProductsToBasket() {
        int[] productsNo = {2, 3, 4};
        int[] productsQuantities = {8, 1, 11};
        for (int i = 0; i < productsNo.length; i++) {
            super.addProductToBasket(productsNo[i], productsQuantities[i]);
        }
    }

    @Then("Products with appropriate names are added to the basket")
    public void productsAreAddedToBasket() {
        int[] productsNo = {2, 3, 4};
        for (int i = 1; i < super.getNumberOfProductsInBasket(); i++) {
            assertThat(super.getBasketProductName(i)).contains(super.getProductName(productsNo[i-1]));
        }
    }

    @Then("Products with appropriate quantities are added to the basket")
    public void productsQuantitiesAddedToBasket() {
        int[] productsQuantities = {8, 1, 11};
        for (int i = 1; i < super.getNumberOfProductsInBasket(); i++) {
            assertThat(super.getBasketProductQuantity(i)).isEqualTo(productsQuantities[i-1]);
        }
    }

    @When("User removes products from the basket")
    public void removeProductsFromBasket() {
        super.deleteAllProductsFromBasket();
    }

    @Then("Total number of products in basket is equal to 0")
    public void basketIsEmpty() {
        assertThat(super.getTotalNumberOfProducts()).isEqualTo(0);
    }

    @Then("Total number of products added to the basket is equal to the sum of products quantities")
    public void totalNumberOfProducts() {
        assertThat(super.getTotalNumberOfProducts()).isEqualTo(super.getTotalProductsQuantities());
    }

    @Then("Total price of products is equal to the sum of products prices added to the basket")
    public void totalPriceOfProducts() {
        assertThat(super.getTotalPrice()).isEqualTo(Math.round(super.getProductsPrices() * 100.0) / 100.0f);
    }

    @When("User adds 101 products to the basket")
    public void addMoreThan100Products() {
        super.addProductToBasket(10, 101);
    }

    @Then("Alert with {string} text is displayed")
    public void alertMessageIsDisplayed(String string) {
        assertThat(super.getAlert().getText()).isEqualTo(string);
        super.getAlert().accept();
    }

    @Then("The products are not added to the basket")
    public void TotalNumberOfProductsIsLessThan101() {
        assertThat(super.getTotalNumberOfProducts()).isLessThan(101);
    }
}
