package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import poms.MenuPOM;
import poms.TablePOM;

import java.util.List;
import java.util.Map;

public class _04_TableSteps {
    TablePOM page = new TablePOM();

    @Given("^I navigate to \"([^\"]*)\" screen$")
    public void i_navigate_to_country_screen(String screenName) {
        MenuPOM menu = new MenuPOM();
        menu.waitAndClick(menu.setupMenuLocator);
        menu.waitAndClick(menu.parametersMenuLocator);
        switch (screenName) {
            case "country":
                menu.waitAndClick(menu.countriesMenuLocator);
                break;
            case "citizenship":
                menu.waitAndClick(menu.citizenshipMenuLocator);
                break;
            case "fee":
                menu.waitAndClick(menu.feeMenuLocator);
                break;
            case "discount":
                menu.waitAndClick(menu.discountMenuLocator);
                break;
            case "nationality":
                menu.waitAndClick(menu.nationalityMenuLocator);
                break;
            case "document types":
                menu.waitAndClick(menu.documentMenuLocator);
                break;
            default:
                Assert.fail(screenName + " menu is not implement!");
        }
        page.waitForTableNotToBeEmpty();
    }

    @And("^\"([^\"]*)\" entity doesn't exist in table$")
    public void entityDoesNotExist(String entityName) {
        page.searchFor(entityName);
        page.deleteAllElementsFromTable();
    }

    @Then("^\"([^\"]*)\" is successfully \"([^\"]*)\"$")
    public void country_is_successfully_edited(String entityName, String outcome) {
        String actual = page.waitForNewAndGetText(page.alertDialogLocator);
        Assert.assertEquals(actual, entityName + " successfully " + outcome);
    }

    @And("^table doesn't contain the entity by name \"([^\"]*)\"$")
    public void tableDoesNotContain(String entityName) {
        page.searchFor(entityName);
        int numberOfElements = page.getNumberOfElements(page.rowLocator);
        Assert.assertEquals(numberOfElements, 0, "expecting number of entities to be zero");
    }

    @And("^search and delete \"([^\"]*)\" entities by \"([^\"]*)\"$")
    public void searchAndDeleteEntitiesBy(String entity, String field) {
        page.searchFor(entity, field);
        page.deleteAllElementsFromTable();
    }

    @Then("^\"([^\"]*)\" is successfully \"([^\"]*)\" message is present$")
    public void isSuccessfullyMessageIsPresent(String entityName, String outcome) {
        boolean messageIsPresent = page.verifyElementsContain(page.alertDialogLocator, entityName + " successfully " + outcome);
        Assert.assertTrue(messageIsPresent, "Message: '" + entityName + " successfully " + outcome + "' should be present on the page!");
    }

    @When("^I create table entity with following arbitrary fields$")
    public void iCreateTableEntityFollowingArbitraryFields(DataTable fieldsTable) {
        Map<String, String> fieldsMap = fieldsTable.asMap(String.class, String.class);
        page.waitAndClick(page.createButtonElement);
        for (String field : fieldsMap.keySet()) {
            page.sendKeysToField(field, fieldsMap.get(field));
        }
        page.waitAndClick(page.saveButtonElement);
    }

    @When("^I search table entity with following arbitrary fields$")
    public void iSearchTableEntityWithFollowingArbitraryFields(DataTable fieldsTable) {
        Map<String, String> fieldsMap = fieldsTable.asMap(String.class, String.class);
        for (String field : fieldsMap.keySet()) {
            page.sendKeysToSearchField(field, fieldsMap.get(field));
        }
        page.waitAndClick(page.searchButtonElement);

    }

    @When("^I edit first table entity with following arbitrary fields$")
    public void iEditFirstTableEntityWithFollowingArbitraryFields(DataTable fieldsTable) {
        Map<String, String> fieldsMap = fieldsTable.asMap(String.class, String.class);
        page.waitAndClick(page.editButtonElement);
        for (String field : fieldsMap.keySet()) {
            page.sendKeysToField(field, fieldsMap.get(field));
        }
        page.waitAndClick(page.saveButtonElement);
    }

    @When("^I delete first table entity$")
    public void iDeleteFirstTableEntity() {
        page.waitAndClick(page.deleteButtonLocator);
        page.waitAndClick(page.dialogSubmitButtonElement);
    }

    @Given("^I click on following elements$")
    public void iClickOnFollowingElements(DataTable elementsTable) {
        List<String> elements = elementsTable.asList(String.class);
        for(String element: elements) {
            page.waitAndClick(element); //createButton
        }
    }
}
