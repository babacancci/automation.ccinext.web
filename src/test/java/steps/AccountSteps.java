package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.AccountPageObject;
import utils.BaseSteps;

import static org.testng.Assert.assertTrue;

public class AccountSteps extends BaseSteps {

    private BaseSteps base;
    private AccountPageObject accountPage;

    public AccountSteps(BaseSteps base) {
        this.base = base;
        accountPage = new AccountPageObject(base.driver);
    }

    @When("^I go to my profile information$")
    public void ıGoToMyProfileInformation() {
        accountPage.clickMyAvatar();
        accountPage.clickMyInformation();
    }

    @Then("^I should see my information$")
    public void ıShouldSeeMyInformation() {
        assertTrue(accountPage.myInformation());
    }


    @When("^I go to my edit profile information$")
    public void ıGoToMyEditProfileInformation() {
        accountPage.clickEditProfile();
    }

}
