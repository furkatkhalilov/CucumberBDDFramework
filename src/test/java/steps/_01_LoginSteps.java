package steps;

import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _01_LoginSteps {

    private WebDriver driver;

    @Given("^I navigate to basqar$")
    public void i_navigate_to_basqar() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://test.basqar.techno.study/");
    }

    @When("^I try to login using username and password$")
    public void i_enter_username_and_password() {
        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys("daulet2030@gmail.com");
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys("DV@d9FjCm5hXeNFv");
        driver.findElement(By.cssSelector("[aria-label=\"LOGIN\"]")).click();
    }

    @Then("^I am logged in$")
    public void i_am_logged_in() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img.avatar")));
    }

}
