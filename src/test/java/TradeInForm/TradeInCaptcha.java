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
public class TradeInCaptcha extends TradeInTestBase2 {

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
        website.setCaptchaType();
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
    public void captchaImgExists() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.isCaptchaImgDisplayed());
    }

    @Test
    public void captchaInputExists() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.isCapthaInputDispalyed());
    }

    @Test
    public void captchaRefreshExists() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.isCaptchaRefreshDispalyed());
    }
}
