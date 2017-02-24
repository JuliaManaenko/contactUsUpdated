/*Site Package Popup in dms Dealers page*/
package dmsDealers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import page.Page;
import utility.LogFactory;

/**
 * Created by Julia on 04.01.2017.
 */
public class SitePackage extends Page {


    public SitePackage(WebDriver webDriver) {
        super(webDriver);
    }

    private static final Logger LOG = LogFactory.getLogger(SitePackage.class);

    /*declare elements on the page*/
    @FindBy(how = How.XPATH, using = "//div[@aria-labelledby='ui-dialog-title-site_package_editor']")
    private WebElement sitePackWindow;

    @FindBy(how = How.ID, using = "dws_contact_us")
    private WebElement contactWidgetCheckbox;

    @FindBy(how = How.ID, using = "page_contact_us")
    private WebElement contactPageCheckbox;

    @FindBy(how = How.ID, using = "dws_form_trade_in")
    private WebElement tradeInWidgetCheckbox;

    @FindBy(how = How.ID, using = "page_trade_in")
    private WebElement tradeInPageCheckbox;

    @FindBy(how = How.XPATH, using = "(//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']/span[contains(text(),'Ok')])[2]")
    private WebElement okBtn;

    /*turn on Contact Us widget*/
    public Dealers turnOnWidgetDealers() {
        if (contactWidgetCheckbox.getAttribute("checked") == null) {
            contactWidgetCheckbox.click();
        }
        okBtn.click();
        return PageFactory.initElements(driver, Dealers.class);
    }

    /*turn on Contact Us page*/
    public Dealers turnOnPageDealers() {
        LOG.info("Checkbox attribute is " + contactPageCheckbox.getAttribute("checked"));
        if (contactPageCheckbox.getAttribute("checked") == null) {
            contactPageCheckbox.click();
        }
        okBtn.click();
        return PageFactory.initElements(driver, Dealers.class);
    }

    /*turn off Contact Us widget*/
    public Dealers turnOffWidgetDealers() {
        if (contactWidgetCheckbox.isSelected()) {
            contactWidgetCheckbox.click();
        }
        okBtn.click();
        return PageFactory.initElements(driver, Dealers.class);
    }

    /*turn off Contact Us page*/
    public Dealers turnOffPageDealers() {
        if (contactPageCheckbox.isSelected()) {
            contactPageCheckbox.click();
        }
        okBtn.click();
        return PageFactory.initElements(driver, Dealers.class);
    }

    /*turn on Contact Us widget*/
    public Dealers turnOnTradeInWidgetDealers() {
        if (tradeInWidgetCheckbox.getAttribute("checked") == null) {
            tradeInWidgetCheckbox.click();
        }
        okBtn.click();
        return PageFactory.initElements(driver, Dealers.class);
    }

    /*turn on Contact Us page*/
    public Dealers turnOnTradeInPageDealers() {
        LOG.info("Checkbox attribute is " + contactPageCheckbox.getAttribute("checked"));
        if (tradeInPageCheckbox.getAttribute("checked") == null) {
            tradeInPageCheckbox.click();
        }
        okBtn.click();
        return PageFactory.initElements(driver, Dealers.class);
    }

    /*turn off Contact Us widget*/
    public Dealers turnOffTradeInWidgetDealers() {
        if (tradeInWidgetCheckbox.isSelected()) {
            tradeInWidgetCheckbox.click();
        }
        okBtn.click();
        return PageFactory.initElements(driver, Dealers.class);
    }

    /*turn off Contact Us page*/
    public Dealers turnOffTradeInPageDealers() {
        if (tradeInPageCheckbox.isSelected()) {
            tradeInPageCheckbox.click();
        }
        okBtn.click();
        return PageFactory.initElements(driver, Dealers.class);
    }

    public ExpectedCondition<WebElement> isEditorVisible() {
        return ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@aria-labelledby='ui-dialog-title-site_package_editor']")));
    }
}
