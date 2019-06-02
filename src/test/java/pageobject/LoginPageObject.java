package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;
import utils.Helper;

import static utils.WebDriverUtils.sleep;


public class LoginPageObject {

    public WebDriver browser;

    public LoginPageObject(WebDriver browser) {
        this.browser = browser;
    }

    public void navigateTo() {
        browser.get(ConfigReader.getInstance().getHost());
    }

    public void login(String userId, String pass) {
        Helper.setObjectById("txtLoginOutletNumber", userId, browser);
        Helper.setObjectById("txtLoginPassword", pass, browser);
        browser.findElement(By.cssSelector(".column #btnLogin")).click();
    }

    public boolean isLoggedIn() {
        Helper.WaitForElementPresent(By.className("container-fluid"), browser);
        WebElement login = browser.findElement(By.className("container-fluid"));
        if (login.getText() != null) {
            return true;
        }
        return false;
    }

    public boolean errorMessage() {
        sleep(2000);
        boolean error = browser.findElement(By.cssSelector(".pop-up.animated.bounceInDown .item")).isEnabled();
        if (error == true) {
            return true;
        }
        return false;
    }

    public void forgetButton() {
        Helper.clickObjectByCss(".column .forgotPasswordText", browser);
    }

    public void forgetPopup(String userId, String phoneNumber) {
        Helper.setObjectById("txtForgotPasswordOutletNumber", userId, browser);
        Helper.setObjectById("txtForgotPasswordPhoneNumber", phoneNumber, browser);
        Helper.clickObjectById("btnSendCode", browser);
    }

    public void userInfoClick() {
        Helper.clickObjectByCss(".inputWrap.numberItem .informationBtn", browser);
    }

    public boolean userInfoPopup() {
        browser.findElement(By.cssSelector(".inputWrap.numberItem .informationBtn")).isEnabled();
        return true;
    }

    public void logoutClick() {
        Helper.clickObjectByCss(".buttonHeader.moderate.clearfix .button .headerProfilePhoto", browser);
        browser.findElements(By.cssSelector(".box.dropdown.is-open.animated.fadeIn ul li")).get(2).click();
    }

    public boolean shouldBeLogout() {
        sleep(2000);
        boolean logout = browser.findElement(By.cssSelector(".item.clearfix .logo")).isEnabled();
        if (logout == true) {
            return true;
        }
        return false;
    }
}
