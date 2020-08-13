package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import poms.MenuPOM;

import java.util.List;

public class MenuSteps {
    MenuPOM page = new MenuPOM();
    @Given("^I navigate to$")
    public void iNavigateTo(DataTable table) {
        List<String> menus = table.asList(String.class);
        for (String menu : menus) {
            page.navigateTo(menu);
        }
        page.waitForTableNotToBeEmpty();
    }
}
