package StepDefinitions;

import BaseClass.BaseClass;
import PageObjects.TaskFourPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.*;

public class TaskFourSteps extends TaskFourPage {

    public TaskFourSteps(BaseClass base) {
        super(base);
    }

    @When("I switch to the opened form")
    public void switchToForm() {
        super.switchToForm();
    }

    @Then("The application form is  opened")
    public void applicationFormIsOpened() {
        assertThat(super.getCurrentURL()).isEqualTo("about:blank");
    }

    @Then("A message about successful application is displayed")
    public void SuccessfulApplicationMessageIsDisplayed() {
        assertThat(super.getMessage().isDisplayed()).isTrue();
    }

    @Then("A message with {} text is displayed")
    public void messageAboutInvalidNameIsDisplayed(String text) {
        assertThat(super.getErrorMessage(text).isDisplayed()).isTrue();
    }
}
