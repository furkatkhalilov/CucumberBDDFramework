package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SecondSteps {
    @When("^I print more to console$")
    public void printMoreToConsole(){
        System.out.println("Print more to console using cucumber!~");
    }
    @Then("^I print even more to console$")
    public void printEvenMoreToConsole() {
        System.out.println("Print EVENT more to console by using cucumber steps!!!~");
    }
}
