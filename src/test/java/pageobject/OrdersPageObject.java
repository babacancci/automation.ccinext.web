package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Helper;


public class OrdersPageObject {
    public WebDriver browser;

    public OrdersPageObject(WebDriver browser) {
        this.browser = browser;
    }

    public void orderButton() {
        Helper.clickObjectByLinkText("Sipariş Ver", browser);
        Helper.switchToWindow(browser);
    }

    public boolean shouldSeeOrder() {
        Helper.WaitForElementPresent(By.linkText("Siparişlerim"), browser);
        browser.findElement(By.linkText("Siparişlerim")).isEnabled();
        return true;
    }
}
