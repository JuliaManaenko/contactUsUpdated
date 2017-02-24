package TradeInForm;

import contactUsPage.ContactUs;
import dmsDealers.Dealers;
import dmsDealers.SitePackage;
import map2.ContactEditor;
import map2.MAP2;
import map2.PreviewPage;
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
import testcase.TestBase;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 16.02.2017.
 */
public class TradeInTurnOnAccessDealers extends TestBase {

    private ContactEditor tradeInEditor;
    private MAP2 map2;
    private WebDriverWait wait;

    /*Trade In tab should not be present in MAP2*/
    @Test
    public void tradeInPageMAP2Exist() throws InterruptedException {
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
        Dealers dealers2 = editor.turnOnTradeInPageDealers();
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
        Assert.assertTrue(map2.isTradeInTabExists());
    }

    /*Trade In tab should not be present in dws, it redirects on inventory page*/
    @Test
    public void tradeInPageDwsExist() throws InterruptedException {
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
        /*turn on Trade In page from access*/
        SitePackage editor = dealers.turnOnAccess();
        waitForJSandJQueryToLoad();
        wait.until(editor.isEditorVisible());
        Dealers dealers2 = editor.turnOnTradeInPageDealers();
        waitForJSandJQueryToLoad();
        /*wait until editor will be closed*/
        wait.until(dealers2.isEditorInvisible());
        dealers2.clickSave();
        waitForJSandJQueryToLoad();
        MAP2 map2 = dealers2.goToMAP2();
        waitForJSandJQueryToLoad();
        map2.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        Thread.sleep(1000);
        tradeInEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        tradeInEditor.activatePage();
        waitForJSandJQueryToLoad();
        driver.get(PropertyLoader.loadProperty("dws.url2") + "tradein");
        waitForJSandJQueryToLoad();

        Assert.assertEquals(driver.getCurrentUrl(), PropertyLoader.loadProperty("dws.url2") + "tradein");

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

    /*Contact Us widget should not be present in MAP2 in library*/
    @Test
    public void tradeInWidgettExistsInLib() throws InterruptedException {
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
        Dealers dealers3 = editor.turnOnTradeInWidgetDealers();
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
        Assert.assertTrue(tradeInEditor.isTradeInWidgetExists());
    }

    @Test
    public void tradeInWidgetExistsInEditor() throws InterruptedException {
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
        Assert.assertTrue(tradeInEditor.isTradeInWidgetExistsInEditor());
        Thread.sleep(1000);

    }

    /*Contact Us widget should not be present on dws page*/
    @Test
    public void tradeInDwsWidgetExist() throws InterruptedException {
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
        Thread.sleep(1000);
        PreviewPage previewPage = tradeInEditor.clickOnPreview();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);
        ContactUs dwsPage2 = previewPage.clickOnVisitWebsite();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(2));
        Thread.sleep(500);
        Assert.assertTrue(dwsPage2.isTradeInWidgetExists());
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        MAP2 map21 = tradeInEditor.backToMap();
        waitForJSandJQueryToLoad();
        wait.until(getConditionForTitle());
        Thread.sleep(1000);
        map21.deletePage();
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
