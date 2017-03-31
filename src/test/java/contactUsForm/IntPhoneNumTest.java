package contactUsForm;

import customers.LeadDetails;
import customers.Leads;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 19.01.2017.
 */
public class IntPhoneNumTest extends TestBase2 {

    private LeadDetails leadDetails;

    @Test(priority = 1)
    public void emptyValueClass() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(formsPage.getIntPhoneInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(priority = 2)
    public void emptyValueHighlight() throws InterruptedException {
        Assert.assertEquals(formsPage.getIntPhoneInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 12)
    public void emptyValueinLead() throws InterruptedException {
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillEmail();
        formsPage.fillZip();
        formsPage.fillPhoneNum();
        driver.findElement(By.name("international_phone")).clear();
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
//        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getIntPhoneNum(), "");
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void oneCharClass() throws InterruptedException {
        driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone1"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(formsPage.getIntPhoneInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(priority = 4)
    public void oneCharHighlight() throws InterruptedException {
      /*  driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone1"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);*/
        Assert.assertEquals(formsPage.getIntPhoneInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 13)
    public void oneCharinLead() throws InterruptedException {
        Thread.sleep(2000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillEmail();
        formsPage.fillZip();
        formsPage.fillPhoneNum();
        driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone1"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getIntPhoneNum(), PropertyLoader.loadProperty("intPhone1"));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 5)
    public void tenCharsClass() throws InterruptedException {
        driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone10"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(formsPage.getIntPhoneInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(priority = 6)
    public void tenCharsHighlight() {
        Assert.assertEquals(formsPage.getIntPhoneInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 14)
    public void tenCharsinLead() throws InterruptedException {
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillEmail();
        formsPage.fillZip();
        formsPage.fillPhoneNum();
        driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone10"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        //  dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getIntPhoneNum(), PropertyLoader.loadProperty("intPhone10"));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 7)
    public void twentyCharsClass() throws InterruptedException {
        driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone20"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(formsPage.getIntPhoneInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(priority = 8)
    public void twentyCharsHighlight() {
        Assert.assertEquals(formsPage.getIntPhoneInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 15)
    public void twentyCharsinLead() throws InterruptedException {
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillEmail();
        formsPage.fillZip();
        formsPage.fillPhoneNum();
        driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone20"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        // dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getIntPhoneNum(), PropertyLoader.loadProperty("intPhone20"));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 9)
    public void twentyoneCharsClass() throws InterruptedException {
        driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone21"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(formsPage.getIntPhoneInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(priority = 10)
    public void twentyoneCharsHighlight() {
        Assert.assertEquals(formsPage.getIntPhoneInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 11)
    public void twentyoneCharsCut() {
        Assert.assertEquals(formsPage.intPhoneGetValue(), PropertyLoader.loadProperty("intPhone20"));
    }

    @Test(priority = 16)
    public void twentyoneCharsinLead() throws InterruptedException {
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillEmail();
        formsPage.fillZip();
        formsPage.fillPhoneNum();
        driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(PropertyLoader.loadProperty("intPhone21"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        // dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getIntPhoneNum(), PropertyLoader.loadProperty("intPhone20"));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }
}
