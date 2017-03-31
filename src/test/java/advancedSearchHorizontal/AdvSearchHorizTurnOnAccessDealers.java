package advancedSearchHorizontal;

import dmsDealers.Dealers;
import dmsDealers.SitePackage;
import dwsPages.SearchesPage;
import map2.MAP2;
import map2.PreviewPage;
import map2.map2PageEditor;
import org.openqa.selenium.By;
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
 * Created by Julia on 16.03.2017.
 */
public class AdvSearchHorizTurnOnAccessDealers extends TestBase {

    private map2PageEditor homeEditor;
    private MAP2 map2;
    private WebDriverWait wait;

    /*Advanced Search widget should not be present in MAP2 in library*/
    @Test
    public void advSearchHorizWidgetExistsInLib() throws InterruptedException {
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
        /*turn off Advanced Search Horizontal widget from access*/
        SitePackage editor = dealers.turnOnAccess();
        waitForJSandJQueryToLoad();
        wait.until(editor.isEditorVisible());
        Dealers dealers2 = editor.turnOnAdvSearch2WidgetDealers();
        waitForJSandJQueryToLoad();
        wait.until(dealers2.isEditorInvisible());
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
        map2.clickHomePageTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        wait.until(getConditionForTitleHome());
        Thread.sleep(1000);
        homeEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        Assert.assertTrue(homeEditor.isAdvancedSearchWidgetExists());
    }

    @Test
    public void advSearchHorizWidgetExistsInEditor() throws InterruptedException {
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
        /*turn off Advanced Search Horizontal page from access*/
        SitePackage editor = dealers.turnOnAccess();
        waitForJSandJQueryToLoad();
        wait.until(editor.isEditorVisible());
        Dealers dealers2 = editor.turnOnAdvSearch2WidgetDealers();
        waitForJSandJQueryToLoad();
        wait.until(dealers2.isEditorInvisible());
        dealers2.clickSave();
        waitForJSandJQueryToLoad();
        map2 = dealers2.goToMAP2();
        waitForJSandJQueryToLoad();
        map2.clickHomePageTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        wait.until(getConditionForTitleHome());
        Thread.sleep(1000);
        homeEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        homeEditor.addAdvancedSearchWidget();
        waitForJSandJQueryToLoad();
        Assert.assertTrue(homeEditor.isAdvancesSearchWidgetExistsInEditor());
        Thread.sleep(1000);

    }

    /*Advanced Search Horizontal widget should not be present on dws page*/
    @Test
    public void advSearchHorizDwsWidgetExist() throws InterruptedException {
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
        /*turn off Advanced Search Horizontal page from access*/
        SitePackage editor = dealers.turnOnAccess();
        waitForJSandJQueryToLoad();
        wait.until(editor.isEditorVisible());
        Dealers dealers2 = editor.turnOnAdvSearch2WidgetDealers();
        waitForJSandJQueryToLoad();
        wait.until(dealers2.isEditorInvisible());
        dealers2.clickSave();
        waitForJSandJQueryToLoad();
        map2 = dealers2.goToMAP2();
        waitForJSandJQueryToLoad();
        map2.clickHomePageTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        wait.until(getConditionForTitleHome());
        homeEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        homeEditor.addAdvancedSearchWidget();
        waitForJSandJQueryToLoad();
        homeEditor.activatePage();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        PreviewPage previewPage = homeEditor.clickOnPreview();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);
        SearchesPage searchesPage = previewPage.clickOnVisitWebsiteHome();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(2));
        Thread.sleep(500);
        Assert.assertTrue(searchesPage.isAdvSearchHorizWidgetExists());
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        MAP2 map21 = homeEditor.backToMap();
        waitForJSandJQueryToLoad();
        wait.until(getConditionForTitleHome());
        Thread.sleep(1000);
        map21.deletePage();
        waitForJSandJQueryToLoad();
    }

    protected ExpectedCondition<Boolean> getConditionForTitleHome() {
        return ExpectedConditions.textToBe(By.xpath("//div[@class='pull-left']/span"), "Index");
    }

}
