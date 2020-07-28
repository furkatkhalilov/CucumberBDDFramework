package steps;

import cucumber.api.java.en.*;
import org.testng.Assert;
import poms.CountryPOM;

public class _03_CountrySteps {

    CountryPOM countryPage = new CountryPOM();

    @When("^I create \"([^\"]*)\" country$")
    public void i_create_country(String countryName) {
        countryPage.waitAndClick(countryPage.createButtonLocator);
        countryPage.waitAndSendKeys(countryPage.nameInputLocator, countryName);
        countryPage.waitAndClick(countryPage.saveButtonLocator);
    }

    @When("^I edit \"([^\"]*)\" country$")
    public void i_edit_country(String countryName) {
        countryPage.waitAndClick(countryPage.editButtonLocator);
        countryPage.waitAndSendKeys(countryPage.nameInputLocator, countryName);
        countryPage.waitAndClick(countryPage.saveButtonLocator);
    }


    @When("^I edit a country$")
    public void i_edit_a_country(){
        countryPage.waitAndClick(countryPage.editButtonLocator);
        countryPage.waitAndSendKeys(countryPage.nameInputLocator, "country name");
        countryPage.waitAndClick(countryPage.saveButtonLocator);
    }

    @Then("^country is successfully edited$")
    public void country_is_successfully_edited() {
        String actual = countryPage.waitAndGetText(countryPage.alertDialogLocator);
        Assert.assertEquals(actual, "Country successfully updated");
    }

    @When("^I delete a country$")
    public void i_delete_a_country()  {
        countryPage.waitAndClick(countryPage.deleteButtonLocator);
        countryPage.waitAndClick(countryPage.dialogSubmitButtonLocator);
    }

    @Then("^country is successfully deleted$")
    public void country_is_successfully_deleted() {
        String actual = countryPage.waitAndGetText(countryPage.alertDialogLocator);
        Assert.assertEquals(actual, "Country successfully deleted");
        // TODO: the list doesn't contain the country that we deleted
    }
}