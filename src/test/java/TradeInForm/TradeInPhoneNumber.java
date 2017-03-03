package TradeInForm;

import contactUsPage.ContactUs;
import customers.LeadDetails;
import customers.Leads;
import dataProviders.DataProviderSet1;
import map2.ContactEditor;
import map2.MAP2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import settings.Localization;
import settings.Website;
import utility.LogFactory;
import utility.PropertyLoader;
import webdriver.WebDriverFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 27.02.2017.
 */
public class TradeInPhoneNumber {

    private static final Logger LOG = LogFactory.getLogger(TradeInPhoneNumber.class);
    private WebDriver driver;
    private ContactUs tradeIn;
    private dms.dmsHome dmsHome;
    private WebDriverWait wait;
    private LeadDetails leadDetails;

    /*run browser, open dms link, initialize dmsHome and contactUs pages, add contact Us page in MAP2, close browser*/
    @BeforeClass
    @Parameters({"browserName"})
    public void activatePage(String browserName) throws Exception {
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dmsHome = PageFactory.initElements(driver, dms.dmsHome.class);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        map2.clickTradeInTab();
        wait.until(isLoadingInvisible());
        wait.until(isAddPageVisible());
        ContactEditor editor = map2.clickAddPage();
        wait.until(isLoadingInvisible());
        editor.addTradeInWidget();
        editor.activatePage();
        wait.until(isLoadingInvisible());
        wait.until(isPageActivatedTooltipVisible());
        tradeIn = PageFactory.initElements(driver, ContactUs.class);
    }

    //close browser
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            LOG.info("Killing web driver");
            WebDriverFactory.killDriverInstance();
        }
    }

    /*check if filled phone number is like in phone input mask*/
    @Test(dataProvider = "phones", dataProviderClass = DataProviderSet1.class)
    public void phInputMaskCheck(String inputMask, String phone) throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        wait.until(isWebsiteSidePanelVisible());
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        wait.until(isLocalizationBreadcrumbsVisible());
        localization.turnOnForceValid();
        waitForJSandJQueryToLoad();
        localization.fillInputMaskVar(inputMask);
        waitForJSandJQueryToLoad();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillEmail();
        tradeIn.fillPhoneNumVar(phone);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        wait.until(isLeadsListVisible());
        leadDetails = leads.openFirstLead();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getPhoneNum(), phone); //'phone' variable is from data provider
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        wait.until(isLeadsListVisible());
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    /*input css class should be 'error' if put phones that are not matches for phone input mask*/
    @Test(dataProvider = "incorrectPhones", dataProviderClass = DataProviderSet1.class)
    public void phIncorrectPhoneTest(String inputMask, String phone) throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        wait = new WebDriverWait(driver, 10);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        wait.until(isWebsiteSidePanelVisible());
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        wait.until(isLocalizationBreadcrumbsVisible());
        localization.turnOnForceValid();
        waitForJSandJQueryToLoad();
        localization.fillInputMaskVar(inputMask);
        waitForJSandJQueryToLoad();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillEmail();
        tradeIn.fillPhoneNumVar(phone);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getPhoneNumInputClass(), "form-control text-uppercase error");
    }


    //input higlight should be red if put phones that are not matches for phone input mask
    @Test(dataProvider = "incorrectPhones", dataProviderClass = DataProviderSet1.class)
    public void phIncorrectPhoneHighlight(String inputMask, String phone) throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        wait = new WebDriverWait(driver, 10);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        wait.until(isWebsiteSidePanelVisible());
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        wait.until(isLocalizationBreadcrumbsVisible());
        localization.turnOnForceValid();
        waitForJSandJQueryToLoad();
        localization.fillInputMaskVar(inputMask);
        waitForJSandJQueryToLoad();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillEmail();
        tradeIn.fillPhoneNumVar(phone);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getPhoneNumInputBorderColor(), PropertyLoader.loadProperty("border_color_red2"));
    }

    @Test(dataProvider = "incorrectPhones", dataProviderClass = DataProviderSet1.class)
    public void phIncorrectLabelHighlight(String inputMask, String phone) throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        wait = new WebDriverWait(driver, 10);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        wait.until(isWebsiteSidePanelVisible());
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        wait.until(isLocalizationBreadcrumbsVisible());
        localization.turnOnForceValid();
        waitForJSandJQueryToLoad();
        localization.fillInputMaskVar(inputMask);
        waitForJSandJQueryToLoad();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillEmail();
        tradeIn.fillPhoneNumVar(phone);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getPhoneNumLabelFontColor(), PropertyLoader.loadProperty("font_color_red"));
    }

    /*All symbols should be accepted if turn off ForceValidation in settings*/
    @Test
    public void forceValidOffClass() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 10);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        wait.until(isWebsiteSidePanelVisible());
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        wait.until(isLocalizationBreadcrumbsVisible());
        localization.turnOffForceValid();
        waitForJSandJQueryToLoad();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillPhoneNumVar(PropertyLoader.loadProperty("phoneAll"));
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getPhoneNumInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test
    public void forceValidOffHighlight() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 10);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        wait.until(isWebsiteSidePanelVisible());
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        wait.until(isLocalizationBreadcrumbsVisible());
        localization.turnOffForceValid();
        waitForJSandJQueryToLoad();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillPhoneNumVar(PropertyLoader.loadProperty("phoneAll"));
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getPhoneNumInputClass(), "form-control text-uppercase valid");
    }

    @Test
    public void forceValidOffLead() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        wait = new WebDriverWait(driver, 10);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        wait.until(isWebsiteSidePanelVisible());
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        wait.until(isLocalizationBreadcrumbsVisible());
        localization.turnOffForceValid();
        waitForJSandJQueryToLoad();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillEmail();
        tradeIn.fillPhoneNumVar(PropertyLoader.loadProperty("phoneAll"));
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
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

    protected ExpectedCondition<WebElement> isAddPageVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right")));
    }

    protected ExpectedCondition<WebElement> isPageActivatedTooltipVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='jGrowl']//div[@class='message'][contains(text(), 'Page activated')]")));
    }

    protected ExpectedCondition<Boolean> isLoadingInvisible() {
        return ExpectedConditions.invisibilityOfElementLocated(By.className("mask"));
    }

    protected ExpectedCondition<WebElement> isHomeBreadcrumbsVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='slid_breadcrumb']//a[contains(text(), 'Home')]")));
    }

    protected ExpectedCondition<WebElement> isWebsiteSidePanelVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.className("td_left_user-managment")));
    }

    protected ExpectedCondition<WebElement> isLocalizationBreadcrumbsVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='header_dealership'][contains(text(), 'Localization')]")));
    }

    protected ExpectedCondition<WebElement> isLeadsListVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.id("leads-list-width")));
    }

    protected ExpectedCondition<WebElement> isPostFormVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.className("btn-message-ok")));
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
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
}
