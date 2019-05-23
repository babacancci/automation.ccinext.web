package utils;

import org.openqa.selenium.WebDriver;

public class BaseSteps {
    public ConfigReader config;
    public WebDriver driver;

    public BaseSteps() {
        config = ConfigReader.getInstance();
    }
}
