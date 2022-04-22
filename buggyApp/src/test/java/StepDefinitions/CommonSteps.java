package StepDefinitions;

import BaseClass.BaseClass;
import PageObjects.DynamicFunctions;
import io.cucumber.java.en.And;
import static org.assertj.core.api.Assertions.assertThat;

public class CommonSteps extends DynamicFunctions {

    public CommonSteps(BaseClass base) {
        super(base);
    }

    @And("I click on {}")
    public void click(String element) {
        super.click(element);
    }

    @And("I type {} in {}")
    public void type(String text, String field) {
        super.type(text, field);
    }

    @And("I select {} from {}")
    public void select(String toBeSelected, String container) {
        super.select(toBeSelected, container);
    }

    @And("I upload {} from {}")
    public void upload(String fileName, String whereTo) {
        super.upload(fileName, whereTo);
    }

    @And("I scroll down")
    public void scrollDown() {
        super.scroll();
    }

    @And("Alert with {} text is displayed")
    public void alertMessageIsDisplayed(String text) {
        assertThat(super.getAlert().getText()).isEqualTo(text);
        super.getAlert().accept();
    }

    @And("{} is opened")
    public void pageIsOpened(String page) {
        assertThat(super.isOpened(page)).isTrue();
    }

    @And("{} is visible")
    public void elementIsDisplayed(String element) {
        assertThat(super.isDisplayed(element)).isTrue();
    }
}
