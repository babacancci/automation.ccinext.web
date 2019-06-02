package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.MyOrdersPageObject;
import utils.BaseSteps;

import static org.testng.AssertJUnit.assertTrue;

public class MyOrdersSteps extends BaseSteps {
    private BaseSteps base;
    private MyOrdersPageObject myOrdersPage;


    public MyOrdersSteps(BaseSteps base) {
        this.base = base;
        myOrdersPage = new MyOrdersPageObject(base.driver);
    }

    @When("^I go to my orders$")
    public void ıGoToMyOrders() {
        myOrdersPage.myOrdersButton();
    }

    @Then("^I should see my orders$")
    public void ıShouldSeeMyOrders() {
        assertTrue(myOrdersPage.shouldSeeMyOrders());
    }

    @And("^I select selecting the date$")
    public void ıSelectSelectingTheDate() {
        myOrdersPage.selectingTheDate();
    }

    @Then("^I should see my orders details$")
    public void ıShouldSeeMyOrdersDetails() {
        assertTrue(myOrdersPage.shouldSeeSelectingMyOrders());
    }
}
