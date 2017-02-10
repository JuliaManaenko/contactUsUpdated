package testcase;

import contactUsPage.ContactUs;
import dms.dmsHome;
import dms.dmsHome2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import settings.LeadsEmail;
import settings.UserEditor;
import settings.Users;
import settings.Website;
import utility.LogFactory;
import utility.PropertyLoader;
import webdriver.WebDriverFactory;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 30.12.2016.
 */
public class TestBase {
    private static final Logger LOG = LogFactory.getLogger(TestBase.class);

    protected WebDriver driver;
    protected ContactUs contactUs;
    protected dmsHome dmsHome;
    protected dmsHome2 dmsHome2;

    /*Presteps: turn on MAP2, set jQuery - 1.11.2, fill email in leads email(not done for now), disable captcha(temporary, until tests with captcha will be done)*/
    @BeforeSuite
    @Parameters({"browserName"})
    public void turnOnMap2(String browserName) throws InterruptedException {
        LOG.info("Navigating to test url");
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dmsHome = PageFactory.initElements(driver, dmsHome.class);
        dmsHome2 = dmsHome.loginToDms();
        Users users = dmsHome2.clickOnUsersMenu();
        Thread.sleep(2000);
        UserEditor editor = users.openUserEditor();
        Thread.sleep(2000);
        Users users2 = editor.turnOnMap2();
        Thread.sleep(2000);
        Website website = users2.clickOnWebsiteMenu();
        Thread.sleep(2000);
        website.disableCaptcha();
        Thread.sleep(2000);
        website.setjQueryVersion();
      /*  Website website2 = users2.clickOnWebsiteMenu();
        Thread.sleep(2000);
        LeadsEmail leads = website2.clickOnLeadsTab();
        Thread.sleep(2000);
        leads.addEmail();*/
        if (driver != null) {
            LOG.info("Killing web driver");
            WebDriverFactory.killDriverInstance();
        }
    }

    /*run browser, open dms link, initialize dmsHome and contactUs pages*/
    @BeforeClass
    @Parameters({"browserName"})
    public void setup(String browserName) throws Exception {

        LOG.info("Navigating to test url");
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dmsHome = PageFactory.initElements(driver, dmsHome.class);
        contactUs = PageFactory.initElements(driver, ContactUs.class);

    }

    /*close browser*/
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            LOG.info("Killing web driver");
            WebDriverFactory.killDriverInstance();
        }
    }

  /*  @AfterSuite
    @Parameters({"browserName"})
    public void backToDefaultSettings(String browserName) throws InterruptedException {
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dmsHome = PageFactory.initElements(driver, dmsHome.class);
        dmsHome2 = dmsHome.loginToDms();
        Thread.sleep(2000);
        Website website = dmsHome2.clickOnWebsiteMenu();
        Thread.sleep(2000);
        LeadsEmail leadsEmail = website.clickOnLeadsTab();
        Thread.sleep(2000);
        leadsEmail.removeEmail();
        Thread.sleep(2000);
        if (driver != null) {
            LOG.info("Killing web driver");
            WebDriverFactory.killDriverInstance();
        }
    }*/

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
