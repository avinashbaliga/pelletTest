package org.automation.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.automation.baseClass.BaseUiTest;
import org.automation.objects.ManageUiObjects;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class CreateLeadTest extends BaseUiTest {

    private WebDriver driver;
    private ManageUiObjects pageObject;

    @Before
    public void setup() {
        driver = getDriver();
        pageObject = new ManageUiObjects(driver);
    }

    @Given("I'm logged in to Zoho CRM")
    public void imLoggedInToZohoCrm() {
        pageObject.getSignInPage().launchAndSignIn();
    }

    @When("I click on Leads")
    public void clickOnLeads() {
        pageObject.getDashBoardPage().clickOnLeadsOption();
    }

    @And("I click on create a lead")
    public void iClickONCreateALead() {
        pageObject.getDashBoardPage().clickOnCreateALead();
    }

    @Then("I should be able to create a lead with given details")
    public void createLeadWithGivenDetails(List<Map<String, String>> details) {
        pageObject.getCreateLeadPage().createLead(details);
    }
}
