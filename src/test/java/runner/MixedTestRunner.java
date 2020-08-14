package runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import utils.ThreadLocalBaseDriver;

@CucumberOptions(
        plugin = {
                "html:target/cucumber-report",
                "com.cucumber.listener.ExtentCucumberFormatter:target/extent_report/index.html" // extent report plugin
        },
        features = {
                "src/test/java/featureFiles/_day24_01_login.feature",
                "src/test/java/featureFiles/_day27_01_fee.feature",
                "src/test/java/featureFiles/_day26_01_country_with_extra.feature",
                "src/test/java/featureFiles/_day27_01_fee.feature",
        },
        glue = {"steps"} // tell cucumber where to look for step definitions
)
public class MixedTestRunner extends AbstractTestNGCucumberTests {
    @AfterSuite
    public void afterSuite() {
        ThreadLocalBaseDriver.quitDriver();
    }
    @AfterClass
    public void configReport(){
        Reporter.loadXMLConfig("src/test/java/runner/reportConfig/report.xml");
    }
}
