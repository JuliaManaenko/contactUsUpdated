package TradeInForm;

import contactUsPage.ContactUs;
import map2.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcase.TestBase2;
import testcase.TradeInTestBase2;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 14.02.2017.
 */
public class TradeInPostFormNotification extends TradeInTestBase2{

    @Test(priority = 1)
    public void checkPostFormDefaultText() throws InterruptedException {
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

    @Test(priority = 2)
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
        ContactEditor editor = map2.clickAddPage();
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
        ContactEditor editor2 = settings2.clickOK();
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
        ContactUs tradeIn2 = previewPage.clickOnVisitWebsite();
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
        Assert.assertEquals(tradeIn2.postFormGetText(), PropertyLoader.loadProperty("text50")+ "\n" + "OK");
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs3.get(1));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(tabs3.get(0));
        Thread.sleep(1000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        waitForJSandJQueryToLoad();
        MAP2 map21 = dmsHome2.clickOnMap2Menu();
        waitForJSandJQueryToLoad();
        map21.clickTradeInTab();
        waitForJSandJQueryToLoad();
        Thread.sleep(500);
        map21.deletePage();
        Thread.sleep(1000);
    }
}
