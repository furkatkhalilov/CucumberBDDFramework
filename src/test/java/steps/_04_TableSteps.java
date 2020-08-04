package steps;

import cucumber.api.java.en.Given;
import poms.CountryPOM;
import poms.MenuPOM;

public class _04_TableSteps {

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
}
