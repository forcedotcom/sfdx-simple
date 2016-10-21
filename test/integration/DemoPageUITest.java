package integration;

import java.util.List;
import org.junit.*;
import org.openqa.selenium.*;

/**
 * UI test.
 */
public class DemoPageUITest extends BaseSalesforceTest {
    @Test
    public void testIntegration() {
       login("/apex/DemoPage?LastName=Testalot");
       WebElement e = driver.findElement(new By.ByCssSelector(".lastName"));
       Assert.assertEquals("Testalot", e.getAttribute("value"));
    }
}
