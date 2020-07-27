package steps;

import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BaseDriver;

public class _02_CreateCountrySteps {

    private WebDriver driver;

    @Given("^I navigate to country screen$")
    public void i_navigate_to_country_screen()  {
        driver = BaseDriver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Setup']")));
        driver.findElement(By.xpath("//span[text()='Setup']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Parameters']")));
        driver.findElement(By.xpath("//span[text()='Parameters']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Countries']")));
        driver.findElement(By.xpath("//span[text()='Countries']")).click();
    }

    @When("^I create a country$")
    public void i_create_a_country()  {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-icon=\"plus\"]")));
        driver.findElement(By.cssSelector("[data-icon=\"plus\"]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[formcontrolname=\"name\"] > input")));
        driver.findElement(By.cssSelector("[formcontrolname=\"name\"] > input")).sendKeys("country name");

        driver.findElement(By.tagName("ms-save-button")).click();
    }

    @Then("^country is successfully created$")
    public void country_is_successfully_created()  {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[role='alertdialog']")));
        WebElement alertDialog = driver.findElement(By.cssSelector("div[role='alertdialog']"));

        Assert.assertEquals(alertDialog.getText(), "Country successfully created");
    }

}
