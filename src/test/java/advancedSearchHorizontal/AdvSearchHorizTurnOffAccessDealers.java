package advancedSearchHorizontal;

import dmsDealers.Dealers;
import dmsDealers.SitePackage;
import dwsPages.SearchesPage;
import map2.MAP2;
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

/**
 * Created by Julia on 16.03.2017.
 */
public class AdvSearchHorizTurnOffAccessDealers extends TestBase {

    private map2PageEditor homeEditor;
    private MAP2 map2;
    private WebDriverWait wait;


    /*Advanced Search Horizontal widget should not be present in MAP2 in library*/
    @Test
    public void advSearchHorizWidgetDoesntExistInLib() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 20);
        waitForJSandJQueryToLoad();
        dms.dmsHome dmsHome1 = PageFactory.initElements(driver, dms.dmsHome.class);
        dmsHome2 = dmsHome1.loginToDms();
        waitForJSandJQueryToLoad();
        //navigate to dms-Dealers
        Dealers dealers = dmsHome2.clickOnDealersMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        //turn off Advanced Search Horizontal page from access
        SitePackage editor = dealers.turnOnAccess();
        waitForJSandJQueryToLoad();
        wait.until(editor.isEditorVisible());
        Dealers dealers2 = editor.turnOffAdvSearch2WidgetDealers();
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
        wait.until(getConditionForTitle());
        Thread.sleep(1000);
        homeEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        Assert.assertFalse(homeEditor.isAdvancedSearchWidgetExists());
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
        /*turn on Advanced Search Horizontal page from access*/
        SitePackage editor = dealers.turnOnAccess();
        waitForJSandJQueryToLoad();
        wait.until(editor.isEditorVisible());
        Dealers dealers2 = editor.turnOnAdvSearch2WidgetDealers();
        waitForJSandJQueryToLoad();
        wait.until(dealers2.isEditorInvisible());
        dealers2.clickSave();
        waitForJSandJQueryToLoad();
        /*add widget to MAP2 home page*/
        map2 = dealers2.goToMAP2();
        waitForJSandJQueryToLoad();
        map2.clickHomePageTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        wait.until(getConditionForTitle());
        Thread.sleep(1000);
        homeEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        homeEditor.addAdvancedSearchWidget();
        waitForJSandJQueryToLoad();
        homeEditor.activatePage();
        waitForJSandJQueryToLoad();
        /*turn off widget from access*/
        Dealers dealers1 = map2.clickOnDealersMenu();
        waitForJSandJQueryToLoad();
        SitePackage editor3 = dealers1.turnOnAccess();
        waitForJSandJQueryToLoad();
        wait.until(editor3.isEditorVisible());
        Dealers dealers4 = editor3.turnOffAdvSearch2WidgetDealers();
        waitForJSandJQueryToLoad();
        wait.until(dealers4.isEditorInvisible());
        dealers2.clickSave();
        waitForJSandJQueryToLoad();
        /*go to MAP2 and check, if added widget isn't displayed*/
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
        Thread.sleep(1000);
        homeEditor = map2.editLastPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        Assert.assertFalse(homeEditor.isAdvancesSearchWidgetExistsInEditor());
        Thread.sleep(1000);
        MAP2 map22 = homeEditor.backToMap();
        wait.until(getConditionForTitle());
        waitForJSandJQueryToLoad();
        map22.deletePage();
        waitForJSandJQueryToLoad();
    }

    /*Advanced Search Horizontal widget should not be present on dws page*/
    @Test
    public void advSearchHorizdwsWidgetDoesntExist() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 20);
        waitForJSandJQueryToLoad();
        dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        //navigate to dms-Dealers
        Dealers dealers = dmsHome2.clickOnDealersMenu();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        //turn on Advanced Search Horizontal page from access
        SitePackage editor = dealers.turnOnAccess();
        waitForJSandJQueryToLoad();
        wait.until(editor.isEditorVisible());
        Dealers dealers2 = editor.turnOnAdvSearch2WidgetDealers();
        waitForJSandJQueryToLoad();
        wait.until(dealers2.isEditorInvisible());
        dealers2.clickSave();
        waitForJSandJQueryToLoad();
        //add widget to MAP2 Home page
        map2 = dealers2.goToMAP2();
        waitForJSandJQueryToLoad();
        map2.clickHomePageTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        Thread.sleep(1000);
        homeEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        homeEditor.addAdvancedSearchWidget();
        waitForJSandJQueryToLoad();
        homeEditor.activatePage();
        waitForJSandJQueryToLoad();
        //turn off widget from access
        Dealers dealers1 = map2.clickOnDealersMenu();
        waitForJSandJQueryToLoad();
        SitePackage editor3 = dealers1.turnOnAccess();
        wait.until(editor3.isEditorVisible());
        Dealers dealers4 = editor3.turnOffAdvSearch2WidgetDealers();
        wait.until(dealers4.isEditorInvisible());
        dealers2.clickSave();
        waitForJSandJQueryToLoad();
        driver.get(PropertyLoader.loadProperty("dws.url2") + "index.html");
        waitForJSandJQueryToLoad();
        SearchesPage searchesPage = PageFactory.initElements(driver, SearchesPage.class);
        Assert.assertFalse(searchesPage.isAdvSearchHorizWidgetExists());
        Thread.sleep(1000);
        //delete the last home page in MAP2
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        MAP2 map22 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        map22.clickHomePageTab();
        waitForJSandJQueryToLoad();
        wait.until(getConditionForTitle());
        Thread.sleep(1000);
        map22.deletePage();
        waitForJSandJQueryToLoad();
    }

    protected ExpectedCondition<Boolean> getConditionForTitle() {
        return ExpectedConditions.textToBe(By.xpath("//div[@class='pull-left']/span"), "Index");
    }
}
