package StepDefinitions;

import BaseClass.BaseClass;
import PageObjects.TaskSixPage;
import io.cucumber.java.en.Then;
import static org.assertj.core.api.Assertions.*;

public class TaskSixSteps extends TaskSixPage {

    public TaskSixSteps(BaseClass base) {
        super(base);
    }

    @Then("I am logged in")
    public void loggedIn() {
        assertThat(super.getCurrentURL()).isEqualTo("https://buggy-testingcup.pgs-soft.com/task_6/logged");
    }

    @Then("Error message is displayed")
    public void errorMessageShouldBeDisplayed() {
        assertThat(super.errorMessageIsDisplayed()).isTrue();
    }

    @Then("I am not logged in")
    public void isNotLoggedIn() {
        assertThat(super.getCurrentURL()).isEqualTo("https://buggy-testingcup.pgs-soft.com/task_6");
    }

    @Then("I am logged out")
    public void isLoggedOut() {
        assertThat(super.getCurrentURL()).isEqualTo("https://buggy-testingcup.pgs-soft.com/task_6");
    }

    @Then("The file is downloaded")
    public void fileIsDownloaded() throws InterruptedException {
        assertThat(super.isFileDownloaded("pgs_cv.jpg")).isTrue();
    }

}
