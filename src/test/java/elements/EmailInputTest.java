package elements;

import contactUsPage.ContactUs;
import dms.dmsHome;
import map2.ContactEditor;
import map2.MAP2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.PropertyLoader;
import webdriver.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 18.01.2017.
 */
public class EmailInputTest {
    protected WebDriver driver;
    WebDriverWait wait;
    protected ContactUs contactUs;
    protected dms.dmsHome dmsHome;

    @BeforeClass
    @Parameters({"browserName"})
    public void activatePage(String browserName) throws Exception {
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dmsHome = PageFactory.initElements(driver, dmsHome.class);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        map2.clickContactTab();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        Thread.sleep(2000);
        ContactEditor editor = map2.clickAddPage();
        Thread.sleep(2000);
        editor.addWidget();
        editor.activatePage();
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        if (driver != null) {
            //   LOG.info("Killing web driver");
            WebDriverFactory.killDriverInstance();
        }
    }

    @BeforeMethod
    @Parameters({"browserName"})
    public void setup(String browserName) throws Exception {
        driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.get(PropertyLoader.loadProperty("dws.url"));
        contactUs = PageFactory.initElements(driver, ContactUs.class);
    }

    @AfterClass
    //  @Parameters({ "browserName" })
    public void tearDown() throws InterruptedException {
        //    driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome dmsHome1 = PageFactory.initElements(driver, dms.dmsHome.class);
        dms.dmsHome2 dmsHome2 = dmsHome1.loginToDms();
        // waitForJSandJQueryToLoad();
        Thread.sleep(3000);
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        //  waitForJSandJQueryToLoad();
        Thread.sleep(3000);
        map2.clickContactTab();
        Thread.sleep(3000);
        map2.deletePage();
        Thread.sleep(1000);
        if (driver != null) {
            //   LOG.info("Killing web driver");
            WebDriverFactory.killDriverInstance();
        }
    }

    @Test(dataProvider = "incorrectEmail")
    public void incorrectCharsInEmailClass(String nEmail) {
        driver.findElement(By.name("email")).sendKeys(nEmail);
        contactUs.clickOnSubmit();
        Assert.assertEquals(contactUs.getEmailInputClass(), "form-control error");
    }

    @Test
    public void twoAtInEmailClass() {
        driver.findElement(By.name("email")).sendKeys(PropertyLoader.loadProperty("nEmail20"));
        contactUs.clickOnSubmit();
        Assert.assertEquals(contactUs.getEmailInputClass(), "form-control error");
    }

    @Test
    public void twoAtInEmailHighlight() throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys(PropertyLoader.loadProperty("nEmail20"));
        contactUs.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getEmailInputBorderColor(), PropertyLoader.loadProperty("border_color_red"));
    }

    @Test
    public void twoDotInEmailClass() {
        driver.findElement(By.name("email")).sendKeys(PropertyLoader.loadProperty("nEmail21"));
        contactUs.clickOnSubmit();
        Assert.assertEquals(contactUs.getEmailInputClass(), "form-control error");
    }

    @Test
    public void twoDotInEmailHighlight() throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys(PropertyLoader.loadProperty("nEmail21"));
        contactUs.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getEmailInputBorderColor(), PropertyLoader.loadProperty("border_color_red"));
    }

    @Test
    public void withoutLoginEmailClass() {
        driver.findElement(By.name("email")).sendKeys(PropertyLoader.loadProperty("nEmail22"));
        contactUs.clickOnSubmit();
        Assert.assertEquals(contactUs.getEmailInputClass(), "form-control error");
    }

    @Test
    public void withoutLoginEmailHighlight() throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys(PropertyLoader.loadProperty("nEmail22"));
        contactUs.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getEmailInputBorderColor(), PropertyLoader.loadProperty("border_color_red"));
    }

    @Test
    public void withoutAtEmailClass() {
        driver.findElement(By.name("email")).sendKeys(PropertyLoader.loadProperty("nEmail23"));
        contactUs.clickOnSubmit();
        Assert.assertEquals(contactUs.getEmailInputClass(), "form-control error");
    }

    @Test
    public void withoutAtEmailHighlight() throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys(PropertyLoader.loadProperty("nEmail23"));
        contactUs.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getEmailInputBorderColor(), PropertyLoader.loadProperty("border_color_red"));
    }

    @Test
    public void withoutDomainEmailClass() {
        driver.findElement(By.name("email")).sendKeys(PropertyLoader.loadProperty("nEmail24"));
        contactUs.clickOnSubmit();
        Assert.assertEquals(contactUs.getEmailInputClass(), "form-control error");
    }

    @Test
    public void withoutDomainEmailHighlight() throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys(PropertyLoader.loadProperty("nEmail24"));
        contactUs.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getEmailInputBorderColor(), PropertyLoader.loadProperty("border_color_red"));
    }

    @Test
    public void correctEmailClass() {
        driver.findElement(By.name("email")).sendKeys(PropertyLoader.loadProperty("Email1"));
        contactUs.clickOnSubmit();
        Assert.assertEquals(contactUs.getEmailInputClass(), "form-control valid");
    }

    @Test
    public void correctEmailHighlight() throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys(PropertyLoader.loadProperty("Email1"));
        contactUs.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(contactUs.getEmailInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @DataProvider(name = "incorrectEmail")
    public Object[][] getIncorrectEmail() {
        return new Object[][]{{PropertyLoader.loadProperty("nEmail1")},
                {PropertyLoader.loadProperty("nEmail2")},
                {PropertyLoader.loadProperty("nEmail3")},
                {PropertyLoader.loadProperty("nEmail4")},
                {PropertyLoader.loadProperty("nEmail5")},
                {PropertyLoader.loadProperty("nEmail6")},
                {PropertyLoader.loadProperty("nEmail7")},
                {PropertyLoader.loadProperty("nEmail8")},
                {PropertyLoader.loadProperty("nEmail9")},
                {PropertyLoader.loadProperty("nEmail10")},
                {PropertyLoader.loadProperty("nEmail11")},
                {PropertyLoader.loadProperty("nEmail12")},
                {PropertyLoader.loadProperty("nEmail13")},
                {PropertyLoader.loadProperty("nEmail14")},
                {PropertyLoader.loadProperty("nEmail15")},
                {PropertyLoader.loadProperty("nEmail16")},
                {PropertyLoader.loadProperty("nEmail17")},
                {PropertyLoader.loadProperty("nEmail18")},
                {PropertyLoader.loadProperty("nEmail19")},};
    }

    public boolean waitForJSandJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
    /*method for execute Java Script: page should be loaded*/
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
}
