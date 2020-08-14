package runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;
import utils.ThreadLocalBaseDriver;

@CucumberOptions(
        plugin = {
                "html:target/cucumber-report",
                "com.cucumber.listener.ExtentCucumberFormatter:target/extent_report/index.html" // extent report plugin
        },
        features = {
                "src/test/java/featureFiles/_day27_01_fee.feature"
        },
        glue = {"steps"} // tell cucumber where to look for step definitions
)
public class FeeTestRunner extends AbstractTestNGCucumberTests {
    @Parameters("browser")
    @BeforeClass
    public void configureBrowser(@Optional("chrome") String browser) {
        ThreadLocalBaseDriver.setBrowser(browser);
    }
    @AfterClass
    public void quiteDriver() {
        ThreadLocalBaseDriver.quitDriver();
    }

    @AfterClass
    public void configReport(){
        Reporter.loadXMLConfig("src/test/java/runner/reportConfig/report.xml");
    }
}
