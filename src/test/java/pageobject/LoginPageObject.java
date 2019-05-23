package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.Helper;


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

    public boolean loggedIn() {
        Helper.WaitForElementPresent(By.className("container-fluid"), browser);
        browser.findElement(By.className("container-fluid")).isDisplayed();
        return true;
    }

    public boolean errorMessage() {
        browser.findElement(By.cssSelector(".pop-up.animated.bounceInDown .item")).getText();
        return true;
    }

    public void forgetButton(){
        Helper.clickObjectByCss(".column .forgotPasswordText",browser);
    }

    public void forgetPopup(String userId,String phoneNumber){
        Helper.setObjectById("txtForgotPasswordOutletNumber",userId,browser);
        Helper.setObjectById("txtForgotPasswordPhoneNumber",phoneNumber,browser);
        Helper.clickObjectById("btnSendCode",browser);
    }

    public void userInfoClick(){
        Helper.clickObjectByCss(".inputWrap.numberItem .informationBtn",browser);
    }

    public boolean userInfoPopup(){
        browser.findElement(By.cssSelector(".inputWrap.numberItem .informationBtn")).isDisplayed();
        return true;
    }
}
