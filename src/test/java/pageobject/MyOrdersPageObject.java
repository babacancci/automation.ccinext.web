package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Helper;

import static utils.WebDriverUtils.sleep;

public class MyOrdersPageObject {
    public WebDriver browser;

    public MyOrdersPageObject(WebDriver browser) {
        this.browser = browser;
    }

    public void myOrdersButton() {
        sleep(2000);
        browser.findElements(By.cssSelector(".megamenu.fadein.blackout li")).get(2).click();
    }

    public boolean shouldSeeMyOrders() {
        sleep(2000);
        browser.findElement(By.cssSelector(".m-t-0.m-b-15")).isEnabled();
        return true;
    }

    public void selectingTheDate() {
        sleep(3000);
        browser.findElements(By.cssSelector(".input-group.date")).get(0).click();
        browser.findElements(By.cssSelector(".datepicker-days  .table-condensed .day")).get(3).click();
    }

    public boolean shouldSeeSelectingMyOrders() {
        sleep(2000);
        boolean status = browser.findElement(By.cssSelector(".order_no.sorting_1")).isEnabled();
        if (status == true) {
            System.out.println(status);
            return true;
        }
        return false;
    }
}
