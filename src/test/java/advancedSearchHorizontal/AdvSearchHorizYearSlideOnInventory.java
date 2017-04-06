package advancedSearchHorizontal;

import dmsInventory.Inventory;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.LogFactory;
import utility.PropertyLoader;

/**
 * Created by Julia on 03.04.2017.
 */
public class AdvSearchHorizYearSlideOnInventory extends AdvSearchTestBaseInv {

    private static final Logger LOG = LogFactory.getLogger(AdvSearchHorizYearSlideOnInventory.class);

    @Test(description = "Year on inventory page - year from should taken from URL")
    public void yearFromIsTakenFromUrl() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String yearFromChanged = searchesPage.getYearFromChanged(3);
        LOG.info("yearFromChanged is " + yearFromChanged);
        String yearToChanged = searchesPage.getYearToChanged(3);
        LOG.info("yearToChanged is " + yearToChanged);
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url") + "_yearfrom_" + yearFromChanged + "_yearto_" + yearToChanged);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearSlideFromValue(), yearFromChanged);
    }

    @Test(description = "Year on inventory page - year to should taken from URL")
    public void yearToIsTakenFromUrl() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String yearFromChanged = searchesPage.getYearFromChanged(3);
        LOG.info("yearFromChanged is " + yearFromChanged);
        String yearToChanged = searchesPage.getYearToChanged(3);
        LOG.info("yearToChanged is " + yearToChanged);
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url") + "_yearfrom_" + yearFromChanged + "_yearto_" + yearToChanged);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearSlideToValue(), yearToChanged);
    }

    @Test(description = "Year on inventory page - year from = year to - should taken from URL")
    public void equalYearsFromAreTakenFromURL() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String yearFromChanged = searchesPage.getYearFromChanged(2);
        LOG.info("yearFromChanged is " + yearFromChanged);
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url") + "_yearfrom_" + yearFromChanged + "_yearto_" + yearFromChanged);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearFromValueVisibility(), "visible");
    }

    @Test(description = "Year on inventory page - year from = year to - should taken from URL")
    public void equalYearsToAreTakenFromURL() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String yearFromChanged = searchesPage.getYearFromChanged(2);
        LOG.info("yearFromChanged is " + yearFromChanged);
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url") + "_yearfrom_" + yearFromChanged + "_yearto_" + yearFromChanged);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearToValueVisibility(), "hidden");
    }

    @Test(description = "Year on inventory page - year from = year to - should taken from URL")
    public void equalYearsProgressBarAreTakenFromURL() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String yearFromChanged = searchesPage.getYearFromChanged(2);
        LOG.info("yearFromChanged is " + yearFromChanged);
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url") + "_yearfrom_" + yearFromChanged + "_yearto_" + yearFromChanged);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearProgressBarWidth(0, 1), "0");
    }

    @Test(description = "Year on inventory page - year from = year to - should taken from URL")
    public void equalYearsAreTakenFromURL() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String yearFromChanged = searchesPage.getYearFromChanged(2);
        LOG.info("yearFromChanged is " + yearFromChanged);
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url") + "_yearfrom_" + yearFromChanged + "_yearto_" + yearFromChanged);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearSlideFromValue(), yearFromChanged);
    }

    @Test
    public void fromSliderIsEnabled() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertTrue(searchesPage.isYearSliderFromEnabled());
    }

    @Test
    public void toSliderIsEnabled() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertTrue(searchesPage.isYearSliderToEnabled());
    }

    @Test
    public void yearFromIsMinYearFromInventory() {
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
        inventory.addYearColumn();
        waitForJSandJQueryToLoad();
        String minYear = inventory.getMinYear();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearSlideFromValue(), minYear);
    }

    @Test
    public void yearToIsMaxYearFromInventory() {
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
        inventory.addYearColumn();
        waitForJSandJQueryToLoad();
        String maxYear = inventory.getMaxYear();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearSlideToValue(), maxYear);
    }

    @Test
    public void yearMinIsMinYearFromInventory() {
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
        inventory.addYearColumn();
        waitForJSandJQueryToLoad();
        String minYear = inventory.getMinYear();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveYearFromSlider(3);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearSlideMinValue(), minYear);
    }

    @Test
    public void yearMaxIsMaxYearFromInventory() {
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
        inventory.addYearColumn();
        waitForJSandJQueryToLoad();
        String maxYear = inventory.getMaxYear();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveYearToSlider(3);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearSlideMaxValue(), maxYear);
    }

    @Test
    public void yearGridFirstValueIsMinYearFromInventory() {
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
        inventory.addYearColumn();
        waitForJSandJQueryToLoad();
        String minYear = inventory.getMinYear();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearSlideGridFirstValue(), minYear);
    }

    @Test
    public void yearGridLastValueIsMaxYearFromInventory() {
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
        inventory.addYearColumn();
        waitForJSandJQueryToLoad();
        String maxYear = inventory.getMaxYear();
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearSlideGridLastValue(), maxYear);
    }

    @Test(description = "Year min value visibility is hidden by default")
    public void yearMinValueHidden() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearMinValueVisibility(), "hidden");
    }

    @Test(description = "Year min value visibility is hidden by default")
    public void yearMaxValueHidden() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearMaxValueVisibility(), "hidden");
    }

    @Test(description = "Progress bar is blue")
    public void isProgressBarBlue() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearProgressBarColor(), PropertyLoader.loadProperty("bg_color_btn"));
    }

    @Test(description = "Progress bar width is full by default (92,2636%)")
    public void yearProgressBarDefaultWidth() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearProgressBarWidth(0, 5), "92.26");
    }

    @Test(description = "Click search without selecting year - in search results should be from min to max years")
    public void clickSearchWithoutYear() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String minYear = searchesPage.getYearSlideFromValue();
        String maxYear = searchesPage.getYearSlideToValue();
        searchesPage.clickSearchBtn();
        waitForJSandJQueryToLoad();
        Assert.assertTrue(driver.getCurrentUrl().contains(("_yearfrom_") + minYear + "_yearto_" + maxYear + "_"));
    }

    @Test(description = "Slide year from - min year should be visible")
    public void yearMinValueVisible() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveYearFromSlider(3);
        Assert.assertEquals(searchesPage.getYearMinValueVisibility(), "visible");
    }

    @Test(description = "Slide year to- max year should be visible")
    public void yearMaxValueVisible() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveYearToSlider(3);
        Assert.assertEquals(searchesPage.getYearMaxValueVisibility(), "visible");
    }

    @Test(description = "Slide year from - from value should change")
    public void yearFromValueChanged() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String yearChanged = searchesPage.getYearFromChanged(3);
        searchesPage.moveYearFromSlider(3);
        Assert.assertEquals(searchesPage.getYearSlideFromValue(), yearChanged);
    }

    @Test(description = "Slide year to - to value should change")
    public void yearToValueChanged() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String yearChanged = searchesPage.getYearToChanged(3);
        searchesPage.moveYearToSlider(3);
        Assert.assertEquals(searchesPage.getYearSlideToValue(), yearChanged);
    }

    @Test(description = "Slide year from - click search - in search result should be changed year from")
    public void yearFromValueChangedInURL() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String yearChanged = searchesPage.getYearFromChanged(3);
        searchesPage.moveYearFromSlider(3);
        searchesPage.clickSearchBtn();
        waitForJSandJQueryToLoad();
        Assert.assertTrue(driver.getCurrentUrl().contains(("_yearfrom_") + yearChanged));
    }

    @Test(description = "Slide year to - click search - in search result should be changed year to")
    public void yearToValueChangedInURL() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        String yearChanged = searchesPage.getYearToChanged(3);
        searchesPage.moveYearToSlider(3);
        searchesPage.clickSearchBtn();
        waitForJSandJQueryToLoad();
        Assert.assertTrue(driver.getCurrentUrl().contains(("_yearto_") + yearChanged));
    }

    @Test(description = "Slide year from - progress bar width is changed")
    public void progressBarWidthChangedFrom() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveYearFromSlider(3);
        Assert.assertEquals(searchesPage.getYearProgressBarWidth(0, 5), "55.35");
    }

    @Test(description = "Slide year to - progress bar width is changed")
    public void progressBarWidthChangedTo() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveYearToSlider(3);
        Assert.assertEquals(searchesPage.getYearProgressBarWidth(0, 5), "55.35");
    }

    @Test(description = "Slide year from and year to on the same value - appears year primary value (yearFrom is visible) ")
    public void yearPrimaryValueAppears() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveYearFromSlider(2);
        searchesPage.moveYearToSlider(2);
        Assert.assertEquals(searchesPage.getYearFromValueVisibility(), "visible");
    }

    @Test(description = "Slide year from and year to on the same value - appears year primary value (yearTo is invisible)")
    public void yearPrimaryValueAppears2() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveYearFromSlider(2);
        searchesPage.moveYearToSlider(2);
        Assert.assertEquals(searchesPage.getYearToValueVisibility(), "hidden");
    }

    @Test(description = "Slide year from and year to on the same value - click search - year from and year to shoud be the same (ex. 2007)")
    public void yearPrimaryValueInURL() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveYearFromSlider(2);
        String yearFromValue = searchesPage.getYearSlideFromValue();
        searchesPage.moveYearToSlider(2);
        searchesPage.clickSearchBtn();
        Assert.assertTrue(driver.getCurrentUrl().contains(("_yearfrom_") + yearFromValue + "_yearto_" + yearFromValue + "_"));
    }

    @Test(description = "Slide year from and year to to be 1 year between them - appears year single value (ex. 2007-2008)")
    public void yearSingleValueAppears() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveYearFromSlider(2);
        searchesPage.moveYearToSlider2(2);
        Assert.assertEquals(searchesPage.getYearSingleValueVisibility(), "visible");
    }

    @Test(description = "Slide year from and year to to be 1 year between them - appears year single value (ex. 2007-2008)")
    public void yearSingleValue() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveYearFromSlider(2);
        String yearFromValue = searchesPage.getYearSlideFromValue();
        String yearFromValuePlus = searchesPage.getYearSlideFromValuePlus(1);
        searchesPage.moveYearToSlider2(2);
        Assert.assertEquals(searchesPage.getYearSingleValue(), yearFromValue + " — " + yearFromValuePlus);
    }


}
