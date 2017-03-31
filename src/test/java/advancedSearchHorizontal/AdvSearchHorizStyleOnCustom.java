package advancedSearchHorizontal;

import dmsInventory.Inventory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertyLoader;

import java.util.List;

/**
 * Created by Julia on 29.03.2017.
 */
public class AdvSearchHorizStyleOnCustom extends AdvSearchTestBaseCustom {

    @Test
    public void isStyleSelectEnabledOnInvPage() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        Assert.assertTrue(searchesPage.isStyleSelectEnabled());
    }

    @Test
    public void selectStyleByDefault() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getStyleSelectText(), "Any Style");
    }

    @Test
    public void styleSelected() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        for (int i = 0; i < searchesPage.getStyleSelectOptions().size(); i++) {
            searchesPage.selectStyleByIndex(i);
            waitForJSandJQueryToLoad();
            Assert.assertEquals(searchesPage.getStyleSelectText().trim(), searchesPage.getStyleSelectOptions().get(i).getText().trim());
        }
    }

    @Test
    public void styleValueIsInSearchResult() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        for (int i = 1; i < searchesPage.getStyleSelectOptions().size(); i++) {
            searchesPage.selectStyleByIndex(i);
            waitForJSandJQueryToLoad();
            String optionValue = searchesPage.getStyleSelectValue();
            searchesPage.clickSearchBtn();
            waitForJSandJQueryToLoad();
            Assert.assertTrue(driver.getCurrentUrl().contains("_body_" + optionValue));
            driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
            waitForJSandJQueryToLoad();
        }
    }

    @Test
    public void noStyleInSearchResult() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        searchesPage.clickSearchBtn();
        waitForJSandJQueryToLoad();
        Assert.assertFalse(driver.getCurrentUrl().contains("_body_"));
    }

    @Test
    public void clickedStyleSelectBackground() {
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        searchesPage.selectStyleByIndex(1);
        waitForJSandJQueryToLoad();
        Assert.assertEquals(searchesPage.getStyleSelectBorderColor(), PropertyLoader.loadProperty("border_color_gray2"));
    }

    @Test
    public void styleValueIsTheSameWithInventory() {
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
        inventory.selectVehiclesPerPage("50");
        waitForJSandJQueryToLoad();
        inventory.addBodyColumn();
        waitForJSandJQueryToLoad();
        driver.navigate().refresh();
        waitForJSandJQueryToLoad();
        List<String> bodiesNumber = inventory.getEachBodyNumber();
        waitForJSandJQueryToLoad();
        driver.get(PropertyLoader.loadProperty("dws.url2") + "customadv");
        waitForJSandJQueryToLoad();
        for (int i = 1; i < searchesPage.getStyleSelectOptions().size(); i++) {
            Assert.assertEquals(searchesPage.getStyleSelectOptionsText().get(i), bodiesNumber.get(i - 1));
        }
    }
}
