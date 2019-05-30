package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobject.EducationPageObject;
import utils.BaseSteps;

import static org.testng.Assert.assertTrue;

public class EducationSteps extends BaseSteps {

    private BaseSteps base;
    private EducationPageObject educationPage;

    public EducationSteps(BaseSteps base) {
        this.base = base;
        educationPage = new EducationPageObject(base.driver);
    }


    @When("^I go to education$")
    public void ıGoToEducation() {
        educationPage.educationButton();
    }

    @Then("^I should see movies$")
    public void ıShouldSeeMovies() {
        assertTrue(educationPage.isMovies());
    }

}
