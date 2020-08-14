package runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.ThreadLocalBaseDriver;

@CucumberOptions(
        plugin = {"html:target/cucumber-report"},
        features = {
                "src/test/java/featureFiles/_day32_01_examination.feature"
        },
        tags = "@EditAndDelete",
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
        ThreadLocalBaseDriver.quitDriver();
    }
    @AfterClass
    public void configReport(){
        Reporter.loadXMLConfig("src/test/java/runner/reportConfig/report.xml");
    }
}
