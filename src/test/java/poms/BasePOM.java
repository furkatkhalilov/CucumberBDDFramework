package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseDriver;

import java.util.List;

public class BasePOM {
    protected WebDriverWait wait;
    protected WebDriver driver;

    public By progressBarLocator = By.tagName("mat-progress-bar");
    public By deleteButtonLocator = By.cssSelector("ms-delete-button > button");
    public By dialogSubmitButtonLocator = By.cssSelector("mat-dialog-actions button[type='submit']");
    public By rowLocator = By.cssSelector("ms-browse-table tbody > tr");

    public BasePOM() {
        driver = BaseDriver.getDriver();
        wait = new WebDriverWait(driver, 10);
    }

    public void waitAndClick(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public void waitAndSendKeys(By locator, String text) {
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        webElement.clear();
        webElement.sendKeys(text);
    }

    public String waitAndGetText(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
    }

    public String waitForNewAndGetText(By locator) {
        // get the current number of alert dialogs
        int size = driver.findElements(locator).size();
        // then wait for the number to grow
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, size));
        // then return the first one
        return driver.findElement(locator).getText();
    }

    public void waitForProgressBar() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(progressBarLocator));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(progressBarLocator));
        } catch (TimeoutException e) {
            System.out.println("There's no progress bar continue");
        }
    }

    public void deleteAllElementsFromTable() {
        List<WebElement> elements = driver.findElements(rowLocator);
        int numberOfElements = elements.size();
        while (numberOfElements > 0) {
            deleteFirstElementFromTable();
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(rowLocator, numberOfElements));
            numberOfElements = driver.findElements(rowLocator).size();
        }
    }

    public void deleteFirstElementFromTable() {
        List<WebElement> elements = driver.findElements(rowLocator);
        elements.get(0).findElement(deleteButtonLocator).click();
        waitAndClick(dialogSubmitButtonLocator);
    }
}
