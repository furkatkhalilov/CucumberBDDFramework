package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThreadLocalBaseDriver {
    private static  ThreadLocal<WebDriver> webDriverHolder = new ThreadLocal<>();
    // webDriverHolder.get() ==> returns WebDriver inside
    // webDriverHolder.set(WebDriver) ==> will set WebDriver inside
    public static WebDriver getDriver() {
        if (webDriverHolder.get() == null) {
            WebDriverManager.chromedriver().setup();
            webDriverHolder.set(new ChromeDriver());
        }
        return webDriverHolder.get();
    }

    public static void quitDriver() {
        if (webDriverHolder.get() != null) {
            webDriverHolder.get().quit();
            webDriverHolder.set(null);
        }
    }
}
