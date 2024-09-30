package org.automation.pages;

import org.automation.utilities.CommonUiUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class ManageLead extends CommonUiUtilities {

    @FindBy(xpath = "//*[contains(@class, 'lv_data_textfield')] //a")
    private List<WebElement> leadName;

    @FindBy(xpath = "//button[contains(@aria-label, 'Edit')]")
    private WebElement leadEditButton;

    @FindBy(id = "Crm_Leads_FIRSTNAME_LInput")
    private WebElement leadFirstName;

    @FindBy(id = "Crm_Leads_LASTNAME_LInput")
    private WebElement leadLastName;

    @FindBy(xpath = "//*[contains(@id, 'Crm_Leads_COMPANY')]//input")
    private WebElement leadCompany;

    @FindBy(id = "crm_create_savebutn")
    private WebElement saveLeadButton;

    @FindBy(id = "moreAct")
    private WebElement actionsButton;

    @FindBy(xpath = "//li[@data-value='mass_delete']")
    private WebElement deleteLeadMenuOption;

    @FindBy(xpath = "//div[contains(@class, 'alertPopup')]//button[contains(@class, 'lyteFailure')]")
    private WebElement confirmLeadDeleteButton;

    @FindBy(id = "newleft_Info")
    private WebElement leadOverView;

    @FindBy(id = "subvalue_LASTNAME")
    private WebElement modifiedLeadName;

    By selectLeadCheckbox = By.xpath("//*[contains(@class, 'lvCheckboxCol')]//input[contains(@type,'checkbox') and not(contains(@id, 'selectAllEntity'))]");

    private int noOfLeadsBeforeDeletion;

    public ManageLead(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyLeadsAreLoaded() {
        waitForVisibility(leadName);
    }

    /**
     * The lead at index 'leadIndex' will be modified with supplied data
     */
    public void modifyLead(int leadIndex, List<Map<String, String>> leadData) {
        openLead(leadIndex - 1);
        clickOnEditOption();
        enterLeadFirstName(leadData.getFirst().get("FirstName"));
        enterLeadLastName(leadData.getFirst().get("LastName"));
        enterLeadCompany(leadData.getFirst().get("Company"));
        saveLead();
        verifyLeadIsModified(leadData.getFirst().get("FirstName"), leadData.getFirst().get("LastName"));
    }

    private void openLead(int index) {
        verifyLeadsAreLoaded();
        if (index > leadName.size())
            Assert.fail(STR."Unable to select lead at index \{index}. Only \{leadName.size()} leads are present");

        clickOnElement(leadName.get(index));
    }

    private void clickOnEditOption() {
        clickOnElement(leadEditButton);
    }

    private void enterLeadFirstName(String firstName) {
        sendKeys(leadFirstName, firstName);
    }

    private void enterLeadLastName(String lastName) {
        sendKeys(leadLastName, lastName);
    }

    private void enterLeadCompany(String company) {
        sendKeys(leadCompany, company);
    }

    private void saveLead() {
        clickOnElement(saveLeadButton);
    }

    private void verifyLeadIsModified(String leadFirstName, String leadLastName) {
        Assert.assertTrue(isElementDisplayed(leadOverView), "Overview tab is not displayed. Failed to save a lead.");
        waitForVisibility(modifiedLeadName);
        Assert.assertEquals(getText(modifiedLeadName).trim(), STR."\{leadFirstName} \{leadLastName}", "Could not modify lead");
    }

    private void selectLead(int leadIndex) {
        List<WebElement> selectedLeadCheckboxes = waitForPresence(selectLeadCheckbox);

        if (leadIndex > selectedLeadCheckboxes.size())
            Assert.fail(STR."Unable to open lead with index \{leadIndex}. Only \{selectedLeadCheckboxes.size()} leads are found.");

//        clickOnElement(selectedLeadCheckboxes.get(leadIndex));
        lazyClick(selectedLeadCheckboxes.get(leadIndex));
    }

    public void deleteLead(int leadIndex) {
        selectLead(leadIndex - 1);
        saveNumberOfLeadBeforeDeletion();
        clickOnActionsButton();
        verifyDeleteLeadOptionIsDisplayed();
        clickOnDeleteLeadOption();
        verifyDeleteLeadOptionIsDisplayed();
        confirmLeadDeletion();
        verifyLeadDeletedSuccessfully();
    }

    private void saveNumberOfLeadBeforeDeletion() {
        noOfLeadsBeforeDeletion = leadName.size();
    }

    private void clickOnActionsButton() {
        clickOnElement(actionsButton);
    }

    private void verifyDeleteLeadOptionIsDisplayed() {
        waitForVisibility(deleteLeadMenuOption);
    }

    private void clickOnDeleteLeadOption() {
        clickOnElement(deleteLeadMenuOption);
    }

    private void verifyConfirmDeletePopupDisplayed() {
        waitForVisibility(confirmLeadDeleteButton);
    }

    private void confirmLeadDeletion() {
        clickOnElement(confirmLeadDeleteButton);
    }

    private void verifyLeadDeletedSuccessfully() {
        boolean leadDeletedSuccessfully = true;

        if (isElementDisplayed(leadName)) {
            if (leadName.size() >= noOfLeadsBeforeDeletion)
                leadDeletedSuccessfully = false;
        }

        Assert.assertTrue(leadDeletedSuccessfully, "Failed to delete lead");
    }
}
