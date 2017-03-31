package advancedSearchHorizontal;

import dmsInventory.Inventory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertyLoader;

import java.util.List;

/**
 * Created by Julia on 24.03.2017.
 */
public class AdvSearchModelOnCustom extends AdvSearchTestBaseCustom {

    @Test
    public void isModelSelectDisabledOnCustomPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        Assert.assertFalse(searchesPage.isModelSelectEnabled());
    }

    @Test
    public void modelsAreTheSameWithInventory() {
        driver.manage().deleteAllCookies();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = dmsHome.loginToDms();
        waitForJSandJQueryToLoad();
        wait.until(isHomeBreadcrumbsVisible());
        Inventory inventory = dmsHome2.clickOnInventoryMenu();
        waitForJSandJQueryToLoad();
        List<String> optionModel = inventory.getModelSelectOptionsText();
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        int k = 0;
        for (int i = 1; i < searchesPage.getMakeSelectOptions().size(); i++) { //loop starts from 1, because there are differences in search and dma inventory ('Make' and 'Any Make')
            searchesPage.selectMakeByIndex(i);
            waitForJSandJQueryToLoad();
            for (int j = 1; j < searchesPage.getModelSelectOptions().size(); j++) {
                Assert.assertEquals(searchesPage.getModelSelectOptions().get(j).getText().trim(), optionModel.get(k));
                k = k + 1;
            }
        }
    }

    @Test
    public void modelValueIsInSearchResult() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        for (int i = 1; i < searchesPage.getMakeSelectOptions().size(); i++) {
            searchesPage.selectMakeByIndex(i);
            waitForJSandJQueryToLoad();
            searchesPage.selectModelByIndex(1);
            waitForJSandJQueryToLoad();
            String optionValue = searchesPage.getModelSelectValue();
            searchesPage.clickSearchBtn();
            waitForJSandJQueryToLoad();
            Assert.assertTrue(driver.getCurrentUrl().contains("_model_" + optionValue));
            driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
            waitForJSandJQueryToLoad();
        }
    }

    @Test
    public void modelSelected() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        for (int i = 1; i < searchesPage.getMakeSelectOptions().size(); i++) {
            searchesPage.selectMakeByIndex(i);
            waitForJSandJQueryToLoad();
            searchesPage.selectModelByIndex(1);
            waitForJSandJQueryToLoad();
            Assert.assertEquals(searchesPage.getModelSelectText().trim(), searchesPage.getModelSelectOptions().get(1).getText().trim());
        }
    }

    @Test
    public void selectModelByDefault() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        searchesPage.selectMakeByIndex(1);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getModelSelectText(), "Any Model");
    }

    @Test
    public void noModelInSearchResult() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        searchesPage.selectMakeByIndex(1);
        waitForJSandJQueryToLoad();
        searchesPage.clickSearchBtn();
        waitForJSandJQueryToLoad();
        Assert.assertFalse(driver.getCurrentUrl().contains("_model_"));
    }

    @Test
    public void clickedModelSelectBackground() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        searchesPage.selectMakeByIndex(1);
        waitForJSandJQueryToLoad();
        searchesPage.selectModelByIndex(1);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getModelSelectBorderColor(), PropertyLoader.loadProperty("border_color_gray2"));
    }

    @Test
    public void modelIsEnabledIfSelectMake() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        searchesPage.selectMakeByIndex(1);
        waitForJSandJQueryToLoad();
        Assert.assertTrue(searchesPage.isModelSelectEnabled());
    }

    @Test
    public void advSearchHorizModelSelectDisplayed() {
        Assert.assertTrue(searchesPage.isModelSelectExists());
    }

    @Test
    public void advSearchHorizModelLabelDisplayed() {
        Assert.assertTrue(searchesPage.isModelSelectLabelExists());
    }
}
