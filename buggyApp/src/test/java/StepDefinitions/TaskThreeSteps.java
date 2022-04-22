package StepDefinitions;

import BaseClass.BaseClass;
import PageObjects.TaskThreePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import static org.assertj.core.api.Assertions.*;

public class TaskThreeSteps extends TaskThreePage {

    private String previousPhotoSrc;
    private String currentPhotoSrc;

    public TaskThreeSteps(BaseClass base) {
        super(base);
    }

    @When("I make the form editable")
    public void makeFormEditable() {
        super.makeFormEditable();
        previousPhotoSrc = super.getPhotoSrc();
    }

    @Then("The form input fields are enabled")
    public void inputFieldsAreEnabled() {
        for (WebElement inputField: super.getInputFields()) {
            assertThat(inputField.isEnabled()).isTrue();
        }
    }

    @Then("The photo is updated")
    public void photoIsUpdated() {
        currentPhotoSrc = super.getPhotoSrc();
        assertThat(previousPhotoSrc).isNotEqualTo(currentPhotoSrc);
    }

    @Then("The photo is not changed")
    public void photoIsNotChanged() {
        currentPhotoSrc = super.getPhotoSrc();
        assertThat(currentPhotoSrc).isEqualTo(previousPhotoSrc);
    }

    @Then("A message about successful registration is displayed")
    public void messageIsDisplayed() {
        assertThat(super.getMessage().isDisplayed()).isTrue();
    }

    @Then("The form input fields are disabled")
    public void inputFieldsAreDisabled() {
        for (WebElement inputField: super.getInputFields()) {
            assertThat(inputField.isEnabled()).isFalse();
        }
    }

    @When("I fill the form with no data")
    public void userFillsFormWithNoData() {
        super.typeName("");
        super.typeSurname("");
        super.typeTelNumber("");
    }

    @Then("Save button is disabled")
    public void saveBtnIsDisabled() {
        assertThat(super.saveButtonIsDisabled()).isTrue();
    }
}
