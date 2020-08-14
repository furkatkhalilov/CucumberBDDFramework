package runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.BaseDriver;

@CucumberOptions(
        plugin = {"html:target/cucumber-report"},
        features = {
                "src/test/java/featureFiles/_day31_01_documents_type.feature"
        },
        tags = {"@AllDocumentTypeScenarios"},
        glue = {"steps"} // tell cucumber where to look for step definitions
)
public class DocumentTypeRunner extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Starting suite!");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Ending suite!");
        BaseDriver.quitDriver();
    }
    @AfterClass
    public void configReport(){
        Reporter.loadXMLConfig("src/test/java/runner/reportConfig/report.xml");
    }
}
