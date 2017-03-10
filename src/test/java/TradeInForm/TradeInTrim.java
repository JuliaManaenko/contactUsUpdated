package TradeInForm;

import customers.LeadDetails;
import customers.Leads;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcase.TradeInTestBase2;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 09.03.2017.
 */
public class TradeInTrim extends TradeInTestBase2 {

   /* @Test
    public void labelIsTrim() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getTrimLabelText(), PropertyLoader.loadProperty("trimLabel"));
    }

    @Test
    public void trimSelectIsDisabled() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertFalse(tradeIn.isTrimSelectEnabled());
    }

    @Test
    public void selectMakeByDefault() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getTrimSelectValue(), "Select Trim");
    }

    @Test
    public void submitWithoutSelectingTrimClass() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getTrimSelectClass(), PropertyLoader.loadProperty("inputClassTrim"));
    }

    @Test
    public void submitWithoutSelectingTrimBorderColor() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getTrimSelectBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test
    public void submitWithoutSelectingTrimNotFocused() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertFalse(tradeIn.isTrimSelected());
    }

    @Test
    public void submitWithoutSelectingTrimLabelFontColor() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getTrimLabelFontColor(), PropertyLoader.loadProperty("font_color_gray"));
    }

    @Test
    public void trimIsEnabledIfSelectMake() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMotorizedType(PropertyLoader.loadProperty("CARS_TRUCKS_VANS"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMakeByIndex(1);
        waitForJSandJQueryToLoad();
        tradeIn.selectModelByIndex(1);
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.isTrimSelectEnabled());
    }

    @Test
    public void trimIsDisabledIfSelectYear() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectYear("1995");
        Assert.assertFalse(tradeIn.isTrimSelectEnabled());
    }

    @Test
    public void trimIsDisabledIfSelectMotorizedType() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMotorizedType(PropertyLoader.loadProperty("CARS_TRUCKS_VANS"));
        Assert.assertFalse(tradeIn.isTrimSelectEnabled());
    }*/

    @Test
    public void trimIsDisabledIfSelectMake() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMotorizedType(PropertyLoader.loadProperty("CARS_TRUCKS_VANS"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMakeByIndex(1);
        waitForJSandJQueryToLoad();
        Assert.assertFalse(tradeIn.isTrimSelectEnabled());
    }

  /*  @Test
    public void trimSelected(){
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMotorizedType(PropertyLoader.loadProperty("CARS_TRUCKS_VANS"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMakeByIndex(1);
        waitForJSandJQueryToLoad();
        tradeIn.selectModelByIndex(1);
        waitForJSandJQueryToLoad();
        tradeIn.selectTrimByIndex(1);
        Assert.assertEquals(tradeIn.getTrimSelectValue(), tradeIn.getTrimSelectOptions().get(1).getText());
    }*/

    @Test
    public void trimInLead() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.selectMotorizedType(PropertyLoader.loadProperty("CARS_TRUCKS_VANS"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMakeByIndex(1);
        waitForJSandJQueryToLoad();
        tradeIn.selectModelByIndex(1);
        waitForJSandJQueryToLoad();
        String firstTrim = tradeIn.getTrimSelectOptions().get(1).getText();
        tradeIn.selectTrimByIndex(1);
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        wait.until(isLeadsListVisible());
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getTrim(), firstTrim);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }
}
