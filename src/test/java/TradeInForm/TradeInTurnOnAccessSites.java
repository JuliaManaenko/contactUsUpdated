package TradeInForm;

import dms.SiteEditor;
import map2.MAP2;
import map2.map2PageEditor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.Sites;
import testcase.TestBase;
import utility.PropertyLoader;

/**
 * Created by Julia on 16.02.2017.
 */
public class TradeInTurnOnAccessSites extends TestBase {

    private map2PageEditor tradeInEditor;
    private MAP2 map2;
    private WebDriverWait wait;

    /*Trade In tab should be present in MAP2*/
    @Test
    public void tradeInMapPageExists() throws InterruptedException {
        /*login under supervisor*/
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 20);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        /*navigate to dms-Sites*/
        Sites sites = dmsHome2.clickOnSitesMenu();
        waitForJSandJQueryToLoad();
        /*turn on Trade In page from access*/
        SiteEditor editor = sites.openSiteEditor();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Sites sites2 = editor.turnOnTradeInPageSite();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-labelledby='ui-dialog-title-site_editor']")));
        /*navigate to MAP2*/
        map2 = sites2.goToMAP2();
        waitForJSandJQueryToLoad();

        Assert.assertTrue(map2.isTradeInTabExists());
    }

    /*Trade In tab should be present in dws*/
    @Test
    public void tradeInPageDwsExists() throws InterruptedException {
        /*login under supervisor*/
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 20);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        /*navigate to dms-Sites*/
        Sites sites = dmsHome2.clickOnSitesMenu();
        waitForJSandJQueryToLoad();
        /*turn on Trade In page from access*/
        SiteEditor editor = sites.openSiteEditor();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Sites sites2 = editor.turnOnTradeInPageSite();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-labelledby='ui-dialog-title-site_editor']")));
        /*navigate to MAP2*/
        map2 = sites2.goToMAP2();
        waitForJSandJQueryToLoad();
        /*add Trade In page*/
        map2.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        Thread.sleep(1000);
        tradeInEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        tradeInEditor.activatePage();
        waitForJSandJQueryToLoad();
        wait.until(isPageActivatedTooltipVisible());
        MAP2 map21 = tradeInEditor.backToMap();
        waitForJSandJQueryToLoad();
        /*open Trade In dws page*/
        driver.get(PropertyLoader.loadProperty("dws.url2") + "tradein");
        waitForJSandJQueryToLoad();

        Assert.assertEquals(driver.getCurrentUrl(), PropertyLoader.loadProperty("dws.url2") + "tradein");

        /*delete the last created Trade In page in MAP2*/
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        MAP2 map22 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        map22.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(getConditionForTitle());
        map22.deletePage();
        waitForJSandJQueryToLoad();
    }

    /*Trade In widget should be present in MAP2 editor in library*/
    @Test
    public void TradeInWidgetExistsInLib() throws InterruptedException {
        /*login under supervisor*/
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 20);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*navigate to dms-Sites*/
        Sites sites = dmsHome2.clickOnSitesMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*turn on Trade In page from access*/
        SiteEditor editor = sites.openSiteEditor();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Sites sites2 = editor.turnOnPageSite();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*turn on Trade In widget from access*/
        SiteEditor editor2 = sites2.openSiteEditor();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Sites sites3 = editor.turnOnWidgetSite();
        waitForJSandJQueryToLoad();
        /*login under manager*/
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome dmsHome1 = PageFactory.initElements(driver, dms.dmsHome.class);
        dmsHome2 = dmsHome1.loginToDmsManager();
        waitForJSandJQueryToLoad();
        /*navigate to MAP2*/
        map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*open new Trade In page in MAP2*/
        map2.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        Thread.sleep(1000);
        tradeInEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);

        Assert.assertTrue(tradeInEditor.isTradeInWidgetExists());
    }

    /*Trade In widget should be present in MAP2 Editor*/
    @Test
    public void TradeInWidgetExistsInEditor() throws InterruptedException {
        /*login under supervisor*/
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 20);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*navigate to dms-Sites*/
        Sites sites = dmsHome2.clickOnSitesMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*turn on Trade In page from access*/
        SiteEditor editor = sites.openSiteEditor();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Sites sites2 = editor.turnOnTradeInPageSite();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*turn on Trade In widget from access*/
        SiteEditor editor2 = sites2.openSiteEditor();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Sites sites3 = editor.turnOnTradeInWidgetSite();
        waitForJSandJQueryToLoad();
        /*navigate to MAP2*/
        map2 = sites3.goToMAP2();
        waitForJSandJQueryToLoad();
        /*add Trade In page and Trade In widget*/
        map2.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        wait.until(getConditionForTitle());
        Thread.sleep(1000);
        tradeInEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        tradeInEditor.addTradeInWidget();
        waitForJSandJQueryToLoad();
        tradeInEditor.activatePage();
        waitForJSandJQueryToLoad();
        wait.until(isPageActivatedTooltipVisible());
        /*login under manager*/
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome dmsHome1 = PageFactory.initElements(driver, dms.dmsHome.class);
        dmsHome2 = dmsHome1.loginToDmsManager();
        waitForJSandJQueryToLoad();
        /*navigate to MAP2*/
        map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*open the last created Trade In page*/
        map2.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        Thread.sleep(1000);
        tradeInEditor = map2.editLastPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);

        Assert.assertTrue(tradeInEditor.isTradeInWidgetExistsInEditor());
    }

    /*Trade In widget should not present on dws page*/
    @Test
    public void tradeInDwsWidgetExists() throws InterruptedException {
        /*login under supervisor*/
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 20);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*navigate to dms-Sites*/
        Sites sites = dmsHome2.clickOnSitesMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*turn on Trade In page from access*/
        SiteEditor editor = sites.openSiteEditor();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Sites sites2 = editor.turnOnTradeInPageSite();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*turn on Trade In widget from access*/
        SiteEditor editor2 = sites2.openSiteEditor();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Sites sites3 = editor.turnOnTradeInWidgetSite();
        waitForJSandJQueryToLoad();
        /*navigate to MAP2*/
        map2 = sites3.goToMAP2();
        waitForJSandJQueryToLoad();
        /*add Trade In page and Trade In widget*/
        map2.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        wait.until(getConditionForTitle());
        Thread.sleep(1000);
        tradeInEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        tradeInEditor.addTradeInWidget();
        waitForJSandJQueryToLoad();
        tradeInEditor.activatePage();
        waitForJSandJQueryToLoad();
        wait.until(isPageActivatedTooltipVisible());
        map2 = tradeInEditor.backToMap();
        waitForJSandJQueryToLoad();
        /*open Trade In page in dws*/
        driver.get(PropertyLoader.loadProperty("dws.url2") + "tradein.html");
        waitForJSandJQueryToLoad();

        Assert.assertTrue(dwsPage.isTradeInWidgetExists());

        /*delete the last created page in MAP2*/
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        MAP2 map22 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        map22.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(getConditionForTitle());
        map22.deletePage();
        waitForJSandJQueryToLoad();
    }
}
