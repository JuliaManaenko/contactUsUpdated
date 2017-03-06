package TradeInForm;

import org.testng.Assert;
import org.testng.annotations.Test;
import testcase.TradeInTestBase2;
import utility.PropertyLoader;

/**
 * Created by Julia on 02.03.2017.
 */
public class TradeInSubmitBtn extends TradeInTestBase2 {

    @Test
    public void tradeInSubmitButtonColor() {
        Assert.assertEquals(tradeIn.getTradeInSubmitBtnBgColor(), PropertyLoader.loadProperty("bg_color_btn"));
    }

    @Test
    public void tradeInSubmitButtonHover() {
        tradeIn.moveMouseToTradeInSubmitBtn();
        Assert.assertEquals(tradeIn.getTradeInSubmitBtnBgColor(), PropertyLoader.loadProperty("bg_color_btn_hover"));
    }

    @Test
    public void tradeInSubmitButtonClickable() {
        Assert.assertTrue(tradeIn.isTradeInSubmitBtnEnabled());
    }

    @Test
    public void tradeInSumbitButtonText() {
        Assert.assertEquals(tradeIn.getTradeInSubmitBtnText(), " Submit");
    }

    @Test
    public void tradeInSubmitBtnHasCheckMark() {
        Assert.assertTrue(tradeIn.isTradeInSubmitHasCheckMark());
    }

    @Test
    public void tradeInSubmitButtonFontColor() {
        Assert.assertEquals(tradeIn.getTradeInSubmitBtnFontColor(), PropertyLoader.loadProperty("font_color_white"));
    }

    @Test
    public void tradeInSubmitBtnCursorPointer() {
        Assert.assertEquals(tradeIn.getTradeInSubmitBtnCursorKind(), "pointer");
    }


}
