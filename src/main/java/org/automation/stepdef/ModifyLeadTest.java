package org.automation.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.automation.baseClass.BaseUiTest;
import org.automation.objects.ManageUiObjects;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class ModifyLeadTest extends BaseUiTest {

    private WebDriver driver;
    private ManageUiObjects pageObjects;

    @Before
    public void setup() {
        driver = getDriver();
        pageObjects = new ManageUiObjects(driver);
    }

    @Then("I should be able to view existing leads")
    public void iShouldBeAbleToViewExistingLeads(){
        pageObjects.getManageLead().verifyLeadsAreLoaded();
    }

    @And("I should be able to modify the existing lead")
    public void modifyExistingLead(List<Map<String, String>> leadData){
        pageObjects.getManageLead().modifyLead(1,leadData);
    }
}
