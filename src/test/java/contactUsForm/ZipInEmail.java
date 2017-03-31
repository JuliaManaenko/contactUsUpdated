package contactUsForm;

import customers.Leads;
import dwsPages.FormsPage;
import map2.MAP2;
import map2.map2PageEditor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import settings.LeadsEmail;
import settings.Localization;
import settings.Website;
import utility.PropertyLoader;
import webdriver.WebDriverFactory;
import webmail.EmailDetails;
import webmail.EmailsList;
import webmail.WebmailLogin;

import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 07.02.2017.
 */
public class ZipInEmail  {

    private dms.dmsHome2 dmsHome2;
    private WebDriver driver;
    private FormsPage formsPage;
    private dms.dmsHome dmsHome;
    private WebDriverWait wait;

    /*run browser, add contact Us page in MAP2, initialize dmsHome and formsPage pages, open dws link*/
    @BeforeClass
    @Parameters({"browserName"})
    public void setup(String browserName) throws Exception {
        //  LOG.info("Navigating to test url");
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        driver.manage().deleteAllCookies();
        dmsHome = PageFactory.initElements(driver, dms.dmsHome.class);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        Thread.sleep(1000);
        map2.clickContactTab();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        wait.until(isAddPageVisible());
        Thread.sleep(1000);
        map2PageEditor editor = map2.clickAddPage();
        wait.until(isLoadingInvisible());
        Thread.sleep(1000);
        editor.addWidget();
        waitForJSandJQueryToLoad();
        Thread.sleep(500);
        editor.activatePage();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        wait.until(isPageActivatedTooltipVisible());
        Thread.sleep(1000);
        Website website = map2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        LeadsEmail leadsEmail = website.clickOnLeadsTab();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leadsEmail.addEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        WebmailLogin webmailLogin = leadsEmail.clickOnWebmailMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        webmailLogin.loginToWebmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage = PageFactory.initElements(driver, FormsPage.class);
    }

    /*delete Contact Us page in MAP2, close browser*/
    @AfterClass(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        map2.clickContactTab();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        wait.until(getConditionForTitle());
        Thread.sleep(2000);
        map2.deletePage();
        waitForJSandJQueryToLoad();
        wait.until(isPageDeletedTooltipVisible());
        Thread.sleep(1000);
        Website website = map2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        LeadsEmail leadsEmail = website.clickOnLeadsTab();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leadsEmail.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        if (driver != null) {
            //   LOG.info("Killing web driver");
            WebDriverFactory.killDriverInstance();
        }
    }

    protected ExpectedCondition<WebElement> isAddPageVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right")));
    }

    protected ExpectedCondition<Boolean> getConditionForTitle() {
        return ExpectedConditions.textToBe(By.xpath("//div[@class='pull-left']/span"), "Contact_us");
    }

    protected ExpectedCondition<WebElement> isPageActivatedTooltipVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='jGrowl']//div[@class='message'][contains(text(), 'Page activated')]")));
    }

    protected ExpectedCondition<WebElement> isPageDeletedTooltipVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='jGrowl']//div[@class='message'][contains(text(), 'Page deleted')]")));
    }

    protected ExpectedCondition<Boolean> isLoadingInvisible() {
        return ExpectedConditions.invisibilityOfElementLocated(By.className("mask"));
    }

    public boolean waitForJSandJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
    /*method for execute Java Script: page should be loaded*/
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
    @Test(priority = 1)
    public void setZipN3() throws InterruptedException {
        wait = new WebDriverWait(driver, 20);
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
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip2);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome22 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome22.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test(priority = 3)
    public void cutZipN3inEmail() throws InterruptedException {
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
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), PropertyLoader.loadProperty("zipN6"));
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome22 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome22.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
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
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome22 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome22.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test(priority = 6)
    public void cutZipN4inEmail() throws InterruptedException {
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
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), PropertyLoader.loadProperty("zipN6"));
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome22 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome22.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
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
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome22 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome22.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test(priority = 9)
    public void cutZipN5inEmail() throws InterruptedException {
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
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), PropertyLoader.loadProperty("zipN6"));
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome22 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome22.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
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
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), PropertyLoader.loadProperty("zipN6"));
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome22 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome22.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test(priority = 12)
    public void cutZipN6inEmail() throws InterruptedException {
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
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), PropertyLoader.loadProperty("zipN6"));
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome22 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome22.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
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
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome22 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome22.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test(dataProvider = "Zip7", priority = 15)
    public void cutZipL3inEmail(String zip7, String zip6) throws InterruptedException {
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
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip6);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome22 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome22.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
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
       // dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome22 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome22.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test(dataProvider = "Zip7", priority = 18)
    public void cutZipL4inEmail(String zip7, String zip6) throws InterruptedException {
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
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip6);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome22 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome22.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
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
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome22 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome22.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test(dataProvider = "Zip7", priority = 21)
    public void cutZipL5inEmail(String zip7, String zip6) throws InterruptedException {
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
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip6);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome22 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome22.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
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
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome22 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome22.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test(dataProvider = "Zip7", priority = 24)
    public void cutZipL6inEmail(String zip7, String zip6) throws InterruptedException {
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
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getZip(), zip6);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome22 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome22.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
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
