package TradeInForm;

import customers.LeadDetails;
import customers.Leads;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 13.03.2017.
 */
public class TradeInPageActions extends TradeInTestBase2 {

    @Test
    public void filledVinIsEmptyIfRefreshPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillVINVar("R564H5UL906AS3N8");
        waitForJSandJQueryToLoad();
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.vinGetValue(), "");
    }

    @Test
    public void filledYearIsEmptyIfRefreshPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectYear("2010");
        waitForJSandJQueryToLoad();
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getYearSelectValue(), "Select Year");
    }

    @Test
    public void filledMotorizedTypeIsEmptyIfRefreshPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMotorizedType(PropertyLoader.loadProperty("CARS_TRUCKS_VANS"));
        waitForJSandJQueryToLoad();
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getMotorizedTypeSelectValue(), "Select Motorized Type");
    }

    @Test
    public void filledMakeIsEmptyIfRefreshPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMotorizedType(PropertyLoader.loadProperty("CARS_TRUCKS_VANS"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMakeByIndex(1);
        waitForJSandJQueryToLoad();
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getMakeSelectValue(), "Select Make");
    }

    @Test
    public void filledModelIsEmptyIfRefreshPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMotorizedType(PropertyLoader.loadProperty("CARS_TRUCKS_VANS"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMakeByIndex(1);
        waitForJSandJQueryToLoad();
        tradeIn.selectModelByIndex(1);
        waitForJSandJQueryToLoad();
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getModelSelectValue(), "Select Model");
    }

    @Test
    public void filledTrimIsEmptyIfRefreshPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMotorizedType(PropertyLoader.loadProperty("CARS_TRUCKS_VANS"));
        waitForJSandJQueryToLoad();
        tradeIn.selectMakeByIndex(1);
        waitForJSandJQueryToLoad();
        tradeIn.selectModelByIndex(1);
        waitForJSandJQueryToLoad();
        tradeIn.selectTrimByIndex(1);
        waitForJSandJQueryToLoad();
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getTrimSelectValue(), "Select Trim");
    }

    @Test
    public void filledAskingPriceIsEmptyIfRefreshPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillAskPriceVar("10000");
        waitForJSandJQueryToLoad();
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.askingPriceGetValue(), "");
    }

    @Test
    public void filledOdometerIsEmptyIfRefreshPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillOdometerVar("100");
        waitForJSandJQueryToLoad();
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.odometerGetValue(), "");
    }

    @Test
    public void filledFirstNameIsEmptyIfRefreshPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        waitForJSandJQueryToLoad();
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.firstNameGetValue(), "");
    }

    @Test
    public void filledLastNameIsEmptyIfRefreshPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillLastName();
        waitForJSandJQueryToLoad();
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.lastNameGetValue(), "");
    }

    @Test
    public void filledEmailIsEmptyIfRefreshPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillEmail();
        waitForJSandJQueryToLoad();
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.emailGetValue(), "");
    }

    @Test
    public void filledPhoneNumIsEmptyIfRefreshPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillPhoneNum();
        waitForJSandJQueryToLoad();
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.phoneNumGetValue(), "");
    }

    @Test
    public void filledIntPhoneIsEmptyIfRefreshPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillIntPhoneVar("71296354896");
        waitForJSandJQueryToLoad();
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.intPhoneGetValue(), "");
    }

    @Test
    public void filledCommentsIsEmptyIfRefreshPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillCommentsVar("comment");
        waitForJSandJQueryToLoad();
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.commentsGetValue(), "");
    }

    @Test
    public void uploadImageIsEmptyIfRefreshPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(System.getProperty("user.dir") + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getUploadImagesNumber(), 0);
    }

    @Test
    public void formComesToLeadsIfClickBackAfterSubmit() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstNameVar("BackCheck");
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.navigate().back();
        waitForJSandJQueryToLoad();
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
        Assert.assertEquals(leadDetails.getFirstName(), "BackCheck");
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test
    public void loadingImageAppearsWhenSubmitForm() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstNameVar("BackCheck");
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.clickOnTradeInSubmit();
        Assert.assertTrue(tradeIn.isLoadingImgExists());
        waitForJSandJQueryToLoad();
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        wait.until(isLeadsListVisible());
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test
    public void loadingTextAppearsWhenSubmitForm() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstNameVar("BackCheck");
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.clickOnTradeInSubmit();
        Assert.assertEquals(tradeIn.getLoadingDWSText(), "Loading...");
        waitForJSandJQueryToLoad();
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        wait.until(isLeadsListVisible());
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test
    public void loadingBgAppearsWhenSubmitForm() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstNameVar("BackCheck");
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.clickOnTradeInSubmit();
        Assert.assertEquals(tradeIn.getLoadingBg(), PropertyLoader.loadProperty("loadingDWSBg"));
        waitForJSandJQueryToLoad();
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        wait.until(isLeadsListVisible());
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }
}
