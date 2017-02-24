package testcase;

import contactUsPage.ContactUs;
import dms.SiteEditor;
import dms.dmsHome;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import settings.Localization;
import settings.Sites;
import settings.Website;
import utility.PropertyLoader;
import webdriver.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 14.02.2017.
 */
public class TradeInTestBase2 {
    protected WebDriver driver;
    protected ContactUs tradeIn;
    protected dms.dmsHome dmsHome;
    protected WebDriverWait wait;

    /*run browser, add contact Us page in MAP2, initialize dmsHome and contactUs pages, open dws link*/
    @BeforeClass
    @Parameters({"browserName"})
    public void setup(String browserName) throws Exception {
        //  LOG.info("Navigating to test url");
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dmsHome = PageFactory.initElements(driver, dms.dmsHome.class);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Sites sites = dmsHome2.clickOnSitesMenu();
        waitForJSandJQueryToLoad();
        SiteEditor editor = sites.openSiteEditor();
        waitForJSandJQueryToLoad();
        Sites sites2 = editor.turnOnTradeInPageSite();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-labelledby='ui-dialog-title-site_editor']")));
        /*turn on Contact Us widget from access*/
        SiteEditor editor2 = sites2.openSiteEditor();
        waitForJSandJQueryToLoad();
        Sites sites3 = editor2.turnOnTradeInWidgetSite();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-labelledby='ui-dialog-title-site_editor']")));
        MAP2 map2 = sites.goToMAP2();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        Thread.sleep(2000);
        map2.clickTradeInTab();
        wait.until(isLoadingInvisible());
        wait.until(isAddPageVisible());
        Thread.sleep(2000);
        ContactEditor mapEditor = map2.clickAddPage();
        wait.until(isLoadingInvisible());
        Thread.sleep(2000);
        mapEditor.addTradeInWidget();
        Thread.sleep(500);
        mapEditor.activatePage();
        wait.until(isLoadingInvisible());
        wait.until(isPageActivatedTooltipVisible());
        Thread.sleep(2000);
        Website website = map2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        Localization localization = website.clickOnLocalizationTab();
        Thread.sleep(2000);
        localization.turnOffForceValid();
        Thread.sleep(2000);
        driver.get(PropertyLoader.loadProperty("dws.url2") + "tradein.html");
        tradeIn = PageFactory.initElements(driver, ContactUs.class);
    }

    /*delete Contact Us page in MAP2, close browser*/
    @AfterClass(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        try {
            MAP2 map2 = dmsHome2.clickOnMap2Menu();
            waitForJSandJQueryToLoad();
            wait.until(isLoadingInvisible());
            map2.clickTradeInTab();
            wait.until(isLoadingInvisible());
            wait.until(getConditionForTitle());
            Thread.sleep(1000);
            map2.deletePage();
            wait.until(isPageDeletedTooltipVisible());
            Thread.sleep(1000);
        }
        catch (Exception ex){
            if (driver != null) {
                //   LOG.info("Killing web driver");
                WebDriverFactory.killDriverInstance();
            }
        }
        if (driver != null) {
            //   LOG.info("Killing web driver");
            WebDriverFactory.killDriverInstance();
        }
    }

    protected ExpectedCondition<WebElement> isAddPageVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right")));
    }

    protected ExpectedCondition<Boolean> getConditionForTitle() {
        return ExpectedConditions.textToBe(By.xpath("//div[@class='pull-left']/span"), "Trade_in");
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
}
