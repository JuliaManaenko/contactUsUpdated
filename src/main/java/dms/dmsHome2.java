/*dms Home page*/
package dms;

import customers.Leads;
import dmsDealers.Dealers;
import map2.MAP2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page.Page;
import settings.Sites;
import settings.Users;
import settings.Website;
import webmail.WebmailLogin;

/**
 * Created by Julia on 03.01.2017.
 */
public class dmsHome2 extends Page {
    public dmsHome2(WebDriver webDriver) {
        super(webDriver);
    }

  /*declare elements on the page*/

    @FindBy(how = How.CSS, using = "a[href='/dms/admin']")
    private WebElement adminMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/admin/dealers']")
    private WebElement dealersMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/tools']")
    private WebElement toolsMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/tools/make_a_page_2']")
    private WebElement map2MenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/settings']")
    private WebElement settingsMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/settings/website']")
    private WebElement websiteMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/settings/sites']")
    private WebElement sitesMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/settings/users']")
    private WebElement usersMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/customers']")
    private WebElement customersMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/customers/leads']")
    private WebElement leadsMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/email']")
    private WebElement webmailMenuItem;


/*go to dms Dealers page*/
    public Dealers clickOnDealersMenu() {
        /*move mouse on Admin menu item*/
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(adminMenuItem).build();
        moveToElem.perform();
        dealersMenuItem.click();
        return PageFactory.initElements(driver, Dealers.class);
    }

    /*go to dms MAP2 page*/
    public MAP2 clickOnMap2Menu() {
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(toolsMenuItem).build();
        moveToElem.perform();
        map2MenuItem.click();
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

    public Website clickOnWebsiteMenu2() {
        driver.get("http://www.tacker.ixloo.com/dms/settings/website#general");
        return PageFactory.initElements(driver, Website.class);
    }

    /*go to dms Sites page*/
    public Sites clickOnSitesMenu() {
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(settingsMenuItem).build();
        moveToElem.perform();
        sitesMenuItem.click();
        return PageFactory.initElements(driver, Sites.class);
    }

    /*go to dms Users page*/
    public Users clickOnUsersMenu() {
    /*    Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(settingsMenuItem).build();
        moveToElem.perform();
        usersMenuItem.click();*/
    driver.get("http://www.tacker.ixloo.com/dms/settings/users");
        return PageFactory.initElements(driver, Users.class);
    }

    /*go to dms Customers Leads page*/
    public Leads clickOnLeadsMenu() {
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(customersMenuItem).build();
        moveToElem.perform();
        leadsMenuItem.click();
        return PageFactory.initElements(driver, Leads.class);
    }

    /*go to Webmail page*/
    public WebmailLogin clickOnWebmailMenu() {
        webmailMenuItem.click();
        return PageFactory.initElements(driver, WebmailLogin.class);
    }
}
