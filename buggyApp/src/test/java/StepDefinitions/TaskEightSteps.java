package StepDefinitions;

import BaseClass.BaseClass;
import PageObjects.TaskEightPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.*;

public class TaskEightSteps extends TaskEightPage {

    public TaskEightSteps(BaseClass base) {
        super(base);
    }

    @Then("A message about successful payment is displayed")
    public void successfulPaymentMessageIsDisplayed() {
        assertThat(super.getSuccessMessage().isDisplayed()).isTrue();
    }

    @Then("A message about card expiration is displayed")
    public void cardExpirationMessageIsDisplayed() {
        assertThat(super.getExpirationMessage().isDisplayed()).isTrue();
    }

    @When("I hover over info sign")
    public void hoversOverInfoSign() {
        super.hoverOverInfoSign();
    }

//    @Then("CVV information is displayed")
//    public void cvvInfoIsDisplayed() {
//        assertThat(super.getCvvInfo().isDisplayed()).isTrue();
//    }

    @Then("A message with {} text about not matching card No is displayed")
    public void notMatchingCardNoMessageIsDisplayed(String text) {
        assertThat(super.getCardNoFieldMessage()).isEqualTo(text);
    }

    @Then("A message about invalid CVV code is displayed")
    public void invalidCVVCodeMessageIsDisplayed() {
        assertThat(super.getCvvCodeFieldMessage().isDisplayed()).isTrue();
    }
}
