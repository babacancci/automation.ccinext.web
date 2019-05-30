package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.OrdersPageObject;
import utils.BaseSteps;

import static org.testng.Assert.assertTrue;

public class OrdersSteps extends BaseSteps {

    private OrdersPageObject orderPage;
    private BaseSteps base;

    public OrdersSteps(BaseSteps base){
        this.base = base;
        orderPage = new OrdersPageObject(base.driver);
    }

    @When("^I go to orders$")
    public void ıGoToOrders() {
        orderPage.orderButton();

    }

    @Then("^I should see orders page$")
    public void ıShouldSeeOrdersPage() {
        assertTrue(orderPage.shouldSeeOrder());
    }
}
