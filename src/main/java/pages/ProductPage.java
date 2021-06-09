package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@data-id='rrp-price']")
    private WebElement oldPrice;

    @FindBy(xpath = "//span[@data-id='current-price']")
    private WebElement currentPrice;

    @FindBy(xpath = "//span[@class='product-discount-percent']")
    private WebElement discountPercent;

    @FindBy(xpath = "//select[@data-id='sizeSelect']")
    private WebElement sizeSelect;

    @FindBy(xpath = "//button[@data-test-id='add-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@id='selectSizeError']")
    private WebElement selectSizeError;

    @FindBy(xpath = "//div[@data-test-id='miniBagHeader']")
    private WebElement cartPopup;

    @FindBy(xpath = "//div[@class='product-gallery']")
    private WebElement photoGalleryOfProduct;

    @FindBy(xpath = "//section[@class='product-description']")
    private WebElement productDescriptionSection;

    @FindBy(xpath = "//button[@class='save-button']")
    private WebElement saveToWishlistButton;

    @FindBy(xpath = "//span[@class='product-colour']")
    private WebElement productColorTextField;

    @FindBy(xpath = " //div[@class='product-hero']")
    private WebElement productDetailsTextField;

    public double getOldPriceWithDiscount() {
        double price = Double.parseDouble(oldPrice.getText().replace("RRP £", ""));
        double discount = Double.parseDouble(discountPercent.getText().replace("%)", "").replace("(-", ""));
        return price - (price * (discount * 0.01));
    }

    public double getCurrentPrice() {
        return Double.parseDouble(currentPrice.getText().replace("£", ""));
    }

    public ProductPage selectProductSize() {
        Select selectProductSize = new Select(sizeSelect);
        selectProductSize.selectByIndex(1);
        return this;
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public boolean isEnabledSelectSizeError() {
        waitVisibilityOfElement(selectSizeError);
        return selectSizeError.isEnabled();
    }

    public boolean isEnabledCartPopup() {
        waitVisibilityOfElement(cartPopup);
        return cartPopup.isEnabled();
    }

    public String getProductsCountFromCart() {
        return cartPopup.getText();
    }

    public boolean isEnabledPhotoGalleryOfProduct() {
        return photoGalleryOfProduct.isEnabled();
    }

    public boolean isEnabledProductDescriptionSection() {
        return productDescriptionSection.isEnabled();
    }

    public boolean isEnabledSaveToWishlistButton() {
        return saveToWishlistButton.isEnabled();
    }

    public boolean isEnabledProductColorTextField() {
        return productColorTextField.isEnabled();
    }

    public boolean isEnabledSizeSelect() {
        return sizeSelect.isEnabled();
    }

    public boolean isEnabledProductDetailsTextField() {
        return productDetailsTextField.isEnabled();
    }
}