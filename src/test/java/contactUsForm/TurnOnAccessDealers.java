package contactUsForm;

import dms.dmsHome2;
import dmsDealers.Dealers;
import dmsDealers.SitePackage;
import map2.MAP2;
import map2.map2PageEditor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcase.TestBase;

/**
 * Created by Julia on 04.01.2017.
 */

public class TurnOnAccessDealers extends TestBase {
    //  protected dmsHome dmsHome;
    protected map2PageEditor map2PageEditor;
    protected MAP2 map2;
    WebDriverWait wait;

    /*Contact Us tab should not be present in MAP2*/
    @Test(priority = 1)
    public void pageExists() throws InterruptedException {
        wait = new WebDriverWait(driver, 20);
        dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Thread.sleep(1000);
            /*navigate to dms-Dealers*/
        Dealers dealers = dmsHome2.clickOnDealersMenu();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
            /*turn on Contact Us widget from access*/
        SitePackage editor = dealers.turnOnAccess();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@aria-labelledby='ui-dialog-title-site_package_editor']"))));
        Thread.sleep(1000);
        Dealers dealers2 = editor.turnOnWidgetDealers();
            /*turn on Contact Us page from access*/
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-labelledby='ui-dialog-title-site_package_editor']")));
        SitePackage editor2 = dealers.clickSitePackBtn();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@aria-labelledby='ui-dialog-title-site_package_editor']"))));
        Dealers dealers3 = editor.turnOnPageDealers();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-labelledby='ui-dialog-title-site_package_editor']")));
        dealers2.clickSave();
        waitForJSandJQueryToLoad();
        // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("idBackCont")));
       // Thread.sleep(15000);
        map2 = dealers2.goToMAP2();
        Assert.assertTrue(map2.isContactTabExists());
    }

    /*Contact Us widget should be present in MAP2*/
    @Test(priority = 2)
    public void widgetExists() throws InterruptedException {
        Thread.sleep(1000);
        map2.clickContactTab();
        waitForJSandJQueryToLoad();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        Thread.sleep(1000);
        map2PageEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertTrue(map2PageEditor.isContactWidgetExists());
    }

    /*Contact Us widget should be present on dws page*/
    @Test(priority = 3)
    public void dwsWidgetExists() throws InterruptedException {
        driver.get("http://www.tacker.ixloo.com/contactus2");
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Assert.assertTrue(dwsPage.isWidgetExists());
    }
}
