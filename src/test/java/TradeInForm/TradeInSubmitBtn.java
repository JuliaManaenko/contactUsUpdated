package TradeInForm;

import org.testng.Assert;
import org.testng.annotations.Test;
import testcase.TradeInTestBase2;

/**
 * Created by Julia on 02.03.2017.
 */
public class TradeInSubmitBtn extends TradeInTestBase2{

    @Test
    public void tradeInSubmitButtonHover(){
        Assert.assertTrue(tradeIn.isTradeInSubmitButtonDisplayed());
    }

    @Test
    public void tradeInSubmitButtonClickable(){
        Assert.assertTrue(tradeIn.isTradeInSubmitButtonDisplayed());
    }
}
