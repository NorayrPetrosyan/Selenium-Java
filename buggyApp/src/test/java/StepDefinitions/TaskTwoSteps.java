package StepDefinitions;

import BaseClass.BaseClass;
import PageObjects.TaskTwoPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import static org.assertj.core.api.Assertions.*;

public class TaskTwoSteps extends TaskTwoPage {

    public TaskTwoSteps(BaseClass base) {
        super(base);
    }

    @When("I set {} as filter")
    public void selectFilter(String filter) {
        super.setProductsCategory(filter);
    }

    @Then("Products are filtered by {}")
    public void productsAreFiltered(String filter) {
        for (WebElement category : super.getProductsCategories()) {
            assertThat(filter).isEqualTo(filter, category.getText());
        }
    }

    @Then("{} is in search results")
    public void isInSearchResults(String filterName) {
        for (WebElement filter : super.getFilters()) {
            assertThat(filter.getText().toLowerCase()).contains(filterName.toLowerCase());
        }
    }

    @Then("No results found")
    public void noResultsFound() {
        assertThat(super.getFilters().size()).isEqualTo(1);
        assertThat(super.getFilters().get(0).getText()).isEqualTo("No results found");
    }
}
