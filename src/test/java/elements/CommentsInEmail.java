package elements;

import customers.LeadDetails;
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
public class CommentsInEmail extends TestBase5 {
    @Test(dataProvider = "comments")
    public void commentsinEmail(String comment1, String comment2) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        contactUs.fillZip();
        Thread.sleep(1000);
        driver.findElement(By.name("comments")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("comments")).sendKeys(comment1);
        Thread.sleep(1000);
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        /*emailsList.clickDateColumn();
        Thread.sleep(1000);
        emailsList.clickDateColumn();
        Thread.sleep(1000);*/
        EmailDetails emailDetails = emailsList.openFirstEmail();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getComments(), comment2);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        Thread.sleep(1000);
    }

    @DataProvider(name = "comments")
    private Object[][] putComments() {
        return new Object[][]{{PropertyLoader.loadProperty("comment1"), PropertyLoader.loadProperty("comment1")},
                {PropertyLoader.loadProperty("comment1000"), PropertyLoader.loadProperty("comment1000")},
                {PropertyLoader.loadProperty("comment2000"), PropertyLoader.loadProperty("comment2000")},
                {PropertyLoader.loadProperty("comment2001"), PropertyLoader.loadProperty("comment2000")}};
    }
}
