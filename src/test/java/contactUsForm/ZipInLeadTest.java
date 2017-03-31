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
 * Created by Julia on 24.01.2017.
 */
public class ZipInLeadTest extends TestBase4 {

    WebDriverWait wait;

   /* private void loginToDms(){
        wait = new WebDriverWait(driver, 10);
        dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
    }*/

    @Test(priority = 1)
    public void setZipN3() throws InterruptedException {
        wait = new WebDriverWait(driver, 20);
        // dmsHome2 = dmsHome.loginToDms();
        // waitForJSandJQueryToLoad();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        localization.allowNumZip();
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isLetterZipEditBtnVisible());
        localization.setMinZip3();
      //  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isMinNumZipEditBtnVisible());
        localization.fillInputMaskNum1();
      //  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_phone_mask_input']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isPhoneInputMaskEditBtnVisible());
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipN3", priority = 2)
    public void correctZipN3inLead(String zip1, String zip2) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum();
        formsPage.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip1);
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(1000);
        Assert.assertEquals(leadDetails.getZip(), zip2);
        Thread.sleep(5000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void cutZipN3inLead() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum();
        formsPage.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(PropertyLoader.loadProperty("zipN7"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(1000);
        Assert.assertEquals(leadDetails.getZip(), PropertyLoader.loadProperty("zipN6"));
        Thread.sleep(5000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
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
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isLetterZipEditBtnVisible());
        localization.setMinZip4();
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isMinNumZipEditBtnVisible());
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipN4", priority = 5)
    public void correctZipN4inLead(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum();
        formsPage.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(leadDetails.getZip(), zip);
        Thread.sleep(5000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
        Thread.sleep(1000);
    }

    @Test(priority = 6)
    public void cutZipN4inLead() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum();
        formsPage.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(PropertyLoader.loadProperty("zipN7"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(leadDetails.getZip(), PropertyLoader.loadProperty("zipN6"));
        Thread.sleep(5000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
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
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isLetterZipEditBtnVisible());
        localization.setMinZip5();
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
       wait.until(localization.isMinNumZipEditBtnVisible());
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipN5", priority = 8)
    public void correctZipN5inLead(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum();
        formsPage.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(leadDetails.getZip(), zip);
        Thread.sleep(5000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
        Thread.sleep(1000);
    }

    @Test(priority = 9)
    public void cutZipN5inLead() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum();
        formsPage.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(PropertyLoader.loadProperty("zipN7"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(leadDetails.getZip(), PropertyLoader.loadProperty("zipN6"));
        Thread.sleep(5000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
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
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isLetterZipEditBtnVisible());
        localization.setMinZip6();
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isMinNumZipEditBtnVisible());
        Thread.sleep(1000);
    }

    @Test(priority = 11)
    public void correctZipN6inLead() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum();
        formsPage.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(PropertyLoader.loadProperty("zipN6"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getZip(), PropertyLoader.loadProperty("zipN6"));
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
        Thread.sleep(1000);
    }

    @Test(priority = 12)
    public void cutZipN6inLead() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum();
        formsPage.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(PropertyLoader.loadProperty("zipN7"));
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(leadDetails.getZip(), PropertyLoader.loadProperty("zipN6"));
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
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
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isLetterZipEditBtnVisible());
        localization.setMinZip3();
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isMinNumZipEditBtnVisible());
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipL3", priority = 14)
    public void correctZipL3inLead(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum();
        formsPage.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(leadDetails.getZip(), zip);
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "Zip7", priority = 15)
    public void cutZipL3inLead(String zip7, String zip6) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum();
        formsPage.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip7);
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(leadDetails.getZip(), zip6);
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
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
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isLetterZipEditBtnVisible());
        localization.setMinZip4();
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isMinNumZipEditBtnVisible());
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipL4", priority = 17)
    public void correctZipL4inLead(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum();
        formsPage.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(leadDetails.getZip(), zip);
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "Zip7", priority = 18)
    public void cutZipL4inLead(String zip7, String zip6) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum();
        formsPage.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip7);
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(leadDetails.getZip(), zip6);
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
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
       //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isLetterZipEditBtnVisible());
        localization.setMinZip5();
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
       wait.until(localization.isMinNumZipEditBtnVisible());
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipL5", priority = 20)
    public void correctZipL5inLead(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum();
        formsPage.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(leadDetails.getZip(), zip);
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "Zip7", priority = 21)
    public void cutZipL5inLead(String zip7, String zip6) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum();
        formsPage.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip7);
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getZip(), zip6);
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
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
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isLetterZipEditBtnVisible());
        localization.setMinZip6();
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
        wait.until(localization.isMinNumZipEditBtnVisible());
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipL6", priority = 23)
    public void correctZipL6inLead(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum();
        formsPage.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getZip(), zip);
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "Zip7", priority = 24)
    public void cutZipL6inLead(String zip7, String zip6) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum();
        formsPage.fillEmail();
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip7);
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getZip(), zip6);
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
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
