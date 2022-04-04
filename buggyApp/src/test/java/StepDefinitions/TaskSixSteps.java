package StepDefinitions;

import BaseClass.BaseClass;
import PageObjects.TaskSixPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.*;

public class TaskSixSteps extends TaskSixPage {

    public TaskSixSteps(BaseClass base) {
        super(base);
    }

    @Given("User is on Task Six page")
    public void clickOnTaskButton() {
        super.clickTaskButton();
    }

    @When("User types {string} as login")
    public void typeLogin(String string) {
        super.typeLogin(string);
    }

    @When("User types {string} as password")
    public void typePassword(String string) {
        super.typePassword(string);
    }

    @When("User clicks 'Login' button")
    public void clickLoginButton() {
        super.clickLoginButton();
    }

    @Then("User logs in")
    public void userLogsIn() {
        assertThat(super.getCurrentURL()).isEqualTo("https://buggy-testingcup.pgs-soft.com/task_6/logged");
    }

    @Then("Error message is displayed")
    public void errorMessageShouldBeDisplayed() {
        assertThat(super.errorMessageIsDisplayed()).isTrue();
    }

    @Then("User is not logged in")
    public void userIsNotLoggedIn() {
        assertThat(super.getCurrentURL()).isEqualTo("https://buggy-testingcup.pgs-soft.com/task_6");
    }

    @Given("User is logged in")
    public void userIsLoggedIn() {
        super.typeLogin("tester");
        super.typePassword("123-xyz");
        super.clickLoginButton();
    }

    @When("User logs out")
    public void logOut() {
        super.clickLogOutButton();
    }

    @Then("User is logged out")
    public void userIsLoggedOut() {
        assertThat(super.getCurrentURL()).isEqualTo("https://buggy-testingcup.pgs-soft.com/task_6");
    }

    @When("User downloads the file")
    public void downloadFile() throws InterruptedException {
        super.clickOnDownloadLink();
    }

    @Then("The file is downloaded")
    public void fileIsDownloaded() {
        assertThat(super.isFileDownloaded("pgs_cv.jpg")).isTrue();
    }

}
