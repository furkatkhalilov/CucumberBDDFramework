package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import poms.TablePOM;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _05_FeeSteps {
    private TablePOM fee = new TablePOM();

    @When("^I create fee with name \"([^\"]*)\", code \"([^\"]*)\", integration code \"([^\"]*)\" and priority \"([^\"]*)\"$")
    public void i_create_fee_with_name_code_integration_code_and_priority(String name, String code, String intCode, String priority) {
        fee.waitAndClick(fee.createButtonElement);
        fee.waitAndSendKeys(fee.nameInputElement, name);
        fee.waitAndSendKeys(fee.codeInputElement, code);
        fee.waitAndSendKeys(fee.intCodeInputElement, intCode);
        fee.waitAndSendKeys(fee.priorityElement, priority);
        fee.waitAndClick(fee.saveButtonElement);
    }

    @When("^I edit  \"([^\"]*)\" to \"([^\"]*)\" fee$")
    public void iEditToFee(String oldName, String newName) throws Throwable {
        fee.searchFor(oldName);

        fee.waitAndClick(fee.editButtonElement);
        fee.waitAndSendKeys(fee.nameInputElement, newName);
        fee.waitAndClick(fee.saveButtonElement);
    }

    @When("^I delete \"([^\"]*)\" fee$")
    public void i_delete_fee(String name) {
        fee.searchFor(name);

        fee.waitAndClick(fee.deleteButtonLocator);
        fee.waitAndClick(fee.dialogSubmitButtonElement);
    }

    @When("^I create fee following fields$")
    public void iCreateFeeFollowingFields(DataTable fields) {
        Map<String, String> fieldsMap = fields.asMap(String.class, String.class);
        fee.waitAndClick(fee.createButtonElement);
        fee.waitAndSendKeys(fee.nameInputElement, fieldsMap.get("name"));
        fee.waitAndSendKeys(fee.codeInputElement, fieldsMap.get("code"));
        fee.waitAndSendKeys(fee.intCodeInputElement, fieldsMap.get("intCode"));
        fee.waitAndSendKeys(fee.priorityElement, fieldsMap.get("priority"));
        fee.waitAndClick(fee.saveButtonElement);
    }

    @When("^I create fee following arbitrary fields$")
    public void iCreateFeeFollowingArbitraryFields(DataTable fields) {
        Map<String, String> fieldsMap = fields.asMap(String.class, String.class);
        fee.waitAndClick(fee.createButtonElement);
        for (String field : fieldsMap.keySet()) {
            fee.sendKeysToField(field, fieldsMap.get(field));
        }
        fee.waitAndClick(fee.saveButtonElement);
    }

    @When("^I try to fill in fee with following data$")
    public void iCreateFeeFollowingData(DataTable fields) {
        fee.waitAndClick(fee.createButtonElement);
        List<Map<String, String>> maps = fields.asMaps(String.class, String.class);
        for (Map<String, String> fieldMap : maps) {
            fee.waitAndSendKeys(fee.nameInputElement, fieldMap.get("name"));
            fee.waitAndSendKeys(fee.codeInputElement, fieldMap.get("code"));
            fee.waitAndSendKeys(fee.intCodeInputElement, fieldMap.get("intCode"));
            fee.waitAndSendKeys(fee.priorityElement, fieldMap.get("priority"));

            boolean errorExists = fee.findErrorIn(fieldMap.get("errorIn"));
            Assert.assertEquals(errorExists, !fieldMap.get("errorIn").isEmpty(), "Expected error in " + fieldMap.get("errorIn") + " to exist!");

        }
//        fee.waitAndClick(fee.saveButtonElement);

    }


    @When("^I create fee with fields from excel sheet \"([^\"]*)\" as a \"([^\"]*)\"$")
    public void iCreateFeeWithFieldsFromExcelSheetAsA(String sheetName, String docType) throws IOException {
        Map<String,String> map = new HashMap<>();

        File file = new File("src/test/resources/fee_scenarios.xlsx");
        Workbook workbook = WorkbookFactory.create(file);

        Sheet sheet = workbook.getSheet(sheetName);
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i); // get reference to
            Cell cell0 = row.getCell(0);
            Cell cell1 = row.getCell(1);
            map.put(cell0.toString(),cell1.toString()); // key, value
        }
        fee.waitAndClick(fee.createButtonElement);
        fee.waitAndSendKeys(fee.nameInputElement, map.get("name"));
        fee.waitAndSendKeys(fee.codeInputElement, map.get("code"));
        fee.waitAndSendKeys(fee.intCodeInputElement, map.get("intCode"));
        fee.waitAndSendKeys(fee.priorityElement, map.get("priority"));
        fee.waitAndClick(fee.saveButtonElement);
    }
}
