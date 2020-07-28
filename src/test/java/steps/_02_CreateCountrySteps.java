package steps;

import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import poms.CountryPOM;
import poms.MenuPOM;
import utils.BaseDriver;

public class _02_CreateCountrySteps {

    CountryPOM countryPage;

    @Given("^I navigate to country screen$")
    public void i_navigate_to_country_screen()  {
        countryPage =new CountryPOM();
        MenuPOM menu = new MenuPOM();
        menu.waitAndClick(menu.setupMenuLocator);
        menu.waitAndClick(menu.parametersMenuLocator);
        menu.waitAndClick(menu.countriesMenuLocator);

    }

    @When("^I create a country$")
    public void i_create_a_country()  {
        countryPage.waitAndClick(countryPage.createButtonLocator);
        countryPage.waitAndSendKeys(countryPage.nameInputLocator, "country name");
        countryPage.waitAndClick(countryPage.saveButtonLocator);
    }

    @Then("^country is successfully created$")
    public void country_is_successfully_created()  {
        String actual = countryPage.waitAndGetText(countryPage.alertDialogLocator);
        Assert.assertEquals(actual, "Country successfully created");
    }

}
