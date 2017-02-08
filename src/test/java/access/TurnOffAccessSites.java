package access;

import dms.SiteEditor;
import dms.dmsHome2;
import map2.ContactEditor;
import map2.MAP2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.Sites;
import testcase.TestBase;

/**
 * Created by Julia on 11.01.2017.
 */
public class TurnOffAccessSites extends TestBase {
    protected ContactEditor contactEditor;
    protected MAP2 map2;
    WebDriverWait wait;

    /*Contact Us tab should not be present in MAP2*/
    @Test(priority = 1)
    public void dmsPageDoesntExist() throws InterruptedException {
        wait = new WebDriverWait(driver, 25);
        /*navigate to dms-Sites*/
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        wait.until(jsLoad);
        Sites sites = dmsHome2.clickOnSitesMenu();
        wait.until(jsLoad);
        /*turn off Contact Us page from access*/
        SiteEditor editor = sites.openSiteEditor();
        wait.until(jsLoad);
        Thread.sleep(1000);
        Sites sites2 = editor.turnOffPageSite();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-labelledby='ui-dialog-title-site_editor']")));
        //  Thread.sleep(15000);
        /*navigate to MAP2*/
        map2 = sites2.goToMAP2();
        wait.until(jsLoad);
        Assert.assertFalse(map2.isContactTabExists());
        Thread.sleep(3000);
    }

    /*Contact Us widget should not be present in MAP2*/
    @Test(priority = 2)
    public void dmsWidgetDoesntExist() throws InterruptedException {
        wait = new WebDriverWait(driver, 25);
        wait.until(jsLoad);
        /*navigate to dms-Sites*/
        Sites sites = map2.clickOnSitesMenu();
        wait.until(jsLoad);
        Thread.sleep(2000);
        /*turn on Contact Us page from access*/
        SiteEditor editor = sites.openSiteEditor();
        wait.until(jsLoad);
        Thread.sleep(2000);
        Sites sites2 = editor.turnOnPageSite();
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-labelledby='ui-dialog-title-site_editor']")));
        Thread.sleep(15000);
        /*turn off Contact Us widget from access*/
        SiteEditor editor2 = sites2.openSiteEditor();
        wait.until(jsLoad);
        Thread.sleep(3000);
        Sites sites3 = editor2.turnOffWidgetSite();
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-labelledby='ui-dialog-title-site_editor']")));
        Thread.sleep(15000);
        /*navigate to MAP2*/
        map2 = sites3.goToMAP2();
        wait.until(jsLoad);
        Thread.sleep(1000);
        map2.clickContactTab();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        Thread.sleep(2000);
        contactEditor = map2.clickAddPage();
        Thread.sleep(2000);
        Assert.assertFalse(contactEditor.isContactWidgetExists());
        Thread.sleep(3000);
    }

    /*Contact Us widget should not be present on dws page*/
    @Test(priority = 3)
    public void dwsWidgetDoesntExist() throws InterruptedException {
        driver.get("http://www.tacker.ixloo.com/contactus2");
        wait.until(jsLoad);
        Assert.assertFalse(contactUs.isWidgetExists());
        Thread.sleep(3000);
    }
}
