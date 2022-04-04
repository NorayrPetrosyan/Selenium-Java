package StepDefinitions;

import BaseClass.BaseClass;
import PageObjects.TaskFourPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.*;

public class TaskFourSteps extends TaskFourPage {

    public TaskFourSteps(BaseClass base) {
        super(base);
    }

    @Given("User is on Task Four page")
    public void ClickOnTaskButton() {
        super.clickTaskButton();
    }

    @When("User clicks on 'Apply' button")
    public void ClickOnApplyButton() {
        super.clickApplyButton();
        super.switchToForm();
    }

    @Then("The application form is opened")
    public void applicationFormIsOpened() {
        assertThat(super.getCurrentURL()).isEqualTo("about:blank");
    }

    @When("User types {string} as name")
    public void typeName(String string) {
        super.typeName(string);
    }

    @When("User types {string} as email")
    public void typeEmail(String string) {
        super.typeEmail(string);
    }

    @When("User types {string} as tel. number")
    public void typeTelNumber(String string) {
        super.typeTelNumber(string);
    }

    @When("User clicks 'Save' button")
    public void clickSaveButton() {
        super.clickSaveButton();
    }

    @Then("A message about successful application is displayed")
    public void SuccessfulApplicationMessageIsDisplayed() {
        assertThat(super.getMessage().isDisplayed()).isTrue();
    }

    @Then("A message with {string} text, about invalid name is displayed")
    public void messageAboutInvalidNameIsDisplayed(String string) {
        assertThat(super.getErrorMessage(string).isDisplayed()).isTrue();
    }

    @Then("A message with {string} text, about invalid email is displayed")
    public void messageAboutInvalidEmailIsDisplayed(String string) {
        assertThat(super.getErrorMessage(string).isDisplayed()).isTrue();
    }

    @Then("A message with {string} text, about invalid tel. number is displayed")
    public void messageAboutInvalidTelNumberIsDisplayed(String string) {
        assertThat(super.getErrorMessage(string).isDisplayed()).isTrue();
    }
}
