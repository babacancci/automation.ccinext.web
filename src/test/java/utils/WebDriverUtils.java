package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class WebDriverUtils {
    public static WebDriver launchChrome(DesiredCapabilities desiredCapabilities) {
        File file = new File("src/test/java/driver/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        return new ChromeDriver(new ChromeOptions().merge(desiredCapabilities));
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception var3) {

        }

    }

}
