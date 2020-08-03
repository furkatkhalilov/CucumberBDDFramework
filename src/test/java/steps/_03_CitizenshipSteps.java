package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import poms.CitizenshipPOM;
import poms.MenuPOM;

public class _03_CitizenshipSteps {
    private CitizenshipPOM citizenshipPage;

    @Given("^I navigate to citizenship screen$")
    public void i_navigate_to_citizenship_screen()  {
        citizenshipPage =new CitizenshipPOM();
        MenuPOM menu = new MenuPOM();
        menu.waitAndClick(menu.setupMenuLocator);
        menu.waitAndClick(menu.parametersMenuLocator);
        menu.waitAndClick(menu.citizenshipMenuLocator);

    }

    @And("^\"([^\"]*)\" citizenship doesn't exist$")
    public void citizenshipDoesnTExist(String citizenshipName) {
        citizenshipPage.waitAndSendKeys(citizenshipPage.nameSearchLocator, citizenshipName);
        citizenshipPage.waitAndClick(citizenshipPage.searchButtonLocator);
        citizenshipPage.waitForProgressBar();

        citizenshipPage.deleteAllElementsFromTable();
    }

    @Then("^citizenship is successfully created$")
    public void citizenship_is_successfully_created()  {
        String actual = citizenshipPage.waitForNewAndGetText(citizenshipPage.alertDialogLocator);
        Assert.assertEquals(actual, "Citizenship successfully created");
    }

    @When("^I create \"([^\"]*)\" citizenship$")
    public void i_create_citizenship(String citizenshipName) {
        citizenshipPage.waitAndClick(citizenshipPage.createButtonLocator);
        citizenshipPage.waitAndSendKeys(citizenshipPage.nameInputLocator, citizenshipName);
        citizenshipPage.waitAndClick(citizenshipPage.saveButtonLocator);
    }

    @When("^I edit  \"([^\"]*)\" to \"([^\"]*)\" citizenship$")
    public void iEditToCitizenship(String oldCitizenship, String newCitizenship) {
        citizenshipPage.waitAndSendKeys(citizenshipPage.nameSearchLocator, oldCitizenship);
        citizenshipPage.waitAndClick(citizenshipPage.searchButtonLocator);

        citizenshipPage.waitForProgressBar();

        citizenshipPage.waitAndClick(citizenshipPage.editButtonLocator);
        citizenshipPage.waitAndSendKeys(citizenshipPage.nameInputLocator, newCitizenship);
        citizenshipPage.waitAndClick(citizenshipPage.saveButtonLocator);
    }

    @Then("^citizenship is successfully edited$")
    public void citizenship_is_successfully_edited() {
        String actual = citizenshipPage.waitForNewAndGetText(citizenshipPage.alertDialogLocator);
        Assert.assertEquals(actual, "Citizenship successfully updated");
    }

    @When("^I delete \"([^\"]*)\" citizenship$")
    public void iDeleteCitizenship(String citizenshipName) throws Throwable {
        citizenshipPage.waitAndSendKeys(citizenshipPage.nameSearchLocator, citizenshipName);
        citizenshipPage.waitAndClick(citizenshipPage.searchButtonLocator);

        citizenshipPage.waitForProgressBar();

        citizenshipPage.waitAndClick(citizenshipPage.deleteButtonLocator);
        citizenshipPage.waitAndClick(citizenshipPage.dialogSubmitButtonLocator);
    }


    @Then("^citizenship is successfully deleted$")
    public void citizenship_is_successfully_deleted() {
        String actual = citizenshipPage.waitForNewAndGetText(citizenshipPage.alertDialogLocator);
        Assert.assertEquals(actual, "Citizenship successfully deleted");
        // TODO: the list doesn't contain the citizenship that we deleted
    }
}
