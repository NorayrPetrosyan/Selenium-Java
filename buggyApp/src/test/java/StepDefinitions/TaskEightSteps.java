package StepDefinitions;

import BaseClass.BaseClass;
import PageObjects.TaskEightPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.*;

public class TaskEightSteps extends TaskEightPage {

    public TaskEightSteps(BaseClass base) {
        super(base);
    }

    @Given("User is on Task Eight page")
    public void ClickOnTaskButton() {
        super.clickTaskButton();
    }

    @When("User selects {string} as card type")
    public void selectCardType(String string) {
        super.selectCardType(string);
    }

    @When("User types {string} as full name")
    public void typeFullName(String string) {
        super.typeFullName(string);
    }

    @When("User types {string} as card No")
    public void typeCardNo(String string) {
        super.typeCardNo(string);
    }

    @When("User types {string} as CVV code")
    public void typesCVVcode(String string) {
        super.typeCvvCode(string);
    }

    @When("User selects {string} as month")
    public void selectMonth(String string) {
        super.selectMonth(string);
    }

    @When("User selects {string} as year")
    public void selectYear(String string) {
        super.selectYear(string);
    }

    @When("User clicks on 'Pay' button")
    public void clickOnPayButton() {
        super.clickPayButton();
    }

    @Then("A message about successful payment is displayed")
    public void successfulPaymentMessageIsDisplayed() {
        assertThat(super.getSuccessMessage().isDisplayed()).isTrue();
    }

    @Then("A message about card expiration is displayed")
    public void cardExpirationMessageIsDisplayed() {
        assertThat(super.getExpirationMessage().isDisplayed()).isTrue();
    }

    @When("User hovers over info sign")
    public void hoversOverInfoSign() {
        super.hoverOverInfoSign();
    }

    @Then("CVV information is displayed")
    public void cvvInfoIsDisplayed() {
        assertThat(super.getCvvInfo().isDisplayed()).isTrue();
    }

    @Then("A message with {string} text, about not matching card No is displayed")
    public void notMatchingCardNoMessageIsDisplayed(String string) {
        assertThat(super.getCardNoFieldMessage()).isEqualTo(string);
    }

    @Then("A message about invalid CVV code is displayed")
    public void invalidCVVCodeMessageIsDisplayed() {
        assertThat(super.getCvvCodeFieldMessage().isDisplayed()).isTrue();
    }
}
