package TradeInForm;

import dataProviders.DataProviderSet1;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertyLoader;
import webmail.EmailDetails;
import webmail.EmailsList;

/**
 * Created by Julia on 28.02.2017.
 */
public class TradeInIntPhoneNumInEmail extends TradeInTestBaseEmail {

    @Test(dataProvider = "intPhones", dataProviderClass = DataProviderSet1.class)
    public void charsInEmail(String intPhone1, String intPhone2) throws InterruptedException {
        Thread.sleep(2000);
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillEmail();
        tradeIn.fillPhoneNum();
        tradeIn.fillIntPhoneVar(intPhone1);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        wait.until(isWebmailFrameVisible());
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(emailDetails.getIntPhone(), intPhone2);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
    }
}
