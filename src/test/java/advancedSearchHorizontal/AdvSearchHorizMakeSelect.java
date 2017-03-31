package advancedSearchHorizontal;

import dmsInventory.Inventory;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.LogFactory;
import utility.PropertyLoader;

import java.util.List;

/**
 * Created by Julia on 21.03.2017.
 */
public class AdvSearchHorizMakeSelect extends AdvSearchTestBase2 {

    private static final Logger LOG = LogFactory.getLogger(AdvSearchHorizMakeSelect.class);

    @Test
    public void isMakeSelectEnabledOnHomePage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
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
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        for (int i = 1; i < searchesPage.getMakeSelectOptions().size(); i++) { //loop starts from 1, because there are differences in search and dma inventory ('Make' and 'Any Make')
            LOG.info("InvOption is " + optionMake.get(i));
            LOG.info("SearchOption is " + searchesPage.getMakeSelectOptions().get(i).getText().trim());
            Assert.assertEquals(searchesPage.getMakeSelectOptions().get(i).getText().trim(), optionMake.get(i));
        }
    }

    @Test
    public void makeValueIsInSearchResult() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        for (int i = 1; i < searchesPage.getMakeSelectOptions().size(); i++) {
            searchesPage.selectMakeByIndex(i);
            waitForJSandJQueryToLoad();
            String optionValue = searchesPage.getMakeSelectValue();
            searchesPage.clickSearchBtn();
            waitForJSandJQueryToLoad();
            Assert.assertTrue(driver.getCurrentUrl().contains("_make_" + optionValue));
            driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
            waitForJSandJQueryToLoad();
        }
    }

    @Test
    public void makeSelected() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        for (int i = 0; i < searchesPage.getMakeSelectOptions().size(); i++) {
            searchesPage.selectMakeByIndex(i);
            waitForJSandJQueryToLoad();
            LOG.info("actual is " + searchesPage.getMakeSelectText());
            LOG.info("expected is " + searchesPage.getMakeSelectOptions().get(i).getText());
            Assert.assertEquals(searchesPage.getMakeSelectText().trim(), searchesPage.getMakeSelectOptions().get(i).getText().trim());
        }
    }

    @Test
    public void selectMakeByDefault() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getMakeSelectText(), "Any Make");
    }

    @Test
    public void noMakeInSearchResult() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        searchesPage.clickSearchBtn();
        waitForJSandJQueryToLoad();
        Assert.assertFalse(driver.getCurrentUrl().contains("_make_"));
    }

    @Test
    public void clickedMakeSelectBackground() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + PropertyLoader.loadProperty("home.url"));
        waitForJSandJQueryToLoad();
        searchesPage.selectMakeByIndex(1);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getMakeSelectBorderColor(), PropertyLoader.loadProperty("border_color_gray2"));
    }
}
