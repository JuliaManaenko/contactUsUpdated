package TradeInForm;

import contactUsPage.ContactUs;
import dataProviders.DataProviderSet1;
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
import org.testng.Assert;
import org.testng.annotations.*;
import utility.PropertyLoader;
import webdriver.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 28.02.2017.
 */
public class TradeInEmailInput {

    private WebDriver driver;
    private WebDriverWait wait;
    private ContactUs tradeIn;
    private dms.dmsHome dmsHome;

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
        wait.until(isHomeBreadcrumbsVisible());
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        wait.until(isMAP2PagesListVisible());
        map2.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(getConditionForTitle());
        ContactEditor editor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        wait.until(isMAP2EditorVisible());
        editor.addTradeInWidget();
        waitForJSandJQueryToLoad();
        editor.activatePage();
        waitForJSandJQueryToLoad();
        wait.until(isPageActivatedTooltipVisible());
        if (driver != null) {
            WebDriverFactory.killDriverInstance();
        }
    }

    @BeforeMethod
    @Parameters({"browserName"})
    public void setup(String browserName) throws Exception {
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn = PageFactory.initElements(driver, ContactUs.class);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome dmsHome1 = PageFactory.initElements(driver, dms.dmsHome.class);
        dms.dmsHome2 dmsHome2 = dmsHome1.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        wait.until(isMAP2PagesListVisible());
        map2.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(getConditionForTitle());
        map2.deletePage();
        waitForJSandJQueryToLoad();
        wait.until(isPageDeletedTooltipVisible());
         if (driver != null) {
            WebDriverFactory.killDriverInstance();
        }
    }

    @Test(dataProvider = "incorrectEmail", dataProviderClass = DataProviderSet1.class)
    public void incorrectEmailClass(String nEmail) {
        tradeIn.fillEmailVar(nEmail);
        tradeIn.clickOnTradeInSubmit();
        Assert.assertEquals(tradeIn.getEmailInputClass(), "form-control error");
    }

    @Test(dataProvider = "incorrectEmail", dataProviderClass = DataProviderSet1.class)
    public void incorrectEmailHighlight(String nEmail) throws InterruptedException {
        tradeIn.fillEmailVar(nEmail);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getEmailInputBorderColor(), PropertyLoader.loadProperty("border_color_red"));
    }

    @Test(dataProvider = "incorrectEmail", dataProviderClass = DataProviderSet1.class)
    public void incorrectEmailLabelHighlight(String nEmail) throws InterruptedException {
        tradeIn.fillEmailVar(nEmail);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getEmailLabelFontColor(), PropertyLoader.loadProperty("font_color_red"));
    }

    @Test
    public void correctEmailClass() {
        tradeIn.fillEmailVar(PropertyLoader.loadProperty("Email1"));
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getEmailInputClass(), "form-control valid");
    }

    @Test
    public void correctEmailHighlight() throws InterruptedException {
        tradeIn.fillEmailVar(PropertyLoader.loadProperty("Email1"));
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getEmailInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test
    public void correctEmailLabelHighlight() throws InterruptedException {
        tradeIn.fillEmailVar(PropertyLoader.loadProperty("Email1"));
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getEmailLabelFontColor(), PropertyLoader.loadProperty("font_color_gray"));
    }

    protected ExpectedCondition<WebElement> isHomeBreadcrumbsVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='slid_breadcrumb']//a[contains(text(), 'Home')]")));
    }

    protected ExpectedCondition<WebElement> isMAP2PagesListVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".sidebar.page-types")));
    }

    protected ExpectedCondition<WebElement> isMAP2EditorVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='map'][@data-screen='editor']")));
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
