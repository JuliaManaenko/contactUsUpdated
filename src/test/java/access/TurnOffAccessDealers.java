package access;

import dmsDealers.Dealers;
import dmsDealers.SitePackage;
import map2.ContactEditor;
import map2.MAP2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcase.TestBase;

/**
 * Created by Julia on 10.01.2017.
 */
public class TurnOffAccessDealers extends TestBase {
    protected ContactEditor contactEditor;
    protected MAP2 map2;
    WebDriverWait wait;

    /*Contact Us tab should not be present in MAP2*/
    @Test(priority = 1)
    public void pageDoesntExist() throws InterruptedException {
        wait = new WebDriverWait(driver, 20);
        /*navigate to dms-Dealers*/
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        wait.until(jsLoad);
        Thread.sleep(1000);
        Dealers dealers = dmsHome2.clickOnDealersMenu();
        wait.until(jsLoad);
        Thread.sleep(1000);
        /*turn off Contact Us page from access*/
        SitePackage editor = dealers.turnOnAccess();
        wait.until(editor.isEditorVisible());
        Dealers dealers2 = editor.turnOffPageDealers();
        /*wait until editor will be closed*/
        wait.until(dealers2.isEditorInvisible());
        dealers2.clickSave();
       // wait.until(absenceOfElementLocated(By.id("idBackCont")));
        Thread.sleep(15000);
        map2 = dealers2.goToMAP2();
        Assert.assertFalse(map2.isContactTabExists());

    }

    /*Contact Us widget should not be present in MAP2*/
    @Test(priority = 2)
    public void widgetDoesntExist() throws InterruptedException {
        wait = new WebDriverWait(driver, 20);
        wait.until(jsLoad);
        /*navigate to dms-Dealers*/
        Dealers dealers = map2.clickOnDealersMenu();
        wait.until(jsLoad);
        Thread.sleep(1000);
        /*turn on Contact Us page from access*/
        SitePackage editor = dealers.turnOnAccess();
        wait.until(editor.isEditorVisible());
        Dealers dealers2 = editor.turnOnPageDealers();
        wait.until(dealers2.isEditorInvisible());
        //Thread.sleep(2000);
        /*turn off Contact Us widget from access*/
        SitePackage editor2 = dealers.clickSitePackBtn();
        wait.until(editor2.isEditorVisible());
        Dealers dealers3 = editor.turnOffWidgetDealers();
        wait.until(dealers3.isEditorInvisible());
        dealers2.clickSave();
       // wait.until(absenceOfElementLocated(By.id("idBackCont")));
        Thread.sleep(15000);
        map2 = dealers2.goToMAP2();
        map2.clickContactTab();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        Thread.sleep(1000);
        contactEditor = map2.clickAddPage();
        Thread.sleep(2000);
        Assert.assertFalse(contactEditor.isContactWidgetExists());
    }

    /*Contact Us widget should not be present on dws page*/
    @Test(priority = 3)
    public void dwsWidgetDoesntExist() throws InterruptedException {
        driver.get("http://www.tacker.ixloo.com/contactus2");
        wait.until(jsLoad);
        Assert.assertFalse(contactUs.isWidgetExists());
    }

   /* ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
        }
    };*/

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
}
