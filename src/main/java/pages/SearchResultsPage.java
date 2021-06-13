package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[contains(text(),'NOTHING MATCHES')]")
    private WebElement nothingMatchesTextField;

    @FindBy(xpath = "//article[@class='_2qG85dG']")
    private List<WebElement> listOfSearchResults;

    @FindBy(xpath = "//article[@class='_2qG85dG']")
    private WebElement firstSearchResult;

    public boolean isEnabledNothingMatchesTextField() {
        waitVisibilityOfElement(nothingMatchesTextField);
        return nothingMatchesTextField.isEnabled();
    }

    public List<WebElement> getListOfSearchResults() {
        waitVisibilityOfElement(firstSearchResult);
        return listOfSearchResults;
    }

    public String getTextFromNothingMatchesTextField() {
        return nothingMatchesTextField.getText();
    }
}