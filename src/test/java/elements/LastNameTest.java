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
public class LastNameTest extends TestBase2 {
    LeadDetails leadDetails;

    @Test(priority = 1)
    public void lEmptyValueClass() throws InterruptedException {
        //   driver.get(PropertyLoader.loadProperty("dws.url"));
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getLastNameInputClass(), PropertyLoader.loadProperty("inputClassError"));
    }

    @Test(priority = 2)
    public void lEmptyValueHighlight() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getLastNameInputBorderColor(), PropertyLoader.loadProperty("border_color_red"));
    }

    @Test(priority = 3, dataProvider = "lName")
    public void lCorrectCharClass(String lName) throws InterruptedException {
        driver.findElement(By.name("last_name")).clear();
        driver.findElement(By.name("last_name")).sendKeys(lName);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getLastNameInputClass(), PropertyLoader.loadProperty("inputClassValid"));
    }

    @Test(priority = 4, dataProvider = "lName")
    public void lCorrectCharHighlight(String lName) throws InterruptedException {
        driver.findElement(By.name("last_name")).clear();
        driver.findElement(By.name("last_name")).sendKeys(lName);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getLastNameInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 5)
    public void lIncorrectCharClass() throws InterruptedException {
        driver.findElement(By.name("last_name")).clear();
        driver.findElement(By.name("last_name")).sendKeys(PropertyLoader.loadProperty("text31"));
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getLastNameInputClass(), PropertyLoader.loadProperty("inputClassError"));
    }

    @Test(priority = 6, enabled = false)
    public void loginToDms() {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
    }

    @Test(priority = 7, dataProvider = "lName")
    public void lCorrectCharinLead(String lName) throws InterruptedException {
        Thread.sleep(2000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillEmail();
        contactUs.fillZip();
        contactUs.fillPhoneNum();
        driver.findElement(By.name("last_name")).clear();
        driver.findElement(By.name("last_name")).sendKeys(lName);
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
        Assert.assertEquals(leadDetails.getLastName(), lName);
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @DataProvider(name = "lName")
    public Object[][] getPhone() {
        return new Object[][]{{PropertyLoader.loadProperty("text1")},
                {PropertyLoader.loadProperty("text20")},
                {PropertyLoader.loadProperty("textAll")}};
    }
}
