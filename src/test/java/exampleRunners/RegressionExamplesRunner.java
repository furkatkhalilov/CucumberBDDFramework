package exampleRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeMethod;

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
