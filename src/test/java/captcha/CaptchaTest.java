package captcha;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.Website;
import testcase.TestBase4;
import utility.PropertyLoader;

/**
 * Created by Julia on 30.01.2017.
 */
public class CaptchaTest extends TestBase4 {

    @Test(priority = 1)
    public void securityTitleExists() {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        wait.until(jsLoad);
        Website website = dmsHome2.clickOnWebsiteMenu();
        wait.until(jsLoad);
        website.enableCaptcha();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='forms_captcha']//a[@class='button-style b_edit notranslate']"))));
        website.setCaptchaType();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='type_of_captcha']//a[@class='button-style b_edit notranslate']"))));
        driver.get(PropertyLoader.loadProperty("dws.url"));
        wait.until(jsLoad);
        Assert.assertTrue(contactUs.isSecurityTitleDisplayed());

    }

    @Test(priority = 2)
    public void captchaImgExists() {
        Assert.assertTrue(contactUs.isCaptchaImgDisplayed());
    }

    @Test(priority = 3)
    public void captchaInputExists() {
        Assert.assertTrue(contactUs.isCapthaInputDispalyed());
    }

    @Test(priority = 4)
    public void captchaRefreshExists() {
        Assert.assertTrue(contactUs.isCaptchaRefreshDispalyed());
    }

}
