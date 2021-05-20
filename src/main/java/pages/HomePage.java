package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//input[@id='search-form'])[1]")
    private WebElement searchInput;

    @FindBy(xpath = "//h1")
    private WebElement header;

    @FindBy(xpath = "(//button[@aria-label='Search'])[1]")
    private WebElement lupeButton;

    @FindBy(xpath = "//div[@data-test='mms-search-srp-productlist-item']")
    private List<WebElement> productList;

    public void enterTextInInputField(String searchItem) {
        typeText(searchInput, searchItem);
    }

    public String getTextFromHeaderElement() {
        return getTextFromElement(header);
    }

    public void clickOnLoupe() {
        clickOnElement(lupeButton);
    }

    public boolean areElementsPresent() {
        int i = getSizeOfListElements(productList);
        return i > 0;
    }
}
