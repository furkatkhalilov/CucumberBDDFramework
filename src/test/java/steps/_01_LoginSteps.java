package steps;

import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ThreadLocalBaseDriver;

public class _01_LoginSteps {

    private WebDriver driver;

    @Given("^I navigate to basqar$")
    public void i_navigate_to_basqar() {
        driver = ThreadLocalBaseDriver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://test.basqar.techno.study/");
    }

    @When("^I try to login using username and password$")
    public void i_enter_username_and_password() {
        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys("daulet2030@gmail.com");
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys("TechnoStudy123@");
        driver.findElement(By.cssSelector("[aria-label=\"LOGIN\"]")).click();
    }

    @Then("^I am logged in$")
    public void i_am_logged_in() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img.avatar")));
    }


}
