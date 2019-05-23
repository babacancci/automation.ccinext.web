package steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.BaseSteps;
import utils.ConfigReader;
import utils.WebDriverUtils;

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
    public void after() {
        base.driver.quit();
    }
}
