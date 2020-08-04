package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import poms.MenuPOM;
import poms.TablePOM;

public class _04_TableSteps {
    TablePOM page = new TablePOM();

    @Given("^I navigate to \"([^\"]*)\" screen$")
    public void i_navigate_to_country_screen(String screenName)  {
        MenuPOM menu = new MenuPOM();
        menu.waitAndClick(menu.setupMenuLocator);
        menu.waitAndClick(menu.parametersMenuLocator);
        switch (screenName){
            case "country":
                menu.waitAndClick(menu.countriesMenuLocator);
                break;
            case "citizenship":
                menu.waitAndClick(menu.citizenshipMenuLocator);
                break;
        }
    }

    @And("^\"([^\"]*)\" entity doesn't exist in table$")
    public void countryDoesnTExist(String entityName) {
        page.searchFor(entityName);
        page.deleteAllElementsFromTable();
    }

}
