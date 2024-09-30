package org.automation.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CommonUiUtilities {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CommonUiUtilities(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(TestProperties.get("timeout"))));
    }

    public void waitForVisibility(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            Assert.fail(STR."Unable to find \{element}");
        }
    }

    public void waitForVisibility(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public List<WebElement> waitForPresence(By by) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void clickOnElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            Assert.fail(STR."Unable to click on \{element}");
        }
    }

    public void sendKeys(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(STR."Failed to get text of \{element}");
        }
    }

    public void clickUsingJs(WebElement element) {
        getJavascriptExecutor().executeScript("arguments[0].click();", element);
    }

    public JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) driver;
    }
}

