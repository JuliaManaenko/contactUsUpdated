package elements;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcase.TestBase4;
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
        wait.until(jsLoad);
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum1();
        contactUs.fillEmail();
        contactUs.fillZip();
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(2000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait.until(jsLoad);
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        WebmailLogin webmailLogin = dmsHome21.clickOnWebmailMenu();
        wait.until(jsLoad);
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
