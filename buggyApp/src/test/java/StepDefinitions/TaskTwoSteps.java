package StepDefinitions;

import BaseClass.BaseClass;
import PageObjects.TaskTwoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import static org.assertj.core.api.Assertions.*;

public class TaskTwoSteps extends TaskTwoPage {

    public TaskTwoSteps(BaseClass base) {
        super(base);
    }

    @Given("User is on Task Two page")
    public void clickOnTaskButton() {
        super.clickTaskButton();
    }

    @When("User selects {string} as filter")
    public void selectFilter(String string) {
        super.setProductsCategory(string);
    }

    @Then("Products are filtered by {string}")
    public void productsAreFiltered(String string) {
        for (WebElement category : super.getProductsCategories()) {
            assertThat(string).isEqualTo(string, category.getText());
        }
    }

    @When("User types {string} as filter name in filter search field")
    public void searchForExistingFilter(String string) {
        super.searchFilter(string);
    }

    @Then("Searched {string} name is in search results")
    public void searchedFilterIsInSearchResults(String string) {
        for (WebElement filter : super.getFilters()) {
            assertThat(filter.getText()).contains(string);
        }
    }

    @Then("{string} is in search results")
    public void caseSensitivity(String string) {
        for (WebElement filter : super.getFilters()) {
            assertThat(filter.getText().toLowerCase()).contains(string.toLowerCase());
        }
    }

    @Then("No results found")
    public void noResultsFound() {
        assertThat(super.getFilters().size()).isEqualTo(1);
        assertThat(super.getFilters().get(0).getText()).isEqualTo("No results found");
    }
}
