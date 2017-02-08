package leadsCRM;

import customers.LeadDetails;
import customers.Leads;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcase.TestBase2;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 11.01.2017.
 */
public class TestLead extends TestBase2 {

    WebDriverWait wait;
    LeadDetails leadDetails;

    @Test(priority = 1)
    public void checkFirstNameValue() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        contactUs.fillZip();
        contactUs.clickOnSubmit();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait.until(jsLoad);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        wait.until(jsLoad);
        Leads leads = dmsHome2.clickOnLeadsMenu();
        wait.until(jsLoad);
        leadDetails = leads.openFirstLead();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        wait.until(jsLoad);
        Assert.assertEquals(leadDetails.getFirstName(), "John");
    }

    @Test(priority = 2)
    public void checkLastNameValue() {
        Assert.assertEquals(leadDetails.getLastName(), "Smith");
    }

    @Test(priority = 3)
    public void checkPhoneNumValue() {
        Assert.assertEquals(leadDetails.getPhoneNum(), "9587 123 698");
    }

    @Test(priority = 4)
    public void checkEmailValue() {
        Assert.assertEquals(leadDetails.getEmail(), "test_2@dxloo.com");
    }

    @Test(priority = 5)
    public void checkZipValue() {
        Assert.assertEquals(leadDetails.getZip(), "100001");
    }

    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        }
    };
}
