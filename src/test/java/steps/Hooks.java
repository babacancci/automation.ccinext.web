package steps;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.BaseSteps;
import utils.ConfigReader;
import utils.WebDriverUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Hooks extends BaseSteps {

    private BaseSteps base;

    public Hooks(BaseSteps base) {
        this.base = base;
    }

    @Before
    public void setUp() {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setJavascriptEnabled(true);
        desiredCapabilities.setCapability("takesScreenshot", true);

        if ("chrome".equals(ConfigReader.getPlatform())) {
            base.driver = WebDriverUtils.launchChrome(desiredCapabilities);
            base.driver.manage().window().maximize();
        }
    }

    @After
    public void after(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            File scrFile = ((TakesScreenshot) base.driver).getScreenshotAs(OutputType.FILE);
            String fileName = new Date().getTime() + ".png";
            FileUtils.copyFile(scrFile, new File("./target/screenshots/test-sc-" + fileName));
        }


        base.driver.quit();
    }
}
