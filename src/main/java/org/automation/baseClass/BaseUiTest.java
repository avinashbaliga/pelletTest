package org.automation.baseClass;

import org.automation.utilities.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseUiTest {

    private static WebDriver driver = null;

    public WebDriver getDriver() {
        if (driver == null)
            initiateDriver();

        return driver;
    }

    private void initiateDriver() {
        String browser = TestProperties.get("browser");
        driver = switch (browser) {
            case "chrome" -> {
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--incognito");
                yield new ChromeDriver(option);
            }
            case "firefox" -> new FirefoxDriver();
            default -> new EdgeDriver();
        };
    }

    public static void deleteBrowserInstance() {
        driver = null;
    }
}
