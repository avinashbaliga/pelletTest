package org.automation.pages;

import org.automation.utilities.CommonUiUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard extends CommonUiUtilities {

    private final WebDriver driver;

    @FindBy(id = "Visible_Leads")
    private WebElement leadsOption;

    @FindBy(xpath = "//button[contains(@aria-label, 'Create Lead')]")
    private WebElement createLead;

    public DashBoard(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnLeadsOption() {
        clickOnElement(leadsOption);
    }

    public void clickOnCreateALead() {
        clickOnElement(createLead);
    }
}
