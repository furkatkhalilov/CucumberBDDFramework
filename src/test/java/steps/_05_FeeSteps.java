package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import poms.FeePom;

import javax.xml.crypto.Data;
import java.util.Map;

public class _05_FeeSteps {
    private FeePom fee = new FeePom();

    @When("^I create fee with name \"([^\"]*)\", code \"([^\"]*)\", integration code \"([^\"]*)\" and priority \"([^\"]*)\"$")
    public void i_create_fee_with_name_code_integration_code_and_priority(String name, String code, String intCode, String priority) {
        fee.waitAndClick(fee.createButtonLocator);
        fee.waitAndSendKeys(fee.nameInputLocator,name);
        fee.waitAndSendKeys(fee.codeInputElement,code);
        fee.waitAndSendKeys(fee.intInputElement,intCode);
        fee.waitAndSendKeys(fee.priorityElement,priority);
        fee.waitAndClick(fee.saveButtonLocator);
    }

    @When("^I edit  \"([^\"]*)\" to \"([^\"]*)\" fee$")
    public void iEditToFee(String oldName, String newName) throws Throwable {
        fee.searchFor(oldName);

        fee.waitAndClick(fee.editButtonLocator);
        fee.waitAndSendKeys(fee.nameInputLocator, newName);
        fee.waitAndClick(fee.saveButtonLocator);
    }

    @When("^I delete \"([^\"]*)\" fee$")
    public void i_delete_fee(String name) {
        fee.searchFor(name);

        fee.waitAndClick(fee.deleteButtonLocator);
        fee.waitAndClick(fee.dialogSubmitButtonLocator);
    }

    @When("^I create fee following fields$")
    public void iCreateFeeFollowingFields(DataTable fields) {
        Map<String, String> fieldsMap = fields.asMap(String.class, String.class);
        fee.waitAndClick(fee.createButtonLocator);
        fee.waitAndSendKeys(fee.nameInputLocator,fieldsMap.get("name"));
        fee.waitAndSendKeys(fee.codeInputElement,fieldsMap.get("code"));
        fee.waitAndSendKeys(fee.intInputElement,fieldsMap.get("intCode"));
        fee.waitAndSendKeys(fee.priorityElement,fieldsMap.get("priority"));
        fee.waitAndClick(fee.saveButtonLocator);
    }
}
