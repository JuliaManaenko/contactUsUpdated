/*dms - settings - website - leads email page*/
package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import page.Page;
import utility.PropertyLoader;
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

    /*not ready yet*/
    public void ifEmailPresent() {
        for (int i = 0; i < emailContexts.size(); i++) {
            //    emailContexts.get(i).getText();
            if (emailContexts.get(i).getText() != "test_1@dxloo.com:") {
                contactEdit.click();
                contactAdd.click();
                contactInput.clear();
                contactInput.sendKeys("test_1@dxloo.com");
                htmlChckbox.click();
                contactSave.click();
            }
        }
     /*   if(emailContext.isDisplayed() == false){
contactEdit.click();
contactAdd.click();
htmlChckbox.click();
contactSave.click();
        }*/
    }

    /*add email to Contact Us leads as custom*/
    public void addEmail() {
        contactEdit.click();
        contactAdd.click();
        contactInput.clear();
        contactInput.sendKeys(PropertyLoader.loadProperty("webmail.user"));
        htmlChckbox.click();
        contactSave.click();
    }

    /*remove the las added email*/
    public void removeEmail() {
        contactEdit.click();
        htmlChckbox.click();
        contactSave.click();
    }

    /*go to Webmail login page*/
    public WebmailLogin clickOnWebmailMenu() {
        webmailMenuItem.click();
        return PageFactory.initElements(driver, WebmailLogin.class);
    }
}
