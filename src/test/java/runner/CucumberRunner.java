package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"steps"},
        plugin = {"pretty",
                "json:target/cucumber.json"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
