package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class FirstSteps {
    @Given("^I printout to console$")
    public void i_printout_to_console() {
        System.out.println("Hello cucumber!");
    }

    @Before // Before each scenario
    public void before(Scenario scenario){
        System.out.println("Before scenario: " + scenario.getName());
    }
    @After // After each scenario
    public void after(Scenario scenario){
        System.out.println("After scenario: " + scenario.getName());
    }
}
