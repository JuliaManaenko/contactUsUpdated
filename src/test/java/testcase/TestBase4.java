package testcase;

import contactUsPage.ContactUs;
import dms.dmsHome;
import dms.dmsHome2;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utility.LogFactory;
import utility.PropertyLoader;
import webdriver.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 27.01.2017.
 */
public class TestBase4 {

    private static final Logger LOG = LogFactory.getLogger(TestBase.class);

    protected WebDriver driver;
    protected ContactUs contactUs;
    protected dms.dmsHome dmsHome;
    protected dms.dmsHome2 dmsHome2;
    protected WebDriverWait wait;

    /* run browser, open dms link, initialize dmsHome and contactUs pages, add contact Us page in MAP2*/
    @BeforeClass
    @Parameters({"browserName"})
    public void setup(String browserName) throws Exception {
        LOG.info("Navigating to test url");
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dmsHome = PageFactory.initElements(driver, dmsHome.class);
        dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        map2.clickContactTab();
        wait.until(isAddPageVisible());
        Thread.sleep(1000);
        ContactEditor editor = map2.clickAddPage();
        wait.until(isLoadingInvisible());
        Thread.sleep(2000);
        editor.addWidget();
        editor.activatePage();
        wait.until(isLoadingInvisible());
        wait.until(isPageActivatedTooltipVisible());
        Thread.sleep(2000);
        contactUs = PageFactory.initElements(driver, ContactUs.class);
    }

    /*delete Contact Us page in MAP2, close browser*/
    @AfterClass
    public void tearDown() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        map2.clickContactTab();
        wait.until(isLoadingInvisible());
        wait.until(getConditionForTitle());
        Thread.sleep(1000);
        map2.deletePage();
        wait.until(isPageDeletedTooltipVisible());
        Thread.sleep(1000);
        if (driver != null) {
            LOG.info("Killing web driver");
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
}