package poms;

import org.openqa.selenium.By;

public class FeePom extends TablePOM {
    public By codeInputLocator=By.cssSelector("[formcontrolname=\"code\"] > input");
    public By intInputLocator=By.cssSelector("[formcontrolname*=\"IntegrationCode\"] > input");
    public By priorityLocator = By.cssSelector("[formcontrolname*=\"priority\"] > input");
}
