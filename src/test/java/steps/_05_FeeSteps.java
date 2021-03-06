package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import poms.TablePOM;
import utils.ExcelReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
        ExcelReader excelReader=new ExcelReader("src/test/resources/fee_scenarios.xlsx");
        Map<String, String> map = excelReader.getMap(sheetName);

        fee.waitAndClick(fee.createButtonElement);
        for (String field : map.keySet()) {
            fee.sendKeysToField(field, map.get(field));
        }
        fee.waitAndClick(fee.saveButtonElement);
    }

    @When("^I validate fee fields from excel sheet \"([^\"]*)\" as a \"([^\"]*)\"$")
    public void iValidateFeeFieldsFromExcelSheetAsA(String sheetName, String docType) throws IOException {
        ExcelReader excelReader=new ExcelReader("src/test/resources/fee_scenarios.xlsx");
        List<Map<String,String>>  listOfMaps = excelReader.getListOfMaps(sheetName);

        fee.waitAndClick(fee.createButtonElement);
        for (Map<String, String> fieldMap : listOfMaps) {
            fee.waitAndSendKeys(fee.nameInputElement, fieldMap.get("name"));
            fee.waitAndSendKeys(fee.codeInputElement, fieldMap.get("code"));
            fee.waitAndSendKeys(fee.intCodeInputElement, fieldMap.get("intCode"));
            fee.waitAndSendKeys(fee.priorityElement, fieldMap.get("priority"));

            boolean errorExists = fee.findErrorIn(fieldMap.get("errorIn"));
            Assert.assertEquals(errorExists, !fieldMap.get("errorIn").isEmpty(), "Expected error in " + fieldMap.get("errorIn") + " to exist!");

        }
    }
}
