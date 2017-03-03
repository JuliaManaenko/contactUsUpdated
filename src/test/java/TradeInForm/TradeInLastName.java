package TradeInForm;

import customers.LeadDetails;
import customers.Leads;
import dataProviders.DataProviderSet1;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcase.TradeInTestBase2;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 27.02.2017.
 */
public class TradeInLastName extends TradeInTestBase2 {

    LeadDetails leadDetails;

    @Test(dataProvider = "fName", dataProviderClass = DataProviderSet1.class)
    public void fCorrectCharClass(String fName) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillLastNameVar(fName);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getLastNameInputClass(), PropertyLoader.loadProperty("inputClassValid"));
    }

    @Test(dataProvider = "fName", dataProviderClass = DataProviderSet1.class)
    public void fCorrectCharHighlight(String fName) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillLastNameVar(fName);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getLastNameInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(dataProvider = "fName", dataProviderClass = DataProviderSet1.class)
    public void fCorrectLabelHighlight(String fName) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillLastNameVar(fName);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getLastNameLabelFontColor(), PropertyLoader.loadProperty("font_color_gray"));
    }

    @Test()
    public void fIncorrectCharClass() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillLastNameVar(PropertyLoader.loadProperty("text31"));
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getLastNameInputClass(), PropertyLoader.loadProperty("inputClassError"));
    }

    @Test()
    public void fIncorrectCharHighlight() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillLastNameVar(PropertyLoader.loadProperty("text31"));
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getLastNameInputBorderColor(), PropertyLoader.loadProperty("border_color_red"));
    }

    @Test()
    public void fIncorrectLabelHighlight() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillLastNameVar(PropertyLoader.loadProperty("text31"));
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getLastNameLabelFontColor(), PropertyLoader.loadProperty("font_color_red"));
    }

    @Test(dataProvider = "fName", dataProviderClass = DataProviderSet1.class)
    public void fCorrectCharinLead(String fName) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillEmail();
        tradeIn.fillPhoneNum();
        tradeIn.fillLastNameVar(fName);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        leadDetails = leads.openFirstLead();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getLastName(), fName);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }
}
