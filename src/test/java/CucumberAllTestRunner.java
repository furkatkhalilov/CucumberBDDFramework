import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {
                "src/test/java/featureFiles"
        },
        dryRun = true // check which tests will run, without actually running them
)
public class CucumberAllTestRunner extends AbstractTestNGCucumberTests {
}
