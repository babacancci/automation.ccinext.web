package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.LoginPageObject;
import utils.BaseSteps;

import static org.testng.Assert.assertTrue;

public class LoginSteps extends BaseSteps {

    private BaseSteps base;
    private LoginPageObject loginPage;

    public LoginSteps(BaseSteps base) {
        this.base = base;
        loginPage = new LoginPageObject(base.driver);
    }

    @Given("^I am a user of CCINEXT$")
    public void ıAmAUserOfCCINEXT() {
        loginPage.navigateTo();
    }


    @When("^I log in using valid credentials$")
    public void ıLogInUsingValidCredentials() {
        loginPage.login("10378175"
                , "asdf1234");
    }

    @Then("^I should be logged in$")
    public void ıShouldBeLoggedIn() {
        assertTrue(loginPage.isLoggedIn());
    }

    @When("^I log in using wrong valid credentials$")
    public void ıLogInUsingWrongValidCredentials() {
        loginPage.login("10378175"
                , "asdf1232224");
    }

    @Then("^I should not be logged in$")
    public void ıShouldNotBeLoggedIn() {
        System.out.println(loginPage.errorMessage());
    }

    @When("^I log in using empty valid credentials$")
    public void ıLogInUsingEmptyValidCredentials() {
        loginPage.login("10378175"
                , "");
    }

    @When("^I log in using missing valid credentials$")
    public void ıLogInUsingMissingValidCredentials() {
        loginPage.login("10378175"
                , "1");
    }

    @When("^I forget password$")
    public void ıForgetPassword() {
        loginPage.forgetButton();

    }

    @And("^I using user and mobile number$")
    public void ıUsingUserAndMobileNumber() {
        loginPage.forgetPopup("10378175", "");
    }

    @Then("^I should see sending message$")
    public void ıShouldSeeSendingMessage() {

    }

    @When("^I user info click$")
    public void ıUserInfoClick() {
        loginPage.userInfoClick();
    }

    @Then("^I should see user area pop-up$")
    public void ıShouldSeeUserAreaPopUp() {
        assertTrue(loginPage.userInfoPopup());
    }

    @And("^I go logout$")
    public void ıGoLogout() {
        loginPage.logoutClick();

    }

    @Then("^I should see logout$")
    public void ıShouldSeeLogout() {
        assertTrue(loginPage.shouldBeLogout());
    }
}
