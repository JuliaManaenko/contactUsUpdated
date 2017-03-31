package contactUsForm;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.PropertyLoader;
import webmail.EmailDetails;
import webmail.EmailsList;

/**
 * Created by Julia on 07.02.2017.
 */
public class CommentsInEmail extends TestBase5 {
    @Test(dataProvider = "comments")
    public void commentsinEmail(String comment1, String comment2) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum();
        formsPage.fillEmail();
        formsPage.fillZip();
        Thread.sleep(1000);
        driver.findElement(By.name("comments")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("comments")).sendKeys(comment1);
        Thread.sleep(1000);
        formsPage.clickOnSubmit();
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
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getComments(), comment2);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
       /* driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome21.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();*/
    }

    @DataProvider(name = "comments")
    private Object[][] putComments() {
        return new Object[][]{{PropertyLoader.loadProperty("comment1"), PropertyLoader.loadProperty("comment1")},
                {PropertyLoader.loadProperty("comment1000"), PropertyLoader.loadProperty("comment1000")},
                {PropertyLoader.loadProperty("comment2000"), PropertyLoader.loadProperty("comment2000")},
                {PropertyLoader.loadProperty("comment2001"), PropertyLoader.loadProperty("comment2000")}};
    }
}
