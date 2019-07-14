package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import java.lang.reflect.Method;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

/**
 * Created by val on 13.07.2019.
 */
public abstract class BaseTest {
    private final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private String driverPath = "D:/chromedriver/chromedriver.exe";

    @BeforeSuite
    public void initWebDriver() {
        browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", driverPath);
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);
        setWebDriver(driver);
    }

    @BeforeMethod()
    public void testStart(Method method) {
        logger.info(String.format("Test '%s' is started", method.getName()));
    }

    @AfterMethod()
    public void testEnd(Method method) {
        logger.info(String.format("Test '%s' is finished", method.getName()));
    }

    @AfterSuite()
    public void closeWebDriver() {
        WebDriverRunner.getWebDriver().quit();
    }
}