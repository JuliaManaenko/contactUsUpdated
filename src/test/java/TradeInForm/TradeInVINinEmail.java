package TradeInForm;

import customers.LeadDetails;
import customers.Leads;
import dataProviders.DataProviderSet1;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertyLoader;
import webmail.EmailDetails;
import webmail.EmailsList;
import webmail.WebmailLogin;

import java.util.ArrayList;

/**
 * Created by Julia on 02.03.2017.
 */
public class TradeInVINinEmail extends TradeInTestBaseEmail {

    private dms.dmsHome2 dmsHome2;

    @Test(dataProvider = "correctVin", dataProviderClass = DataProviderSet1.class)
    public void correctValuesVINinEmail(String vinForm, String vinEmail){
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillVINVar(vinForm);
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        wait.until(isWebmailFrameVisible());
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(emailDetails.getVin(), vinEmail);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
    }
}
