package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.BaseDriver;

public class FirstSteps {
    @Given("^I printout to console$")
    public void i_printout_to_console() {
        System.out.println("Hello cucumber!");
    }


}
