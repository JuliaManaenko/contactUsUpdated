package elements;

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
import testcase.TestBase5;
import utility.PropertyLoader;
import webmail.EmailDetails;
import webmail.EmailsList;
import webmail.WebmailLogin;

import java.util.ArrayList;

/**
 * Created by Julia on 07.02.2017.
 */
public class ZipInEmail extends TestBase5 {
    WebDriverWait wait;
    private dms.dmsHome2 dmsHome2;

    @Test(priority = 1)
    public void setZipN3() throws InterruptedException {
        wait = new WebDriverWait(driver, 20);
        // dmsHome2 = dmsHome.loginToDms();
        // waitForJSandJQueryToLoad();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        localization.allowNumZip();
        waitForJSandJQueryToLoad();
        // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isLetterZipEditBtnVisible());
        localization.setMinZip3();
        waitForJSandJQueryToLoad();
        //  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isMinNumZipEditBtnVisible());
        localization.fillInputMaskNum1();
        waitForJSandJQueryToLoad();
        //  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_phone_mask_input']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isPhoneInputMaskEditBtnVisible());
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipN3", priority = 2)
    public void correctZipN3inEmail(String zip1, String zip2) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip1);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        //dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
       /* emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip2);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void cutZipN3inEmail() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(PropertyLoader.loadProperty("zipN7"));
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
       // dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
      /*  emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), PropertyLoader.loadProperty("zipN6"));
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 4)
    public void setZipN4() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        localization.allowNumZip();
        waitForJSandJQueryToLoad();
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isLetterZipEditBtnVisible());
        localization.setMinZip4();
        waitForJSandJQueryToLoad();
        // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isMinNumZipEditBtnVisible());
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipN4", priority = 5)
    public void correctZipN4inEmail(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        //dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 6)
    public void cutZipN4inEmail() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(PropertyLoader.loadProperty("zipN7"));
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
       // dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
       /* emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), PropertyLoader.loadProperty("zipN6"));
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 7)
    public void setZipN5() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1500);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        localization.allowNumZip();
        waitForJSandJQueryToLoad();
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isLetterZipEditBtnVisible());
        localization.setMinZip5();
        waitForJSandJQueryToLoad();
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isMinNumZipEditBtnVisible());
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipN5", priority = 8)
    public void correctZipN5inEmail(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
       // dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
      /*  emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 9)
    public void cutZipN5inEmail() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(PropertyLoader.loadProperty("zipN7"));
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        //dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
       /* emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), PropertyLoader.loadProperty("zipN6"));
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 10)
    public void setZipN6() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        localization.allowNumZip();
        waitForJSandJQueryToLoad();
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isLetterZipEditBtnVisible());
        localization.setMinZip6();
        waitForJSandJQueryToLoad();
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isMinNumZipEditBtnVisible());
        Thread.sleep(1000);
    }

    @Test(priority = 11)
    public void correctZipN6inEmail() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(PropertyLoader.loadProperty("zipN6"));
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        //dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
     /*   emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), PropertyLoader.loadProperty("zipN6"));
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 12)
    public void cutZipN6inEmail() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(PropertyLoader.loadProperty("zipN7"));
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
       // dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
       /* emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), PropertyLoader.loadProperty("zipN6"));
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 13)
    public void setZipL3() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        localization.allowCharNumZip();
        waitForJSandJQueryToLoad();
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isLetterZipEditBtnVisible());
        localization.setMinZip3();
        waitForJSandJQueryToLoad();
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isMinNumZipEditBtnVisible());
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipL3", priority = 14)
    public void correctZipL3inEmail(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
       // dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
       /* emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "Zip7", priority = 15)
    public void cutZipL3inEmail(String zip7, String zip6) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip7);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
       // dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
       /* emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip6);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 16)
    public void setZipL4() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        localization.allowCharNumZip();
        waitForJSandJQueryToLoad();
        // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isLetterZipEditBtnVisible());
        localization.setMinZip4();
        waitForJSandJQueryToLoad();
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isMinNumZipEditBtnVisible());
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipL4", priority = 17)
    public void correctZipL4inEmail(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
       // dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "Zip7", priority = 18)
    public void cutZipL4inEmail(String zip7, String zip6) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip7);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        //dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
       /* emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip6);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 19)
    public void setZipL5() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        localization.allowCharNumZip();
        waitForJSandJQueryToLoad();
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isLetterZipEditBtnVisible());
        localization.setMinZip5();
        waitForJSandJQueryToLoad();
        // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isMinNumZipEditBtnVisible());
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipL5", priority = 20)
    public void correctZipL5inEmail(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
       // dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
       /* emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "Zip7", priority = 21)
    public void cutZipL5inEmail(String zip7, String zip6) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip7);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
      //  dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
      /*  emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip6);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(priority = 22)
    public void setZipL6() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        localization.allowCharNumZip();
        waitForJSandJQueryToLoad();
        // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isLetterZipEditBtnVisible());
        localization.setMinZip6();
        waitForJSandJQueryToLoad();
        // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isMinNumZipEditBtnVisible());
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipL6", priority = 23)
    public void correctZipL6inEmail(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
       // dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
       /* emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "Zip7", priority = 24)
    public void cutZipL6inEmail(String zip7, String zip6) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip7);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
       // dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
       /* emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip6);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @DataProvider(name = "zipN3")
    private Object[][] putZipN3() {
        return new Object[][]{{PropertyLoader.loadProperty("zipN3"), PropertyLoader.loadProperty("zipN3")},
                {PropertyLoader.loadProperty("zipN4"), PropertyLoader.loadProperty("zipN4")},
                {PropertyLoader.loadProperty("zipN5"), PropertyLoader.loadProperty("zipN5")},
                {PropertyLoader.loadProperty("zipN6"), PropertyLoader.loadProperty("zipN6")}};
    }

    @DataProvider(name = "zipN4")
    private Object[][] putZipN4() {
        return new Object[][]{{PropertyLoader.loadProperty("zipN4")},
                {PropertyLoader.loadProperty("zipN5")},
                {PropertyLoader.loadProperty("zipN6")}};
    }

    @DataProvider(name = "zipN5")
    private Object[][] putZipN5() {
        return new Object[][]{{PropertyLoader.loadProperty("zipN5")},
                {PropertyLoader.loadProperty("zipN6")}};
    }

    @DataProvider(name = "zipL3")
    private Object[][] putZipL3() {
        return new Object[][]{{PropertyLoader.loadProperty("zipL3")},
                {PropertyLoader.loadProperty("zipL4")},
                {PropertyLoader.loadProperty("zipL5")},
                {PropertyLoader.loadProperty("zipL6")},
                {PropertyLoader.loadProperty("zipM3")},
                {PropertyLoader.loadProperty("zipM4")},
                {PropertyLoader.loadProperty("zipM5")},
                {PropertyLoader.loadProperty("zipM6")},
                {PropertyLoader.loadProperty("zipN3")},
                {PropertyLoader.loadProperty("zipN4")},
                {PropertyLoader.loadProperty("zipN5")},
                {PropertyLoader.loadProperty("zipN6")}};
    }

    @DataProvider(name = "zipL4")
    private Object[][] putZipL4() {
        return new Object[][]{{PropertyLoader.loadProperty("zipL4")},
                {PropertyLoader.loadProperty("zipL5")},
                {PropertyLoader.loadProperty("zipL6")},
                {PropertyLoader.loadProperty("zipM4")},
                {PropertyLoader.loadProperty("zipM5")},
                {PropertyLoader.loadProperty("zipM6")},
                {PropertyLoader.loadProperty("zipN4")},
                {PropertyLoader.loadProperty("zipN5")},
                {PropertyLoader.loadProperty("zipN6")}};
    }

    @DataProvider(name = "zipL5")
    private Object[][] putZipL5() {
        return new Object[][]{{PropertyLoader.loadProperty("zipL5")},
                {PropertyLoader.loadProperty("zipL6")},
                {PropertyLoader.loadProperty("zipM5")},
                {PropertyLoader.loadProperty("zipM6")},
                {PropertyLoader.loadProperty("zipN5")},
                {PropertyLoader.loadProperty("zipN6")}};
    }

    @DataProvider(name = "zipL6")
    private Object[][] putZipL6() {
        return new Object[][]{{PropertyLoader.loadProperty("zipL6")},
                {PropertyLoader.loadProperty("zipM6")},
                {PropertyLoader.loadProperty("zipN6")}};
    }

    @DataProvider(name = "Zip7")
    public Object[][] zip7() {
        return new Object[][]{{PropertyLoader.loadProperty("zipN7"), PropertyLoader.loadProperty("zipN6")},
                {PropertyLoader.loadProperty("zipL7"), PropertyLoader.loadProperty("zipL6")},
                {PropertyLoader.loadProperty("zipM7"), PropertyLoader.loadProperty("zipM6")}};
    }
}
