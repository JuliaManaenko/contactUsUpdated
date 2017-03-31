package contactUsForm;

import customers.LeadDetails;
import customers.Leads;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import settings.Localization;
import settings.Website;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 12.01.2017.
 */
public class PhoneNumTest extends TestBase3 {

    WebDriverWait wait;
    LeadDetails leadDetails;

    /*check if filled phone number is like in phone input mask*/
    @Test(dataProvider = "phones", priority = 1)
    public void inputMaskCheck(String inputMask, String phone) throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        localization.turnOnForceValid();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        //fill phone input mask, it get not via page objects for using data provider
        driver.findElement(By.xpath("//tr[@id='localization_phone_mask_input']//a[@class='button-style b_edit notranslate']")).click();
        driver.findElement(By.xpath("//tr[@id='localization_phone_mask_input']//input")).clear();
        driver.findElement(By.xpath("//tr[@id='localization_phone_mask_input']//input")).sendKeys(inputMask); //'inputMask' variable is from datap rovider
        driver.findElement(By.xpath("//tr[@id='localization_phone_mask_input']//a[@class='button-style b_save']")).click();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillEmail();
        formsPage.fillZip();
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(phone);//'phone' variable is from data provider
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leadDetails = leads.openFirstLead();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getPhoneNum(), phone); //'phone' variable is from data provider
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    /*input css class should be 'error' if put phones that are not matches for phone input mask*/
    @Test(dataProvider = "incorrectPhones", priority = 2)
    public void incorretPhoneTest(String inputMask, String phone) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 10);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        localization.turnOnForceValid();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        //fill phone input mask, it get not via page objects for using data provider
        driver.findElement(By.xpath("//tr[@id='localization_phone_mask_input']//a[@class='button-style b_edit notranslate']")).click();
        driver.findElement(By.xpath("//tr[@id='localization_phone_mask_input']//input")).clear();
        driver.findElement(By.xpath("//tr[@id='localization_phone_mask_input']//input")).sendKeys(inputMask); //'inputMask' variable is from datap rovider
        driver.findElement(By.xpath("//tr[@id='localization_phone_mask_input']//a[@class='button-style b_save']")).click();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillEmail();
        formsPage.fillZip();
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(phone);//'phone' variable is from data provider
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(3000);
        Assert.assertEquals(formsPage.getPhoneNumInputClass(), "form-control text-uppercase error");
    }


    //input higlight should be red if put phones that are not matches for phone input mask
    @Test(dataProvider = "incorrectPhones", priority = 3)
    public void incorretPhoneHighlight(String inputMask, String phone) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 10);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        localization.turnOnForceValid();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        //fill phone input mask, it get not via page objects for using data provider
        driver.findElement(By.xpath("//tr[@id='localization_phone_mask_input']//a[@class='button-style b_edit notranslate']")).click();
        driver.findElement(By.xpath("//tr[@id='localization_phone_mask_input']//input")).clear();
        driver.findElement(By.xpath("//tr[@id='localization_phone_mask_input']//input")).sendKeys(inputMask); //'inputMask' variable is from datap rovider
        driver.findElement(By.xpath("//tr[@id='localization_phone_mask_input']//a[@class='button-style b_save']")).click();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillEmail();
        formsPage.fillZip();
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(phone);//'phone' variable is from data provider
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(3000);
        Assert.assertEquals(formsPage.getPhoneNumInputBorderColor(), "rgb(132, 53, 52)");
    }

    /*All symbols should be accepted if turn off ForceValidation in settings*/
    @Test(priority = 4)
    public void forceValidOffClass() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 10);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        localization.turnOffForceValid();
        waitForJSandJQueryToLoad();
        Thread.sleep(1500);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(PropertyLoader.loadProperty("phoneAll"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(formsPage.getPhoneNumInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 5)
    public void forceValidOffHighlight() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 10);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1500);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        localization.turnOffForceValid();
        waitForJSandJQueryToLoad();
        Thread.sleep(1500);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(PropertyLoader.loadProperty("phoneAll"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(formsPage.getPhoneNumInputClass(), "form-control text-uppercase valid");
    }

    @Test(priority = 6)
    public void forceValidOffLead() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 10);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        localization.turnOffForceValid();
        waitForJSandJQueryToLoad();
        Thread.sleep(1500);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillEmail();
        formsPage.fillZip();
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(PropertyLoader.loadProperty("phoneAll"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leadDetails = leads.openFirstLead();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getPhoneNum(), PropertyLoader.loadProperty("phoneAll"));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }


    /*1st element - phone input mask (diff variants), 2nd element - phone number in form and lead details*/
    @DataProvider(name = "phones")
    public Object[][] getPhone() {
        return new Object[][]{{PropertyLoader.loadProperty("inputMaskL1"), PropertyLoader.loadProperty("phoneL1")},
                {PropertyLoader.loadProperty("inputMaskL2"), PropertyLoader.loadProperty("phoneL2")},
                {PropertyLoader.loadProperty("inputMaskN1"), PropertyLoader.loadProperty("phoneN1")},
                {PropertyLoader.loadProperty("inputMaskN2"), PropertyLoader.loadProperty("phoneN2")},
                {PropertyLoader.loadProperty("inputMaskS1"), PropertyLoader.loadProperty("phoneS1")},
                {PropertyLoader.loadProperty("inputMaskS2"), PropertyLoader.loadProperty("phoneS2")},
                {PropertyLoader.loadProperty("inputMaskNLS1"), PropertyLoader.loadProperty("phoneNLS1")},
                {PropertyLoader.loadProperty("inputMaskNLS2"), PropertyLoader.loadProperty("phoneNLS2")},
                {PropertyLoader.loadProperty("inputMaskLSN1"), PropertyLoader.loadProperty("phoneLSN1")},
                {PropertyLoader.loadProperty("inputMaskLSN2"), PropertyLoader.loadProperty("phoneLSN2")},
                {PropertyLoader.loadProperty("inputMaskMix1"), PropertyLoader.loadProperty("phoneMix1")},
                {PropertyLoader.loadProperty("inputMaskMix2"), PropertyLoader.loadProperty("phoneMix2")}};
    }

    @DataProvider(name = "incorrectPhones")
    public Object[][] getIncorrectPhone() {
        return new Object[][]{{PropertyLoader.loadProperty("inputMaskL1"), PropertyLoader.loadProperty("phoneMix1")},
                {PropertyLoader.loadProperty("inputMaskL2"), PropertyLoader.loadProperty("phoneLSN2")},
                {PropertyLoader.loadProperty("inputMaskN1"), PropertyLoader.loadProperty("phoneL2")},
                {PropertyLoader.loadProperty("inputMaskN2"), PropertyLoader.loadProperty("phoneS2")},
                {PropertyLoader.loadProperty("inputMaskNLS1"), PropertyLoader.loadProperty("phoneS1")},
                {PropertyLoader.loadProperty("inputMaskNLS2"), PropertyLoader.loadProperty("phoneLSN1")},
                {PropertyLoader.loadProperty("inputMaskLSN1"), PropertyLoader.loadProperty("phoneNLS2")},
                {PropertyLoader.loadProperty("inputMaskLSN2"), PropertyLoader.loadProperty("phoneL2")},
                {PropertyLoader.loadProperty("inputMaskMix1"), PropertyLoader.loadProperty("phoneL1")},
                {PropertyLoader.loadProperty("inputMaskMix2"), PropertyLoader.loadProperty("phoneN1")}};
    }
}
