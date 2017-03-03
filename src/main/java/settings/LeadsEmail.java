/*dms - settings - website - leads email page*/
package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import page.Page;
import utility.PropertyLoader;
import utility.PropertyLoader2;
import webmail.WebmailLogin;

import java.util.List;

/**
 * Created by Julia on 04.01.2017.
 */
public class LeadsEmail extends Page {
    public LeadsEmail(WebDriver webDriver) {
        super(webDriver);
    }

    /*declare elements on the page*/
    @FindBy(how = How.XPATH, using = "//tr[@id='leads_email_contactus']//div[@class='dotted_note3'][contains(text(), 'test_1@dxloo.com')]")
    private WebElement emailContext;

    @FindAll(@FindBy(how = How.XPATH, using = "//tr[@id='leads_email_contactus']//div[@class='dotted_note3'][contains(text(), 'test_1@dxloo.com')]"))
    private List<WebElement> emailContexts;

    @FindBy(how = How.XPATH, using = "//tr[@id='leads_email_contactus']//a[@class='button-style b_edit notranslate']")
    private WebElement contactEdit;

    @FindBy(how = How.XPATH, using = "//tr[@id='leads_email_contactus']//a[@class='button-style b_add']")
    private WebElement contactAdd;

    @FindBy(how = How.XPATH, using = "(//tr[@id='leads_email_contactus']//input[@class='leads_email my_form'])[last()]")
    private WebElement contactInput;

    @FindBy(how = How.XPATH, using = "(//tr[@id='leads_email_contactus']//input[@class='leads_email_type_html'])[last()]")
    private WebElement htmlChckbox;

    @FindBy(how = How.XPATH, using = "(//tr[@id='leads_email_contactus']//span[@class='gl_button save_btn'])[2]")
    private WebElement contactSave;

    @FindBy(how = How.CSS, using = "a[href='/dms/email']")
    private WebElement webmailMenuItem;

    @FindBy(how = How.XPATH, using = "//tr[@id='leads_email_tradein']//a[@class='button-style b_edit notranslate']")
    private WebElement tradeInEditBtn;

    @FindBy(how = How.XPATH, using = "//tr[@id='leads_email_tradein']//a[@class='button-style b_add']")
    private WebElement tradeInAddBtn;

    @FindBy(how = How.XPATH, using = "(//tr[@id='leads_email_tradein']//input[@class='leads_email my_form'])[last()]")
    private WebElement tradeInInput;

    @FindBy(how = How.XPATH, using = "(//tr[@id='leads_email_tradein']//input[@class='leads_email_type_html'])[last()]")
    private WebElement tradeInHtmlCheckbox;

    @FindBy(how = How.XPATH, using = "(//tr[@id='leads_email_tradein']//span[@class='gl_button save_btn'])[2]")
    private WebElement tradeInSaveBtn;

    /*add email to Contact Us leads as custom*/
    public void addEmail() {
        contactEdit.click();
        contactAdd.click();
        contactInput.clear();
        contactInput.sendKeys(PropertyLoader2.loadProperty("webmail.user"));
        htmlChckbox.click();
        contactSave.click();
    }

    /*remove the last added Contact Us email*/
    public void removeEmail() {
        contactEdit.click();
        htmlChckbox.click();
        contactSave.click();
    }

    /*add email to TradeIn leads as custom*/
    public void addTradeInEmail() {
        tradeInEditBtn.click();
        tradeInAddBtn.click();
        tradeInInput.clear();
        tradeInInput.sendKeys(PropertyLoader2.loadProperty("webmail.user"));
        tradeInHtmlCheckbox.click();
        tradeInSaveBtn.click();
    }

    /*remove the last added Trade In email*/
    public void removeTradeInEmail() {
        tradeInEditBtn.click();
        tradeInHtmlCheckbox.click();
        tradeInSaveBtn.click();
    }

    /*go to Webmail login page*/
    public WebmailLogin clickOnWebmailMenu() {
        webmailMenuItem.click();
        return PageFactory.initElements(driver, WebmailLogin.class);
    }
}
