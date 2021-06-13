package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;


import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class DefinitionSteps {

    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    OutletPage outletPage;
    ProductPage productPage;
    SearchResultsPage searchResultsPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User clicks on Women button")
    public void clickOnWomenButton() {
        homePage.clickOnWomenFloorButton();
    }

    @And("User clicks on Outlet button")
    public void clickOnOutletButton() {
        homePage.clickOnOutletFloorButton();
    }

    @And("User clicks on View all button")
    public void clickOnViewAllButton() {
        homePage.clickOnViewAllButton();
    }

    @When("User moved to Product page")
    public void userMovedToProductPage() {
        outletPage = pageFactoryManager.getOutletPage();
        outletPage.moveToProductPage();
    }

    @Then("User checks visibility of Product photo gallery")
    public void checkVisibilityOfProductPhotoGallery() {
        productPage = pageFactoryManager.getProductPage();
        assertTrue(productPage.isEnabledPhotoGalleryOfProduct());
    }

    @And("User checks visibility of Product description section")
    public void checkVisibilityOfProductDescriptionSection() {
        assertTrue(productPage.isEnabledProductDescriptionSection());
    }

    @And("User checks visibility of Save to wishlist button")
    public void checkVisibilityOfSaveToWishlistButton() {
        assertTrue(productPage.isEnabledSaveToWishlistButton());
    }

    @And("User checks visibility of Product color text field")
    public void checkVisibilityOfProductColorTextField() {
        assertTrue(productPage.isEnabledProductColorTextField());
    }

    @And("User checks visibility of Size selector")
    public void checkVisibilityOfSizeSelect() {
        assertTrue(productPage.isEnabledSizeSelect());
    }

    @And("User checks visibility of Product details text field")
    public void checkVisibilityOfProductDetailsTextField() {
        assertTrue(productPage.isEnabledProductDetailsTextField());
    }

    @And("User clicks on account button")
    public void clickOnAccountButton() {
        homePage.clickOnMyAccountButton();
    }

    @And("User clicks on Sign in button")
    public void clickOnSignInButton() {
        homePage.clickOnSignInButton();
    }

    @And("User checks visibility of Email and Password inputs")
    public void moveToSignInPage() {
        signInPage = pageFactoryManager.getSignInPage();
        assertTrue(signInPage.isEnabledEmailInput());
        assertTrue(signInPage.isEnabledPasswordInput());
    }

    @And("User enters email {string}")
    public void enterEmail(String email) {
        signInPage.enterEmail(email);
    }

    @And("User enters password {string}")
    public void enterPassword(String password) {
        signInPage.enterPassword(password);
    }

    @When("User clicks on Submit sign in button")
    public void clickOnSubmitSignInButton() {
        signInPage.clickOnSigninButton();
    }

    @And("User goes to Account page")
    public void goToAccountPage() {
        homePage.clickOnMyAccountButton();
        homePage.clickOnGoToMyAccountButton();
    }

    @Then("User checks that current tab has title {string}")
    public void userChecksThatCurrentUrlContainsMyAccount(String keyword) {
        assertTrue(signInPage.getTitleCurrentUrl().contains(keyword));
    }

    @And("User clicks on Log out button")
    public void clickOnLogOutButton() {
        signInPage.clickOnLogoutButton();
    }

    @And("User checks search field visibility")
    public void checkSearchFieldVisibility() {
        assertTrue(homePage.isSearchInputEnabled());
    }

    @And("User makes search by keyword {string}")
    public void searchByKeyword(String keyword) {
        homePage.enterKeyWordToSearchInput(keyword);
    }

    @When("User moved to Search result page")
    public void userMovedToSearchResultPage() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
    }

    @Then("User checks that all product names contain keyword {string}")
    public void userChecksThatAllProductNamesContainsKeywordKeyword(String keyword) {
        for (WebElement product : searchResultsPage.getListOfSearchResults()) {
            assertTrue(product.getText().contains(keyword));
        }
    }

    @Then("User checks that login error message is displayed")
    public void userChecksThatLoginErrorMessageIsDisplayed() {
        assertTrue(signInPage.isDisplayedLoginErrorMessage());
    }

    @Then("User checks that information message {string} is displayed")
    public void checkThatInformationMessageIsDisplayed(String informMessage) {
        assertTrue(searchResultsPage.isEnabledNothingMatchesTextField());
        assertEquals(searchResultsPage.getTextFromNothingMatchesTextField(), informMessage);
    }

    @Then("User checks that all products have discount")
    public void userChecksThatAllProductsHaveDiscount() {
        for (WebElement product : outletPage.getListOfProducts()) {
            assertTrue(outletPage.isDiscountEnabled(product));
        }
    }

    @Then("User checks that the discount is calculated correctly")
    public void userChecksThatTheDiscountIsCalculatedCorrectly() {
        productPage = pageFactoryManager.getProductPage();
        assertEquals((productPage.getOldPriceWithDiscount()), (productPage.getCurrentPrice()), 0.0);
    }

    @And("User moved to Outlet page")
    public void moveToOutletPage() {
        outletPage = pageFactoryManager.getOutletPage();
    }

    @And("User chooses the necessary size of product")
    public void userChooseTheNecessarySizeOfProduct() {
        productPage = pageFactoryManager.getProductPage();
        productPage.selectProductSize();
    }

    @When("User clicks on Add to cart button")
    public void clickOnAddToCartButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickOnAddToCartButton();
    }


    @Then("User checks that Cart popup is displayed")
    public void checkThatCartPopupIsDisplayed() {
        assertTrue(productPage.isEnabledCartPopup());
    }

    @And("User checks that text from cart is {string}")
    public void userChecksThatCountOfProductsInCartEqualsToCountOfProducts(String textFromCart) {
        assertEquals(productPage.getProductsCountFromCart(), textFromCart);
    }

    @Then("User checks that select size error is enabled")
    public void checkThatSelectSizeErrorIsEnabled() {
        assertTrue(productPage.isEnabledSelectSizeError());
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @When("User clicks on Add to wishlist button")
    public void clickOnAddToWishlistButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickOnAddToWishlistButton();
    }

    @Then("User checks that text from wishlist is {string}")
    public void userChecksThatProductAddedToWishlist(String textFromWishlist) {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickOnWishlistButton();
        assertEquals(homePage.getTextFromCountProductsFromWishlist(), textFromWishlist);
    }
}