package TradeInForm;

import dmsDealers.Dealers;
import dmsDealers.SitePackage;
import map2.MAP2;
import map2.map2PageEditor;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.Website;
import testcase.TestBase;
import utility.PropertyLoader;

/**
 * Created by Julia on 15.02.2017.
 */
public class TradeInTurnOffAccessDealers extends TestBase {

    private map2PageEditor tradeInEditor;
    private MAP2 map2;
    private WebDriverWait wait;

    /*Trade In tab should not be present in MAP2*/
    @Test
    public void tradeInPageMAP2DoesntExist() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 20);
        /*navigate to dms-Dealers*/
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Dealers dealers = dmsHome2.clickOnDealersMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1100);
        /*turn off Contact Us page from access*/
        SitePackage editor = dealers.turnOnAccess();
        waitForJSandJQueryToLoad();
        wait.until(editor.isEditorVisible());
        Dealers dealers2 = editor.turnOffTradeInPageDealers();
        waitForJSandJQueryToLoad();
        /*wait until editor will be closed*/
        wait.until(dealers2.isEditorInvisible());
        dealers2.clickSave();
        waitForJSandJQueryToLoad();
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome dmsHome1 = PageFactory.initElements(driver, dms.dmsHome.class);
        dmsHome2 = dmsHome1.loginToDmsManager();
        waitForJSandJQueryToLoad();
        map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        Assert.assertFalse(map2.isTradeInTabExists());
    }

    /*Trade In tab should not be present in dws, it redirects on inventory page*/
    @Test
    public void tradeInPageDwsDoesntExist() throws InterruptedException {
        /*login under supervisor*/
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 20);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*navigate to dms-Dealers*/
        Dealers dealers = dmsHome2.clickOnDealersMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1100);
        /*turn on Trade In page from access*/
        SitePackage editor = dealers.turnOnAccess();
        waitForJSandJQueryToLoad();
        wait.until(editor.isEditorVisible());
        Dealers dealers2 = editor.turnOnTradeInPageDealers();
        waitForJSandJQueryToLoad();
        wait.until(dealers2.isEditorInvisible());//wait until editor will be closed
        dealers2.clickSave();
        waitForJSandJQueryToLoad();
        /*navigate to MAP2*/
        MAP2 map2 = dealers2.goToMAP2();
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
        /*navigate to dms-Dealers*/
        Dealers dealers3 = map21.clickOnDealersMenu();
        waitForJSandJQueryToLoad();
        /*turn off Trade In page from access*/
        SitePackage editor2 = dealers3.turnOnAccess();
        waitForJSandJQueryToLoad();
        wait.until(editor2.isEditorVisible());
        Dealers dealers4 = editor.turnOffTradeInPageDealers();
        waitForJSandJQueryToLoad();
        wait.until(dealers4.isEditorInvisible());//wait until editor will be closed
        dealers4.clickSave();
        waitForJSandJQueryToLoad();
        /*navigate to dms - Settings - Website General*/
        Website website = dealers4.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        /*Set 'The '404 not found' Redirection' setting to 'Inventory page (default)'*/
        website.set404Redir(PropertyLoader.loadProperty("the404InventoryRedirect"));
        waitForJSandJQueryToLoad();
        /*open Trade In dws page*/
        driver.get(PropertyLoader.loadProperty("dws.url2") + "tradein");
        waitForJSandJQueryToLoad();

        Assert.assertEquals(driver.getCurrentUrl(), PropertyLoader.loadProperty("dws.url2") + "cars-for-sale.html");

        /*turn on Trade In page in Access*/
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Dealers dealers1 = dmsHome2.clickOnDealersMenu();
        waitForJSandJQueryToLoad();
        SitePackage editor3 = dealers1.turnOnAccess();
        waitForJSandJQueryToLoad();
        wait.until(editor3.isEditorVisible());
        Dealers dealers5 = editor.turnOnTradeInPageDealers();
        waitForJSandJQueryToLoad();
        wait.until(dealers5.isEditorInvisible());//wait until editor will be closed
        dealers5.clickSave();
        waitForJSandJQueryToLoad();
        /*delete the last created Trade In page in MAP2*/
        MAP2 map22 = dealers5.goToMAP2();
        waitForJSandJQueryToLoad();
        map22.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(getConditionForTitle());
        map22.deletePage();
        waitForJSandJQueryToLoad();
    }

    /*Contact Us widget should not be present in MAP2 in library*/
    @Test
    public void tradeInWidgetDoesntExistInLib() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 20);
        waitForJSandJQueryToLoad();
        dms.dmsHome dmsHome1 = PageFactory.initElements(driver, dms.dmsHome.class);
        dmsHome2 = dmsHome1.loginToDms();
        waitForJSandJQueryToLoad();
        /*navigate to dms-Dealers*/
        Dealers dealers = dmsHome2.clickOnDealersMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*turn on Contact Us page from access*/
        SitePackage editor = dealers.turnOnAccess();
        waitForJSandJQueryToLoad();
        wait.until(editor.isEditorVisible());
        Dealers dealers2 = editor.turnOnTradeInPageDealers();
        waitForJSandJQueryToLoad();
        wait.until(dealers2.isEditorInvisible());
        /*turn off Contact Us widget from access*/
        SitePackage editor2 = dealers.clickSitePackBtn();
        waitForJSandJQueryToLoad();
        wait.until(editor2.isEditorVisible());
        Dealers dealers3 = editor.turnOffTradeInWidgetDealers();
        waitForJSandJQueryToLoad();
        wait.until(dealers3.isEditorInvisible());
        dealers2.clickSave();
        waitForJSandJQueryToLoad();
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome dmsHome11 = PageFactory.initElements(driver, dms.dmsHome.class);
        dmsHome2 = dmsHome11.loginToDmsManager();
        waitForJSandJQueryToLoad();
        map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        map2.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        wait.until(getConditionForTitle());
        Thread.sleep(1000);
        tradeInEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        Assert.assertFalse(tradeInEditor.isTradeInWidgetExists());
    }

    @Test
    public void tradeInWidgetDoesntExistInEditor() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 20);
        waitForJSandJQueryToLoad();
        dms.dmsHome dmsHome1 = PageFactory.initElements(driver, dms.dmsHome.class);
        dmsHome2 = dmsHome1.loginToDms();
        waitForJSandJQueryToLoad();
        /*navigate to dms-Dealers*/
        Dealers dealers = dmsHome2.clickOnDealersMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*turn on Contact Us page from access*/
        SitePackage editor = dealers.turnOnAccess();
        waitForJSandJQueryToLoad();
        wait.until(editor.isEditorVisible());
        Dealers dealers2 = editor.turnOnTradeInPageDealers();
        waitForJSandJQueryToLoad();
        wait.until(dealers2.isEditorInvisible());
        /*turn on Contact Us widget from access*/
        SitePackage editor2 = dealers.clickSitePackBtn();
        waitForJSandJQueryToLoad();
        wait.until(editor2.isEditorVisible());
        Dealers dealers3 = editor.turnOnTradeInWidgetDealers();
        waitForJSandJQueryToLoad();
        wait.until(dealers3.isEditorInvisible());
        dealers2.clickSave();
        waitForJSandJQueryToLoad();
        map2 = dealers2.goToMAP2();
        waitForJSandJQueryToLoad();
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
        Dealers dealers1 = map2.clickOnDealersMenu();
        waitForJSandJQueryToLoad();
        SitePackage editor3 = dealers1.turnOnAccess();
        waitForJSandJQueryToLoad();
        wait.until(editor3.isEditorVisible());
        Dealers dealers4 = editor3.turnOffTradeInWidgetDealers();
        waitForJSandJQueryToLoad();
        wait.until(dealers4.isEditorInvisible());
        dealers2.clickSave();
        waitForJSandJQueryToLoad();
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome dmsHome11 = PageFactory.initElements(driver, dms.dmsHome.class);
        dmsHome2 = dmsHome11.loginToDmsManager();
        waitForJSandJQueryToLoad();
        map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        map2.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        Thread.sleep(1000);
        tradeInEditor = map2.editLastPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        Assert.assertFalse(tradeInEditor.isTradeInWidgetExistsInEditor());
        Thread.sleep(1000);
        MAP2 map22 =  tradeInEditor.backToMap();
        wait.until(getConditionForTitle());
        waitForJSandJQueryToLoad();
        map22.deletePage();
        waitForJSandJQueryToLoad();
    }

    /*Trade In widget should not be present on dws page*/
    @Test
    public void tradeInDdwsWidgetDoesntExist() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 20);
        waitForJSandJQueryToLoad();
        dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        /*navigate to dms-Dealers*/
        Dealers dealers = dmsHome2.clickOnDealersMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*turn on Contact Us page from access*/
        SitePackage editor = dealers.turnOnAccess();
        waitForJSandJQueryToLoad();
        wait.until(editor.isEditorVisible());
        Dealers dealers2 = editor.turnOnTradeInPageDealers();
        wait.until(dealers2.isEditorInvisible());
        /*turn off Contact Us widget from access*/
        SitePackage editor2 = dealers.clickSitePackBtn();
        waitForJSandJQueryToLoad();
        wait.until(editor2.isEditorVisible());
        Dealers dealers3 = editor.turnOnTradeInWidgetDealers();
        waitForJSandJQueryToLoad();
        wait.until(dealers3.isEditorInvisible());
        dealers2.clickSave();
        waitForJSandJQueryToLoad();
        map2 = dealers2.goToMAP2();
        waitForJSandJQueryToLoad();
        map2.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        Thread.sleep(1000);
        tradeInEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        tradeInEditor.addTradeInWidget();
        waitForJSandJQueryToLoad();
        tradeInEditor.activatePage();
        waitForJSandJQueryToLoad();
        Dealers dealers1 = map2.clickOnDealersMenu();
        waitForJSandJQueryToLoad();
        SitePackage editor3 = dealers1.turnOnAccess();
        wait.until(editor3.isEditorVisible());
        Dealers dealers4 = editor3.turnOffTradeInWidgetDealers();
        wait.until(dealers4.isEditorInvisible());
        dealers2.clickSave();
        waitForJSandJQueryToLoad();
        driver.get(PropertyLoader.loadProperty("dws.url2") + "tradein.html");
        waitForJSandJQueryToLoad();
        Assert.assertFalse(dwsPage.isTradeInWidgetExists());
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        MAP2 map22 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        map22.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(getConditionForTitle());
        Thread.sleep(1000);
        map22.deletePage();
        waitForJSandJQueryToLoad();
    }

    public static ExpectedCondition<Boolean> absenceOfElementLocated(
            final By locator) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    driver.findElement(locator);
                    return false;
                } catch (NoSuchElementException e) {
                    return true;
                } catch (StaleElementReferenceException e) {
                    return true;
                }
            }

            @Override
            public String toString() {
                return "element to not being present: " + locator;
            }
        };
    }

    protected ExpectedCondition<Boolean> getConditionForTitle() {
        return ExpectedConditions.textToBe(By.xpath("//div[@class='pull-left']/span"), "Trade_in");
    }
}
