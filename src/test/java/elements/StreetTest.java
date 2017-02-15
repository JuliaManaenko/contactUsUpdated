package elements;

import customers.LeadDetails;
import customers.Leads;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testcase.TestBase2;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 20.01.2017.
 */
public class StreetTest extends TestBase2 {
    LeadDetails leadDetails;

    @Test(priority = 1)
    public void strEmptyValueClass() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getStreetInputClass(), PropertyLoader.loadProperty("inputClassValid2"));
    }

    @Test(priority = 2)
    public void streEmptyValueHighlight() throws InterruptedException {
        Assert.assertEquals(contactUs.getStreetInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 3, dataProvider = "street")
    public void strCorrectCharClass(String street) throws InterruptedException {
        driver.findElement(By.name("street")).clear();
        driver.findElement(By.name("street")).sendKeys(street);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getStreetInputClass(), PropertyLoader.loadProperty("inputClassValid"));
    }

    @Test(priority = 4, dataProvider = "street")
    public void strCorrectCharHighlight(String street) throws InterruptedException {
        driver.findElement(By.name("street")).clear();
        driver.findElement(By.name("street")).sendKeys(street);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getStreetInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 5, enabled = false)
    public void loginToDms() {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
    }

    @Test(priority = 6, dataProvider = "street")
    public void strCorrectCharinLead(String street) throws InterruptedException {
        Thread.sleep(2000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillEmail();
        contactUs.fillZip();
        contactUs.fillPhoneNum();
        driver.findElement(By.name("street")).clear();
        driver.findElement(By.name("street")).sendKeys(street);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        //  dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leadDetails = leads.openFirstLead();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getStreet(), street);
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @DataProvider(name = "street")
    public Object[][] getPhone() {
        return new Object[][]{{PropertyLoader.loadProperty("text1")},
                {PropertyLoader.loadProperty("text20")},
                {PropertyLoader.loadProperty("text50")},
                {PropertyLoader.loadProperty("textAll")}};
    }
}
