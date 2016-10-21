package integration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.google.common.base.Function;
import org.openqa.selenium.support.ui.*;

/**
 * Base test for ALMSourceDrivenDev/Example-Dev-Workspace UI tests.
 */
public class BaseSalesforceTest {
    protected WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        TestUtil.setupPhantom();
        driver = new PhantomJSDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void login() {
        login(null);
    }

    protected void login(String retUrl) {
        String instanceUrl = TestUtil.getProperty("SALESFORCE_INSTANCE_URL");
        String accessToken = TestUtil.getProperty("SALESFORCE_ACCESS_TOKEN");

        String frontDoorUrl = String.format("%s/secur/frontdoor.jsp?sid=%s", instanceUrl, accessToken);

        if (retUrl != null) {
            frontDoorUrl += ("&retURL=" + retUrl);
        }

        System.out.println();
        System.out.println(frontDoorUrl);
        System.out.println();

        driver.get(frontDoorUrl);
    }

    // public WebElement fluentWait(final By locator) {
    //     Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
    //             .withTimeout(5, TimeUnit.SECONDS)
    //             .pollingEvery(1, TimeUnit.SECONDS)
    //             .ignoring(NoSuchElementException.class);
    //
    //     WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
    //         @Override
    //         public WebElement apply(WebDriver driver) {
    //             return driver.findElement(locator);
    //         }
    //     });
    //
    //     return foo;
    // };
}
