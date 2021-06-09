package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}