package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@data-testid='myaccount-link']")
    private WebElement goToMyAccountButton;

    @FindBy(xpath = "//button[@data-testid='myAccountIcon']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']")
    private WebElement wishlistButton;

    @FindBy(xpath = "//a[contains((text()),'Sign In')]")
    private WebElement signInButton;

    @FindBy(xpath = "//button[@data-id='a92844a0-3b5b-41b6-ad85-9ca81f5c24f1']")
    private WebElement outletFloorButton;

    @FindBy(xpath = "//a[@id='women-floor']")
    private WebElement womenFloorButton;

    @FindBy(xpath = "//a[contains(@href,'?cid=27391&nlid=ww')]")
    private WebElement viewAllButton;

    @FindBy(xpath = " //div[@class='itemCount_3vWat']")
    private WebElement countProductsFromWishlist;

    @FindBy(xpath = "//input[@id='chrome-search']")
    private WebElement searchInput;

    public void openHomePage(String url) {
        driver.get(url);
        waitElementToBeClickable(womenFloorButton);
    }

    public void clickOnMyAccountButton() {
        waitElementToBeClickable(myAccountButton);
        myAccountButton.click();
        waitElementToBeClickable(signInButton);
    }

    public void clickOnWishlistButton() {
        waitElementToBeClickable(wishlistButton);
        wishlistButton.click();
        waitVisibilityOfElement(countProductsFromWishlist);
    }

    public String getTextFromCountProductsFromWishlist() {
        return countProductsFromWishlist.getText();
    }

    public void clickOnGoToMyAccountButton() {
        goToMyAccountButton.click();
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public void clickOnOutletFloorButton() {
        waitElementToBeClickable(outletFloorButton);
        outletFloorButton.click();
    }

    public void clickOnWomenFloorButton() {
        womenFloorButton.click();
    }

    public void clickOnViewAllButton() {
        waitElementToBeClickable(viewAllButton);
        viewAllButton.click();
    }

    public void enterKeyWordToSearchInput(final String keyword) {
        waitElementToBeClickable(searchInput);
        searchInput.clear();
        searchInput.sendKeys(keyword, Keys.ENTER);
    }

    public boolean isSearchInputEnabled() {
        return searchInput.isEnabled();
    }
}