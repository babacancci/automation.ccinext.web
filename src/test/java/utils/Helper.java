package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Helper {
    public static int waitForPresentElement = 5;
    private static boolean acceptNextAlert = true;
    private static long waitTime = 2000L;

    public Helper() {
    }

    public static void WaitForElementPresent(By by, WebDriver driver) {
        for (int second = 0; second < waitForPresentElement; ++second) {
            try {
                if (IsElementPresent(by, driver)) {
                    return;
                }
            } catch (Exception var4) {
            }
        }

        throw new TimeoutException("timeout");
    }

    public static void mouseMove(WebElement webElement, WebDriver driver) {
        Locatable hoverItem = (Locatable) webElement;
        Mouse mouse = ((HasInputDevices) driver).getMouse();
        mouse.mouseMove(hoverItem.getCoordinates());
    }

    private static boolean IsElementPresent(By by, WebDriver driver) {
        try {
            WebElement var10000 = (WebElement) (new WebDriverWait(driver, (long) waitForPresentElement)).until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean IsElementPresentByName(String by, WebDriver driver) {
        try {
            WebElement var10000 = (WebElement) (new WebDriverWait(driver, (long) waitForPresentElement)).until(ExpectedConditions.visibilityOfElementLocated(By.name(by)));
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean IsElementPresentByXpath(String by, WebDriver driver) {
        try {
            WebElement var10000 = (WebElement) (new WebDriverWait(driver, (long) waitForPresentElement)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(by)));
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean IsElementPresentByClassName(String by, WebDriver driver) {
        try {
            WebElement var10000 = (WebElement) (new WebDriverWait(driver, (long) waitForPresentElement)).until(ExpectedConditions.visibilityOfElementLocated(By.className(by)));
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean IsElementPresentByCss(String by, WebDriver driver) {
        try {
            WebElement var10000 = (WebElement) (new WebDriverWait(driver, (long) waitForPresentElement)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(by)));
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean IsElementPresentById(String by, WebDriver driver) {
        try {
            WebElement var10000 = (WebElement) (new WebDriverWait(driver, (long) waitForPresentElement)).until(ExpectedConditions.visibilityOfElementLocated(By.id(by)));
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean IsAlertPresent(WebDriver driver) {
        try {
            Thread.sleep(waitTime);
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException var2) {
            return false;
        } catch (InterruptedException var3) {
            return false;
        }
    }

    public static String CloseAlertAndGetItsText(WebDriver driver) {
        String var3;
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }

            var3 = alertText;
        } finally {
            acceptNextAlert = true;
        }

        return var3;
    }

    public static WebElement SearchAndFindElement(By id, WebDriver driver) throws Exception {
        WebElement element = driver.findElement(id);
        return element;
    }

    public static List<WebElement> SearchAndFindElements(By id, WebDriver driver) {
        return driver.findElements(id);
    }

    public static String ToLocalDate(String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = dateFormat.parse(date).toString();
        return formattedDate;
    }

    public static void writeText(WebElement element, String value, long time, boolean clearText) {
        try {
            element.click();
            Thread.sleep(time);
            if (clearText) {
                element.clear();
                Thread.sleep(time);
            }

            element.sendKeys(new CharSequence[]{value});
        } catch (Exception var6) {
        }

    }

    public static void writeText(By id, String value, long time, boolean clearText, WebDriver driver) {
        try {
            WaitForElementPresent(id, driver);
            SearchAndFindElement(id, driver).click();
            Thread.sleep(time);
            if (clearText) {
                SearchAndFindElement(id, driver).clear();
                Thread.sleep(time);
            }

            SearchAndFindElement(id, driver).sendKeys(new CharSequence[]{value});
        } catch (Exception var7) {
        }

    }

    public static String getTextByClassWithTag(String clas, String tag, int index, WebDriver driver) throws Exception {
        WaitForElementPresent(By.className(clas), driver);
        return ((WebElement) SearchAndFindElement(By.className(clas), driver).findElements(By.tagName(tag)).get(index)).getText();
    }

    public static void clickObjectByClassdWithTag(String clas, String tag, int index, WebDriver driver) {
        try {
            WaitForElementPresent(By.className(clas), driver);
            Thread.sleep(waitTime);
            ((WebElement) SearchAndFindElement(By.className(clas), driver).findElements(By.tagName(tag)).get(index)).click();
            Thread.sleep(waitTime);
        } catch (Exception var5) {
        }

    }

    public static void setObjectByClassWithTag(String clas, String value, String tag, int index, WebDriver driver) throws Exception {
        WaitForElementPresent(By.className(clas), driver);
        writeText((WebElement) SearchAndFindElement(By.className(clas), driver).findElements(By.tagName(tag)).get(index), value, waitTime, true);
    }

    public static String getTextByIdWithTag(String id, String tag, int index, WebDriver driver) throws Exception {
        WaitForElementPresent(By.id(id), driver);
        return ((WebElement) SearchAndFindElement(By.id(id), driver).findElements(By.tagName(tag)).get(index)).getText();
    }

    public static void clickObjectByIdWithTag(String id, String tag, int index, WebDriver driver) {
        try {
            WaitForElementPresent(By.id(id), driver);
            Thread.sleep(waitTime);
            ((WebElement) SearchAndFindElement(By.id(id), driver).findElements(By.tagName(tag)).get(index)).click();
            Thread.sleep(waitTime);
        } catch (Exception var5) {
        }

    }

    public static void setObjectByIdWithTag(String id, String value, String tag, int index, WebDriver driver) throws Exception {
        WaitForElementPresent(By.id(id), driver);
        writeText((WebElement) SearchAndFindElement(By.id(id), driver).findElements(By.tagName(tag)).get(index), value, waitTime, true);
    }

    public static String getTextByName(String name, WebDriver driver, int i) throws Exception {
        WaitForElementPresent(By.name(name), driver);
        return ((WebElement) SearchAndFindElements(By.name(name), driver).get(i)).getText();
    }

    public static String getTextById(String id, WebDriver driver) throws Exception {
        WaitForElementPresent(By.id(id), driver);
        return SearchAndFindElement(By.id(id), driver).getText();
    }

    public static String getValueById(String id, WebDriver driver, boolean checkPresence) throws Exception {
        if (checkPresence) {
            WaitForElementPresent(By.id(id), driver);
        }

        return SearchAndFindElement(By.id(id), driver).getAttribute("value");
    }

    public static String getTextByXpath(String xpath, boolean checkPresent, WebDriver driver) throws Exception {
        if (checkPresent) {
            WaitForElementPresent(By.xpath(xpath), driver);
        }

        return SearchAndFindElement(By.xpath(xpath), driver).getText();
    }

    public static String getTextByClass(String classs, WebDriver driver) throws Exception {
        WaitForElementPresent(By.className(classs), driver);
        return SearchAndFindElement(By.className(classs), driver).getText();
    }

    public static void setObjectByName(String name, String value, WebDriver driver) {
        writeText(By.name(name), value, waitTime, false, driver);
    }

    public static void setObjectById(String id, String value, WebDriver driver) {
        writeText(By.id(id), value, waitTime, false, driver);
    }

    public static void setObjectByXPath(String xpath, String value, WebDriver driver) {
        writeText(By.xpath(xpath), value, waitTime, false, driver);
    }

    public static void setObjectByCssSelector(String cssSelector, String value, WebDriver driver) {
        writeText(By.cssSelector(cssSelector), value, waitTime, false, driver);
    }

    public static void setObjectByClassName(String className, String value, WebDriver driver) {
        writeText(By.className(className), value, waitTime, false, driver);
    }

    public static void clickObjectByXpath(String xpath, WebDriver driver) {
        try {
            WaitForElementPresent(By.xpath(xpath), driver);
            SearchAndFindElement(By.xpath(xpath), driver).click();
            Thread.sleep(waitTime);
        } catch (Exception var3) {
        }

    }

    public static void clickObjectById(String id, WebDriver driver) {
        try {
            WaitForElementPresent(By.id(id), driver);
            SearchAndFindElement(By.id(id), driver).click();
            Thread.sleep(waitTime);
        } catch (Exception var3) {
        }

    }

    public static void clickObjectByName(String name, WebDriver driver) {
        try {
            WaitForElementPresent(By.name(name), driver);
            SearchAndFindElement(By.name(name), driver).click();
        } catch (Exception var3) {
        }

    }

    public static void clickObjectByCss(String css, WebDriver driver) {
        try {
            WaitForElementPresent(By.cssSelector(css), driver);
            SearchAndFindElement(By.cssSelector(css), driver).click();
            Thread.sleep(waitTime);
        } catch (Exception var3) {
        }

    }

    public static void clickObjectByClassName(String className, WebDriver driver) {
        try {
            WaitForElementPresent(By.className(className), driver);
            SearchAndFindElement(By.className(className), driver).click();
            Thread.sleep(waitTime);
        } catch (Exception var3) {
        }

    }

    public static WebElement selectValueObjectBy(By by, String value, WebDriver driver) {
        try {
            WebElement element = SearchAndFindElement(by, driver);
            (new Select(element)).selectByValue(value);
            return element;
        } catch (Exception var4) {
            return null;
        }
    }

    public static WebElement selectValueObjectById(String id, String value, WebDriver driver) {
        WebElement element = selectValueObjectBy(By.id(id), value, driver);
        return element;
    }

    public static WebElement selectValueObjectByName(String name, String value, WebDriver driver) {
        WebElement element = selectValueObjectBy(By.name(name), value, driver);
        return element;
    }

    public static WebElement selectValueObjectByXpath(String xpath, String value, WebDriver driver) {
        WebElement element = selectValueObjectBy(By.xpath(xpath), value, driver);
        return element;
    }

    public static WebElement selectValueObjectByCssSelector(String cssSelector, String value, WebDriver driver) {
        WebElement element = selectValueObjectBy(By.cssSelector(cssSelector), value, driver);
        return element;
    }

    public static WebElement selectIndexObjectBy(By by, int index, WebDriver driver) {
        try {
            WebElement element = SearchAndFindElement(by, driver);
            (new Select(element)).selectByIndex(index);
            return element;
        } catch (Exception var4) {
            return null;
        }
    }

    public static WebElement selectIndexObjectById(String id, int index, WebDriver driver) {
        return selectIndexObjectBy(By.id(id), index, driver);
    }

    public static WebElement selectIndexObjectByName(String name, int index, WebDriver driver) {
        return selectIndexObjectBy(By.name(name), index, driver);
    }

    public static WebElement selectIndexObjectByCss(String css, int index, WebDriver driver) {
        return selectIndexObjectBy(By.cssSelector(css), index, driver);
    }

    public static WebElement selectIndexObjectByXpath(String xpath, int index, WebDriver driver) {
        return selectIndexObjectBy(By.xpath(xpath), index, driver);
    }

    public static List<WebElement> getSelectOptionListById(String id, WebDriver driver) throws Exception {
        Select select = new Select(SearchAndFindElement(By.id(id), driver));
        return select.getOptions();
    }

    public static List<WebElement> getSelectOptionListByName(String name, WebDriver driver) throws Exception {
        Select select = new Select(SearchAndFindElement(By.name(name), driver));
        return select.getOptions();
    }

    public static List<WebElement> getSelectOptionListByClassName(String className, WebDriver driver) throws Exception {
        Select select = new Select(SearchAndFindElement(By.className(className), driver));
        return select.getOptions();
    }

    public static List<WebElement> getSelectOptionListByCss(String css, WebDriver driver) throws Exception {
        Select select = new Select(SearchAndFindElement(By.cssSelector(css), driver));
        return select.getOptions();
    }

    public static List<WebElement> getSelectOptionListByXpath(String xpath, WebDriver driver) throws Exception {
        Select select = new Select(SearchAndFindElement(By.xpath(xpath), driver));
        return select.getOptions();
    }

    public static List<WebElement> getElementListByXpath(String xpath, WebDriver driver) {
        return SearchAndFindElements(By.xpath(xpath), driver);
    }
}
