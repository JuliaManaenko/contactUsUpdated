package TradeInForm;

import customers.LeadDetails;
import customers.Leads;
import dataProviders.DataProviderSet1;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testcase.TradeInTestBase2;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 01.03.2017.
 */
public class TradeInComments extends TradeInTestBase2 {

    private dms.dmsHome2 dmsHome2;

    @Test
    public void emptyCommentsClass(){
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getCommentInputClass(), PropertyLoader.loadProperty("textAreaClassValid2"));
    }

    @Test
    public void emptyCommentsHighlight(){
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getCommentInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test
    public void emptyCommentsCount() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.commentsCounterGetValue(), PropertyLoader.loadProperty("count2000"));
    }

    @Test(dataProvider = "comments", dataProviderClass = DataProviderSet1.class)
    public void commentsClass(String commentForm, String commentCount) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillCommentsVar(commentForm);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getCommentInputClass(), PropertyLoader.loadProperty("textAreaClassValid"));
    }

    @Test(dataProvider = "comments", dataProviderClass = DataProviderSet1.class)
    public void commentsHighlight(String commentForm, String commentCount) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillCommentsVar(commentForm);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getCommentInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(dataProvider = "commentsCount", dataProviderClass = DataProviderSet1.class)
    public void commentsCount(String commentForm, String commentCount) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillCommentsVar(commentForm);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.commentsCounterGetValue(), commentCount);
    }

    @Test
    public void twoThousandOneCharCommentsText() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillCommentsVar(PropertyLoader.loadProperty("comment2001"));
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.commentsGetValue(), PropertyLoader.loadProperty("comment2000"));
    }

    @Test
    public void tagInCommentsText() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillCommentsVar(PropertyLoader.loadProperty("commentTag"));
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.commentsGetValue(), PropertyLoader.loadProperty("comment1"));
    }

    @Test
    public void emptyCommentsInLead() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        wait.until(isLeadsListVisible());
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertFalse(leadDetails.isTradeInCommentsExist());
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }


    @Test(dataProvider = "comments", dataProviderClass = DataProviderSet1.class)
    public void commentsInLead(String commentForm, String commentLead) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.fillCommentsVar(commentForm);
        Thread.sleep(3000);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        wait.until(isLeadsListVisible());
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getTradeInComments(), commentLead);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }
}
