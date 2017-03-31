package TradeInForm;

import customers.LeadDetails;
import customers.Leads;
import dataProviders.DataProviderSet1;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 02.03.2017.
 */
public class TradeInAskingPrice extends TradeInTestBase2 {

    private dms.dmsHome2 dmsHome2;

    @Test(dataProvider = "correctPrice", dataProviderClass = DataProviderSet1.class)
    public void correctValuesAskingPriceClass(String price, String priceLead){
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillAskPriceVar(price);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getAskingPriceInputClass(), PropertyLoader.loadProperty("inputClassValid"));
    }

    @Test(dataProvider = "correctPrice", dataProviderClass = DataProviderSet1.class)
    public void correctValuesAskingPriceHighlight(String price, String priceLead) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillAskPriceVar(price);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getAskingPriceInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(dataProvider = "correctPrice", dataProviderClass = DataProviderSet1.class)
    public void correctValuesAskingPriceLabelHighlight(String price, String priceLead) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillAskPriceVar(price);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getAskingPriceLabelFontColor(), PropertyLoader.loadProperty("font_color_gray"));
    }

    @Test(dataProvider = "correctPrice", dataProviderClass = DataProviderSet1.class)
    public void correctValuesAskingPriceinLead(String price, String priceLead){
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillAskPriceVar(price);
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
        Assert.assertEquals(leadDetails.getAskingPrice(), priceLead);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test(dataProvider = "incorrectPrice", dataProviderClass = DataProviderSet1.class)
    public void incorrectValuesAskingPriceClass(String price){
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillAskPriceVar(price);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getAskingPriceInputClass(), PropertyLoader.loadProperty("inputClassError"));
    }

    @Test(dataProvider = "incorrectPrice", dataProviderClass = DataProviderSet1.class)
    public void incorrectValuesAskingPriceHighlight(String price) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillAskPriceVar(price);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1500);
        Assert.assertEquals(tradeIn.getAskingPriceInputBorderColor(), PropertyLoader.loadProperty("border_color_gray2"));
    }

    @Test(dataProvider = "incorrectPrice", dataProviderClass = DataProviderSet1.class)
    public void incorrectValuesAskingPriceFocused(String price) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillAskPriceVar(price);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertTrue(tradeIn.isAskingPriceSelected());
    }

    @Test
    public void clickOnAskingPriceHighlight() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickAskingPriceInput();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getAskingPriceInputBorderColor(), PropertyLoader.loadProperty("border_color_gray2"));
    }

    @Test
    public void isAskingPriceEmptyByDefault() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.askingPriceGetValue(), "");
    }
}
