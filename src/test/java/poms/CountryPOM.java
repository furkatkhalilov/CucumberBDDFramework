package poms;

import org.openqa.selenium.By;

public class CountryPOM extends BasePOM {

    public By createButtonLocator = By.cssSelector("[data-icon=\"plus\"]");
    public By editButtonLocator = By.cssSelector("ms-edit-button > button");
    public By deleteButtonLocator = By.cssSelector("ms-delete-button > button");
    public By dialogSubmitButtonLocator = By.cssSelector("mat-dialog-actions button[type='submit']");
    public By nameInputLocator = By.cssSelector("[formcontrolname=\"name\"] > input");
    public By saveButtonLocator = By.tagName("ms-save-button");
    public By searchButtonLocator = By.tagName("ms-search-button");
    public By alertDialogLocator = By.cssSelector("div[role='alertdialog']");
    public By nameSearchLocator = By.cssSelector("ms-text-field[placeholder='GENERAL.FIELD.NAME'] > input");

}
