/*dms Sites page*/
package settings;

import dms.SiteEditor;
import dmsDealers.Dealers;
import map2.MAP2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page.Page;

/**
 * Created by Julia on 10.01.2017.
 */
public class Sites extends Page {
    public Sites(WebDriver webDriver) {
        super(webDriver);
    }

    /*declare elements on the page*/
    @FindBy(how = How.CSS, using = "div#sites_tree ul:first-child li.open.last > a")
    private WebElement rootSite;

    @FindBy(how = How.CSS, using = "a[href='/dms/tools']")
    private WebElement toolsMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/tools/make_a_page_2']")
    private WebElement map2MenuItem;

    @FindBy(how = How.XPATH, using = "//div[@aria-labelledby='ui-dialog-title-site_editor']")
    private WebElement siteEditorWindow;

    /*open Site Editor popup on the root site*/
    public SiteEditor openSiteEditor() {
        Actions action = new Actions(driver);
        Action dblclick = action.doubleClick(rootSite).build();
        dblclick.perform();
        return PageFactory.initElements(driver, SiteEditor.class);
    }

    /*go to MAP2 module*/
    public MAP2 goToMAP2() {
     /*   Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(toolsMenuItem).build();
        moveToElem.perform();
        map2MenuItem.click();*/
        driver.get("http://www.tacker.ixloo.com/dms/tools/make_a_page_2");
        return PageFactory.initElements(driver, MAP2.class);
    }
}
