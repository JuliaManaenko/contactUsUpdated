package TradeInForm;

import dataProviders.DataProviderSet1;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertyLoader;
import webmail.EmailDetails;
import webmail.EmailsList;

/**
 * Created by Julia on 01.03.2017.
 */
public class TradeInCommentsInEmail extends TradeInTestBaseEmail {

    @Test(dataProvider = "comments", dataProviderClass = DataProviderSet1.class)
    public void commentsInEmail(String commentForm, String commentEmail) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.fillCommentsVar(commentForm);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        wait.until(isWebmailFrameVisible());
        Thread.sleep(1000);
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(emailDetails.getTradeInComments(), commentEmail);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
    }

    @Test
    public void emptyCommentsInEmail() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        wait.until(isWebmailFrameVisible());
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Assert.assertFalse(emailDetails.isTradeInCommentsFieldExist());
        EmailsList emailsList1 = emailDetails.removeEmail2();
        waitForJSandJQueryToLoad();
    }
 }

