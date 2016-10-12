package test.integration;

import java.util.List;
import org.junit.*;
import org.openqa.selenium.*;

/**
 * Base test for ALMSourceDrivenDev/Example-Dev-Workspace UI tests.
 */
public class IntegrationTest extends BaseSalesforceTest {
    @Test
    public void testIntegration() {
        
       final String pageSrc = this.login("/one/one.app");
       WebElement e = this.fluentWait(new By.ByCssSelector(".oneContent h2"));
       Assert.assertTrue("One.app was not loaded", e.isDisplayed());		

    //    final String pageSrc = this.login("/one/one.app#/sObject/Property__c/home");
    //    ((JavascriptExecutor) driver).executeScript("window.location.hash='#/sObject/Property__c/home'");
    //    this.fluentWait(By.linkText("Contemporary Luxury")).click();
    //    Assert.assertTrue(this.fluentWait(By.xpath("//*[contains(text(), 'Contemporary Luxury')]")).isDisplayed());
    //    WebElement e = this.driver.findElement(By.xpath("//span[contains(text(), 'IQ Picture Uploader')]"));        
    //    Assert.assertTrue("IQ Compontent was not loaded", e.isDisplayed());
    }
}
