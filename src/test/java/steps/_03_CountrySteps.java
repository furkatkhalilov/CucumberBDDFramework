package steps;

import cucumber.api.java.en.*;
import org.testng.Assert;
import poms.CountryPOM;

public class _03_CountrySteps {

    CountryPOM countryPage = new CountryPOM();

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
}
