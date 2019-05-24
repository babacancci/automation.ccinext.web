package pageobject;

import gherkin.lexer.He;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Helper;

public class MoneyBoxPageObject {
    public WebDriver browser;

    public MoneyBoxPageObject(WebDriver browser) {
        this.browser = browser;
    }

    public void moneyBoxButton() {
        browser.findElements(By.cssSelector(".clearfix .navMenu a")).get(1).click();
    }

    public void redMoneyBoxButton(){
        Helper.clickObjectByCss(".col-md-12 .whatMoneyBox",browser);
    }

    public boolean redMoneyBoxAbout() {
        Helper.WaitForElementPresent(By.id("ui-id-1"), browser);
        WebElement about = browser.findElement(By.id("ui-id-1"));
        if (about.getText() != null) {
            return true;
        }
        return false;
    }

    public void pointHistoryButton(){
        Helper.clickObjectByCss(".link.clearfix .pointHistoryPage",browser);
    }

    public boolean availablePoints() {
        WebElement points = browser.findElements(By.className("col-md-12")).get(1);
        if (points.getText() != null) {
            return true;
        }
        return false;
    }


}
