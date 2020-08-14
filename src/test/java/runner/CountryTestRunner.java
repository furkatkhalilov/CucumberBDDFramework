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
                "src/test/java/featureFiles/_day26_01_country_with_extra.feature"
        },
        glue = {"steps"} // tell cucumber where to look for step definitions
)
public class CountryTestRunner extends AbstractTestNGCucumberTests {
    @AfterSuite
    public void afterSuite() {
        ThreadLocalBaseDriver.quitDriver();
    }
    @AfterClass
    public void configReport(){
        Reporter.loadXMLConfig("src/test/java/runner/reportConfig/report.xml");
        Reporter.setSystemInfo("Author", "Mersys");
        Reporter.setSystemInfo("Application name", "Basqar");
        Reporter.setSystemInfo("Operating System", System.getProperty("os.name"));
        Reporter.setSystemInfo("Environment", "test");

    }
}
