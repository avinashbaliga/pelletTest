package org.automation.stepdef;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import org.automation.baseClass.BaseUiTest;
import org.automation.objects.ManageUiObjects;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class FilterLeadTest extends BaseUiTest {

    private WebDriver driver;

    private ManageUiObjects pageObjects;

    @Before
    public void setUp() {
        driver = getDriver();
        pageObjects = new ManageUiObjects(driver);
    }

    @And("I should be able to filter leads based on given parameter")
    public void iShouldBeAbleToFilterLeads(List<Map<String, String>> filterDetails) {
        pageObjects.getManageLead().filterLead(filterDetails);
    }

    @And("Verify that no leads are displayed with above filter")
    public void verifyNoLeadsAreDisplayedMatchingFilter() {
        pageObjects.getManageLead().verifyNoLeadDisplayedAfterFilter();
    }
}
