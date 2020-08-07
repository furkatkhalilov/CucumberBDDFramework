package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import org.testng.Assert;
import poms.DiscountPom;
import poms.FeePom;

import java.util.List;
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
}
