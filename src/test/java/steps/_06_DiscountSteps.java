package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import poms.TablePOM;

import java.util.Map;

public class _06_DiscountSteps {
    private TablePOM page = new TablePOM();
    @When("^I create discount following arbitrary fields$")
    public void iCreateDiscountFollowingArbitraryFields(DataTable table) {
        page.waitAndClick(page.createButtonElement);
        Map<String, String> fieldMap = table.asMap(String.class, String.class);
        for (String field : fieldMap.keySet()) {
            page.sendKeysToField(field, fieldMap.get(field));
        }
        page.waitAndClick(page.saveButtonElement);
    }

    @When("^I edit  \"([^\"]*)\" to \"([^\"]*)\" discount by \"([^\"]*)\"$")
    public void iEditToDiscountBy(String oldName, String newName, String field) {
        page.searchFor(oldName, field);

        page.waitAndClick(page.editButtonElement);
        page.sendKeysToField(field, newName);
        page.waitAndClick(page.saveButtonElement);
    }
}
