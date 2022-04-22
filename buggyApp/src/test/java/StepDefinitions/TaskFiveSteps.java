package StepDefinitions;

import BaseClass.BaseClass;
import PageObjects.TaskFivePage;
import io.cucumber.java.en.Then;
import static org.assertj.core.api.Assertions.*;

public class TaskFiveSteps extends TaskFivePage {

    public TaskFiveSteps(BaseClass base) {
        super(base);
    }

    private final String filePath = "C:\\Users\\User\\Documents\\Selenium-Java\\Testing Material\\";

    @Then("{} file is uploaded")
    public void isUploaded(String fileName) {
        assertThat(super.fileIsUploaded(filePath+fileName)).isTrue();
    }

    @Then("{} file is not uploaded")
    public void isNotUploaded(String fileName) {
        assertThat(super.fileIsUploaded(filePath+fileName)).isFalse();
    }

}
