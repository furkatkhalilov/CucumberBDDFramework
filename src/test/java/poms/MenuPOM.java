package poms;

import org.openqa.selenium.By;


public class MenuPOM extends BasePOM {
    public By setupMenuLocator = By.xpath("//span[text()='Setup']");
    public By parametersMenuLocator = By.xpath("//span[text()='Parameters']");
    public By countriesMenuLocator = By.xpath("//span[text()='Countries']");
    public By citizenshipMenuLocator = By.xpath("//span[text()='Citizenships']");
    public By feeMenuLocator = By.xpath("//span[text()='Fees']");

}
