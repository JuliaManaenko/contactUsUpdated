/*dms Dealers page*/
package dmsDealers;

import map2.MAP2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.Page;
import settings.Website;

/**
 * Created by Julia on 03.01.2017.
 */
public class Dealers extends Page{

    public Dealers(WebDriver webDriver) {
        super(webDriver);
    }

     /*declare elements on the page*/

    @FindBy(how = How.ID, using = "dealer_20")
    private WebElement domainInTree;

    @FindBy(how= How.ID, using ="site_package_editor_open")
    private WebElement sitePackEditBtn;

    @FindBy(how= How.ID, using ="dealer_save")
    private WebElement saveBtn;

    @FindBy(how = How.CSS, using = "a[href='/dms/tools']")
    private WebElement toolsMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/tools/make_a_page_2']")
    private WebElement map2MenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/settings']")
    private WebElement settingsMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/settings/website']")
    private WebElement websiteMenuItem;

    @FindBy(how = How.ID, using = "idBackCont")
    private WebElement screenLoading;

    /*Open Site Package editor for tacker.ixloo.com*/
    public SitePackage turnOnAccess() throws InterruptedException {
        Actions action = new Actions(driver);
        Action dblclick = action.doubleClick(domainInTree).build();
        dblclick.perform();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        sitePackEditBtn.click();
        waitForJSandJQueryToLoad();
        return PageFactory.initElements(driver, SitePackage.class);
    }

    /*click on Site Package Edit button*/
    public SitePackage clickSitePackBtn() throws InterruptedException {
        sitePackEditBtn.click();
        waitForJSandJQueryToLoad();
        return PageFactory.initElements(driver, SitePackage.class);
    }

    /*click on Save button*/
    public void clickSave(){
        saveBtn.click();
    }


    /*click on MAP2 in dms menu*/
    public MAP2 goToMAP2(){
    /*    Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(toolsMenuItem).build();
        moveToElem.perform();
        map2MenuItem.click();*/
        driver.get("http://www.svtautotest.ixloo.com/dms/tools/make_a_page_2");
        return PageFactory.initElements(driver, MAP2.class);
    }

    /*go to dms Website General page*/
    public Website clickOnWebsiteMenu() {
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(settingsMenuItem).build();
        moveToElem.perform();
        websiteMenuItem.click();
        return PageFactory.initElements(driver, Website.class);
    }

    public ExpectedCondition<Boolean> isEditorInvisible() {
        return ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-labelledby='ui-dialog-title-site_package_editor']"));
    }

    public boolean isLoadingExists(){
        try{
            screenLoading.isDisplayed();
            return false;
        }
        catch (NoSuchElementException ex){
            return true;
        }
    }
}
