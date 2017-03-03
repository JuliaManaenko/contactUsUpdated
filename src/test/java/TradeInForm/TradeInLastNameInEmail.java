package TradeInForm;

import dataProviders.DataProviderSet1;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertyLoader;
import webmail.EmailDetails;
import webmail.EmailsList;

/**
 * Created by Julia on 27.02.2017.
 */
public class TradeInLastNameInEmail extends TradeInTestBaseEmail {

    @Test(dataProvider = "fName", dataProviderClass = DataProviderSet1.class)
    public void fCorrectCharinEmail(String fName) throws InterruptedException {
        Thread.sleep(2000);
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillEmail();
        tradeIn.fillPhoneNum();
        tradeIn.fillLastNameVar(fName);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(emailDetails.getLastName(), fName);
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
    }
}
