package TradeInForm;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Julia on 14.02.2017.
 */
public class TradeInRequiredFieldsSelected extends TradeInTestBase2 {

    @Test
    public void firstNameSelected() throws InterruptedException, IOException {
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        Thread.sleep(1000);
        Assert.assertTrue(tradeIn.isFirstNameSelected());
    }

    @Test
    public void lastNameSelected() throws InterruptedException, IOException {
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.clickOnTradeInSubmit();
        Thread.sleep(1000);
        Assert.assertTrue(tradeIn.isLastNameSelected());
    }

    @Test
    public void phoneNumSelected() throws InterruptedException, IOException {
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.clickOnTradeInSubmit();
        Thread.sleep(1000);
        Assert.assertTrue(tradeIn.isPhoneNumSelected());
    }

    @Test
    public void emailSelected() throws InterruptedException, IOException {
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum1();
        tradeIn.clickOnTradeInSubmit();
        Thread.sleep(1000);
        Assert.assertTrue(tradeIn.isEmailSelected());
    }
}
