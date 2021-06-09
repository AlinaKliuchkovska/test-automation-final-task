package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class OutletPage extends BasePage {
    private static final String discount = "//div[@class='_1MVUcS8']";

    public OutletPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@aria-haspopup='listbox']")
    private WebElement sortButton;

    @FindBy(xpath = "//li[@id='plp_web_sort_price_high_to_low']")
    private WebElement sortPriceHighToLowButton;

    @FindBy(xpath = "//a[@class='_3TqU78D']")
    private List<WebElement> listOfProducts;

    @FindBy(xpath = "//span[@data-auto-id='productTileSaleAmount']")
    private List<WebElement> listOfProductsPrices;

    @FindBy(xpath = "//a[@data-auto-id='loadMoreProducts']")
    private WebElement loadMoreButton;

    @FindBy(xpath = "//span[@data-auto-id='productTileSaleAmount']")
    private WebElement firstProductPrice;

    @FindBy(xpath = "//article[last()]//span[@data-auto-id='productTileSaleAmount']")
    private WebElement lastProductPrice;

    public void setSearchType() {
        waitElementToBeClickable(sortButton);
        sortButton.click();
        sortPriceHighToLowButton.click();
        waitElementToBeClickable(lastProductPrice);
    }

    public void moveToProductPage() {
        waitVisibilityOfElement(listOfProducts.get(0));
        listOfProducts.get(0).click();
    }

    public boolean isDiscountEnabled(WebElement product) {
        return product.findElement(By.xpath(discount)).isEnabled();
    }

    public List<WebElement> getListOfProducts() {
        return listOfProducts;
    }

    public List<String> getListOfProductsPrices() {
        waitVisibilityOfElement(firstProductPrice);
        List<String> pricesOfElements = new ArrayList<>();
        for (WebElement price : listOfProductsPrices) {
            waitElementToBeClickable(price);
            pricesOfElements.add(price.getText().replace("£", ""));

        }
        return pricesOfElements;
    }
}