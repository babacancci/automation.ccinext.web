package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Helper;

public class EducationPageObject {

    public WebDriver browser;

    public EducationPageObject(WebDriver browser) {
        this.browser = browser;
    }


    public void educationButton() {
        Helper.clickObjectByLinkText("Eğitim", browser);
    }

    public boolean isMovies(){
        browser.findElement(By.cssSelector(".blogItem .row")).isDisplayed();
        return true;
    }

}
