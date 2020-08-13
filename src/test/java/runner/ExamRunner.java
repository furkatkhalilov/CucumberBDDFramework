package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.BaseDriver;

@CucumberOptions(
        plugin = {"html:target/cucumber-report"},
        features = {
                "src/test/java/featureFiles/_day32_01_examination.feature"
        },
        glue = {"steps"} // tell cucumber where to look for step definitions
)
public class ExamRunner extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Starting suite!");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Ending suite!");
        BaseDriver.quitDriver();
    }
}
