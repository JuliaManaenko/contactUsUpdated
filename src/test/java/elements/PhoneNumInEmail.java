package elements;

import customers.Leads;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import settings.Localization;
import settings.Website;
import testcase.TestBase5;
import utility.PropertyLoader;
import webmail.EmailDetails;
import webmail.EmailsList;
import webmail.WebmailLogin;

import java.util.ArrayList;

/**
 * Created by Julia on 07.02.2017.
 */
public class PhoneNumInEmail extends TestBase5 {

    @AfterMethod
    public void setInputMaskDefault() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
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
        localization.fillInputMaskStar1();
        Thread.sleep(2000);
       // driver.manage().deleteAllCookies();
    }

    @Test(dataProvider = "phones")
    public void inputMaskCheck(String inputMask, String phone) throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1500);
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
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillEmail();
        contactUs.fillZip();
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(phone);//'phone' variable is from data provider
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getPhone(), phone);
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test
    public void forceValidOffInEmail() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 10);
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Website website = dmsHome2.clickOnWebsiteMenu2();
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
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillEmail();
        contactUs.fillZip();
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(PropertyLoader.loadProperty("phoneAll"));
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList =  dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getPhone(), PropertyLoader.loadProperty("phoneAll"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
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
}
