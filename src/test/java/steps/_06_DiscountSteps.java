package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import org.testng.Assert;
import poms.TablePOM;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
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

    @When("^I validate discount fields from excel sheet \"([^\"]*)\" as a \"([^\"]*)\"$")
    public void iValidateDiscountFieldsFromExcelSheetAsA(String sheetName, String arg1) throws IOException {
        ExcelReader excelReader=new ExcelReader("src/test/resources/discount_scenarios.xlsx");
        List<Map<String,String>> listOfMaps = excelReader.getListOfMaps(sheetName);
        page.waitAndClick(page.createButtonElement);
        for (Map<String, String> fieldMap : listOfMaps) {
            page.waitAndSendKeys(page.descInputElement, fieldMap.get("description"));
            page.waitAndSendKeys(page.intCodeInputElement, fieldMap.get("intCode"));
            page.waitAndSendKeys(page.priorityElement, fieldMap.get("priority"));

            boolean errorExists = page.findErrorIn(fieldMap.get("errorIn"));
            Assert.assertEquals(errorExists, !fieldMap.get("errorIn").isEmpty(), "Expected error in " + fieldMap.get("errorIn") + " to exist!");

        }
    }
}
