package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BaseDriver;

import java.util.List;
import java.util.Map;

public class AutomationPracticeSteps {
    private WebDriver driver;

    @Given("^I navigate to \"([^\"]*)\"$")
    public void navigate(String websiteUrl) {
        driver = BaseDriver.getDriver();
        driver.manage().window().maximize();
        driver.get(websiteUrl);
    }

    @When("^I Search for products I expect number of results to be:$")
    public void iSearchForProductsIExpectNumberOfResultsToBe(DataTable table) {
        List<Map<String, String>> mapList = table.asMaps(String.class, String.class);
        for ( Map<String, String> row: mapList) {
            WebElement searchQueryTop = driver.findElement(By.id("search_query_top"));
            searchQueryTop.clear();
            searchQueryTop.sendKeys(row.get("product"));
            driver.findElement(By.name("submit_search")).click();
            int results = driver.findElements(By.cssSelector("li.ajax_block_product")).size();
            Assert.assertEquals(results, Integer.parseInt(row.get("results")));
        }
    }
}
