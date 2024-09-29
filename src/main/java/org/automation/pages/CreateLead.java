package org.automation.pages;

import org.automation.utilities.CommonUiUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class CreateLead extends CommonUiUtilities {

    @FindBy(xpath = "//label[contains(@class, 'create-title-label')]")
    private WebElement createLeadPageTitle;

    @FindBy(id = "Crm_Leads_FIRSTNAME_LInput")
    private WebElement leadFirstName;

    @FindBy(id = "Crm_Leads_LASTNAME_LInput")
    private WebElement leadLastName;

    @FindBy(xpath = "//*[contains(@id, 'Crm_Leads_COMPANY')]//input")
    private WebElement leadCompany;

    @FindBy(id = "crm_create_savebutn")
    private WebElement saveLeadButton;

    @FindBy(xpath = "//*[contains(@class, 'lv_data_textfield')] //a")
    private List<WebElement> leadName;

    @FindBy(id = "Visible_Leads")
    private WebElement leadsOption;

    @FindBy(id = "newleft_Info")
    private WebElement leadOverView;

    public CreateLead(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void createLead(List<Map<String, String>> details) {
        verifyCreateLeadPageIsDisplayed();
        enterLeadFirstName(details.getFirst().get("FirstName"));
        enterLeadLastName(details.getFirst().get("LastName"));
        enterLeadCompany(details.getFirst().get("Company"));
        saveLead();
        clickOnLeadsOption();
        verifyLeadIsCreated(details.getFirst().get("FirstName"), details.getFirst().get("LastName"));
    }

    private void enterLeadCompany(String company) {
        sendKeys(leadCompany, company);
    }

    private void verifyCreateLeadPageIsDisplayed() {
        waitForVisibility(createLeadPageTitle);
    }

    private void enterLeadFirstName(String firstName) {
        sendKeys(leadFirstName, firstName);
    }

    private void enterLeadLastName(String lastName) {
        sendKeys(leadLastName, lastName);
    }

    private void saveLead() {
        clickOnElement(saveLeadButton);
        Assert.assertTrue(isElementDisplayed(leadOverView), "Overview tab is not displayed. Failed to save a lead.");
    }

    private void verifyLeadIsCreated(String leadFirstName, String leadLastName) {
        boolean leadFound = false;
        waitForVisibility(leadName);

        for (WebElement name : leadName) {
            if (name.getText().toLowerCase().contains(STR."\{leadFirstName.toLowerCase()} \{leadLastName.toLowerCase()}")) {
                leadFound = true;
                break;
            }
        }

        Assert.assertTrue(leadFound, STR."Failed to create lead with first name: \{leadFirstName} and last name: \{leadLastName}");
    }

    public void clickOnLeadsOption() {
        clickOnElement(leadsOption);
    }
}
