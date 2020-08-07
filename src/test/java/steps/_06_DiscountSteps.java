package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import poms.DiscountPom;

import java.util.Map;

public class _06_DiscountSteps {
    private DiscountPom page = new DiscountPom();
    @When("^I create discount following arbitrary fields$")
    public void iCreateDiscountFollowingArbitraryFields(DataTable table) {
        page.waitAndClick(page.createButtonLocator);
        Map<String, String> fieldMap = table.asMap(String.class, String.class);
        for (String field : fieldMap.keySet()) {
            page.sendKeysToField(field, fieldMap.get(field));
        }
        page.waitAndClick(page.saveButtonLocator);
    }

    @When("^I edit  \"([^\"]*)\" to \"([^\"]*)\" discount by \"([^\"]*)\"$")
    public void iEditToDiscountBy(String oldName, String newName, String field) {
        page.searchFor(oldName, field);

        page.waitAndClick(page.editButtonLocator);
        page.sendKeysToField(field, newName);
        page.waitAndClick(page.saveButtonLocator);
    }
}
