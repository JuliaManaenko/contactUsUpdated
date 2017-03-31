package advancedSearchHorizontal;

import dms.SiteEditor;
import dwsPages.SearchesPage;
import map2.MAP2;
import map2.map2PageEditor;
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
import settings.Sites;
import utility.PropertyLoader;
import webdriver.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 23.03.2017.
 */
public class AdvSearchTestBaseCustom {

    protected WebDriver driver;
    protected SearchesPage searchesPage;
    protected dms.dmsHome dmsHome;
    protected WebDriverWait wait;

    /*run browser, add custom page in MAP2, initialize dmsHome and home pages, open dws link*/
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
        Sites sites2 = editor.turnOnAdvSearchHorizWidgetSite();
        waitForJSandJQueryToLoad();
        wait.until(isSiteEditorInvisible());
        MAP2 map2 = sites2.goToMAP2();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        map2.clickCustomTab();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        wait.until(isAddPageVisible());
        map2PageEditor mapEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        mapEditor.setPageName("customadv");
        mapEditor.setPageTitle("customadv");
        mapEditor.setPageUrl("customadv");
        waitForJSandJQueryToLoad();
        mapEditor.addAdvancedSearchWidget();
        waitForJSandJQueryToLoad();
        mapEditor.activatePage();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        wait.until(isPageActivatedTooltipVisible());
        MAP2 map21 = mapEditor.backToMap();
        waitForJSandJQueryToLoad();
        map21.clickInventoryPageTab();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        wait.until(isAddPageVisible());
        map2PageEditor mapEditor1 = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        mapEditor1.activatePage();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        wait.until(isPageActivatedTooltipVisible());
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        searchesPage = PageFactory.initElements(driver, SearchesPage.class);
    }

    /*delete Custom and Inventory pages in MAP2, close browser*/
    @AfterClass(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        try {
            MAP2 map2 = dmsHome2.clickOnMap2Menu();
            waitForJSandJQueryToLoad();
            wait.until(isLoadingInvisible());
            map2.clickCustomTab();
            waitForJSandJQueryToLoad();
            wait.until(isLoadingInvisible());
            wait.until(getConditionForTitle("Custom"));
            map2.deletePage();
            waitForJSandJQueryToLoad();
            wait.until(isPageDeletedTooltipVisible());
            map2.clickInventoryPageTab();
            waitForJSandJQueryToLoad();
            wait.until(isLoadingInvisible());
            wait.until(getConditionForTitle("Inventory"));
            map2.deletePage();
            waitForJSandJQueryToLoad();
            wait.until(isPageDeletedTooltipVisible());
        } catch (Exception ex) {
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

    protected ExpectedCondition<Boolean> getConditionForTitle(String pageName) {
        return ExpectedConditions.textToBe(By.xpath("//div[@class='pull-left']/span"), pageName);
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

    protected ExpectedCondition<WebElement> isPostFormVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.className("btn-message-ok")));
    }

    protected ExpectedCondition<WebElement> isLeadsListVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.id("leads-list-width")));
    }

    protected ExpectedCondition<WebElement> isHomeBreadcrumbsVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='slid_breadcrumb']//a[contains(text(), 'Home')]")));
    }

    protected ExpectedCondition<Boolean> isSiteEditorInvisible() {
        return ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-labelledby='ui-dialog-title-site_editor']"));
    }

    protected ExpectedCondition<WebElement> isWebsiteSidePanelVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.className("td_left_user-managment")));
    }

    protected ExpectedCondition<WebElement> isLocalizationBreadcrumbsVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='header_dealership'][contains(text(), 'Localization')]")));
    }

    protected ExpectedCondition<WebElement> isUWFormVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.id("informationform")));
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
