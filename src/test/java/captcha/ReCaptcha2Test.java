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
public class ReCaptcha2Test extends TestBase4 {

    @Test(priority = 1)
    public void securityTitleExists(){
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        website.enableCaptcha();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='forms_captcha']//a[@class='button-style b_edit notranslate']"))));
        website.setReCaptcha2Type();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='type_of_captcha']//a[@class='button-style b_edit notranslate']"))));
        driver.get(PropertyLoader.loadProperty("dws.url"));
        waitForJSandJQueryToLoad();
        Assert.assertTrue(contactUs.isSecurityTitleDisplayed());
    }

    @Test(priority = 2)
    public void reCaptcha2Exists(){
        Assert.assertTrue(contactUs.isRecaptcha2Displayed());
    }

    @Test(priority = 3)
    public void reCaptcha2AstericsExists(){
        Assert.assertTrue(contactUs.isAstericsCaptchaDisplayed());
    }

    @Test(priority = 4)
    public void submitWithoutCaptcha(){
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        contactUs.fillZip();
        contactUs.clickOnSubmit();
        Assert.assertTrue(contactUs.isSubmitButtonDisplayed());
    }

}
