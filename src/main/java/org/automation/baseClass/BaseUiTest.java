package org.automation.baseClass;

import org.automation.utilities.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseUiTest {

    private final static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public WebDriver getDriver() {
        if (driverThreadLocal.get() == null)
            initiateDriver();

        return driverThreadLocal.get();
    }

    private void initiateDriver() {
        String browser = TestProperties.get("browser");
        WebDriver driver = switch (browser) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            default -> new EdgeDriver();
        };

        driverThreadLocal.set(driver);
    }
}
