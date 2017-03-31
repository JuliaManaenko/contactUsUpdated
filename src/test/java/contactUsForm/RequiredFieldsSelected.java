package contactUsForm;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Julia on 03.01.2017.
 */

public class RequiredFieldsSelected extends TestBase2 {

    @Test(groups = "dws")
    public void firstNameSelected() throws InterruptedException, IOException {
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        formsPage.clickOnSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(formsPage.isFirstNameSelected());
    }

    @Test(groups = "dws")
    public void lastNameSelected() throws InterruptedException, IOException {
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.clickOnSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(formsPage.isLastNameSelected());
    }

    @Test(groups = "dws")
    public void phoneNumSelected() throws InterruptedException, IOException {
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.clickOnSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(formsPage.isPhoneNumSelected());
    }

    @Test(groups = "dws")
    public void emailSelected() throws InterruptedException, IOException {
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum1();
        formsPage.clickOnSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(formsPage.isEmailSelected());
    }

    @Test(groups = "dws")
    public void zipSelected() throws InterruptedException, IOException {
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        formsPage.fillFirstName();
        formsPage.fillLastName();
        formsPage.fillPhoneNum1();
        formsPage.fillEmail();
        formsPage.clickOnSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(formsPage.isZipSelected());
    }
}
