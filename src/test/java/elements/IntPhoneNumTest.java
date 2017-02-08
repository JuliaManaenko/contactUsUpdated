package elements;

import customers.LeadDetails;
import customers.Leads;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcase.TestBase2;
import utility.PropertyLoader;
import webdriver.WebDriverFactory;

import java.util.ArrayList;

/**
 * Created by Julia on 19.01.2017.
 */
public class IntPhoneNumTest extends TestBase2 {

    LeadDetails leadDetails;

    @Test(priority = 1)
    public void emptyValueClass() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        wait.until(jsLoad);
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getIntPhoneInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(priority = 2)
    public void emptyValueHighlight() throws InterruptedException {
        Assert.assertEquals(contactUs.getIntPhoneInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 12)
    public void emptyValueinLead() throws InterruptedException {
        wait.until(jsLoad);
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillEmail();
        contactUs.fillZip();
        contactUs.fillPhoneNum();
        driver.findElement(By.name("international_phone")).clear();
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
//        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        wait.until(jsLoad);
        Leads leads = dmsHome2.clickOnLeadsMenu();
        wait.until(jsLoad);
        leadDetails = leads.openFirstLead();
        wait.until(jsLoad);
        Thread.sleep(1000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        wait.until(jsLoad);
        Assert.assertEquals(leadDetails.getIntPhoneNum(), "");
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }

    @Test(priority = 3)
    public void oneCharClass() throws InterruptedException {
        driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone1"));
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getIntPhoneInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(priority = 4)
    public void oneCharHighlight() throws InterruptedException {
      /*  driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone1"));
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(1000);*/
        Assert.assertEquals(contactUs.getIntPhoneInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 13)
    public void oneCharinLead() throws InterruptedException {
        Thread.sleep(2000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        wait.until(jsLoad);
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillEmail();
        contactUs.fillZip();
        contactUs.fillPhoneNum();
        driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone1"));
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        wait.until(jsLoad);
        Leads leads = dmsHome2.clickOnLeadsMenu();
        wait.until(jsLoad);
        leadDetails = leads.openFirstLead();
        wait.until(jsLoad);
        Thread.sleep(1000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        wait.until(jsLoad);
        Assert.assertEquals(leadDetails.getIntPhoneNum(), PropertyLoader.loadProperty("intPhone1"));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }

    @Test(priority = 5)
    public void tenCharsClass() throws InterruptedException {
        driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone10"));
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getIntPhoneInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(priority = 6)
    public void tenCharsHighlight() {
        Assert.assertEquals(contactUs.getIntPhoneInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 14)
    public void tenCharsinLead() throws InterruptedException {
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        wait.until(jsLoad);
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillEmail();
        contactUs.fillZip();
        contactUs.fillPhoneNum();
        driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone10"));
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
        wait.until(jsLoad);
        Thread.sleep(1000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        wait.until(jsLoad);
        Assert.assertEquals(leadDetails.getIntPhoneNum(), PropertyLoader.loadProperty("intPhone10"));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }

    @Test(priority = 7)
    public void twentyCharsClass() throws InterruptedException {
        driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone20"));
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getIntPhoneInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(priority = 8)
    public void twentyCharsHighlight() {
        Assert.assertEquals(contactUs.getIntPhoneInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 15)
    public void twentyCharsinLead() throws InterruptedException {
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        wait.until(jsLoad);
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillEmail();
        contactUs.fillZip();
        contactUs.fillPhoneNum();
        driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone20"));
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        // dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        wait.until(jsLoad);
        Leads leads = dmsHome2.clickOnLeadsMenu();
        wait.until(jsLoad);
        leadDetails = leads.openFirstLead();
        wait.until(jsLoad);
        Thread.sleep(1000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        wait.until(jsLoad);
        Assert.assertEquals(leadDetails.getIntPhoneNum(), PropertyLoader.loadProperty("intPhone20"));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }

    @Test(priority = 9)
    public void twentyoneCharsClass() throws InterruptedException {
        driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone21"));
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getIntPhoneInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(priority = 10)
    public void twentyoneCharsHighlight() {
        Assert.assertEquals(contactUs.getIntPhoneInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 11)
    public void twentyoneCharsCut() {
        Assert.assertEquals(contactUs.intPhoneGetValue(), PropertyLoader.loadProperty("intPhone20"));
    }

    @Test(priority = 16)
    public void twentyoneCharsinLead() throws InterruptedException {
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        wait.until(jsLoad);
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillEmail();
        contactUs.fillZip();
        contactUs.fillPhoneNum();
        driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone21"));
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        // dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        wait.until(jsLoad);
        Leads leads = dmsHome2.clickOnLeadsMenu();
        wait.until(jsLoad);
        leadDetails = leads.openFirstLead();
        wait.until(jsLoad);
        Thread.sleep(1000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        wait.until(jsLoad);
        Assert.assertEquals(leadDetails.getIntPhoneNum(), PropertyLoader.loadProperty("intPhone20"));
    }
}
