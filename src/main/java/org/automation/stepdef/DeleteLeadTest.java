package org.automation.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import org.automation.baseClass.BaseUiTest;
import org.automation.objects.ManageUiObjects;
import org.openqa.selenium.WebDriver;

public class DeleteLeadTest extends BaseUiTest {

    private WebDriver driver;

    private ManageUiObjects pageObjects;

    @Before
    public void setUp() {
        driver = getDriver();
        pageObjects = new ManageUiObjects(driver);
    }

    @And("I should be able to delete a lead")
    public void IShouldBeAbleToDeleteLead(int leadIndex) {
        pageObjects.getManageLead().deleteLead(leadIndex);
    }
}
