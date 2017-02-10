package elements;

import customers.LeadDetails;
import customers.Leads;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcase.TestBase2;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 01.02.2017.
 */
public class EmailInLead extends TestBase2 {

    @Test
    public void checkEmailInLead() throws InterruptedException {
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillZip();
        contactUs.fillEmail2();
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getEmail(), PropertyLoader.loadProperty("Email1"));
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
        Thread.sleep(1000);
    }
}
