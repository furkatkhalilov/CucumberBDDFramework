package poms;

import org.openqa.selenium.By;

public class TablePOM extends BasePOM {

    public By createButtonLocator = By.cssSelector("[data-icon=\"plus\"]");
    public By editButtonLocator = By.cssSelector("ms-edit-button > button");
    public By nameInputLocator = By.cssSelector("[formcontrolname=\"name\"] > input");
    public By saveButtonLocator = By.tagName("ms-save-button");
    public By searchButtonLocator = By.tagName("ms-search-button");
    public By alertDialogLocator = By.cssSelector("div[role='alertdialog']");
    public By nameSearchLocator = By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.NAME'] > input");
    public By descSearchLocator = By.cssSelector("ms-text-field[placeholder*='DESCRIPTION'] > input");
    public By codeSearchLocator = By.cssSelector("ms-text-field[placeholder*='FIELD.CODE'] > input");

    public void searchFor(String citizenshipName) {
        waitAndSendKeys(nameSearchLocator, citizenshipName);
        waitAndClick(searchButtonLocator);
        waitForProgressBar();
    }

    public void searchFor(String entity, String field) {
        By locator = null;
        switch (field) {
            case "name":
                locator = nameSearchLocator;
                break;
            case "description":
                locator = descSearchLocator;
                break;
            case "code":
                locator = codeSearchLocator;
                break;
        }
        waitAndSendKeys(locator, entity);
        waitAndClick(searchButtonLocator);
        waitForProgressBar();
    }
}
