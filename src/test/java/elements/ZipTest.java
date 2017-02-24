package elements;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import settings.Localization;
import settings.Website;
import testcase.TestBase;
import utility.PropertyLoader;

import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Julia on 20.01.2017.
 */
public class ZipTest extends TestBase {

    WebDriverWait wait;
    protected dms.dmsHome2 dmsHome2;

    @Test(priority = 1)
    public void loginToDms() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        map2.clickContactTab();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.map-link.pull-right"))));
        Thread.sleep(1000);
        ContactEditor editor = map2.clickAddPage();
        Thread.sleep(1000);
        editor.addWidget();
        editor.activatePage();
        waitForJSandJQueryToLoad();
       // wait.until(jsLoad);
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void setZipN3() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Thread.sleep(1000);
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        localization.allowNumZip();
        //Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        localization.setMinZip3();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipN3", priority = 3)
    public void correctZipN3Class(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(dataProvider = "zipN3", priority = 4)
    public void correctZipN3Highlight(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(dataProvider = "incZipN3", priority = 5)
    public void incorrectZipN3Class(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputClass(), PropertyLoader.loadProperty("inputPhoneClassError"));
    }

    @Test(dataProvider = "incZipN3", priority = 6)
    public void incorrectZipN3Highlight(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputBorderColor(), PropertyLoader.loadProperty("border_color_red"));
    }

