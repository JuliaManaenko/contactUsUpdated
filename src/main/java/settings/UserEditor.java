/*User Editor popup at Users module*/
package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page.Page;

/**
 * Created by Julia on 10.01.2017.
 */
public class UserEditor extends Page {
    public UserEditor(WebDriver webDriver) {
        super(webDriver);
    }

    /*declare elements on the page*/
    @FindBy(how = How.ID, using = "user_editor_tab4")
    private WebElement accessTab;

    @FindBy(how = How.XPATH, using = "//div[@class='access_group']/span[contains(text(), 'Tools')]")
    private WebElement toolsItem;

    @FindBy(how = How.ID, using = "addon_make_a_page_2")
    private WebElement map2Checkbox;

    @FindBy(how = How.XPATH, using = "(//a[@class='button-style b_save notranslate'])[7]")
    private WebElement saveBtn;

    /*turn on MAP2 checkbox in Access tab(if it is off)*/
    public Users turnOnMap2() throws InterruptedException {
        Thread.sleep(1000);
        accessTab.click();
        toolsItem.click();
        if (map2Checkbox.getAttribute("checked") == null) {
            map2Checkbox.click();
        }
        saveBtn.click();
        return PageFactory.initElements(driver, Users.class);
    }
}
