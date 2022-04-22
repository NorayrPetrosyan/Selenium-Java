package StepDefinitions;

import BaseClass.BaseClass;
import PageObjects.TaskNinePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.WebElement;

public class TaskNineSteps extends TaskNinePage {

    public TaskNineSteps(BaseClass base) {
        super(base);
    }

    @When("I open all nodes")
    public void openAllNodes() {
        super.openAllNodes();
    }

    @Then("All nodes have the same names and titles")
    public void allNodesHaveTheSameNamesAndTitles() {
        for (WebElement node: super.getNodes()) {
            node.click();
            assertThat(super.getTitle().getText()).isEqualTo(node.getText());
        }
    }
}
