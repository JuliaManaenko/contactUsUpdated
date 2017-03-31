package advancedSearchHorizontal;

import dmsInventory.Inventory;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.LogFactory;
import utility.PropertyLoader;

import java.util.List;

/**
 * Created by Julia on 22.03.2017.
 */
public class AdvSearchHorizMakeSelectOnInventory extends AdvSearchTestBaseInv {

    private static final Logger LOG = LogFactory.getLogger(AdvSearchHorizMakeSelectOnInventory.class);

    @Test
    public void isMakeSelectEnabledOnInventoryPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
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
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        for (int i = 1; i < searchesPage.getMakeSelectOptions().size(); i++) { //loop starts from 1, because there are differences in search and dma inventory ('Make' and 'Any Make')
            Assert.assertEquals(searchesPage.getMakeSelectOptions().get(i).getText().trim(), optionMake.get(i));
        }
    }

    @Test
    public void selectMakeByDefault() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getMakeSelectText(), "Any Make");
    }

    @Test
    public void makeIsFromURL() {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Inventory inventory = dmsHome2.clickOnInventoryMenu();
        waitForJSandJQueryToLoad();
        List<WebElement> optionMake = inventory.getMakeSelectOptions();
        List<String> optionMakeValue = inventory.getMakeSelectOptionsValue();
        for (int i = 1; i < optionMake.size(); i++) {
            driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url") + "_make_" + optionMakeValue.get(i));
            waitForJSandJQueryToLoad();
            LOG.info("make in URL is " + optionMakeValue.get(i));
            Assert.assertEquals(searchesPage.getMakeSelectValue(), optionMakeValue.get(i));
        }
    }

    @Test
    public void advSearchHorizMakeSelectDisplayed() {
        Assert.assertTrue(searchesPage.isMakeSelectExists());
    }

    @Test
    public void advSearchHorizMakeLabelDisplayed() {
        Assert.assertTrue(searchesPage.isMakeSelectLabelExists());
    }

    @Test
    public void makeValueIsInSearchResult() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        for (int i = 1; i < searchesPage.getMakeSelectOptions().size(); i++) {
            searchesPage.selectMakeByIndex(i);
            waitForJSandJQueryToLoad();
            String optionValue = searchesPage.getMakeSelectValue();
            searchesPage.clickSearchBtn();
            waitForJSandJQueryToLoad();
            Assert.assertTrue(driver.getCurrentUrl().contains("_make_" + optionValue));
            driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
            waitForJSandJQueryToLoad();
        }
    }

    @Test
    public void noMakeInSearchResult() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("inventory.url"));
        waitForJSandJQueryToLoad();
        searchesPage.clickSearchBtn();
        waitForJSandJQueryToLoad();
        Assert.assertFalse(driver.getCurrentUrl().contains("_make_"));
    }


}
