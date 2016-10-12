package test.integration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.base.Function;
import org.openqa.selenium.support.ui.*;

/**
 * Base test for ALMSourceDrivenDev/Example-Dev-Workspace UI tests.
 */
public class BaseSalesforceTest {
    private static final String DEFAULT_SELENIUM_URL = "http://127.0.0.1:4444/wd/hub";

    protected WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("version", "43.0");

        driver = new RemoteWebDriver(new URL(DEFAULT_SELENIUM_URL), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected String login() {
        return login(null);
    }
    protected String login(String retUrl) {
        String instanceUrl = getProperty("SALESFORCE_INSTANCE_URL");
        String accessToken = getProperty("SALESFORCE_ACCESS_TOKEN");

        String frontDoorUrl = String.format("%s/secur/frontdoor.jsp?sid=%s", instanceUrl, accessToken);

        if (retUrl != null) {
            frontDoorUrl += ("&retURL=" + retUrl);
        }

        System.out.println();
        System.out.println(frontDoorUrl);
        System.out.println();

        driver.get(frontDoorUrl);
        return driver.getPageSource();
    }

    public WebElement fluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(5, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return foo;
    };

    private String getProperty(String name) {
        String prop = System.getProperty(name);

        if (isEmpty(prop)) {
            prop = System.getenv(name);
        }

        if (isEmpty(prop)) {
            throw new IllegalArgumentException("Property '" + name + "' not provided.");
        }

        return prop;
    }

    protected boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }
}
