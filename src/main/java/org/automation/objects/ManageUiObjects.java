package org.automation.objects;

import org.automation.pages.CreateLead;
import org.automation.pages.DashBoard;
import org.automation.pages.ManageLead;
import org.automation.pages.SignIn;
import org.openqa.selenium.WebDriver;

public class ManageUiObjects {

    private final WebDriver driver;

    private SignIn signIn = null;

    private DashBoard dashBoard = null;

    private CreateLead createLead = null;

    private ManageLead manageLead = null;

    public ManageUiObjects(WebDriver driver) {
        this.driver = driver;
    }

    public SignIn getSignInPage() {
        return (signIn == null) ? signIn = new SignIn(driver) : signIn;
    }

    public DashBoard getDashBoardPage() {
        return (dashBoard == null) ? dashBoard = new DashBoard(driver) : dashBoard;
    }

    public CreateLead getCreateLeadPage() {
        return (createLead == null) ? createLead = new CreateLead(driver) : createLead;
    }

    public ManageLead getManageLead() {
        return (manageLead == null) ? manageLead = new ManageLead(driver) : manageLead;
    }
}
