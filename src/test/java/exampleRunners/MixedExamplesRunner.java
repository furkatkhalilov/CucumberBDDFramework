package exampleRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {
                "src/test/java/datatable_examples.feature"                ,
                "src/test/java/first.feature",
                "src/test/java/second.feature"
        },
        glue = "steps",
//        tags = {"@SmokeTest, @FunctionalTest"} // SmokeTest or FunctionalTest
        tags = {"@SmokeTest", "@RegressionTest"} // SmokeTest and RegressionTest
)
public class MixedExamplesRunner extends AbstractTestNGCucumberTests {
}
