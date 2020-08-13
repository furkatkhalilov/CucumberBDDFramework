package exampleRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {
                "src/test/java/datatable_examples.feature",
                "src/test/java/first.feature"
        },
        glue = "steps",
        tags = {"@RegressionTest"}
)
public class RegressionExamplesRunner extends AbstractTestNGCucumberTests {
}
