package steps;

import cucumber.api.java.en.Given;

public class FirstSteps {
    @Given("^I printout to console$")
    public void i_printout_to_console() {
        System.out.println("Hello cucumber!");
    }
}
