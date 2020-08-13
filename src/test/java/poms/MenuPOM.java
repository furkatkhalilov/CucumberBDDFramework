package poms;

import org.openqa.selenium.By;
import org.testng.Assert;


public class MenuPOM extends BasePOM {
    public By setupMenuLocator = By.xpath("//span[text()='Setup']");
    public By setup2MenuLocator = By.xpath("(//span[text()='Setup'])[2]");
    public By parametersMenuLocator = By.xpath("//span[text()='Parameters']");
    public By countriesMenuLocator = By.xpath("//span[text()='Countries']");
    public By citizenshipMenuLocator = By.xpath("//span[text()='Citizenships']");
    public By feeMenuLocator = By.xpath("//span[text()='Fees']");
    public By discountMenuLocator = By.xpath("//span[text()='Discounts']");
    public By nationalityMenuLocator = By.xpath("//span[text()='Nationalities']");
    public By documentMenuLocator = By.xpath("//span[text()='Document Types']");
    public By entranceExams1MenuLocator = By.xpath("//span[text()='Entrance Exams']");
    public By entranceExams2MenuLocator = By.xpath("(//span[text()='Entrance Exams'])[2]");

    public void navigateTo(String menu) {
        switch (menu) {
            case "Entrance Exams 1":
                waitAndClick(entranceExams1MenuLocator);
                break;
            case "Entrance Exams 2":
                waitAndClick(entranceExams2MenuLocator);
                break;
            case "Setup 2":
                waitAndClick(setup2MenuLocator);
                break;
            default:
                Assert.fail(menu + " not yet implemented!");
        }
    }
}
