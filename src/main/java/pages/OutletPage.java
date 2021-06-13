package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OutletPage extends BasePage {
    private static final String DISCOUNT_XPATH = "//div[@class='_1MVUcS8']";

    public OutletPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='_3TqU78D']")
    private List<WebElement> listOfProducts;

    @FindBy(xpath = "//a[@class='_3TqU78D']")
    private WebElement firstProduct;

    public void moveToProductPage() {
        waitVisibilityOfElement(firstProduct);
        listOfProducts.get(0).click();
    }

    public boolean isDiscountEnabled(WebElement product) {
        return product.findElement(By.xpath(DISCOUNT_XPATH)).isEnabled();
    }

    public List<WebElement> getListOfProducts() {
        waitVisibilityOfElement(firstProduct);
        return listOfProducts;
    }
}