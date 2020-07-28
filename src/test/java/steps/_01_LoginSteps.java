package steps;

import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseDriver;

public class _01_LoginSteps {

    private WebDriver driver;

    @Given("^I navigate to basqar$")
    public void i_navigate_to_basqar() {
        driver = BaseDriver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://test.basqar.mersys.io/");
    }

    @When("^I try to login using username and password$")
    public void i_enter_username_and_password() {
        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys("F4pj8Zsq52mX!");
        driver.findElement(By.cssSelector("[aria-label=\"LOGIN\"]")).click();
    }

    @Then("^I am logged in$")
    public void i_am_logged_in() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img.avatar")));
    }

}
