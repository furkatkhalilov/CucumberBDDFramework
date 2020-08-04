package steps;

import cucumber.api.java.en.When;
import poms.FeePom;

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
}
