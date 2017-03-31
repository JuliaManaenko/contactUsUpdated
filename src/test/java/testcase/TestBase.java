package testcase;

import dms.dmsHome;
import dms.dmsHome2;
import dwsPages.FormsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.testng.annotations.*;
import settings.UserEditor;
import settings.Users;
import settings.Website;
import utility.LogFactory;
import utility.PropertyLoader;
import webdriver.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 30.12.2016.
 */
public class TestBase {
    private static final Logger LOG = LogFactory.getLogger(TestBase.class);

    protected WebDriver driver;
    protected FormsPage dwsPage;
    protected dmsHome dmsHome;
    protected dmsHome2 dmsHome2;

    /*Presteps: turn on MAP2, set jQuery - 1.11.2, disable captcha(temporary, until tests with captcha will be done)*/
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
        waitForJSandJQueryToLoad();
        UserEditor editor = users.openUserEditor();
        waitForJSandJQueryToLoad();
        Thread.sleep(500);
        Users users2 = editor.turnOnMap2();
        waitForJSandJQueryToLoad();
        UserEditor editor2 = users2.clickAddUser();
        waitForJSandJQueryToLoad();
        Users users3 = editor2.addNewManager();
        waitForJSandJQueryToLoad();
        UserEditor editor3 = users3.openLastUserEditor();
        waitForJSandJQueryToLoad();
        editor3.clickAccessTab();
        editor3.turnOnMap2Checkbox();
        editor3.turnOnLeadsCRM();
        editor3.turnOnLeadsEmail();
        editor3.turnOnWebmail();
        editor3.turnOnWebsiteSettings();
        Users users4 = editor3.clickSaveBtn();
        waitForJSandJQueryToLoad();
        Thread.sleep(500);
        Website website = users2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(500);
        website.disableCaptcha();
        waitForJSandJQueryToLoad();
        Thread.sleep(500);
        website.setjQueryVersion();
        waitForJSandJQueryToLoad();

        if (driver != null) {
            LOG.info("Killing web driver");
            WebDriverFactory.killDriverInstance();
        }
    }

    /*run browser, open dms link, initialize dmsHome and formsPage pages*/
    @BeforeClass
    @Parameters({"browserName"})
    public void setup(String browserName) throws Exception {

        LOG.info("Navigating to test url");
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dmsHome = PageFactory.initElements(driver, dmsHome.class);
        dwsPage = PageFactory.initElements(driver, FormsPage.class);

    }

    /*close browser*/
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            LOG.info("Killing web driver");
            WebDriverFactory.killDriverInstance();
        }
    }

    /*delete the last user in Users tree*/
    @AfterSuite
    @Parameters({"browserName"})
    public void backToDefaultSettings(String browserName) throws InterruptedException {
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dmsHome = PageFactory.initElements(driver, dmsHome.class);
        dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Thread.sleep(500);
        Users users = dmsHome2.clickOnUsersMenu();
        waitForJSandJQueryToLoad();
        users.deleteLastUser();
        waitForJSandJQueryToLoad();

        if (driver != null) {
            LOG.info("Killing web driver");
            WebDriverFactory.killDriverInstance();
        }
    }

    public boolean waitForJSandJQueryToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 35);
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

    protected ExpectedCondition<Boolean> getConditionForTitle() {
        return ExpectedConditions.textToBe(By.xpath("//div[@class='pull-left']/span"), "Trade_in");
    }

    protected ExpectedCondition<WebElement> isPageActivatedTooltipVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='jGrowl']//div[@class='message'][contains(text(), 'Page activated')]")));
    }
}
