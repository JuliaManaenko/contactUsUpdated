package TradeInForm;

import customers.LeadDetails;
import customers.Leads;
import dataProviders.DataProviderSet1;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 03.03.2017.
 */
public class TradeInOdometer extends TradeInTestBase2 {

    private dms.dmsHome2 dmsHome2;

    @Test(dataProvider = "correctOdometer", dataProviderClass = DataProviderSet1.class)
    public void correctValuesOdometerClass(String odometer, String odometerLead) {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillOdometerVar(odometer);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getOdometerClass(), PropertyLoader.loadProperty("inputClassValid"));
    }

    @Test(dataProvider = "correctOdometer", dataProviderClass = DataProviderSet1.class)
    public void correctValuesOdometerHighlight(String odometer, String odometerLead) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillOdometerVar(odometer);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getOdometerInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(dataProvider = "correctOdometer", dataProviderClass = DataProviderSet1.class)
    public void correctValuesOdometerLabelHighlight(String odometer, String odometerLead) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillOdometerVar(odometer);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getOdometerLabelFontColor(), PropertyLoader.loadProperty("font_color_gray"));
    }

    @Test
    public void odometerValuesCut() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillOdometerVar(PropertyLoader.loadProperty("number11"));
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.odometerGetValue(), PropertyLoader.loadProperty("number10"));
    }

    @Test(dataProvider = "correctOdometer", dataProviderClass = DataProviderSet1.class)
    public void correctValuesOdometerinLead(String odometer, String odometerLead) {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillOdometerVar(odometer);
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
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        wait.until(isLeadsListVisible());
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getOdometer(), odometerLead);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test(dataProvider = "incorrectPrice", dataProviderClass = DataProviderSet1.class)
    public void incorrectValuesOdometerClass(String odometer) {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillOdometerVar(odometer);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getOdometerClass(), PropertyLoader.loadProperty("inputClassError"));
    }

    @Test(dataProvider = "incorrectPrice", dataProviderClass = DataProviderSet1.class)
    public void incorrectValuesOdometerHighlight(String odometer) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillOdometerVar(odometer);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1500);
        Assert.assertEquals(tradeIn.getOdometerInputBorderColor(), PropertyLoader.loadProperty("border_color_gray2"));
    }

    @Test(dataProvider = "incorrectPrice", dataProviderClass = DataProviderSet1.class)
    public void incorrectValuesOdometerFocused(String odometer) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillOdometerVar(odometer);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1500);
        Assert.assertTrue(tradeIn.isOdometerSelected());
    }

    @Test
    public void clickOnOdometerHighlight() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOdometerInput();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getOdometerInputBorderColor(), PropertyLoader.loadProperty("border_color_gray2"));
    }

    @Test
    public void isOdometerEmptyByDefault() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.odometerGetValue(), "");
    }
}
