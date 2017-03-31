package TradeInForm;

import customers.LeadDetails;
import customers.Leads;
import dataProviders.DataProviderSet1;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 28.02.2017.
 */
public class TradeInIntPhoneNum extends TradeInTestBase2 {

    private LeadDetails leadDetails;

    @Test(dataProvider = "intPhones", dataProviderClass = DataProviderSet1.class)
    public void allValuesClass(String intPhoneForm, String intPhoneLead) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillIntPhoneVar(intPhoneForm);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getIntPhoneInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(dataProvider = "intPhones", dataProviderClass = DataProviderSet1.class)
    public void allValuesHighlight(String intPhoneForm, String intPhoneLead) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillIntPhoneVar(intPhoneForm);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getIntPhoneInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(dataProvider = "intPhones", dataProviderClass = DataProviderSet1.class)
    public void allValuesInLead(String intPhoneForm, String intPhoneLead) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillEmail();
        tradeIn.fillPhoneNum();
        tradeIn.fillIntPhoneVar(intPhoneForm);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        //dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        wait.until(isLeadsListVisible());
        leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getIntPhoneNum(), intPhoneLead);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test
    public void twentyOneCharsCut() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillIntPhoneVar(PropertyLoader.loadProperty("intPhone21"));
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.intPhoneGetValue(), PropertyLoader.loadProperty("intPhone20"));
    }

    @Test
    public void isIntPhoneEmptyByDefault() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.intPhoneGetValue(), "");
    }


}
