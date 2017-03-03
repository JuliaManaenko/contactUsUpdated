package TradeInForm;

import customers.LeadDetails;
import customers.Leads;
import dataProviders.DataProviderSet1;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcase.TradeInTestBase2;
import utility.PropertyLoader;

import java.util.*;

/**
 * Created by Julia on 02.03.2017.
 */
public class TradeInYearSelect extends TradeInTestBase2 {
    private dms.dmsHome2 dmsHome2;

   /* @Test
    public void labelIsYear() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getYearLabelText(), PropertyLoader.loadProperty("yearLabel"));
    }

    @Test
    public void selectYearByDefault() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getYearSelectValue(), "Select Year");
    }

   //TODO: check all years in a loop
    @Test(dataProvider = "years", dataProviderClass = DataProviderSet1.class, enabled = false)
    public void getAllYearValues(String year) {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
       // List <String> yearList = Arrays.asList("Select Year", "2018", "2017", "2016", "2015");
        for (int i=0; i<tradeIn.getYearSelectOptions().size(); i++) {
         //   for(int j=0; j<yearList.size(); j++) {
                Assert.assertEquals(tradeIn.getYearSelectOptions().get(i).getText(), year);
            //}
        }
    }

    @Test
    public void submitWithoutSelectingYearInputClass(){
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
Assert.assertEquals(tradeIn.getYearSelectClass(), PropertyLoader.loadProperty("inputClassValid2"));
    }

    @Test
    public void submitWithoutSelectingYearBorderColor(){
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getYearSelectBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test
    public void submitWithoutSelectingYearNotFocused(){
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertFalse(tradeIn.isYearSelected());
    }*/

    @Test(dataProvider = "yearsLead", dataProviderClass = DataProviderSet1.class)
    public void yearInLead(String yearForm, String yearLead) {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.selectYear(yearForm);
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
        Assert.assertEquals(leadDetails.getYear(), yearLead);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }
}
