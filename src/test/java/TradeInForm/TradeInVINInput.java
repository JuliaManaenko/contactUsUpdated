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
 * Created by Julia on 01.03.2017.
 */
public class TradeInVINInput extends TradeInTestBase2 {

    private dms.dmsHome2 dmsHome2;

    @Test(dataProvider = "correctVin", dataProviderClass = DataProviderSet1.class)
    public void correctValuesVINClass(String vinForm, String vinLead){
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillVINVar(vinForm);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getVINInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(dataProvider = "correctVin", dataProviderClass = DataProviderSet1.class)
    public void correctValuesVINHighlight(String vinForm, String vinLead) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillVINVar(vinForm);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(tradeIn.getVINInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(dataProvider = "correctVin", dataProviderClass = DataProviderSet1.class)
    public void correctValuesVINLabelHighlight(String vinForm, String vinLead){
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillVINVar(vinForm);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getVINLabelFontColor(), PropertyLoader.loadProperty("font_color_gray"));
    }

    @Test
    public void vinValuesCut(){
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillVINVar(PropertyLoader.loadProperty("vin18"));
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.vinGetValue(), PropertyLoader.loadProperty("vin17"));
    }

    @Test(dataProvider = "correctVin", dataProviderClass = DataProviderSet1.class)
    public void correctValuesVINinLead(String vinForm, String vinLead){
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillVINVar(vinForm);
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
        Assert.assertEquals(leadDetails.getVin(), vinLead);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test(dataProvider = "incorrectVin", dataProviderClass = DataProviderSet1.class)
    public void incorrectValuesVINClass(String vinForm){
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillVINVar(vinForm);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getVINInputClass(), PropertyLoader.loadProperty("inputPhoneClassError"));
    }

    @Test(dataProvider = "incorrectVin", dataProviderClass = DataProviderSet1.class)
    public void incorrectValuesVINHighlight(String vinForm) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillVINVar(vinForm);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1500);
        Assert.assertEquals(tradeIn.getVINInputBorderColor(), PropertyLoader.loadProperty("border_color_gray2"));
    }

    @Test(dataProvider = "incorrectVin", dataProviderClass = DataProviderSet1.class)
    public void incorrectValuesVINFocused(String vinForm) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillVINVar(vinForm);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertTrue(tradeIn.isVINSelected());
    }

    @Test(dataProvider = "incorrectVin", dataProviderClass = DataProviderSet1.class)
    public void incorrectValuesVINdontSubmit(String vinForm){
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.fillVINVar(vinForm);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.isPostFormDisplayed());
    }

}
