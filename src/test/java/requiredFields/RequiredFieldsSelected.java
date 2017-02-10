package requiredFields;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testcase.TestBase;
import testcase.TestBase2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 03.01.2017.
 */

public class RequiredFieldsSelected extends TestBase2 {

    @Test(groups = "dws")
    public void firstNameSelected() throws InterruptedException, IOException {
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        contactUs.clickOnSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(contactUs.isFirstNameSelected());
    }

    @Test(groups = "dws")
    public void lastNameSelected() throws InterruptedException, IOException {
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.clickOnSubmit();
        Thread.sleep(2000);
         Assert.assertTrue(contactUs.isLastNameSelected());
    }

    @Test(groups = "dws")
    public void phoneNumSelected() throws InterruptedException, IOException {
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.clickOnSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(contactUs.isPhoneNumSelected());
    }

    @Test(groups = "dws")
    public void emailSelected() throws InterruptedException, IOException {
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum1();
        contactUs.clickOnSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(contactUs.isEmailSelected());
    }

    @Test(groups = "dws")
    public void zipSelected() throws InterruptedException, IOException {
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum1();
        contactUs.fillEmail();
        contactUs.clickOnSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(contactUs.isZipSelected());
    }
}
