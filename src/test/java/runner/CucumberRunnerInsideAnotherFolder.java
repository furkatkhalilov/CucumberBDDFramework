package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {
                "src/test/java/featureFiles/_day24_01_login.feature"
        },
        glue = {"steps"} // tell cucumber where to look for step definitions
)
public class CucumberRunnerInsideAnotherFolder extends AbstractTestNGCucumberTests {
}
