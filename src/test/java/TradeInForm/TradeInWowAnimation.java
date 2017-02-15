package TradeInForm;

import contactUsPage.ContactUs;
import dataProviders.DataProviderSet1;
import map2.ContactEditor;
import map2.ContactUsWidgetSettings;
import map2.MAP2;
import map2.PreviewPage;
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
import settings.Website;
import utility.PropertyLoader;
import webdriver.WebDriverFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 14.02.2017.
 */
public class TradeInWowAnimation {

    WebDriverWait wait;
    ArrayList<String> tabs2;
    ContactEditor editor2;
    WebDriver driver;
    ContactUs tradeIn;
    dms.dmsHome dmsHome;
    dms.dmsHome2 dmsHome2;

    @BeforeClass
    @Parameters({"browserName"})
    public void loginToDms(String browserName) {
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dmsHome = PageFactory.initElements(driver, dms.dmsHome.class);
        dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        website.disableCaptcha();
        waitForJSandJQueryToLoad();
        if (driver != null) {
            //  LOG.info("Killing web driver");
            WebDriverFactory.killDriverInstance();
        }
    }

    @Test(dataProvider = "wows1", dataProviderClass = DataProviderSet1.class)
    @Parameters({"browserName"})
    public void checkAnimClass(String wowValue, String wowClass) throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dmsHome = PageFactory.initElements(driver, dms.dmsHome.class);
        tradeIn = PageFactory.initElements(driver, ContactUs.class);
        dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        map2.clickTradeInTab();
        wait.until(isLoadingInvisible());
        wait.until(getConditionForTitle());
        Thread.sleep(2000);
        ContactEditor editor = map2.clickAddPage();
        wait.until(isLoadingInvisible());
        Thread.sleep(1000);
        editor.addTradeInWidget();
        Thread.sleep(1000);
        ContactUsWidgetSettings settings = editor.openWidgetSettings();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        settings.setAnimation(wowValue);
        editor2 = settings.clickOK();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        //need to add wait.until()
        editor2.activatePage();
        wait.until(isLoadingInvisible());
        wait.until(isPageActivatedTooltipVisible());
        Thread.sleep(2000);
        PreviewPage previewPage = editor2.clickOnPreview();
        waitForJSandJQueryToLoad();
        tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(1000);
        ContactUs contactUs2 = previewPage.clickOnVisitWebsite();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs3.get(2));
        Thread.sleep(500);
        Assert.assertTrue(contactUs2.getTradeInWidgetClassWow(wowClass));
    }

    @AfterMethod
    public void closeTabs() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        MAP2 map21 = editor2.backToMap();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        map21.deletePage();
        Thread.sleep(2000);
        driver.manage().deleteAllCookies();
    }


    protected ExpectedCondition<Boolean> isLoadingInvisible() {
        return ExpectedConditions.invisibilityOfElementLocated(By.className("mask"));
    }

    protected ExpectedCondition<Boolean> getConditionForTitle() {
        return ExpectedConditions.textToBe(By.xpath("//div[@class='pull-left']/span"), "Trade_in");
    }

    protected ExpectedCondition<WebElement> isPageActivatedTooltipVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='jGrowl']//div[@class='message'][contains(text(), 'Page activated')]")));
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
