/*MAP2 page (pages tree)*/
package map2;

import dmsDealers.Dealers;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page.Page;
import settings.Sites;
import settings.Website;

import java.io.IOException;

/**
 * Created by Julia on 04.01.2017.
 */
public class MAP2 extends Page {
    public MAP2(WebDriver webDriver) {
        super(webDriver);
    }

    /*declare elements on the page*/
    @FindBy(how = How.CSS, using = "div[data-page='contact_us']")
    private WebElement contactUsTab;

    @FindBy(how = How.CSS, using = "div.map-link.pull-right")
    private WebElement addPageBtn;

    @FindBy(how = How.XPATH, using = "(//span[@class='ui-button ui-state-default'])[last()]")
    private WebElement deleteLastPageBtn;

    @FindBy(how = How.CSS, using = "a[href='/dms/admin']")
    private WebElement adminMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/admin/dealers']")
    private WebElement dealersMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/settings']")
    private WebElement settingsMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/settings/sites']")
    private WebElement sitesMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/settings/website']")
    private WebElement websiteMenuItem;



    /*click on Contact Us tab in pages tree*/
    public void clickContactTab() {
        contactUsTab.click();
    }

    /*click on Add Page button, that opens Contact Us editor*/
    public ContactEditor clickAddPage() {
        addPageBtn.click();
        return PageFactory.initElements(driver, ContactEditor.class);
    }

    /*click on Delete Page icon*/
    public void deletePage() {
            deleteLastPageBtn.click();
            driver.switchTo().alert().accept(); //click OK in alert

    }

    /*ckeck if Contact Us tab exists in pages tree*/
    public boolean isContactTabExists() {
        try {
            contactUsTab.isDisplayed();
            return true;// return true, if element exists
        } catch (NoSuchElementException ex) {
            return false;//return false, if element doesn't exist
        }
    }

    /*go to dms Dealers module*/
    public Dealers clickOnDealersMenu() {
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(adminMenuItem).build();
        moveToElem.perform();
        dealersMenuItem.click();
        return PageFactory.initElements(driver, Dealers.class);
    }

    /*go to dms Sites module*/
    public Sites clickOnSitesMenu() {
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(settingsMenuItem).build();
        moveToElem.perform();
        sitesMenuItem.click();
        return PageFactory.initElements(driver, Sites.class);
    }

    /*go to dms Website General page*/
    public Website clickOnWebsiteMenu() {
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(settingsMenuItem).build();
        moveToElem.perform();
        websiteMenuItem.click();
        return PageFactory.initElements(driver, Website.class);
    }
}
