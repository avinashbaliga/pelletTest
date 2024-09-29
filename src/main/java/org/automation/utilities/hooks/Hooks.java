package org.automation.utilities.hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.automation.baseClass.BaseUiTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks extends BaseUiTest {

    private final WebDriver driver;
    private TakesScreenshot takesScreenshot = null;

    public Hooks() {
        this.driver = getDriver();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed())
            scenario.attach(getScreenShot(), "image/png", scenario.getName());
    }

    private byte[] getScreenShot() {
        if (takesScreenshot == null)
            takesScreenshot = (TakesScreenshot) driver;

        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }

    @AfterAll
    public static void afterAll(){

    }
}
