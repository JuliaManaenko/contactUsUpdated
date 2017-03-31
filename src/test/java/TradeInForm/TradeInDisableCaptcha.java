package TradeInForm;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.Website;
import utility.PropertyLoader;

/**
 * Created by Julia on 09.03.2017.
 */
public class TradeInDisableCaptcha extends TradeInTestBase2 {

    @Test
    public void tradeInDisableCaptcha() {
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        dms.dmsHome2 dmsHome2 = PageFactory.initElements(driver, dms.dmsHome2.class);
        Website website = dmsHome2.clickOnWebsiteMenu2();
        waitForJSandJQueryToLoad();
        wait.until(isWebsiteSidePanelVisible());
        website.disableCaptcha();
        waitForJSandJQueryToLoad();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        waitForJSandJQueryToLoad();
        Assert.assertFalse(tradeIn.isSecurityTitleDisplayed());
    }
}
