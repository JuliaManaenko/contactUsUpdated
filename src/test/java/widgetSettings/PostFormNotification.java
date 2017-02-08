package widgetSettings;

import contactUsPage.ContactUs;
import map2.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcase.TestBase2;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 26.01.2017.
 */
public class PostFormNotification extends TestBase2 {

    @Test(priority = 1)
    public void checkPostFormDefaultText() throws InterruptedException {
        contactUs.fillFirstName();
        contactUs.fillLastName();
        contactUs.fillPhoneNum();
        contactUs.fillEmail();
        contactUs.fillZip();
        contactUs.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(3000);
        Assert.assertEquals(contactUs.postFormGetText(), "Your request has been received.\n" +
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
        wait.until(jsLoad);
        MAP2 map2 = dmsHome2.clickOnMap2Menu();
        wait.until(jsLoad);
        map2.clickContactTab();
        Thread.sleep(2000);
        ContactEditor editor = map2.clickAddPage();
        Thread.sleep(2000);
        editor.addWidget();
        Thread.sleep(500);
        ContactUsWidgetSettings settings = editor.openWidgetSettings();
        Thread.sleep(2000);
        HTMLEditor htmlEditor = settings.openHtmlEditor();
        Thread.sleep(2000);
        htmlEditor.addText();
        Thread.sleep(2000);
        ContactUsWidgetSettings settings2 = htmlEditor.clickEditorOk();
        Thread.sleep(2000);
        ContactEditor editor2 = settings2.clickOK();
        Thread.sleep(2000);
        editor2.activatePage();
        Thread.sleep(2000);
        PreviewPage previewPage = editor2.clickOnPreview();
        wait.until(jsLoad);
        Thread.sleep(2000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        ContactUs contactUs2 = previewPage.clickOnVisitWebsite();
        wait.until(jsLoad);
        ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs3.get(2));
        contactUs2.fillFirstName();
        contactUs2.fillLastName();
        contactUs2.fillPhoneNum();
        contactUs2.fillEmail();
        contactUs2.fillZip();
        contactUs2.clickOnSubmit();
        wait.until(jsLoad);
        Thread.sleep(3000);
        Assert.assertEquals(contactUs2.postFormGetText(), PropertyLoader.loadProperty("text50")+ "\n" + "OK");
        Thread.sleep(3000);
        driver.get(PropertyLoader.loadProperty("dms.url"));
        dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        wait.until(jsLoad);
        MAP2 map21 = dmsHome2.clickOnMap2Menu();
        wait.until(jsLoad);
        map21.clickContactTab();
        Thread.sleep(3000);
        map21.deletePage();
        Thread.sleep(1000);
    }
}
