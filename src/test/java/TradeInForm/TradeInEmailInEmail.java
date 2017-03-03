package TradeInForm;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertyLoader;
import webmail.EmailDetails;
import webmail.EmailsList;

/**
 * Created by Julia on 28.02.2017.
 */
public class TradeInEmailInEmail extends TradeInTestBaseEmail {

    @Test
    public void checkEmailInEmail() throws InterruptedException {
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail2();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        EmailsList emailsList = dmsHome21.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        wait.until(isWebmailFrameVisible());
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(emailDetails.getEmail(), PropertyLoader.loadProperty("Email1"));
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
    }
}
