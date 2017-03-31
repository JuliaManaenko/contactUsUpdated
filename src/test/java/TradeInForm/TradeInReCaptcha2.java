package TradeInForm;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import settings.Website;
import utility.PropertyLoader;

/**
 * Created by Julia on 09.03.2017.
 */
public class TradeInReCaptcha2 extends TradeInTestBase2 {

    @BeforeClass
    public void setCaptcha() {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Website website = dmsHome2.clickOnWebsiteMenu2();
        waitForJSandJQueryToLoad();
        wait.until(isWebsiteSidePanelVisible());
        website.enableCaptcha();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='forms_captcha']//a[@class='button-style b_edit notranslate']"))));
        website.setReCaptcha2Type();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='type_of_captcha']//a[@class='button-style b_edit notranslate']"))));
    }

    @AfterClass
    public void disableCaptcha() {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        wait.until(isWebsiteSidePanelVisible());
        website.disableCaptcha();
        waitForJSandJQueryToLoad();
    }

    @Test
    public void securityTitleExists() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.isSecurityTitleDisplayed());
    }

    @Test
    public void reCaptcha2Exists() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.isRecaptcha2Displayed());
    }

    @Test
    public void reCaptcha2AstericsExists() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.isAstericsCaptchaDisplayed());
    }

    @Test
    public void submitWithoutCaptcha() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.isTradeInSubmitButtonDisplayed());
    }
}
