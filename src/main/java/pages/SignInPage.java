package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@class='qa-password-textbox']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='signin']")
    private WebElement signinButton;

    @FindBy(xpath = "//a[contains(@href,'/logout')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//li[@id='loginErrorMessage']")
    private WebElement loginErrorMessage;

    public String getTextFromLoginErrorMessage() {
        waitVisibilityOfElement(loginErrorMessage);
        return loginErrorMessage.getText();
    }

    public void enterEmail(final String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(final String password) {
        passwordInput.sendKeys(password);
    }

    public void clickOnSigninButton() {
        signinButton.click();
    }

    public String getTitleCurrentUrl() {
        return driver.getTitle();
    }

    public void clickOnLogoutButton() {
        Actions action = new Actions(driver);
        action.moveToElement(logoutButton);
        waitElementToBeClickable(logoutButton);
        logoutButton.click();
    }

    public boolean isEnabledEmailInput() {
        return emailInput.isEnabled();
    }

    public boolean isEnabledPasswordInput() {
        return passwordInput.isEnabled();
    }
}