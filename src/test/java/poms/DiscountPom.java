package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class DiscountPom extends TablePOM {

    public DiscountPom() {
        PageFactory.initElements(driver, this);
    }

    public By descInputLocator = By.cssSelector("[formcontrolname=\"description\"] > input");
    public By intCodeInputLocator = By.cssSelector("[formcontrolname=\"code\"] > input");
    public By priorityLocator = By.cssSelector("[formcontrolname*=\"priority\"] > input");

    public void sendKeysToField(String field, String value) {
        switch (field) {
            case "description":
                waitAndSendKeys(descInputLocator, value);
                break;
            case "intCode":
                waitAndSendKeys(intCodeInputLocator, value);
                break;
            case "priority":
                waitAndSendKeys(priorityLocator, value);
                break;
        }
    }

    public boolean findErrorIn(String errorInField) {
        String classAttribute = "";
        switch (errorInField) {
            case "description":
                classAttribute = driver.findElement(descInputLocator).getAttribute("class");
                break;
            case "intCode":
                classAttribute = driver.findElement(intCodeInputLocator).getAttribute("class");
                break;
            case "priority":
                classAttribute = driver.findElement(priorityLocator).getAttribute("class");
                break;
        }
        return classAttribute.contains("ng-invalid");
    }
}
