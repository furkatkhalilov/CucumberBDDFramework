import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {
                "src/test/java/featureFiles/_day24_01_login.feature",
                "src/test/java/featureFiles/_day27_01_fee.feature"
        }
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
