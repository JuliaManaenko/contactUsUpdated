package contactUsForm;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertyLoader;
import webmail.EmailDetails;
import webmail.EmailsList;
import webmail.WebmailLogin;

/**
 * Created by Julia on 03.02.2017.
 */
public class CheckInEmailTest extends TestBase4 {

    @Test
    public void testInEmail() throws InterruptedException {
        wait = new WebDriverWait(driver, 20);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum1();
        formsPage.fillEmail();
        formsPage.fillZip();
        formsPage.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        WebmailLogin webmailLogin = dmsHome21.clickOnWebmailMenu();
        waitForJSandJQueryToLoad();
        EmailsList emailsList = webmailLogin.loginToWebmail();
        Thread.sleep(2000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        Thread.sleep(2000);
        Assert.assertEquals(emailDetails.getFirstName(), "John");

    }
}
