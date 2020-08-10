package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import poms.TablePOM;

public class _07_NationalitySteps {
    private TablePOM page = new TablePOM();

    @When("^I create nationality with name \"([^\"]*)\"$")
    public void iCreateNationalityWithName(String name) {
        page.waitAndClick(page.createButtonElement);
        page.waitAndSendKeys(page.nameInputElement, name);
        page.waitAndClick(page.saveButtonElement);
    }

    @When("^I edit  \"([^\"]*)\" to \"([^\"]*)\" nationality$")
    public void iEditToNationality(String oldName, String newName) {
        page.searchFor(oldName);

        page.waitAndClick(page.editButtonElement);
        page.waitAndSendKeys(page.nameInputElement, newName);
        page.waitAndClick(page.saveButtonElement);
    }

    @When("^I delete \"([^\"]*)\" nationality$")
    public void iDeleteNationality(String name) {
        page.searchFor(name);

        page.waitAndClick(page.deleteButtonLocator);
        page.waitAndClick(page.dialogSubmitButtonElement);
    }
}
