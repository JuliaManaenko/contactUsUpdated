package elements;

import customers.Leads;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
public class IntPhoneNumInEmail extends TestBase5 {
    @Test
    public void emptyValueinEmail() throws InterruptedException {
        wait.until(jsLoad);
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillEmail();
        contactUs.fillZip();
        contactUs.fillPhoneNum();
        driver.findElement(By.name("international_phone")).clear();
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
//        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        wait.until(jsLoad);
        WebmailLogin webmailLogin = dmsHome2.clickOnWebmailMenu();
        wait.until(jsLoad);
        EmailsList emailsList = webmailLogin.loginToWebmail();
        Thread.sleep(3000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        Thread.sleep(2000);
        Assert.assertEquals(emailDetails.getIntPhone(), "");
        Thread.sleep(2000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        Thread.sleep(2000);
        driver.manage().deleteAllCookies();
    }

    @Test(dataProvider = "intPhones")
    public void charsInEmail(String intPhone1, String intPhone2) throws InterruptedException {
        Thread.sleep(2000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        wait.until(jsLoad);
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillEmail();
        contactUs.fillZip();
        contactUs.fillPhoneNum();
        driver.findElement(By.name("international_phone")).clear();
        driver.findElement(By.name("international_phone")).sendKeys(intPhone1);
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        wait.until(jsLoad);
        WebmailLogin webmailLogin = dmsHome2.clickOnWebmailMenu();
        wait.until(jsLoad);
        EmailsList emailsList = webmailLogin.loginToWebmail();
        Thread.sleep(3000);
        /*emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        Thread.sleep(2000);
        Assert.assertEquals(emailDetails.getIntPhone(), intPhone2);
        Thread.sleep(2000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        Thread.sleep(2000);
        driver.manage().deleteAllCookies();
    }

    @DataProvider(name = "intPhones")
    public Object[][] getPhone() {
        return new Object[][]{{PropertyLoader.loadProperty("intPhone1"), PropertyLoader.loadProperty("intPhone1")},
                {PropertyLoader.loadProperty("intPhone10"), PropertyLoader.loadProperty("intPhone10")},
                {PropertyLoader.loadProperty("intPhone20"), PropertyLoader.loadProperty("intPhone2")},
                {PropertyLoader.loadProperty("intPhone21"), PropertyLoader.loadProperty("intPhone20")}};
    }
}
