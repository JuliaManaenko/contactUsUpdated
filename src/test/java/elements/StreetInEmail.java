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
public class StreetInEmail extends TestBase5 {
    @Test(dataProvider = "street")
    public void strCorrectCharinEmail(String street) throws InterruptedException {
        Thread.sleep(2000);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        wait.until(jsLoad);
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillEmail();
        contactUs.fillZip();
        contactUs.fillPhoneNum();
        driver.findElement(By.name("street")).clear();
        driver.findElement(By.name("street")).sendKeys(street);
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        //  dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
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
        Assert.assertEquals(emailDetails.getState(), street);
        Thread.sleep(2000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        Thread.sleep(2000);
        driver.manage().deleteAllCookies();
    }

    @DataProvider(name = "street")
    public Object[][] getPhone() {
        return new Object[][]{{PropertyLoader.loadProperty("text0")},
                {PropertyLoader.loadProperty("text1")},
                {PropertyLoader.loadProperty("text20")},
                {PropertyLoader.loadProperty("text50")},
                {PropertyLoader.loadProperty("textAll")}};
    }
}
