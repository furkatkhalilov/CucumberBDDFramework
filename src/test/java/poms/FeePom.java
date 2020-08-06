package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeePom extends TablePOM {

    public FeePom() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[formcontrolname=\"code\"] > input")
    public WebElement codeInputElement;
    @FindBy(css = "[formcontrolname*=\"IntegrationCode\"] > input")
    public WebElement intInputElement;
    @FindBy(css = "[formcontrolname*=\"priority\"] > input")
    public WebElement priorityElement;

    public void sendKeysToField(String field, String value) {
        switch (field) {
            case "name":
                waitAndSendKeys(nameInputLocator, value);
                break;
            case "code":
                waitAndSendKeys(codeInputElement, value);
                break;
            case "intCode":
                waitAndSendKeys(intInputElement, value);
                break;
            case "priority":
                waitAndSendKeys(priorityElement, value);
                break;
        }
    }
}
