package StepDefinitions;

import BaseClass.BaseClass;
import PageObjects.TaskSevenPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.UnhandledAlertException;

public class TaskSevenSteps extends TaskSevenPage {

    public TaskSevenSteps(BaseClass base) {
        super(base);
    }

    @When("I add products to the basket via drag and drop")
    public void addProductsToBasket() {
        int[] productsNo = {2, 3, 4};
        int[] productsQuantities = {8, 1, 11};
        for (int i = 0; i < productsNo.length; i++) {
            super.addProductToBasket(productsNo[i], productsQuantities[i]);
        }
    }

    @When("I add more than 100 products to the basket via drag and drop")
    public void addMoreThan100Products() {
        try {
            super.addProductToBasket(10, 101);
        } catch (UnhandledAlertException e) {
            e.printStackTrace();
        }

    }
}
