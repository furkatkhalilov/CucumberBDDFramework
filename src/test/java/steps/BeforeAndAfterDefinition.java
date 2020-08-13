package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.BaseDriver;

public class BeforeAndAfterDefinition {
    @Before // Before each scenario
    public void before(Scenario scenario){
        System.out.println("Before scenario: " + scenario.getName());
    }
    @After // After each scenario
    public void after(Scenario scenario){
        System.out.println("After scenario: " + scenario.getName());
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) BaseDriver.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
        }
    }
}
