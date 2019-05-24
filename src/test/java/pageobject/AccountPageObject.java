package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Helper;

import static utils.WebDriverUtils.sleep;

public class AccountPageObject {

    public WebDriver browser;

    public AccountPageObject(WebDriver browser) {
        this.browser = browser;
    }

    public void clickMyAvatar() {
        Helper.clickObjectByCss(".buttonHeader.moderate.clearfix .button .headerProfilePhoto", browser);
    }

    public void clickMyInformation() {
        browser.findElements(By.cssSelector(".box.dropdown.is-open.animated.fadeIn ul li")).get(0).click();
    }

    public boolean myInformation() {
        sleep(2000);
        String information = browser.findElement(By.cssSelector(".container-fluid .row .col-md-7.col-sm-7")).getText();
        if (information.contains("PROFİL BİLGİLERİ") == true) {
            return true;
        }
        return false;
    }

    public void clickEditProfile() {
        Helper.clickObjectByCss(".edit.btnEditProfile", browser);
        Helper.clickObjectById("btnUpdateProfile", browser);
    }


}
