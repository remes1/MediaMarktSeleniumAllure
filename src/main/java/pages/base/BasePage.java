package pages.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static constants.Constants.TimeoutVariables.EXPLICIT_WAIT;

public class BasePage {

    WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(BasePage.class);

    @FindBy(xpath = "//div[@id='privacy-layer__wrapper']//form")
    private WebElement cookiesPopup;

    @FindBy(xpath = "//button[@id='privacy-layer-accept-all-button']")
    private WebElement acceptAllCookiesButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigating to specific url and accept Cookie Popup
     */

    public void goToUrl(String url) {
        LOGGER.info("Open URL -> " + url);
        driver.get(url);
        if (isElementVisible(cookiesPopup))
            clickOnElement(acceptAllCookiesButton);
    }

    /**
     * Wait for visibility of element in DOM model
     */

    private WebElement waitUntilElementIsVisible(WebElement element) {
        LOGGER.info("Wait until element is visible -> " + element);
        return new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait for element to be clickable
     */

    private WebElement waitUntilElementIsClickable(WebElement element) {
        LOGGER.info("Wait until element is clickable -> " + element);
        return new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Get the size of the list of elements
     */

    public int getSizeOfListElements(List<WebElement> elements) {
        LOGGER.info("Get size of elements -> " + elements.size());
        return elements.size();
    }

    /**
     * Click on Button
     */

    protected void clickOnElement(WebElement element) {
        LOGGER.info("Click on element -> " + element);
        waitUntilElementIsClickable(element).click();
    }

    protected boolean isElementVisible(WebElement element) {
        LOGGER.info("Element is visible -> " + element);
        return element.isDisplayed();
    }

    /**
     * Enter text in the input field
     */
    protected void typeText(WebElement element, String text) {
        waitUntilElementIsVisible(element);
        element.clear();
        LOGGER.info("Type text " + text + " in input -> " + element);
        element.sendKeys(text);
    }

    /**
     * Get Text from element
     */
    protected String getTextFromElement(WebElement element) {
        LOGGER.info("Get text from element -> " + element);
        return waitUntilElementIsVisible(element).getText();
    }
}
