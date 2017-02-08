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
import webmail.EmailDetails;
import webmail.EmailsList;
import webmail.WebmailLogin;

import java.util.ArrayList;

/**
 * Created by Julia on 20.01.2017.
 */
public class FirstNameTest extends TestBase2 {

    LeadDetails leadDetails;

    @Test(priority = 1)
    public void fEmptyValueClass() throws InterruptedException {
        //   driver.get(PropertyLoader.loadProperty("dws.url"));
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getFirstNameInputClass(), PropertyLoader.loadProperty("inputClassError"));
    }

    @Test(priority = 2)
    public void fEmptyValueHighlight() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getFirstNameInputBorderColor(), PropertyLoader.loadProperty("border_color_red2"));
    }

    @Test(priority = 3, dataProvider = "fName")
    public void fCorrectCharClass(String fName) throws InterruptedException {
        driver.findElement(By.name("first_name")).clear();
        driver.findElement(By.name("first_name")).sendKeys(fName);
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getFirstNameInputClass(), PropertyLoader.loadProperty("inputClassValid"));
    }

    @Test(priority = 4, dataProvider = "fName")
    public void fCorrectCharHighlight(String fName) throws InterruptedException {
        driver.findElement(By.name("first_name")).clear();
        driver.findElement(By.name("first_name")).sendKeys(fName);
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getFirstNameInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 5)
    public void fIncorrectCharClass() throws InterruptedException {
        driver.findElement(By.name("first_name")).clear();
        driver.findElement(By.name("first_name")).sendKeys(PropertyLoader.loadProperty("text31"));
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getFirstNameInputClass(), PropertyLoader.loadProperty("inputClassError"));
    }

    @Test(priority = 6, enabled = false)
    public void loginToDms() {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
    }

    @Test(priority = 7, dataProvider = "fName")
    public void fCorrectCharinLead(String fName) throws InterruptedException {
        Thread.sleep(2000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        wait.until(jsLoad);
        contactUs.fillLastName();
        contactUs.fillEmail();
        contactUs.fillZip();
        contactUs.fillPhoneNum();
        driver.findElement(By.name("first_name")).clear();
        driver.findElement(By.name("first_name")).sendKeys(fName);
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        //  dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        wait.until(jsLoad);
        Leads leads = dmsHome2.clickOnLeadsMenu();
        wait.until(jsLoad);
        leadDetails = leads.openFirstLead();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        wait.until(jsLoad);
        Assert.assertEquals(leadDetails.getFirstName(), fName);
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }



    @DataProvider(name = "fName")
    public Object[][] getPhone() {
        return new Object[][]{{PropertyLoader.loadProperty("text1")},
                {PropertyLoader.loadProperty("text20")},
                {PropertyLoader.loadProperty("textAll")}};
    }
}
