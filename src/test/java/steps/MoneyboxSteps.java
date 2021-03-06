package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.LoginPageObject;
import pageobject.MoneyBoxPageObject;
import utils.BaseSteps;

import static org.testng.Assert.assertTrue;

public class MoneyboxSteps {

    private BaseSteps base;
    private MoneyBoxPageObject moneyboxPage;
    private LoginPageObject loginPage;

    public MoneyboxSteps(BaseSteps base) {
        this.base = base;
        moneyboxPage = new MoneyBoxPageObject(base.driver);
        loginPage = new LoginPageObject(base.driver);
    }

    @And("^I go to moneybox$")
    public void ıGoToMoneybox() {
        moneyboxPage.moneyBoxButton();
    }

    @When("^I go to what is the red moneybox$")
    public void ıGoToWhatIsTheRedMoneybox() {
        moneyboxPage.redMoneyBoxButton();
    }

    @Then("^I should see what the moneybox is$")
    public void ıShouldSeeWhatTheMoneyboxIs() {
        assertTrue(moneyboxPage.redMoneyBoxAbout());
    }

    @When("^I go to display points movements$")
    public void ıGoToDisplayPointsMovements() {
        moneyboxPage.pointHistoryButton();
    }

    @Then("^I should see points movements$")
    public void ıShouldSeePointsMovements() {
        assertTrue(moneyboxPage.availablePoints());
    }

    @When("^I go to gift catalog$")
    public void ıGoToGiftCatalog() {
        moneyboxPage.butonCatalogButton();
    }

    @And("^I cancel Cocacola box$")
    public void ıCancelCocacolaBox() {
        moneyboxPage.cancelCocaColaBoxPopup();
    }

    @Then("^I should see CCINEXT$")
    public void ıShouldSeeCCINEXT() {
        assertTrue(loginPage.isLoggedIn());
    }

    @When("^I go to where gift$")
    public void ıGoToWhereGift() {
        moneyboxPage.whereGiftButton();
    }
}
