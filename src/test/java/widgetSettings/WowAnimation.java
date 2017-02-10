package widgetSettings;

import contactUsPage.ContactUs;
import dms.dmsHome;
import dms.dmsHome2;
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
import testcase.TestBase;
import utility.PropertyLoader;
import webdriver.WebDriverFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 25.01.2017.
 */
public class WowAnimation {

    WebDriverWait wait;
    ArrayList<String> tabs2;
    ContactEditor editor2;
    WebDriver driver;
    ContactUs contactUs;
    dms.dmsHome dmsHome;
    dms.dmsHome2 dmsHome2;

    // @Test(priority = 1)
    @BeforeClass
    @Parameters({"browserName"})
    public void loginToDms(String browserName) {
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        //   driver.get(PropertyLoader.loadProperty("dms.url"));
        //  dmsHome = PageFactory.initElements(driver, dmsHome.class);
        //   contactUs = PageFactory.initElements(driver, ContactUs.class);

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            //  LOG.info("Killing web driver");
            WebDriverFactory.killDriverInstance();
        }
    }

    @Test(dataProvider = "wows")
    @Parameters({"browserName"})
    public void checkAnimClass(String wowValue, String wowClass) throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        //  driver = WebDriverFactory.getInstance(browserName);
        //   driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dmsHome = PageFactory.initElements(driver, dmsHome.class);
        contactUs = PageFactory.initElements(driver, ContactUs.class);
        dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        map2.clickContactTab();
        wait.until(isLoadingInvisible());
        wait.until(getConditionForTitle());
        Thread.sleep(2000);
        ContactEditor editor = map2.clickAddPage();
        wait.until(isLoadingInvisible());
        Thread.sleep(1000);
        editor.addWidget();
        Thread.sleep(1000);
        ContactUsWidgetSettings settings = editor.openWidgetSettings();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        WebElement select = driver.findElement(By.xpath("//div[@data-option='wow']//select"));
        Select options = new Select(select);
        options.selectByValue(wowValue);
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
       // Assert.assertEquals(contactUs2.getWidgetClass(), wowClass);
        Assert.assertTrue(contactUs2.getWidgetClassWow(wowClass));
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

    @DataProvider(name = "wows")
    public Object[][] getWow() {
        return new Object[][]{{PropertyLoader.loadProperty("animValueDisabled"),PropertyLoader.loadProperty("animValueDisabled2")},
                {PropertyLoader.loadProperty("animValueBounceIn"),PropertyLoader.loadProperty("animValueBounceIn2")},
                {PropertyLoader.loadProperty("animValueBounceInDown"), PropertyLoader.loadProperty("animValueBounceInDown2")},
                {PropertyLoader.loadProperty("animValueBounceInLeft"), PropertyLoader.loadProperty("animValueBounceInLeft2")},
                {PropertyLoader.loadProperty("animValueBounceInRight"), PropertyLoader.loadProperty("animValueBounceInRight2")},
                {PropertyLoader.loadProperty("animValueFadeIn"), PropertyLoader.loadProperty("animValueFadeIn2")},
                {PropertyLoader.loadProperty("animValueFadeInDown"), PropertyLoader.loadProperty("animValueFadeInDown2")},
                {PropertyLoader.loadProperty("animValueFadeInDownBig"), PropertyLoader.loadProperty("animValueFadeInDownBig2")},
                {PropertyLoader.loadProperty("animValueFadeInLeft"), PropertyLoader.loadProperty("animValueFadeInLeft2")},
                {PropertyLoader.loadProperty("animValueFadeInLeftBig"), PropertyLoader.loadProperty("animValueFadeInLeftBig2")},
                {PropertyLoader.loadProperty("animValueFadeInRight"), PropertyLoader.loadProperty("animValueFadeInRight2")},
                {PropertyLoader.loadProperty("animValueFadeInRightBig"), PropertyLoader.loadProperty("animValueFadeInRightBig2")},
                {PropertyLoader.loadProperty("animValueFadeInUp"), PropertyLoader.loadProperty("animValueFadeInUp2")},
                {PropertyLoader.loadProperty("animValueFadeInUpBig"), PropertyLoader.loadProperty("animValueFadeInUpBig2")},
                {PropertyLoader.loadProperty("animValueFlipInX"), PropertyLoader.loadProperty("animValueFlipInX2")},
                {PropertyLoader.loadProperty("animValueFlipInY"), PropertyLoader.loadProperty("animValueFlipInY2")},
                {PropertyLoader.loadProperty("animValueLightSpeedIn"), PropertyLoader.loadProperty("animValueLightSpeedIn2")},
                {PropertyLoader.loadProperty("animValueRotateIn"), PropertyLoader.loadProperty("animValueRotateIn2")},
                {PropertyLoader.loadProperty("animValueRotateInDownLeft"), PropertyLoader.loadProperty("animValueRotateInDownLeft2")},
                {PropertyLoader.loadProperty("animValueRotateInDownRight"), PropertyLoader.loadProperty("animValueRotateInDownRight2")},
                {PropertyLoader.loadProperty("animValueRotateInUpLeft"), PropertyLoader.loadProperty("animValueRotateInUpLeft2")},
                {PropertyLoader.loadProperty("animValueRotateInUpRight"), PropertyLoader.loadProperty("animValueRotateInUpRight2")},
                {PropertyLoader.loadProperty("animValueRollIn"), PropertyLoader.loadProperty("animValueRollIn2")}};
    }

    @DataProvider(name = "wows2")
    public Object[][] getWow2() {
        return new Object[][]{{PropertyLoader.loadProperty("animValueDisabled"), PropertyLoader.loadProperty("animClassDisabled")},
                {PropertyLoader.loadProperty("animValueBounceIn"), PropertyLoader.loadProperty("animClassBounceIn")},
                {PropertyLoader.loadProperty("animValueBounceInDown"), PropertyLoader.loadProperty("animClassBounceInDown")},
                {PropertyLoader.loadProperty("animValueBounceInLeft"), PropertyLoader.loadProperty("animClassBounceInLeft")},
                {PropertyLoader.loadProperty("animValueBounceInRight"), PropertyLoader.loadProperty("animClassBounceInRight")},
                {PropertyLoader.loadProperty("animValueFadeIn"), PropertyLoader.loadProperty("animClassFadeIn")},
                {PropertyLoader.loadProperty("animValueFadeInDown"), PropertyLoader.loadProperty("animClassFadeInDown")},
                {PropertyLoader.loadProperty("animValueFadeInDownBig"), PropertyLoader.loadProperty("animClassFadeInDownBig")},
                {PropertyLoader.loadProperty("animValueFadeInLeft"), PropertyLoader.loadProperty("animClassFadeInLeft")},
                {PropertyLoader.loadProperty("animValueFadeInLeftBig"), PropertyLoader.loadProperty("animClassFadeInLeftBig")},
                {PropertyLoader.loadProperty("animValueFadeInRight"), PropertyLoader.loadProperty("animClassFadeInRight")},
                {PropertyLoader.loadProperty("animValueFadeInRightBig"), PropertyLoader.loadProperty("animClassFadeInRightBig")},
                {PropertyLoader.loadProperty("animValueFadeInUp"), PropertyLoader.loadProperty("animClassFadeInUp")},
                {PropertyLoader.loadProperty("animValueFadeInUpBig"), PropertyLoader.loadProperty("animClassFadeInUpBig")},
                {PropertyLoader.loadProperty("animValueFlipInX"), PropertyLoader.loadProperty("animClassFlipInX")},
                {PropertyLoader.loadProperty("animValueFlipInY"), PropertyLoader.loadProperty("animClassFlipInY")},
                {PropertyLoader.loadProperty("animValueLightSpeedIn"), PropertyLoader.loadProperty("animClassLightSpeedIn")},
                {PropertyLoader.loadProperty("animValueRotateIn"), PropertyLoader.loadProperty("animClassRotateIn")},
                {PropertyLoader.loadProperty("animValueRotateInDownLeft"), PropertyLoader.loadProperty("animClassRotateInDownLeft")},
                {PropertyLoader.loadProperty("animValueRotateInDownRight"), PropertyLoader.loadProperty("animClassRotateInDownRight")},
                {PropertyLoader.loadProperty("animValueRotateInUpLeft"), PropertyLoader.loadProperty("animClassRotateInUpLeft")},
                {PropertyLoader.loadProperty("animValueRotateInUpRight"), PropertyLoader.loadProperty("animClassRotateInUpRight")},
                {PropertyLoader.loadProperty("animValueRollIn"), PropertyLoader.loadProperty("animClassRollIn")}};
    }

    protected ExpectedCondition<Boolean> isLoadingInvisible() {
        return ExpectedConditions.invisibilityOfElementLocated(By.className("mask"));
    }

    protected ExpectedCondition<Boolean> getConditionForTitle() {
        return ExpectedConditions.textToBe(By.xpath("//div[@class='pull-left']/span"), "Contact_us");
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
