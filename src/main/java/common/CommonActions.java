package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static constants.Constants.TimeoutVariables.PAGE_LOAD_WAIT;

public class CommonActions {
    private static final Logger LOGGER = LogManager.getLogger(CommonActions.class);
    private static final String BROWSER = System.getProperty("browser");

    public static WebDriver createDriver() {
        WebDriver driver = null;

        if (BROWSER.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (BROWSER.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        LOGGER.info("Maximize the browser");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(PAGE_LOAD_WAIT, TimeUnit.SECONDS);
        return driver;
    }
}
