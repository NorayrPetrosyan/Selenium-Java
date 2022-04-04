package StepDefinitions;

import BaseClass.BaseClass;
import PageObjects.TaskThreePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import static org.assertj.core.api.Assertions.*;

public class TaskThreeSteps extends TaskThreePage {

    private String previousPhotoSrc;
    private String currentPhotoSrc;
    private final String filePath = "C:\\Users\\User\\Documents\\Selenium-Java\\Testing Material\\";

    public TaskThreeSteps(BaseClass base) {
        super(base);
    }

    @Given("User is on Task Three page")
    public void clickOnTaskButton() {
        super.clickTaskButton();
    }

    @When("User makes form editable")
    public void makeFormEditable() {
        super.makeFormEditable();
    }

    @Then("The form input fields are enabled")
    public void inputFieldsAreEnabled() {
        for (WebElement inputField: super.getInputFields()) {
            assertThat(inputField.isEnabled()).isTrue();
        }
    }

    @When("User uploads a photo")
    public void uploadPhoto() {
        previousPhotoSrc = super.getPhotoSrc();
        super.uploadFile(filePath+"image.png");
    }

    @Then("The photo is updated")
    public void photoIsUpdated() {
        currentPhotoSrc = super.getPhotoSrc();
        assertThat(previousPhotoSrc).isNotEqualTo(currentPhotoSrc);
    }

    @When("User uploads a wrong formatted file")
    public void uploadWrongFormattedFile() {
        previousPhotoSrc = super.getPhotoSrc();
        super.uploadFile(filePath+"wrongFileFormat.xlsx");
    }

    @Then("The photo is not changed")
    public void photoIsNotChanged() {
        currentPhotoSrc = super.getPhotoSrc();
        assertThat(currentPhotoSrc).isEqualTo(previousPhotoSrc);
    }

    @When("User fills form with valid data")
    public void fillFormWithValidData() {
        super.typeName("Tom");
        super.typeSurname("Smith");
        super.typeNote("Something");
        super.typeTelNumber("19154234567");
        super.uploadFile(filePath+"image.png");
    }

    @When("User clicks on 'Save' button")
    public void clickOnSaveButton() {
        super.clickSaveButton();
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

    @When("User fills form with no data")
    public void userFillsFormWithNoData() {
        super.typeName("");
        super.typeSurname("");
        super.typeTelNumber("");
    }

    @Then("'Save' button is disabled")
    public void saveBtnIsDisabled() {
        assertThat(super.saveButtonIsDisabled()).isTrue();
    }
}
