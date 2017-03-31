package advancedSearchHorizontal;

import dmsInventory.Inventory;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.LogFactory;
import utility.PropertyLoader;

import java.util.List;

/**
 * Created by Julia on 23.03.2017.
 */
public class AdvSearchHorizMakeSelectOnCustom extends AdvSearchTestBaseCustom {

    private static final Logger LOG = LogFactory.getLogger(AdvSearchHorizMakeSelectOnCustom.class);

    @Test
    public void isMakeSelectEnabledOnCustomPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        Assert.assertTrue(searchesPage.isMakeSelectEnabled());
    }

    @Test
    public void makesAreTheSameWithInventory() {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Inventory inventory = dmsHome2.clickOnInventoryMenu();
        waitForJSandJQueryToLoad();
        List<String> optionMake = inventory.getMakeSelectOptionsText();
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        for (int i = 1; i < searchesPage.getMakeSelectOptions().size(); i++) { //loop starts from 1, because there are differences in search and dma inventory ('Make' and 'Any Make')
            Assert.assertEquals(searchesPage.getMakeSelectOptions().get(i).getText().trim(), optionMake.get(i));
        }
    }

    @Test
    public void selectMakeByDefault() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getMakeSelectText(), "Any Make");
    }

    @Test
    public void advSearchHorizMakeSelectDisplayed() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        Assert.assertTrue(searchesPage.isMakeSelectExists());
    }

    @Test
    public void advSearchHorizMakeLabelDisplayed() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        Assert.assertTrue(searchesPage.isMakeSelectLabelExists());
    }

    @Test
    public void makeValueIsInSearchResult() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        for (int i = 1; i < searchesPage.getMakeSelectOptions().size(); i++) {
            searchesPage.selectMakeByIndex(i);
            waitForJSandJQueryToLoad();
            String optionValue = searchesPage.getMakeSelectValue();
            searchesPage.clickSearchBtn();
            waitForJSandJQueryToLoad();
            Assert.assertTrue(driver.getCurrentUrl().contains("_make_" + optionValue));
            driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
            waitForJSandJQueryToLoad();
        }
    }

    @Test
    public void noMakeInSearchResult() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        searchesPage.clickSearchBtn();
        waitForJSandJQueryToLoad();
        Assert.assertFalse(driver.getCurrentUrl().contains("_make_"));
    }
}
