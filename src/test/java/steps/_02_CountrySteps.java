package steps;

import cucumber.api.java.en.*;
import poms.TablePOM;

public class _02_CountrySteps {

    TablePOM countryPage = new TablePOM();

    @When("^I create a country$")
    public void i_create_a_country()  {
        countryPage.waitAndClick(countryPage.createButtonElement);
        countryPage.waitAndSendKeys(countryPage.nameInputElement, "country name");
        countryPage.waitAndClick(countryPage.saveButtonElement);
    }
    @When("^I edit a country$")
    public void i_edit_a_country(){
        countryPage.waitAndClick(countryPage.editButtonElement);
        countryPage.waitAndSendKeys(countryPage.nameInputElement, "country name");
        countryPage.waitAndClick(countryPage.saveButtonElement);
    }
    @When("^I delete a country$")
    public void i_delete_a_country()  {
        countryPage.waitAndClick(countryPage.deleteButtonLocator);
        countryPage.waitAndClick(countryPage.dialogSubmitButtonElement);
    }


    @When("^I create \"([^\"]*)\" country$")
    public void i_create_country(String countryName) {
        countryPage.waitAndClick(countryPage.createButtonElement);
        countryPage.waitAndSendKeys(countryPage.nameInputElement, countryName);
        countryPage.waitAndClick(countryPage.saveButtonElement);
    }

    @When("^I edit \"([^\"]*)\" country$")
    public void i_edit_country(String countryName) {
        countryPage.waitAndClick(countryPage.editButtonElement);
        countryPage.waitAndSendKeys(countryPage.nameInputElement, countryName);
        countryPage.waitAndClick(countryPage.saveButtonElement);
    }

    @When("^I edit  \"([^\"]*)\" to \"([^\"]*)\" country$")
    public void iEditToCountry(String oldCountry, String newCountry) {
        countryPage.searchFor(oldCountry);

        countryPage.waitAndClick(countryPage.editButtonElement);
        countryPage.waitAndSendKeys(countryPage.nameInputElement, newCountry);
        countryPage.waitAndClick(countryPage.saveButtonElement);
    }

    @When("^I delete \"([^\"]*)\" country$")
    public void iDeleteCountry(String countryName) throws Throwable {
        countryPage.searchFor(countryName);
        countryPage.waitAndClick(countryPage.deleteButtonLocator);
        countryPage.waitAndClick(countryPage.dialogSubmitButtonElement);
    }
}
