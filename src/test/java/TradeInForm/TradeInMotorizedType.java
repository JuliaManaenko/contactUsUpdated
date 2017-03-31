package TradeInForm;

import customers.LeadDetails;
import customers.Leads;
import dataProviders.DataProviderSet1;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 06.03.2017.
 */
public class TradeInMotorizedType extends TradeInTestBase2 {

    @Test
    public void labelIsMotorizedType() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getMotorizedTypeLabelText(), PropertyLoader.loadProperty("motorizedTypeLabel"));
    }

    @Test
    public void motorizedTypeSelectIsEnabled() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.isMotorizedTypeSelectEnabled());
    }

    @Test
    public void selectMotorizedTypeByDefault() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getMotorizedTypeSelectValue(), "Select Motorized Type");
    }

    @Test
    public void submitWithoutSelectingMotorizedTypeClass() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getMotorizedTypeSelectClass(), PropertyLoader.loadProperty("inputClassMotorizedType"));
    }

    @Test
    public void submitWithoutSelectingMotorizedTypeBorderColor() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getMotorizedTypeSelectBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test
    public void submitWithoutSelectingMotorizedTypeNotFocused() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertFalse(tradeIn.isMotorizedTypeSelected());
    }

    @Test
    public void submitWithoutSelectingMotorizedTypeLabelFontColor() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getMotorizedTypeLabelFontColor(), PropertyLoader.loadProperty("font_color_gray"));
    }

    @Test
    public void getAllMotorizedTypeValues() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        for (int i = 0; i < tradeIn.getMotorizedTypeSelectOptions().size(); i++) { //compare recived years and years from array list
            Assert.assertEquals(tradeIn.getMotorizedTypeSelectOptions().get(i).getText(), tradeIn.getMotorizedTypeSelectOptionsManually().get(i));
        }
    }

    @Test(dataProvider = "motorizedType", dataProviderClass = DataProviderSet1.class)
    public void motorizedTypeInLead(String motorizedTypeForm, String motorizedTypeLead) {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.selectMotorizedType(motorizedTypeForm);
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
        Assert.assertEquals(leadDetails.getMotorizedType(), motorizedTypeLead);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test(dataProvider = "motorizedType", dataProviderClass = DataProviderSet1.class)
    public void motorizedTypeSelected(String motorizedTypeForm, String motorizedTypeLead) {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMotorizedType(motorizedTypeForm);
        Assert.assertEquals(tradeIn.getMotorizedTypeSelectValue(), motorizedTypeForm);
    }

    @Test(dataProvider = "yearsLead", dataProviderClass = DataProviderSet1.class)
    public void motorTypeIsnotDependOfYear(String yearForm, String yearLead) {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectYear(yearForm);
        Assert.assertEquals(tradeIn.getMotorizedTypeSelectOptions().size(), 19);
    }

    @Test
    public void motorizedTypeIsEnabledByDefault() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.isMotorizedTypeSelectEnabled());
    }


}
