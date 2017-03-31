package TradeInForm;

import customers.LeadDetails;
import customers.Leads;
import dms.SiteEditor;
import dwsPages.FormsPage;
import map2.MAP2;
import map2.PreviewPage;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import settings.*;
import utility.PropertyLoader;
import webdriver.WebDriverFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 13.03.2017.
 */
public class TradeInCustomPage {

    private WebDriver driver;
    private FormsPage tradeIn;
    private dms.dmsHome dmsHome;
    private WebDriverWait wait;

    @BeforeClass
    @Parameters({"browserName"})
    public void setup(String browserName) throws Exception {
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dmsHome = PageFactory.initElements(driver, dms.dmsHome.class);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Sites sites = dmsHome2.clickOnSitesMenu();
        waitForJSandJQueryToLoad();
        SiteEditor editor = sites.openSiteEditor();
        waitForJSandJQueryToLoad();
        Sites sites2 = editor.turnOnTradeInPageSite();
        waitForJSandJQueryToLoad();
        wait.until(isSiteEditorInvisible());
        //turn on Contact Us widget from access
        SiteEditor editor2 = sites2.openSiteEditor();
        waitForJSandJQueryToLoad();
        Sites sites3 = editor2.turnOnTradeInWidgetSite();
        waitForJSandJQueryToLoad();
        wait.until(isSiteEditorInvisible());
        //turn on custom pages in Users Access
        Users users = sites3.clickOnUsersMenu();
        waitForJSandJQueryToLoad();
        UserEditor editor3 = users.openUserEditor();
        waitForJSandJQueryToLoad();
        editor3.clickAccessTab();
        waitForJSandJQueryToLoad();
        editor3.turnOnMapCustomCheckbox();
        waitForJSandJQueryToLoad();
        Users users1 = editor3.clickSaveBtn();
        waitForJSandJQueryToLoad();
        //turn off Force validation in Localization
        Website website = users1.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        wait.until(isWebsiteSidePanelVisible());
        Localization localization = website.clickOnLocalizationTab();
        wait.until(isLocalizationBreadcrumbsVisible());
        localization.turnOffForceValid();
        waitForJSandJQueryToLoad();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            WebDriverFactory.killDriverInstance();
        }
    }

    @Test
    public void isTradeInWidgetExistsInCustomLibrary() {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        map2.clickCustomTab();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        wait.until(isAddPageVisible());
        map2PageEditor mapEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        Assert.assertTrue(mapEditor.isTradeInWidgetExists());
    }

    @Test
    public void isTradeInWidgetExistsInCustomDWS() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        map2.clickCustomTab();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        wait.until(isAddPageVisible());
        map2PageEditor mapEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        mapEditor.setPageName("customauto2");
        mapEditor.setPageTitle("customauto2");
        mapEditor.setPageUrl("customauto2");
        waitForJSandJQueryToLoad();
        mapEditor.addTradeInWidget();
        waitForJSandJQueryToLoad();
        mapEditor.activatePage();
        waitForJSandJQueryToLoad();
        wait.until(isPageActivatedTooltipVisible());
        PreviewPage previewPage = mapEditor.clickOnPreview();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(1000);
        FormsPage tradeIn = previewPage.clickOnVisitWebsite();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs3.get(2));
        Assert.assertTrue(tradeIn.isTradeInWidgetExists());
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        MAP2 map21 = mapEditor.backToMap();
        waitForJSandJQueryToLoad();
        map21.deletePage();
        waitForJSandJQueryToLoad();
    }

    @Test
    public void isLeadComeFromCustom() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        map2.clickCustomTab();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        wait.until(isAddPageVisible());
        map2PageEditor mapEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        mapEditor.setPageName("customauto");
        mapEditor.setPageTitle("customauto");
        mapEditor.setPageUrl("customauto");
        waitForJSandJQueryToLoad();
        mapEditor.addTradeInWidget();
        waitForJSandJQueryToLoad();
        mapEditor.activatePage();
        waitForJSandJQueryToLoad();
        wait.until(isPageActivatedTooltipVisible());
        PreviewPage previewPage = mapEditor.clickOnPreview();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(1000);
        FormsPage tradeIn = previewPage.clickOnVisitWebsite();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs3.get(2));
        tradeIn.fillFirstNameVar("CustomCheck");
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.navigate().back();
        waitForJSandJQueryToLoad();
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome21 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        wait.until(isLeadsListVisible());
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs4 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs4.get(3));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getFirstName(), "CustomCheck");
        driver.close();
        driver.switchTo().window(tabs4.get(2));
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
        driver.close();
        driver.switchTo().window(tabs4.get(1));
        waitForJSandJQueryToLoad();
        driver.close();
        driver.switchTo().window(tabs4.get(0));
        waitForJSandJQueryToLoad();
        MAP2 map21 = mapEditor.backToMap();
        waitForJSandJQueryToLoad();
        map21.deletePage();
        waitForJSandJQueryToLoad();
    }

    protected ExpectedCondition<WebElement> isHomeBreadcrumbsVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='slid_breadcrumb']//a[contains(text(), 'Home')]")));
    }

    protected ExpectedCondition<Boolean> isSiteEditorInvisible() {
        return ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-labelledby='ui-dialog-title-site_editor']"));
    }

    protected ExpectedCondition<Boolean> isLoadingInvisible() {
        return ExpectedConditions.invisibilityOfElementLocated(By.className("mask"));
    }

    protected ExpectedCondition<WebElement> isAddPageVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right")));
    }

    protected ExpectedCondition<WebElement> isPageActivatedTooltipVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='jGrowl']//div[@class='message'][contains(text(), 'Page activated')]")));
    }

    protected ExpectedCondition<WebElement> isPageDeletedTooltipVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='jGrowl']//div[@class='message'][contains(text(), 'Page deleted')]")));
    }

    protected ExpectedCondition<WebElement> isWebsiteSidePanelVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.className("td_left_user-managment")));
    }

    protected ExpectedCondition<WebElement> isLocalizationBreadcrumbsVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='header_dealership'][contains(text(), 'Localization')]")));
    }

    protected ExpectedCondition<WebElement> isPostFormVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.className("btn-message-ok")));
    }

    protected ExpectedCondition<WebElement> isLeadsListVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.id("leads-list-width")));
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
