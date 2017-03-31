package advancedSearchHorizontal;

import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.LogFactory;
import utility.PropertyLoader;

/**
 * Created by Julia on 29.03.2017.
 */
public class AdvSearchHorizYearSlide extends AdvSearchTestBase2 {

    private static final Logger LOG = LogFactory.getLogger(AdvSearchHorizYearSlide.class);

   /* @Test
    public void fromSliderIsEnabled() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        Assert.assertTrue(searchesPage.isYearSliderFromEnabled());
    }

    @Test
    public void toSliderIsEnabled() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
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
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
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
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
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
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveYearFromSlider();
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
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        searchesPage.moveYearToSlider();
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
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
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
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearSlideGridLastValue(), maxYear);
    }

    @Test(description = "Year min value visibility is hidden by default")
    public void yearMinValueHidden() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getMinValueVisibility(), "hidden");
    }

    @Test(description = "Year min value visibility is hidden by default")
    public void yearMaxValueHidden() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getMaxValueVisibility(), "hidden");
    }

    @Test(description = "Progress bar is blue")
    public void isProgressBarBlue() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearProgressBarColor(), PropertyLoader.loadProperty("bg_color_btn"));
    }

    @Test(description = "Progress bar width is full by default (92,2636%)")
    public void yearProgressBarDefaultWidth() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getYearProgressBarWidth(), "92.26");
    }*/

    @Test(description = "Click search without selecting year - in search results should be from min to max years")
    public void clickSearchWithoutYear() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        String minYear = searchesPage.getYearSlideFromValue();
        String maxYear = searchesPage.getYearSlideToValue();
        searchesPage.clickSearchBtn();
        waitForJSandJQueryToLoad();
        Assert.assertTrue(driver.getCurrentUrl().contains(("_yearfrom_") + minYear + "_yearto_" + maxYear + "_"));
    }
}
