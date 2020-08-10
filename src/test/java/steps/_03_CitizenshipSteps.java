package steps;

import cucumber.api.java.en.When;
import poms.TablePOM;

public class _03_CitizenshipSteps {
    private TablePOM citizenshipPage = new TablePOM();

    @When("^I create \"([^\"]*)\" citizenship$")
    public void i_create_citizenship(String citizenshipName) {
        citizenshipPage.waitAndClick(citizenshipPage.createButtonElement);
        citizenshipPage.waitAndSendKeys(citizenshipPage.nameInputElement, citizenshipName);
        citizenshipPage.waitAndClick(citizenshipPage.saveButtonElement);
    }

    @When("^I edit  \"([^\"]*)\" to \"([^\"]*)\" citizenship$")
    public void iEditToCitizenship(String oldCitizenship, String newCitizenship) {
        citizenshipPage.searchFor(oldCitizenship);

        citizenshipPage.waitAndClick(citizenshipPage.editButtonElement);
        citizenshipPage.waitAndSendKeys(citizenshipPage.nameInputElement, newCitizenship);
        citizenshipPage.waitAndClick(citizenshipPage.saveButtonElement);
    }

    @When("^I delete \"([^\"]*)\" citizenship$")
    public void iDeleteCitizenship(String citizenshipName) {
        citizenshipPage.searchFor(citizenshipName);

        citizenshipPage.waitAndClick(citizenshipPage.deleteButtonLocator);
        citizenshipPage.waitAndClick(citizenshipPage.dialogSubmitButtonElement);
    }

}
