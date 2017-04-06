package advancedSearchHorizontal;

import dmsInventory.Inventory;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.LogFactory;
import utility.PropertyLoader;

/**
 * Created by Julia on 06.04.2017.
 */
public class AdvSearchHorizOdometerSlideOnInventory extends AdvSearchTestBaseInv {

    private static final Logger LOG = LogFactory.getLogger(AdvSearchHorizOdometerSlideOnInventory.class);

    @Test(description = "from slider is enabled by default")
    public void fromSliderIsEnabled() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertTrue(searchesPage.isOdometerSliderFromEnabled());
    }

    @Test(description = "to slider is enabled by default")
    public void toSliderIsEnabled() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertTrue(searchesPage.isOdometerSliderToEnabled());
    }

    @Test(description = "from odometer equals the min odometer value from dms inventory")
    public void odoFromIsMinOdoFromInventory() {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Inventory inventory = dmsHome2.clickOnInventoryMenu();
        waitForJSandJQueryToLoad();
        inventory.clickInventoryRadioBtn();
        waitForJSandJQueryToLoad();
        inventory.addOdometerColumn();
        waitForJSandJQueryToLoad();
        String minOdometer = inventory.getMinOdometerWithoutSpace();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getOdometerSlideFromValueWithoutSpace(), minOdometer);
    }

    @Test(description = "to odometer equals the max odometer value from dms inventory")
    public void odoToIsMaxOdoFromInventory() {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Inventory inventory = dmsHome2.clickOnInventoryMenu();
        waitForJSandJQueryToLoad();
        inventory.clickInventoryRadioBtn();
        waitForJSandJQueryToLoad();
        inventory.addOdometerColumn();
        waitForJSandJQueryToLoad();
        String maxOdometer = inventory.getMaxOdometerWithoutSpace();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getOdometerSlideToValueWithoutSpace(), maxOdometer);
    }

    @Test(description = "min odometer equals the min odometer value from dms inventory")
    public void odoMinIsMinOdoFromInventory() {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Inventory inventory = dmsHome2.clickOnInventoryMenu();
        waitForJSandJQueryToLoad();
        inventory.clickInventoryRadioBtn();
        waitForJSandJQueryToLoad();
        inventory.addOdometerColumn();
        waitForJSandJQueryToLoad();
        String minOdometer = inventory.getMinOdometerWithoutSpace();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveOdometerFromSlider(3);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getOdometerSlideMinValueWithoutSpace(), minOdometer);
    }

    @Test(description = "max odometer equals the max odometer value from dms inventory")
    public void odoMaxIsMaxOdoFromInventory() {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Inventory inventory = dmsHome2.clickOnInventoryMenu();
        waitForJSandJQueryToLoad();
        inventory.clickInventoryRadioBtn();
        waitForJSandJQueryToLoad();
        inventory.addOdometerColumn();
        waitForJSandJQueryToLoad();
        String maxOdometer = inventory.getMaxOdometerWithoutSpace();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveOdometerToSlider(3);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getOdometerSlideMaxValueWithoutSpace(), maxOdometer);
    }

    @Test(description = "grid first value equals the min odometer value from dms inventory")
    public void odoGridFirstValueIsMinOdoFromInventory() {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Inventory inventory = dmsHome2.clickOnInventoryMenu();
        waitForJSandJQueryToLoad();
        inventory.clickInventoryRadioBtn();
        waitForJSandJQueryToLoad();
        inventory.addOdometerColumn();
        waitForJSandJQueryToLoad();
        String minOdometer = inventory.getMinOdometerWithoutSpace();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getOdometerSlideGridFirstValueWithoutSpace(), minOdometer);
    }

    @Test(description = "grid last value equals the max odometer value from dms inventory")
    public void odoGridLastValueIsMaxOdoFromInventory() {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Inventory inventory = dmsHome2.clickOnInventoryMenu();
        waitForJSandJQueryToLoad();
        inventory.clickInventoryRadioBtn();
        waitForJSandJQueryToLoad();
        inventory.addOdometerColumn();
        waitForJSandJQueryToLoad();
        String maxOdometer = inventory.getMaxOdometerWithoutSpace();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getOdometerSlideGridLastValueWithoutSpace(), maxOdometer);
    }

    @Test(description = "Odometer min value visibility is hidden by default")
    public void odometerMinValueHidden() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getOdometerMinValueVisibility(), "hidden");
    }

    @Test(description = "Odometer min value visibility is hidden by default")
    public void odometerMaxValueHidden() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getOdometerMaxValueVisibility(), "hidden");
    }

    @Test(description = "Progress bar is blue")
    public void isProgressBarBlue() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getOdometerProgressBarColor(), PropertyLoader.loadProperty("bg_color_btn"));
    }

    @Test(description = "Progress bar width is full by default (92,2636%)")
    public void odometerProgressBarDefaultWidth() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getOdometerProgressBarWidth(0, 5), "92.26");
    }

    @Test(description = "Click search without selecting odometer - in search results should be from min to max odometers")
    public void clickSearchWithoutOdometer() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String minOdometer = searchesPage.getOdometerSlideFromValueWithoutSpace();
        LOG.info("minOdometer is " + minOdometer);
        String maxOdometer = searchesPage.getOdometerSlideToValueWithoutSpace();
        LOG.info("maxOdometer is " + maxOdometer);
        searchesPage.clickSearchBtn();
        waitForJSandJQueryToLoad();
        Assert.assertTrue(driver.getCurrentUrl().contains(("_mileagefrom_") + minOdometer + "_mileageto_" + maxOdometer + "_"));
    }

    @Test(description = "Slide odometer from - min odometer should be visible")
    public void odometerMinValueVisible() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveOdometerFromSlider(3);
        Assert.assertEquals(searchesPage.getOdometerMinValueVisibility(), "visible");
    }

    @Test(description = "Slide odometer to - max odometer should be visible")
    public void odometerMaxValueVisible() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveOdometerToSlider(3);
        Assert.assertEquals(searchesPage.getOdometerMaxValueVisibility(), "visible");
    }

    //TODO: actual and expected results are different
   /* @Test(description = "Slide odometer from - from value should change")
    public void odometerFromValueChanged() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String odometerChanged = searchesPage.getOdometerFromChanged(3);
        searchesPage.moveOdometerFromSlider(3);
        Assert.assertEquals(searchesPage.getOdometerSlideFromValue(), odometerChanged);
    }*/

    //TODO: odometerChanged is different from actual
    /*@Test(description = "Slide odometer to - to value should change")
    public void odometerToValueChanged() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String odometerChanged = searchesPage.getOdometerToChanged(3);
        searchesPage.moveOdometerToSlider(3);
        Assert.assertEquals(searchesPage.getOdometerSlideToValue(), odometerChanged);
    }*/

    //TODO: odometerChanged is different from actual
   /* @Test(description = "Slide odometer from - click search - in search result should be changed odometer from")
    public void odometerFromValueChangedInURL() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String odometerChanged = searchesPage.getOdometerFromChanged(3);
        searchesPage.moveOdometerFromSlider(3);
        searchesPage.clickSearchBtn();
        waitForJSandJQueryToLoad();
        Assert.assertTrue(driver.getCurrentUrl().contains(("_mileagefrom_") + odometerChanged));
    }*/

    //TODO: odometerChaged is different from actual
   /* @Test(description = "Slide odometer to - click search - in search result should be changed odometer to")
    public void odometerToValueChangedInURL() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String odometerChanged = searchesPage.getOdometerToChanged(3);
        searchesPage.moveOdometerToSlider(3);
        searchesPage.clickSearchBtn();
        waitForJSandJQueryToLoad();
        Assert.assertTrue(driver.getCurrentUrl().contains(("_mileageto_") + odometerChanged));
    }*/

    @Test(description = "Slide odometer from - progress bar width is changed")
    public void progressBarWidthChangedFrom() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveOdometerFromSlider(3);
        Assert.assertEquals(searchesPage.getOdometerProgressBarWidth(0, 5), "59.96");
    }

    @Test(description = "Slide odometer to - progress bar width is changed")
    public void progressBarWidthChangedTo() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveOdometerToSlider(3);
        Assert.assertEquals(searchesPage.getOdometerProgressBarWidth(0, 5), "59.96");
    }

    @Test(description = "Slide odometer from and odometer to on the same value - appears odometer primary value (odometerFrom is visible) ")
    public void yearPrimaryValueAppears() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveOdometerFromSlider(2);
        searchesPage.moveOdometerToSlider(2);
        Assert.assertEquals(searchesPage.getOdometerFromValueVisibility(), "visible");
    }

    @Test(description = "Slide odometer from and odometer to on the same value - appears odometer primary value (odometerTo is invisible)")
    public void odometerPrimaryValueAppears2() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveOdometerFromSlider(2);
        searchesPage.moveOdometerToSlider(2);
        Assert.assertEquals(searchesPage.getOdometerToValueVisibility(), "hidden");
    }

    @Test(description = "Slide odometer from and odometer to on the same value - click search - odometer from and odometer to should be the same (ex. 20000)")
    public void odometerPrimaryValueInURL() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveOdometerFromSlider(2);
        String odometerFromValue = searchesPage.getOdometerSlideFromValueWithoutSpace();
        LOG.info("odometerFromValue is " + odometerFromValue);
        searchesPage.moveOdometerToSlider(2);
        searchesPage.clickSearchBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains(("_mileagefrom_") + odometerFromValue + "_mileageto_" + odometerFromValue + "_"));
    }

    //TODO:
    /*@Test(description = "Slide odometer from and odometer to to be 1 year between them - appears year single value (ex. 2007-2008)")
    public void yearSingleValueAppears() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveYearFromSlider(2);
        searchesPage.moveYearToSlider2(2);
        Assert.assertEquals(searchesPage.getYearSingleValueVisibility(), "visible");
    }

//TODO:
    @Test(description = "Slide year from and year to to be 1 year between them - appears year single value (ex. 2007-2008)")
    public void yearSingleValue() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveYearFromSlider(2);
        String yearFromValue = searchesPage.getYearSlideFromValue();
        String yearFromValuePlus = searchesPage.getYearSlideFromValuePlus(1);
        searchesPage.moveYearToSlider2(2);
        Assert.assertEquals(searchesPage.getYearSingleValue(), yearFromValue + " — " + yearFromValuePlus);
    }*/

    @Test(description = "Slide odometer from and odometer to on the same value - progress bar width is 0")
    public void odometerPrimaryProgressBar() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveOdometerFromSlider(2);
        searchesPage.moveOdometerToSlider(2);
        Assert.assertEquals(searchesPage.getOdometerProgressBarWidth(0, 1), "0");
    }

    @Test(description = "Odometer on inventory page - odometer from should taken from URL")
    public void yearFromIsTakenFromUrl() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String odometerFromChanged = searchesPage.getOdometerFromChanged(3);
        LOG.info("odometerFromChanged is " + odometerFromChanged);
        String odometerToChanged = searchesPage.getOdometerToChanged(3);
        LOG.info("odometerToChanged is " + odometerToChanged);
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url") + "_mileagefrom_" + odometerFromChanged + "_mileageto_" + odometerToChanged);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getOdometerSlideFromValueWithoutSpace(), odometerFromChanged);
    }

    @Test(description = "Odometer on inventory page - odometer to should taken from URL")
    public void yearToIsTakenFromUrl() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String odometerFromChanged = searchesPage.getOdometerFromChanged(3);
        LOG.info("odometerFromChanged is " + odometerFromChanged);
        String odometerToChanged = searchesPage.getOdometerToChanged(3);
        LOG.info("odometerToChanged is " + odometerToChanged);
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url") + "_mileagefrom_" + odometerFromChanged + "_mileageto_" + odometerToChanged);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getOdometerSlideToValueWithoutSpace(), odometerToChanged);
    }

    @Test(description = "Odometer on inventory page - odometer from = odometer to - should taken from URL")
    public void equalOdometersFromAreTakenFromURL() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String odometerFromChanged = searchesPage.getOdometerFromChanged(2);
        LOG.info("odometerFromChanged is " + odometerFromChanged);
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url") + "_mileagefrom_" + odometerFromChanged + "_mileageto_" + odometerFromChanged);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getOdometerFromValueVisibility(), "visible");
    }
}
