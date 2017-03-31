package TradeInForm;

import customers.LeadDetails;
import customers.Leads;
import dataProviders.DataProviderSet1;
import dmsInventory.UploadWizard;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertyLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julia on 06.03.2017.
 */
public class TradeInMake extends TradeInTestBase2 {

    @Test
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
    }

    @Test
    public void submitWithoutSelectingMakeLabelFontColor() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getMakeLabelFontColor(), PropertyLoader.loadProperty("font_color_gray"));
    }

    @Test(dataProvider = "motorizedTypeWithoutSelect", dataProviderClass = DataProviderSet1.class)
    public void makeIsEnabledIfSelectMotorizedType(String motorizedTypeForm, String motorizedTypeLead) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMotorizedType(motorizedTypeForm);
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.isMakeSelectEnabled());
    }

    @Test
    public void makeIsDisabledIfSelectYear() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectYear("1995");
        Assert.assertFalse(tradeIn.isMakeSelectEnabled());
    }

    @Test
    public void makeSelected() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMotorizedType(PropertyLoader.loadProperty("CARS_TRUCKS_VANS"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMakeByIndex(1);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getMakeSelectValue(), tradeIn.getMakeSelectOptions().get(1).getText());
    }

    @Test
    public void makeInLead() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.selectMotorizedType(PropertyLoader.loadProperty("CARS_TRUCKS_VANS"));
        waitForJSandJQueryToLoad();
        String firstMake = tradeIn.getMakeSelectOptions().get(1).getText();
        tradeIn.selectMakeByIndex(1);
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
        Assert.assertEquals(leadDetails.getMake(), firstMake);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test(dataProvider = "motorizedTypeWithoutSelect", dataProviderClass = DataProviderSet1.class)
    public void makesAreFromSelectedMotorType(String motorizedTypeForm, String motorizedTypeLead) {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        UploadWizard uploadWizard = dmsHome2.clickOnUploadWizardMenu();
        waitForJSandJQueryToLoad();
        wait.until(isUWFormVisible());
        uploadWizard.selectMotorizedType(motorizedTypeForm);
        waitForJSandJQueryToLoad();
        List<String> optionMake = uploadWizard.getMakeSelectOptionsText();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMotorizedType(motorizedTypeForm);
        waitForJSandJQueryToLoad();
        for (int i = 0; i < tradeIn.getMakeSelectOptions().size(); i++) {
            Assert.assertEquals(tradeIn.getMakeSelectOptions().get(i).getText(), optionMake.get(i));
        }
    }

}
