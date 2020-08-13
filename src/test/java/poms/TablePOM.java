package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class TablePOM extends BasePOM {


    public TablePOM() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-icon=\"plus\"]")
    public WebElement createButtonElement;
    @FindBy(css = "ms-edit-button > button")
    public WebElement editButtonElement;
    @FindBy(css = "[formcontrolname=\"name\"] > input")
    public WebElement nameInputElement;
    @FindBy(tagName = "ms-save-button")
    public WebElement saveButtonElement;
    @FindBy(tagName = "ms-search-button")
    public WebElement searchButtonElement;
    @FindBy(css = "div[role='alertdialog']")
    public WebElement alertDialogElement;
    public By alertDialogLocator = By.cssSelector("div[role='alertdialog']");
    @FindBy(css = "ms-text-field[placeholder='GENERAL.FIELD.NAME'] > input")
    public WebElement nameSearchElement;
    @FindBy(css = "input[data-placeholder=\"Name\"]")
    public WebElement examNameSearchElement;
    @FindBy(css = "ms-text-field[placeholder*='DESCRIPTION'] > input")
    public WebElement descSearchElement;
    @FindBy(css = "ms-text-field[placeholder*='FIELD.CODE'] > input")
    public WebElement codeSearchElement;
    @FindBy(css = "ms-browse-table tbody > tr")
    public List<WebElement> rowElement;
    @FindBy(css = "[formcontrolname=\"description\"]")
    public WebElement descInputElement;
    @FindBy(css = "[formcontrolname*=\"priority\"] > input")
    public WebElement priorityElement;
    @FindBy(css = "[formcontrolname=\"code\"] > input")
    public WebElement codeInputElement;
    @FindBy(css = "[placeholder*=\"INTEGRATION_CODE\"] > input")
    public WebElement intCodeInputElement;
    public By deleteButtonLocator = By.cssSelector("ms-delete-button > button");
    @FindBy(css = "mat-dialog-actions button[type='submit']")
    public WebElement dialogSubmitButtonElement;
    @FindBy(css = "mat-select[formcontrolname=\"attachmentStages\"]")
    private WebElement attachmentStagesSelectElement;

    @FindBy(css = "mat-select[aria-label=\"Academic Period\"]")
    private WebElement academicPeriodSelectElement;
    @FindBy(css = "mat-select[aria-label=\"Grade Level\"]")
    private WebElement gradeLevelSelectElement;

    @FindBy(css = ".mat-select-panel mat-option")
    private List<WebElement> listOfSelectOptions;
    @FindBy(css = "mat-slide-toggle[formcontrolname=\"useCamera\"]")
    private WebElement useCameraToggleElement;

    public void sendKeysToField(String field, String value) {
        WebElement fieldElement = getFieldElement(field);
        waitAndSendKeys(fieldElement, value);
    }

    public boolean findErrorIn(String errorIn) {
        String classAttribute = "";
        switch (errorIn) {
            case "name":
                classAttribute = nameInputElement.getAttribute("class");
                break;
            case "code":
                classAttribute = codeInputElement.getAttribute("class");
                break;
            case "intCode":
                classAttribute = intCodeInputElement.getAttribute("class");
                break;
            case "priority":
                classAttribute = priorityElement.getAttribute("class");
                break;
            case "description":
                classAttribute = descInputElement.getAttribute("class");
                break;
        }
        return classAttribute.contains("ng-invalid");
    }

    public void searchFor(String citizenshipName) {
        waitAndSendKeys(nameSearchElement, citizenshipName);
        waitAndClick(searchButtonElement);
        waitForProgressBar();
    }

    public void searchFor(String entity, String field) {
        waitAndSendKeys(getSearchFieldElement(field), entity);
        waitAndClick(searchButtonElement);
        waitForProgressBar();
    }

    public WebElement getSearchFieldElement(String field) {
        WebElement element = null;
        switch (field) {
            case "name":
                element = nameSearchElement;
                break;
            case "examName":
                element = examNameSearchElement;
                break;
            case "description":
                element = descSearchElement;
                break;
            case "code":
                element = codeSearchElement;
                break;
            default:
                Assert.fail(field + " not implemented for search fields");
        }
        return element;
    }

    public WebElement getFieldElement(String field) {
        WebElement element = null;
        switch (field) {
            case "intCode":
                element = intCodeInputElement;
                break;
            case "priority":
                element = priorityElement;
                break;
            case "name":
                element = nameInputElement;
                break;
            case "description":
                element = descInputElement;
                break;
            case "code":
                element = codeInputElement;
                break;
            case "createButton":
                element = createButtonElement;
                break;
            case "editButton":
                element = editButtonElement;
                break;
            case "saveButton":
                element = saveButtonElement;
                break;
            case "attachmentStagesSelect":
                element = attachmentStagesSelectElement;
                break;
            case "academicPeriodSelect":
                element = academicPeriodSelectElement;
                break;
            case "gradeLevelSelect":
                element = gradeLevelSelectElement;
                break;
            case "Option1":
                element = listOfSelectOptions.get(0);
                break;
            case "Option2":
                element = listOfSelectOptions.get(1);
                break;
            case "useCameraToggle":
                element = useCameraToggleElement;
                break;
            default:
                Assert.fail(field + " not implemented for search fields");
        }
        return element;
    }

    public void sendKeysToSearchField(String field, String value) {
        WebElement searchFieldElement = getSearchFieldElement(field);
        waitAndSendKeys(searchFieldElement, value);
    }



    public void deleteAllElementsFromTable() {
        List<WebElement> elements = rowElement;
        int numberOfElements = elements.size();
        while (numberOfElements > 0) {
            deleteFirstElementFromTable();
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(rowLocator, numberOfElements));
            numberOfElements = driver.findElements(rowLocator).size();
        }
    }

    public void deleteFirstElementFromTable() {
        List<WebElement> elements = rowElement;
        elements.get(0).findElement(deleteButtonLocator).click();
        waitAndClick(dialogSubmitButtonElement);
    }

    public void waitAndClick(String element) {
        WebElement fieldElement = getFieldElement(element); //attachmentStagesSelect
        wait.until(ExpectedConditions.visibilityOf(fieldElement));
        wait.until(ExpectedConditions.elementToBeClickable(fieldElement));
        fieldElement.click();
    }

}