    @Test(priority = 7)
    public void zipCutTo6() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(PropertyLoader.loadProperty("zipN7"));
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.zipGetValue(), PropertyLoader.loadProperty("zipN6"));
    }

    @Test(priority = 8)
    public void setZipN4() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        // dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
       // wait.until(jsLoad);
        localization.allowNumZip();
        // Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        localization.setMinZip4();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipN4", priority = 9)
    public void correctZipN4Class(String zip) throws InterruptedException {

        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(dataProvider = "zipN4", priority = 10)
    public void correctZipN4Highlight(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(dataProvider = "incZipN4", priority = 11)
    public void incorrectZipN4Class(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputClass(), PropertyLoader.loadProperty("inputPhoneClassError"));
    }

    @Test(dataProvider = "incZipN4", priority = 12)
    public void incorrectZipN4Highlight(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputBorderColor(), PropertyLoader.loadProperty("border_color_red"));
    }

    @Test(priority = 13)
    public void setZipN5() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        //   dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
       // wait.until(jsLoad);
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
        localization.allowNumZip();
        //Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        localization.setMinZip5();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipN5", priority = 14)
    public void correctZipN5Class(String zip) throws InterruptedException {

        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(dataProvider = "zipN5", priority = 15)
    public void correctZipN5Highlight(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(dataProvider = "incZipN5", priority = 16)
    public void incorrectZipN5Class(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputClass(), PropertyLoader.loadProperty("inputPhoneClassError"));
    }

    @Test(dataProvider = "incZipN5", priority = 17)
    public void incorrectZipN5Highlight(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputBorderColor(), PropertyLoader.loadProperty("border_color_red"));
    }

    @Test(priority = 18)
    public void setZipN6() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        //  dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        localization.allowNumZip();
        // Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        localization.setMinZip6();
        Thread.sleep(1000);
    }

    @Test(priority = 19)
    public void correctZipN6Class() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(PropertyLoader.loadProperty("zipN6"));
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(priority = 20)
    public void correctZipN6Highlight() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(PropertyLoader.loadProperty("zipN6"));
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(dataProvider = "incZipN6", priority = 21)
    public void incorrectZipN6Class(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputClass(), PropertyLoader.loadProperty("inputPhoneClassError"));
    }

    @Test(dataProvider = "incZipN6", priority = 22)
    public void incorrectZipN6Highlight(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputBorderColor(), PropertyLoader.loadProperty("border_color_red"));
    }

    @Test(priority = 23)
    public void setZipL3() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
       // wait.until(jsLoad);
        localization.allowCharNumZip();
        // Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        localization.setMinZip3();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipL3", priority = 24)
    public void correctZipL3Class(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(dataProvider = "zipL3", priority = 25)
    public void correctZipL3Highlight(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(dataProvider = "incZipL3", priority = 26)
    public void incorrectZipL3Class(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputClass(), PropertyLoader.loadProperty("inputPhoneClassError"));
    }

    @Test(dataProvider = "incZipL3", priority = 27)
    public void incorrectZipL3Highlight(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputBorderColor(), PropertyLoader.loadProperty("border_color_red"));
    }

    @Test(dataProvider = "Zip7", priority = 28)
    public void ziplCutTo6(String zip7, String zip6) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip7);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.zipGetValue(), zip6);
    }

    @Test(priority = 29)
    public void setZipL4() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        // dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
       // wait.until(jsLoad);
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        localization.allowCharNumZip();
        // Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        localization.setMinZip4();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipL4", priority = 30)
    public void correctZipL4Class(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(dataProvider = "zipL4", priority = 31)
    public void correctZipL4Highlight(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(dataProvider = "incZipL4", priority = 32)
    public void incorrectZipL4Class(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputClass(), PropertyLoader.loadProperty("inputPhoneClassError"));
    }

    @Test(dataProvider = "incZipL4", priority = 33)
    public void incorrectZipL4Highlight(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputBorderColor(), PropertyLoader.loadProperty("border_color_red"));
    }

    @Test(priority = 34)
    public void setZipL5() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        //   dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']"))));
        localization.allowCharNumZip();
        // Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        localization.setMinZip5();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipL5", priority = 35)
    public void correctZipL5Class(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(dataProvider = "zipL5", priority = 36)
    public void correctZipL5Highlight(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(dataProvider = "incZipL5", priority = 37)
    public void incorrectZipL5Class(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputClass(), PropertyLoader.loadProperty("inputPhoneClassError"));
    }

    @Test(dataProvider = "incZipL5", priority = 38)
    public void incorrectZipL5Highlight(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputBorderColor(), PropertyLoader.loadProperty("border_color_red"));
    }

    @Test(priority = 39)
    public void setZipL6() throws InterruptedException {
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        //  dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Website website = dmsHome2.clickOnWebsiteMenu();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Thread.sleep(1000);
        Localization localization = website.clickOnLocalizationTab();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        Thread.sleep(1000);
        localization.allowCharNumZip();
        // Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']"))));
        localization.setMinZip6();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "zipL6", priority = 40)
    public void correctZipL6Class(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputClass(), PropertyLoader.loadProperty("inputPhoneClassValid"));
    }

    @Test(dataProvider = "zipL6", priority = 41)
    public void correctZipL6Highlight(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputBorderColor(), PropertyLoader.loadProperty("border_color_gray"));
    }

    @Test(dataProvider = "incZipL6", priority = 42)
    public void incorrectZipL6Class(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputClass(), PropertyLoader.loadProperty("inputPhoneClassError"));
    }

    @Test(dataProvider = "incZipL6", priority = 43)
    public void incorrectZipL6Highlight(String zip) throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url"));
        driver.findElement(By.name("zip")).clear();
        driver.findElement(By.name("zip")).sendKeys(zip);
        dwsPage.clickOnSubmit();
        Thread.sleep(1000);
        Assert.assertEquals(dwsPage.getZipInputBorderColor(), PropertyLoader.loadProperty("border_color_red"));
    }

    @Test(priority = 44)
    public void deleteMap2Page() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        //wait.until(jsLoad);
        map2.clickContactTab();
        Thread.sleep(1000);
        map2.deletePage();
        Thread.sleep(1000);
    }

    @DataProvider(name = "zipN3")
    private Object[][] putZipN3() {
        return new Object[][]{{PropertyLoader.loadProperty("zipN3")},
                {PropertyLoader.loadProperty("zipN4")},
                {PropertyLoader.loadProperty("zipN5")},
                {PropertyLoader.loadProperty("zipN6")},
                {PropertyLoader.loadProperty("zipN7")}};
    }

    @DataProvider(name = "zipN4")
    private Object[][] putZipN4() {
        return new Object[][]{{PropertyLoader.loadProperty("zipN4")},
                {PropertyLoader.loadProperty("zipN5")},
                {PropertyLoader.loadProperty("zipN6")},
                {PropertyLoader.loadProperty("zipN7")}};
    }

    @DataProvider(name = "zipN5")
    private Object[][] putZipN5() {
        return new Object[][]{{PropertyLoader.loadProperty("zipN5")},
                {PropertyLoader.loadProperty("zipN6")},
                {PropertyLoader.loadProperty("zipN7")}};
    }

    @DataProvider(name = "zipL3")
    private Object[][] putZipL3() {
        return new Object[][]{{PropertyLoader.loadProperty("zipL3")},
                {PropertyLoader.loadProperty("zipL4")},
                {PropertyLoader.loadProperty("zipL5")},
                {PropertyLoader.loadProperty("zipL6")},
                {PropertyLoader.loadProperty("zipL7")},
                {PropertyLoader.loadProperty("zipM3")},
                {PropertyLoader.loadProperty("zipM4")},
                {PropertyLoader.loadProperty("zipM5")},
                {PropertyLoader.loadProperty("zipM6")},
                {PropertyLoader.loadProperty("zipM7")},
                {PropertyLoader.loadProperty("zipN3")},
                {PropertyLoader.loadProperty("zipN4")},
                {PropertyLoader.loadProperty("zipN5")},
                {PropertyLoader.loadProperty("zipN6")},
                {PropertyLoader.loadProperty("zipN7")}};
    }

    @DataProvider(name = "zipL4")
    private Object[][] putZipL4() {
        return new Object[][]{{PropertyLoader.loadProperty("zipL4")},
                {PropertyLoader.loadProperty("zipL5")},
                {PropertyLoader.loadProperty("zipL6")},
                {PropertyLoader.loadProperty("zipL7")},
                {PropertyLoader.loadProperty("zipM4")},
                {PropertyLoader.loadProperty("zipM5")},
                {PropertyLoader.loadProperty("zipM6")},
                {PropertyLoader.loadProperty("zipM7")},
                {PropertyLoader.loadProperty("zipN4")},
                {PropertyLoader.loadProperty("zipN5")},
                {PropertyLoader.loadProperty("zipN6")},
                {PropertyLoader.loadProperty("zipN7")}};
    }

    @DataProvider(name = "zipL5")
    private Object[][] putZipL5() {
        return new Object[][]{{PropertyLoader.loadProperty("zipL5")},
                {PropertyLoader.loadProperty("zipL6")},
                {PropertyLoader.loadProperty("zipL7")},
                {PropertyLoader.loadProperty("zipM5")},
                {PropertyLoader.loadProperty("zipM6")},
                {PropertyLoader.loadProperty("zipM7")},
                {PropertyLoader.loadProperty("zipN5")},
                {PropertyLoader.loadProperty("zipN6")},
                {PropertyLoader.loadProperty("zipN7")}};
    }

    @DataProvider(name = "zipL6")
    private Object[][] putZipL6() {
        return new Object[][]{{PropertyLoader.loadProperty("zipL6")},
                {PropertyLoader.loadProperty("zipL7")},
                {PropertyLoader.loadProperty("zipM6")},
                {PropertyLoader.loadProperty("zipM7")},
                {PropertyLoader.loadProperty("zipN6")},
                {PropertyLoader.loadProperty("zipN7")}};
    }

    @DataProvider(name = "incZipN3")
    public Object[][] incZipN3() {
        return new Object[][]{{PropertyLoader.loadProperty("zipN1")},
                {PropertyLoader.loadProperty("zipN2 ")},
                {PropertyLoader.loadProperty("zipL1")},
                {PropertyLoader.loadProperty("zipL2")},
                {PropertyLoader.loadProperty("zipL3")},
                {PropertyLoader.loadProperty("zipL4")},
                {PropertyLoader.loadProperty("zipL5")},
                {PropertyLoader.loadProperty("zipL6")},
                {PropertyLoader.loadProperty("zipL7")},
                {PropertyLoader.loadProperty("zipM1")},
                {PropertyLoader.loadProperty("zipM2")},
                {PropertyLoader.loadProperty("zipM3")},
                {PropertyLoader.loadProperty("zipm4")},
                {PropertyLoader.loadProperty("zipM5")},
                {PropertyLoader.loadProperty("zipM6")},
                {PropertyLoader.loadProperty("zipM7")}};
    }

    @DataProvider(name = "incZipN4")
    public Object[][] incZipN4() {
        return new Object[][]{{PropertyLoader.loadProperty("zipN1")},
                {PropertyLoader.loadProperty("zipN2 ")},
                {PropertyLoader.loadProperty("zipN3 ")},
                {PropertyLoader.loadProperty("zipL1")},
                {PropertyLoader.loadProperty("zipL2")},
                {PropertyLoader.loadProperty("zipL3")},
                {PropertyLoader.loadProperty("zipL4")},
                {PropertyLoader.loadProperty("zipL5")},
                {PropertyLoader.loadProperty("zipL6")},
                {PropertyLoader.loadProperty("zipL7")},
                {PropertyLoader.loadProperty("zipM1")},
                {PropertyLoader.loadProperty("zipM2")},
                {PropertyLoader.loadProperty("zipM3")},
                {PropertyLoader.loadProperty("zipm4")},
                {PropertyLoader.loadProperty("zipM5")},
                {PropertyLoader.loadProperty("zipM6")},
                {PropertyLoader.loadProperty("zipM7")}};
    }

    @DataProvider(name = "incZipN5")
    public Object[][] incZipN5() {
        return new Object[][]{{PropertyLoader.loadProperty("zipN1")},
                {PropertyLoader.loadProperty("zipN2 ")},
                {PropertyLoader.loadProperty("zipN3 ")},
                {PropertyLoader.loadProperty("zipN4 ")},
                {PropertyLoader.loadProperty("zipL1")},
                {PropertyLoader.loadProperty("zipL2")},
                {PropertyLoader.loadProperty("zipL3")},
                {PropertyLoader.loadProperty("zipL4")},
                {PropertyLoader.loadProperty("zipL5")},
                {PropertyLoader.loadProperty("zipL6")},
                {PropertyLoader.loadProperty("zipL7")},
                {PropertyLoader.loadProperty("zipM1")},
                {PropertyLoader.loadProperty("zipM2")},
                {PropertyLoader.loadProperty("zipM3")},
                {PropertyLoader.loadProperty("zipm4")},
                {PropertyLoader.loadProperty("zipM5")},
                {PropertyLoader.loadProperty("zipM6")},
                {PropertyLoader.loadProperty("zipM7")}};
    }

    @DataProvider(name = "incZipN6")
    public Object[][] incZipN6() {
        return new Object[][]{{PropertyLoader.loadProperty("zipN1")},
                {PropertyLoader.loadProperty("zipN2 ")},
                {PropertyLoader.loadProperty("zipN3 ")},
                {PropertyLoader.loadProperty("zipN4 ")},
                {PropertyLoader.loadProperty("zipN5 ")},
                {PropertyLoader.loadProperty("zipL1")},
                {PropertyLoader.loadProperty("zipL2")},
                {PropertyLoader.loadProperty("zipL3")},
                {PropertyLoader.loadProperty("zipL4")},
                {PropertyLoader.loadProperty("zipL5")},
                {PropertyLoader.loadProperty("zipL6")},
                {PropertyLoader.loadProperty("zipL7")},
                {PropertyLoader.loadProperty("zipM1")},
                {PropertyLoader.loadProperty("zipM2")},
                {PropertyLoader.loadProperty("zipM3")},
                {PropertyLoader.loadProperty("zipm4")},
                {PropertyLoader.loadProperty("zipM5")},
                {PropertyLoader.loadProperty("zipM6")},
                {PropertyLoader.loadProperty("zipM7")}};
    }

    @DataProvider(name = "incZipL3")
    public Object[][] incZipL3() {
        return new Object[][]{{PropertyLoader.loadProperty("zipN1")},
                {PropertyLoader.loadProperty("zipN2 ")},
                {PropertyLoader.loadProperty("zipL1")},
                {PropertyLoader.loadProperty("zipL2")},
                {PropertyLoader.loadProperty("zipM1")},
                {PropertyLoader.loadProperty("zipM2")}};
    }

    @DataProvider(name = "incZipL4")
    public Object[][] incZipL4() {
        return new Object[][]{{PropertyLoader.loadProperty("zipN1")},
                {PropertyLoader.loadProperty("zipN2")},
                {PropertyLoader.loadProperty("zipN3")},
                {PropertyLoader.loadProperty("zipL1")},
                {PropertyLoader.loadProperty("zipL2")},
                {PropertyLoader.loadProperty("zipL3")},
                {PropertyLoader.loadProperty("zipM1")},
                {PropertyLoader.loadProperty("zipM2")},
                {PropertyLoader.loadProperty("zipM3")},};
    }

    @DataProvider(name = "incZipL5")
    public Object[][] incZipL5() {
        return new Object[][]{{PropertyLoader.loadProperty("zipN1")},
                {PropertyLoader.loadProperty("zipN2")},
                {PropertyLoader.loadProperty("zipN3")},
                {PropertyLoader.loadProperty("zipN4")},
                {PropertyLoader.loadProperty("zipL1")},
                {PropertyLoader.loadProperty("zipL2")},
                {PropertyLoader.loadProperty("zipL3")},
                {PropertyLoader.loadProperty("zipL4")},
                {PropertyLoader.loadProperty("zipM1")},
                {PropertyLoader.loadProperty("zipM2")},
                {PropertyLoader.loadProperty("zipM3")},
                {PropertyLoader.loadProperty("zipM4")}};
    }

    @DataProvider(name = "incZipL6")
    public Object[][] incZipL6() {
        return new Object[][]{{PropertyLoader.loadProperty("zipN1")},
                {PropertyLoader.loadProperty("zipN2")},
                {PropertyLoader.loadProperty("zipN3")},
                {PropertyLoader.loadProperty("zipN4")},
                {PropertyLoader.loadProperty("zipN5")},
                {PropertyLoader.loadProperty("zipL1")},
                {PropertyLoader.loadProperty("zipL2")},
                {PropertyLoader.loadProperty("zipL3")},
                {PropertyLoader.loadProperty("zipL4")},
                {PropertyLoader.loadProperty("zipL5")},
                {PropertyLoader.loadProperty("zipM1")},
                {PropertyLoader.loadProperty("zipM2")},
                {PropertyLoader.loadProperty("zipM3")},
                {PropertyLoader.loadProperty("zipM4")},
                {PropertyLoader.loadProperty("zipM5")},};
    }

    @DataProvider(name = "Zip7")
    public Object[][] zip7() {
        return new Object[][]{{PropertyLoader.loadProperty("zipN7"), PropertyLoader.loadProperty("zipN6")},
                {PropertyLoader.loadProperty("zipL7"), PropertyLoader.loadProperty("zipL6")},
                {PropertyLoader.loadProperty("zipM7"), PropertyLoader.loadProperty("zipM6")}};
    }

}
