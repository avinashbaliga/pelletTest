package org.automation.pages;

import org.automation.utilities.CommonUiUtilities;
import org.automation.utilities.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn extends CommonUiUtilities {

    private final WebDriver driver;
    @FindBy(xpath = "//div[contains(@class, 'zgh-utilities')]//a[contains(@href, 'signin')]")
    private WebElement signInButton;

    @FindBy(xpath = "//button[@id='nextbtn']/span")
    private WebElement login;

    @FindBy(id = "login_id")
    private WebElement userNameTextBox;

    @FindBy(id = "nextbtn")
    private WebElement signInNextButton;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    public SignIn(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void launchAndSignIn() {
        launchZoho();
        signInToZoho();
    }

    private void launchZoho() {
        String url = TestProperties.get("url");
        driver.get(url);
        driver.manage().window().maximize();
    }

    private void signInToZoho() {
        clickOnSignInButton();
        enterUserName();
        clickOnNextButtonWhileSignIn();
        enterPassword();
        login();
    }

    private void clickOnSignInButton() {
        clickOnElement(signInButton);
    }

    private void enterUserName() {
        sendKeys(userNameTextBox, TestProperties.get("zohoLoginUserName"));
    }

    private void clickOnNextButtonWhileSignIn() {
        clickOnElement(signInNextButton);
    }

    private void enterPassword() {
        sendKeys(passwordTextBox, TestProperties.get("zohoLoginPassword"));
    }

    private void login() {
        clickOnElement(login);
    }
}
