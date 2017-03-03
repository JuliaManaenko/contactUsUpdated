package TradeInForm;

import dataProviders.DataProviderSet1;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import settings.Localization;
import settings.Website;
import utility.PropertyLoader;
import webmail.EmailDetails;
import webmail.EmailsList;

/**
 * Created by Julia on 27.02.2017.
 */
public class TradeInPhoneNumInEmail extends TradeInTestBaseEmail {

    @AfterMethod
    public void setInputMaskDefault() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        wait.until(isWebsiteSidePanelVisible());
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        wait.until(isLocalizationBreadcrumbsVisible());
        localization.turnOnForceValid();
        waitForJSandJQueryToLoad();
        localization.fillInputMaskStar1();
        waitForJSandJQueryToLoad();
        // driver.manage().deleteAllCookies();
    }

    @Test(dataProvider = "phones", dataProviderClass = DataProviderSet1.class)
    public void inputMaskCheck(String inputMask, String phone) throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        wait.until(isWebsiteSidePanelVisible());
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        wait.until(isLocalizationBreadcrumbsVisible());
        localization.turnOnForceValid();
        waitForJSandJQueryToLoad();
        localization.fillInputMaskVar(inputMask);
        waitForJSandJQueryToLoad();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillEmail();
        tradeIn.fillPhoneNumVar(phone);
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        EmailsList emailsList = dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        wait.until(isWebmailFrameVisible());
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getPhone(), phone);
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }

    @Test
    public void forceValidOffInEmail() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait = new WebDriverWait(driver, 10);
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Website website = dmsHome2.clickOnWebsiteMenu2();
        waitForJSandJQueryToLoad();
        wait.until(isWebsiteSidePanelVisible());
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        wait.until(isLocalizationBreadcrumbsVisible());
        localization.turnOffForceValid();
        waitForJSandJQueryToLoad();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillEmail();
        tradeIn.fillPhoneNumVar(PropertyLoader.loadProperty("phoneAll"));
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        EmailsList emailsList =  dmsHome2.clickOnWebmailMenu2();
        waitForJSandJQueryToLoad();
        wait.until(isWebmailFrameVisible());
        EmailDetails emailDetails = emailsList.openFirstEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        Assert.assertEquals(emailDetails.getPhone(), PropertyLoader.loadProperty("phoneAll"));
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
        EmailsList emailsList1 = emailDetails.removeEmail();
        waitForJSandJQueryToLoad();
        Thread.sleep(1000);
    }
}
