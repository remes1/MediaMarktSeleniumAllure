package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constants.URLs.URL;

public class SearchTest extends BaseTest {

    @Test
    public void openMediaMarktTest() {
        basePage.goToUrl(URL);
    }

    @Test
    public void doSearchTest() {
        basePage.goToUrl(URL);
        homePage.enterTextInInputField("Notebooks");
        homePage.clickOnLoupe();
        Assertions.assertTrue(homePage.areElementsPresent());
    }
}