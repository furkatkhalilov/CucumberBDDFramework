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
}
