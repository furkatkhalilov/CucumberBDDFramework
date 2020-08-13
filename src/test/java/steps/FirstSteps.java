package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class FirstSteps {
    @Given("^I printout to console$")
    public void i_printout_to_console() {
        System.out.println("Hello cucumber!");
    }

    @Before // Before each scenario
    public void before(){
        System.out.println("Before scenario!");
    }
    @After // After each scenario
    public void after(){
        System.out.println("After scenario!");
    }
}
