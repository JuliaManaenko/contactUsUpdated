package TradeInForm;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testcase.TradeInTestBase2;
import utility.PropertyLoader;

/**
 * Created by Julia on 14.02.2017.
 */
public class TradeInRequiredFieldsHighlighted extends TradeInTestBase2 {

    @BeforeMethod
    public void clickSubmit() throws InterruptedException {
        tradeIn.clickOnTradeInSubmit();
        Thread.sleep(1000);
    }


    @Test
    public void firstNameClass() { Assert.assertEquals(tradeIn.getFirstNameInputClass(), "form-control error"); }

    @Test
    public void lastNameClass() {
        Assert.assertEquals(tradeIn.getLastNameInputClass(), "form-control error");
    }

    @Test
    public void emailNameClass() {
        Assert.assertEquals(tradeIn.getEmailInputClass(), "form-control error");
    }

    @Test
    public void phoneNumNameClass() { Assert.assertEquals(tradeIn.getPhoneNumInputClass(), "form-control text-uppercase error"); }

    @Test
    public void firstNameHighlight() { Assert.assertEquals(tradeIn.getFirstNameInputBorderColor(), PropertyLoader.loadProperty("border_color_red2")); }

    @Test
    public void lastNameHighlight() { Assert.assertEquals(tradeIn.getLastNameInputBorderColor(), PropertyLoader.loadProperty("border_color_red")); }

    @Test
    public void phoneNumHighlight() { Assert.assertEquals(tradeIn.getPhoneNumInputBorderColor(), PropertyLoader.loadProperty("border_color_red")); }

    @Test
    public void emailHighlight() { Assert.assertEquals(tradeIn.getEmailInputBorderColor(), PropertyLoader.loadProperty("border_color_red")); }

}
