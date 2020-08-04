package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import poms.CitizenshipPOM;
import poms.MenuPOM;

public class _03_CitizenshipSteps {
    private CitizenshipPOM citizenshipPage = new CitizenshipPOM();

    @When("^I create \"([^\"]*)\" citizenship$")
    public void i_create_citizenship(String citizenshipName) {
        citizenshipPage.waitAndClick(citizenshipPage.createButtonLocator);
        citizenshipPage.waitAndSendKeys(citizenshipPage.nameInputLocator, citizenshipName);
        citizenshipPage.waitAndClick(citizenshipPage.saveButtonLocator);
    }

    @When("^I edit  \"([^\"]*)\" to \"([^\"]*)\" citizenship$")
    public void iEditToCitizenship(String oldCitizenship, String newCitizenship) {
        citizenshipPage.searchFor(oldCitizenship);

        citizenshipPage.waitAndClick(citizenshipPage.editButtonLocator);
        citizenshipPage.waitAndSendKeys(citizenshipPage.nameInputLocator, newCitizenship);
        citizenshipPage.waitAndClick(citizenshipPage.saveButtonLocator);
    }

    @When("^I delete \"([^\"]*)\" citizenship$")
    public void iDeleteCitizenship(String citizenshipName) {
        citizenshipPage.searchFor(citizenshipName);

        citizenshipPage.waitAndClick(citizenshipPage.deleteButtonLocator);
        citizenshipPage.waitAndClick(citizenshipPage.dialogSubmitButtonLocator);
    }

}