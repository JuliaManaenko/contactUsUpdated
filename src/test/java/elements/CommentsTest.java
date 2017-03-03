package elements;

import customers.LeadDetails;
import customers.Leads;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testcase.TestBase2;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 24.01.2017.
 */
public class CommentsTest extends TestBase2 {

    private dms.dmsHome2 dmsHome2;

    @Test(priority = 1)
    public void emptyCommentsClass() throws InterruptedException {
        contactUs.clickOnSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(contactUs.getCommentInputClass(), PropertyLoader.loadProperty("inputClassValid2"));
    }

    @Test(priority = 2)
    public void emptyCommentsHighlight() throws InterruptedException {
        Assert.assertEquals(contactUs.getCommentInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 3)
    public void oneCharinComments() throws InterruptedException {
        contactUs.fillComments1();
        contactUs.clickOnSubmit();
        Assert.assertEquals(contactUs.commentsCounterGetValue(), "1999");
    }

    @Test(priority = 4)
    public void oneCharCommentsClass() throws InterruptedException {
        Assert.assertEquals(contactUs.getCommentInputClass(), PropertyLoader.loadProperty("inputClassValid"));
    }

    @Test(priority = 5)
    public void oneCharCommentsHighlight() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getCommentInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 6)
    public void thousandCharinComments() throws InterruptedException {
        Thread.sleep(3000);
        contactUs.fillComments1000();
        Thread.sleep(1000);
        contactUs.clickOnSubmit();
        Assert.assertEquals(contactUs.commentsCounterGetValue(), "1000");
    }

    @Test(priority = 7)
    public void thousandCharCommentsClass() throws InterruptedException {
        Assert.assertEquals(contactUs.getCommentInputClass(), PropertyLoader.loadProperty("inputClassValid"));
    }

    @Test(priority = 8)
    public void thousandCharCommentsHighlight() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getCommentInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 9)
    public void twothousandCharinComments() throws InterruptedException {
        Thread.sleep(3000);
        contactUs.fillComments2000();
        Thread.sleep(1000);
        contactUs.clickOnSubmit();
        Assert.assertEquals(contactUs.commentsCounterGetValue(), "0");
    }

    @Test(priority = 10)
    public void twothousandCharCommentsClass() throws InterruptedException {
        Assert.assertEquals(contactUs.getCommentInputClass(), PropertyLoader.loadProperty("inputClassValid"));
    }

    @Test(priority = 11)
    public void twothousandCharCommentsHighlight() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getCommentInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 12)
    public void twothousandoneCharinComments() throws InterruptedException {
        Thread.sleep(3000);
        contactUs.fillComments2001();
        Thread.sleep(1000);
        contactUs.clickOnSubmit();
        Assert.assertEquals(contactUs.commentsCounterGetValue(), "0");
    }

    @Test(priority = 13)
    public void twothousandoneCharCommentsClass() throws InterruptedException {
        Assert.assertEquals(contactUs.getCommentInputClass(), PropertyLoader.loadProperty("inputClassValid"));
    }

    @Test(priority = 14)
    public void twothousandoneCharCommentsHighlight() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getCommentInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(priority = 15)
    public void twothousandoneCharCommentsText() throws InterruptedException {
        Assert.assertEquals(contactUs.commentsGetValue(), PropertyLoader.loadProperty("comment2000"));
    }

    @Test(priority = 16, enabled = false)
    public void loginToDms() {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dmsHome = PageFactory.initElements(driver, dms.dmsHome.class);
        dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
    }

    @Test(priority = 17, dataProvider = "comments")
    public void commentsinLead(String comment1, String comment2) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        contactUs.fillZip();
        Thread.sleep(3000);
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
        dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        LeadDetails leadDetails = leads.openFirstLead();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getComments(), comment2);
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        leads.removeFirstLead();
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
