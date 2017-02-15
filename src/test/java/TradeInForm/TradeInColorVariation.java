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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.PropertyLoader;
import webdriver.WebDriverFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 14.02.2017.
 */
public class TradeInColorVariation {
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
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dmsHome = PageFactory.initElements(driver, dms.dmsHome.class);
        tradeIn = PageFactory.initElements(driver, ContactUs.class);
        dmsHome2 = dmsHome.loginToDms();
    }

    @Test(dataProvider = "colors", dataProviderClass = DataProviderSet1.class)
    public void checkColorClass(String colorValue, String colorClass) throws InterruptedException {
        wait = new WebDriverWait(driver, 20);
        waitForJSandJQueryToLoad();
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        map2.clickTradeInTab();
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='pull-left']/span"), "Trade_in"));
        Thread.sleep(1000);
        ContactEditor editor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        editor.addTradeInWidget();
        Thread.sleep(1000);
        ContactUsWidgetSettings settings = editor.openWidgetSettings();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        settings.setAnimationDisabled();
        Thread.sleep(1000);
       /* WebElement select = driver.findElement(By.xpath("//div[@data-option='colorTheme']//select"));
        Select options = new Select(select);
        options.selectByValue(colorValue);*/
        settings.setColorVariation(colorValue);
        editor2 = settings.clickOK();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        editor2.activatePage();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='jGrowl-notification ui-state-highlight ui-corner-all jgrowl_default_alert']/div[@class='message'][contains(text(), 'Page activated')]"))));
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
        Assert.assertEquals(contactUs2.getTradeinWidgetClassColor(), colorClass);
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
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            //  LOG.info("Killing web driver");
            WebDriverFactory.killDriverInstance();
        }
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
