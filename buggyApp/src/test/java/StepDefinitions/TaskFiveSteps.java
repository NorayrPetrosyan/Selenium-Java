package StepDefinitions;

import BaseClass.BaseClass;
import PageObjects.TaskFivePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.*;

public class TaskFiveSteps extends TaskFivePage {

    public TaskFiveSteps(BaseClass base) {
        super(base);
    }

    private final String filePath = "C:\\Users\\User\\Documents\\Selenium-Java\\Testing Material\\";

    @Given("User is on Task Five page")
    public void ClickOnTaskButton() {
        super.clickTaskButton();
    }

    @When("User uploads {string} file")
    public void uploadFile(String string) {
        super.uploadFile(filePath+string);
    }

    @Then("{string} file is uploaded")
    public void isUploaded(String string) {
        assertThat(super.fileIsUploaded(filePath+string)).isTrue();
    }

    @Then("{string} file is not uploaded")
    public void isNotUploaded(String string) {
        assertThat(super.fileIsUploaded(filePath+string)).isFalse();
    }

}
