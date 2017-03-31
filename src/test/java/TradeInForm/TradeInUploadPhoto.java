package TradeInForm;

import customers.LeadDetails;
import customers.Leads;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertyLoader;

import java.util.ArrayList;

/**
 * Created by Julia on 09.03.2017.
 */
public class TradeInUploadPhoto extends TradeInTestBase2 {

    private String workingDir = System.getProperty("user.dir");

    @Test
    public void isUploadButtonEnabled() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertFalse(tradeIn.isUploadBtnDisabled());
    }

    @Test
    public void isRemoveButtonDisabled() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.isRemoveBtnDisabled());
    }

    @Test
    public void uploadSuccessTextDisplayed() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        String filePath = workingDir + "/src/test/resources/images/01.jpg";
        tradeIn.addImageToTradeIn(filePath);
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.uploadSuccessTextDisplayed());
    }

    @Test
    public void isOneImageDisplayed() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        String filePath = workingDir + "/src/test/resources/images/01.jpg";
        tradeIn.addImageToTradeIn(filePath);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getUploadImagesNumber(), 1);
    }

    @Test
    public void isTwoImagesDisplayed() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/02.jpg");
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getUploadImagesNumber(), 2);
    }

    @Test
    public void isThreeImagesDisplayed() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/02.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/03.jpg");
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getUploadImagesNumber(), 3);
    }

    @Test
    public void addFourImages() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/02.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/03.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/04.jpg");
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getUploadImagesNumber(), 3);
    }

    @Test
    public void addOneImageUploadBtnEnabled() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        Assert.assertFalse(tradeIn.isUploadBtnDisabled());
    }

    @Test
    public void addTwoImagesUploadBtnEnabled() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/02.jpg");
        waitForJSandJQueryToLoad();
        Assert.assertFalse(tradeIn.isUploadBtnDisabled());
    }

    @Test
    public void addThreeImagesUploadBtnDisabled() throws InterruptedException {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/02.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/03.jpg");
        waitForJSandJQueryToLoad();
        Thread.sleep(2000);
        Assert.assertTrue(tradeIn.isUploadBtnDisabled());
    }

    @Test
    public void removeBtnIsDisabledIfAddOneImage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.isRemoveBtnDisabled());
    }

    @Test
    public void removeBtnIsEnabledIfClickOneFromOneImage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(0);
        waitForJSandJQueryToLoad();
        Assert.assertFalse(tradeIn.isRemoveBtnDisabled());
    }

    @Test
    public void removeBtnIsEnabledIfClickOneFromTwoImage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(0);
        waitForJSandJQueryToLoad();
        Assert.assertFalse(tradeIn.isRemoveBtnDisabled());
    }


    @Test
    public void removeBtnIsEnabledIfClickTwoFromTwoImages() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/02.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(0);
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(1);
        waitForJSandJQueryToLoad();
        Assert.assertFalse(tradeIn.isRemoveBtnDisabled());
    }


    @Test
    public void removeBtnIsEnabledIfClickOneFromThreeImage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/02.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/03.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(1);
        waitForJSandJQueryToLoad();
        Assert.assertFalse(tradeIn.isRemoveBtnDisabled());
    }


    @Test
    public void removeBtnIsEnabledIfClickTwoFromThreeImage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/02.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/03.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(0);
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(1);
        waitForJSandJQueryToLoad();
        Assert.assertFalse(tradeIn.isRemoveBtnDisabled());
    }


    @Test
    public void removeBtnIsEnabledIfClickThreeFromThreeImage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/02.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/03.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(0);
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(1);
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(2);
        waitForJSandJQueryToLoad();
        Assert.assertFalse(tradeIn.isRemoveBtnDisabled());
    }

    @Test
    public void uploadBtnHasIcon() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.isTradeInUploadBtnIconDisplayed());
    }

    @Test
    public void removeBtnHasIcon() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        Assert.assertTrue(tradeIn.isTradeInRemoveBtnIconDisplayed());
    }

    @Test
    public void addImageTwoTimes() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getUploadImagesNumber(), 1);
    }

    @Test
    public void removeOneFromOneImage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(0);
        waitForJSandJQueryToLoad();
        tradeIn.clickRemoveBtn();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getUploadImagesNumber(), 0);
    }

    @Test
    public void removeOneFromTwoImages() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/02.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(0);
        waitForJSandJQueryToLoad();
        tradeIn.clickRemoveBtn();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getUploadImagesNumber(), 1);
    }

    @Test
    public void removeTwoFromTwoImages() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/02.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(0);
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(1);
        waitForJSandJQueryToLoad();
        tradeIn.clickRemoveBtn();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getUploadImagesNumber(), 0);
    }

    @Test
    public void removeOneFromThreeImages() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/02.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/03.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(0);
        waitForJSandJQueryToLoad();
        tradeIn.clickRemoveBtn();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getUploadImagesNumber(), 2);
    }

    @Test
    public void removeTwoFromThreeImages() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/02.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/03.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(0);
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(1);
        waitForJSandJQueryToLoad();
        tradeIn.clickRemoveBtn();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getUploadImagesNumber(), 1);
    }

    @Test
    public void removeThreeFromThreeImages() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/02.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/03.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(0);
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(1);
        waitForJSandJQueryToLoad();
        tradeIn.tradeInClickOnImage(2);
        waitForJSandJQueryToLoad();
        tradeIn.clickRemoveBtn();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getUploadImagesNumber(), 0);
    }

    @Test
    public void oneImageInLead() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        wait.until(isLeadsListVisible());
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getUserImageNumber(), 1);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test
    public void twoImagesInLead() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/02.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        wait.until(isLeadsListVisible());
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getUserImageNumber(), 2);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test
    public void threeImagesInLead() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/02.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/03.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        wait.until(isLeadsListVisible());
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getUserImageNumber(), 3);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test
    public void noImagesInLead() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        wait.until(isLeadsListVisible());
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(leadDetails.getUserImageNumber(), 0);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test
    public void noUserImagePartInLead() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.fillFirstName();
        tradeIn.fillLastName();
        tradeIn.fillPhoneNum();
        tradeIn.fillEmail();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        wait.until(isPostFormVisible());
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Leads leads = dmsHome2.clickOnLeadsMenu();
        waitForJSandJQueryToLoad();
        wait.until(isLeadsListVisible());
        LeadDetails leadDetails = leads.openFirstLead();
        waitForJSandJQueryToLoad();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles()); //switch between tabs
        driver.switchTo().window(tabs2.get(1));
        waitForJSandJQueryToLoad();
        Assert.assertFalse(leadDetails.isUserImageTitleExist());
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        waitForJSandJQueryToLoad();
        leads.removeFirstLead();
        waitForJSandJQueryToLoad();
    }

    @Test
    public void imageExistIfSubmitWithoutRequiredFields() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("tradein.url"));
        waitForJSandJQueryToLoad();
        tradeIn.addImageToTradeIn(workingDir + "/src/test/resources/images/01.jpg");
        waitForJSandJQueryToLoad();
        tradeIn.clickOnTradeInSubmit();
        waitForJSandJQueryToLoad();
        Assert.assertEquals(tradeIn.getUploadImagesNumber(), 1);
    }
}
