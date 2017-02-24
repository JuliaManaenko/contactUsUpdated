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
        //waitForJSandJQueryToLoad();
    }


    @Test
    public void firstNameInputClass() { Assert.assertEquals(tradeIn.getFirstNameInputClass(), "form-control error"); }

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
    public void firstNameInputHighlight() {
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getFirstNameInputBorderColor(), PropertyLoader.loadProperty("border_color_red")); }

    @Test
    public void lastNameHighlight() { Assert.assertEquals(tradeIn.getLastNameInputBorderColor(), PropertyLoader.loadProperty("border_color_red")); }

    @Test
    public void phoneNumHighlight() { Assert.assertEquals(tradeIn.getPhoneNumInputBorderColor(), PropertyLoader.loadProperty("border_color_red")); }

    @Test
    public void emailHighlight() { Assert.assertEquals(tradeIn.getEmailInputBorderColor(), PropertyLoader.loadProperty("border_color_red")); }

    @Test
    public void firstNameLabelHighlight() { Assert.assertEquals(tradeIn.getFirstNameLabelFontColor(), PropertyLoader.loadProperty("font_color_red")); }

    @Test
    public void lastNameLabelHighlight() { Assert.assertEquals(tradeIn.getLastNameLabelFontColor(), PropertyLoader.loadProperty("font_color_red")); }

    @Test
    public void phoneNumLabelHighlight() { Assert.assertEquals(tradeIn.getPhoneNumLabelFontColor(), PropertyLoader.loadProperty("font_color_red")); }

    @Test
    public void emailLabelHighlight() { Assert.assertEquals(tradeIn.getEmailLabelFontColor(), PropertyLoader.loadProperty("font_color_red")); }

}
