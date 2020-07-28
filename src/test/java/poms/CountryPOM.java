package poms;

import org.openqa.selenium.By;

public class CountryPOM extends BasePOM {

    public By createButtonLocator = By.cssSelector("[data-icon=\"plus\"]");
    public By nameInputLocator = By.cssSelector("[formcontrolname=\"name\"] > input");
    public By saveButtonLocator = By.tagName("ms-save-button");
    public By alertDialogLocator = By.cssSelector("div[role='alertdialog']");

}
