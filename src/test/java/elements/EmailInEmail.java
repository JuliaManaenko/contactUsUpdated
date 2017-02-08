package elements;

import customers.LeadDetails;
import customers.Leads;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcase.TestBase5;
import utility.PropertyLoader;
import webmail.EmailDetails;
import webmail.EmailsList;
import webmail.WebmailLogin;

import java.util.ArrayList;

/**
 * Created by Julia on 07.02.2017.
 */
public class EmailInEmail extends TestBase5 {

    @Test
    public void checkEmailInEmail() throws InterruptedException {
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillZip();
        contactUs.fillEmail2();
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(2000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait.until(jsLoad);
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        WebmailLogin webmailLogin = dmsHome21.clickOnWebmailMenu();
        wait.until(jsLoad);
        EmailsList emailsList = webmailLogin.loginToWebmail();
        Thread.sleep(3000);
      /*  emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        Thread.sleep(2000);
        Assert.assertEquals(emailDetails.getEmail(), PropertyLoader.loadProperty("Email1"));
        Thread.sleep(2000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        Thread.sleep(2000);
        driver.manage().deleteAllCookies();
    }
}
