package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.AccountPageObject;
import pageobject.LoginPageObject;
import utils.BaseSteps;

public class AccountSteps extends BaseSteps {

    private BaseSteps base;
    private AccountPageObject accountPage;

    public AccountSteps(BaseSteps base) {
        this.base = base;
        accountPage = new AccountPageObject(base.driver);
    }


}
