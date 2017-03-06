package TradeInForm;

import dataProviders.DataProviderSet1;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcase.TradeInTestBase2;
import utility.PropertyLoader;

/**
 * Created by Julia on 06.03.2017.
 */
public class TradeInMake extends TradeInTestBase2 {

  /*  @Test
    public void labelIsMake() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getMakeLabelText(), PropertyLoader.loadProperty("makeLabel"));
    }

    @Test
    public void makeSelectIsDisabled() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertFalse(tradeIn.isMakeSelectEnabled());
    }

    @Test
    public void selectMakeByDefault() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getMakeSelectValue(), "Select Make");
    }

    @Test
    public void submitWithoutSelectingMakeClass() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getMakeSelectClass(), PropertyLoader.loadProperty("inputClassMake"));
    }

    @Test
    public void submitWithoutSelectingMakeBorderColor() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getMakeSelectBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test
    public void submitWithoutSelectingMakeNotFocused() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertFalse(tradeIn.isMakeSelected());
    }*/

    @Test
    public void submitWithoutSelectingMakeLabelFontColor() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getMakeLabelFontColor(), PropertyLoader.loadProperty("font_color_gray"));
    }

    @Test(dataProvider = "motorizedType", dataProviderClass = DataProviderSet1.class)
    public void makeIsEnabledIfSelectMotorizedType(String motorizedTypeForm, String motorizedTypeLead) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMotorizedType(motorizedTypeForm);
        Thread.sleep(1000);
        Assert.assertTrue(tradeIn.isMakeSelectEnabled());
    }

    @Test
    public void makeIsDisabledIfSelectYear() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectYear("1995");
        Assert.assertFalse(tradeIn.isMakeSelectEnabled());
    }
}
