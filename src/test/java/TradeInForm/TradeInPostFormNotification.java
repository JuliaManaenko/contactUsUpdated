package TradeInForm;

import dwsPages.FormsPage;
import map2.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 14.02.2017.
 */
public class TradeInPostFormNotification extends TradeInTestBase2 {

    @AfterMethod
    public void deletePageFromMAP2() {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome21 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        MAP2 map21 = dmsHome21.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        map21.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        wait.until(getConditionForTitle());
        map21.deletePage();
        waitForJSandJQueryToLoad();
        wait.until(isPageDeletedTooltipVisible());
    }

    @Test
    public void checkPostFormDefaultText() throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dmsHome = PageFactory.initElements(driver, dms.dmsHome.class);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        map2.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        wait.until(isAddPageVisible());
        map2PageEditor mapEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        mapEditor.addTradeInWidget();
        waitForJSandJQueryToLoad();
        mapEditor.activatePage();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        wait.until(isPageActivatedTooltipVisible());
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(3000);
        Assert.assertEquals(tradeIn.postFormGetText(), "Your request has been received.\n" +
                "A customer service representative will contact you shortly to complete the transaction.\n" +
                "\n" +
                "Thank you for using tacker1 service.\n" +
                "\n" +
                "OK");
    }

    @Test
    public void changeTextInSettings() throws InterruptedException {
        wait = new WebDriverWait(driver, 20);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        map2.clickTradeInTab();
        waitForJSandJQueryToLoad();
        Thread.sleep(500);
        map2PageEditor editor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        Thread.sleep(500);
        editor.addTradeInWidget();
        waitForJSandJQueryToLoad();
        Thread.sleep(500);
        ContactUsWidgetSettings settings = editor.openWidgetSettings();
        waitForJSandJQueryToLoad();
        Thread.sleep(500);
        HTMLEditor htmlEditor = settings.openHtmlEditor();
        waitForJSandJQueryToLoad();
        Thread.sleep(500);
        htmlEditor.addText();
        Thread.sleep(500);
        ContactUsWidgetSettings settings2 = htmlEditor.clickEditorOk();
        waitForJSandJQueryToLoad();
        Thread.sleep(500);
        map2PageEditor editor2 = settings2.clickOK();
        waitForJSandJQueryToLoad();
        Thread.sleep(500);
        editor2.activatePage();
        waitForJSandJQueryToLoad();
        Thread.sleep(500);
        PreviewPage previewPage = editor2.clickOnPreview();
        waitForJSandJQueryToLoad();
        Thread.sleep(500);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        FormsPage tradeIn2 = previewPage.clickOnVisitWebsite();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs3.get(2));
        tradeIn2.fillFirstName();
        tradeIn2.fillLastName();
        tradeIn2.fillPhoneNum();
        tradeIn2.fillEmail();
        tradeIn2.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Thread.sleep(500);
        Assert.assertEquals(tradeIn2.postFormGetText(), PropertyLoader.loadProperty("text50") + "\n" + "OK");
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs3.get(1));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs3.get(0));
        Thread.sleep(1000);
    }

    @Test
    public void clearFormAppearIfClickOK() {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dmsHome = PageFactory.initElements(driver, dms.dmsHome.class);
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        map2.clickTradeInTab();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        wait.until(isAddPageVisible());
        map2PageEditor mapEditor = map2.clickAddPage();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        mapEditor.addTradeInWidget();
        waitForJSandJQueryToLoad();
        mapEditor.activatePage();
        waitForJSandJQueryToLoad();
        wait.until(isLoadingInvisible());
        wait.until(isPageActivatedTooltipVisible());
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        tradeIn.clickOKinPostForm();
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.isTradeInFormInWidgetDisplayed());
        Assert.assertEquals(tradeIn.firstNameGetValue(), "");
        Assert.assertEquals(tradeIn.lastNameGetValue(), "");
        Assert.assertEquals(tradeIn.phoneNumGetValue(), "");
        Assert.assertEquals(tradeIn.emailGetValue(), "");
        Assert.assertEquals(tradeIn.intPhoneGetValue(), "");
        Assert.assertEquals(tradeIn.vinGetValue(), "");
        Assert.assertEquals(tradeIn.askingPriceGetValue(), "");
        Assert.assertEquals(tradeIn.odometerGetValue(), "");
        Assert.assertEquals(tradeIn.askingPriceGetValue(), "");
        Assert.assertEquals(tradeIn.getMakeSelectValue(), "Select Make");
        Assert.assertEquals(tradeIn.getModelSelectValue(), "Select Model");
        Assert.assertEquals(tradeIn.getTrimSelectValue(), "Select Trim");
        Assert.assertEquals(tradeIn.getMotorizedTypeSelectValue(), "Select Motorized Type");
        Assert.assertEquals(tradeIn.getYearSelectValue(), "Select Year");
        Assert.assertEquals(tradeIn.commentsGetValue(), "");
        Assert.assertEquals(tradeIn.getUploadImagesNumber(), 0);
    }
}
