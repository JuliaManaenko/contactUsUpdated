package contactUsForm;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Julia on 30.12.2016.
 */

public class RequiredFieldsHighlighted extends TestBase2 {
    private WebDriver driver;


    //@BeforeGroups ("highlight")
    @Test(priority = 1)
    public void clickSubmit() throws InterruptedException {
        formsPage.clickOnSubmit();
        Thread.sleep(1000);
        //  WebDriverWait wait = new WebDriverWait(driver, 10);
        //  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("first_name"))));
    }


    @Test(groups = "dws", priority = 2)
    public void firstNameClass() {

        Assert.assertEquals(formsPage.getFirstNameInputClass(), "form-control error");
    }

    @Test(groups = "dws", priority = 3)
    public void lastNameClass() {
        Assert.assertEquals(formsPage.getLastNameInputClass(), "form-control error");
    }

    @Test(groups = "dws", priority = 4)
    public void emailNameClass() {
        Assert.assertEquals(formsPage.getEmailInputClass(), "form-control error");
    }

    @Test(groups = "dws", priority = 5)
    public void phoneNumNameClass() {
        Assert.assertEquals(formsPage.getPhoneNumInputClass(), "form-control text-uppercase error");

    }

    @Test(groups = "dws", priority = 6)
    public void zipNameClass() {
        Assert.assertEquals(formsPage.getZipInputClass(), "form-control text-uppercase error");
    }

    @Test(groups = "dws", priority = 7)
    public void firstNameHighlight() {
        Assert.assertEquals(formsPage.getFirstNameInputBorderColor(), "rgb(132, 53, 52)");
    }

    @Test(groups = "dws", priority = 8)
    public void lastNameHighlight() {
        Assert.assertEquals(formsPage.getLastNameInputBorderColor(), "rgb(169, 68, 66)");
    }

    @Test(groups = "dws", priority = 9)
    public void phoneNumHighlight() {
        Assert.assertEquals(formsPage.getPhoneNumInputBorderColor(), "rgb(169, 68, 66)");
    }

    @Test(groups = "dws", priority = 10)
    public void emailHighlight() {
        Assert.assertEquals(formsPage.getEmailInputBorderColor(), "rgb(169, 68, 66)");
    }

    @Test(groups = "dws", priority = 11)
    public void zipHighlight() {
        Assert.assertEquals(formsPage.getZipInputBorderColor(), "rgb(169, 68, 66)");
    }


}
