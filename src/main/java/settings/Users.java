/*dms Users page*/
package settings;

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
public class Users extends Page {
    public Users(WebDriver webDriver) {
        super(webDriver);
    }

    /*declare elements on the page*/
    @FindBy(how = How.XPATH, using = "//li[@class='rootUserBranch jstree-open jstree-last']/a")
    private WebElement rootUser;

    @FindBy(how = How.XPATH, using = "(//li[contains(@class, 'userBranch')]/a)[last()]")
    private WebElement lastUser;

    @FindBy(how = How.ID, using = "user_tree_add")
    private WebElement addUserBtn;

    @FindBy(how = How.ID, using = "user_tree_delete")
    private WebElement deleteUserBtn;

    @FindBy(how = How.CSS, using = "a[href='/dms/settings']")
    private WebElement settingsMenuItem;

    @FindBy(how = How.CSS, using = "a[href='/dms/settings/website']")
    private WebElement websiteMenuItem;

    /*open User Editor of root user*/
    public UserEditor openUserEditor() {
        Actions action = new Actions(driver);
        Action moveToElem = action.doubleClick(rootUser).build();
        moveToElem.perform();
        return PageFactory.initElements(driver, UserEditor.class);
    }

    /*go to Website module*/
    public Website clickOnWebsiteMenu() {
    /*    Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(settingsMenuItem).build();
        moveToElem.perform();
        websiteMenuItem.click();*/
        driver.get("http://www.tacker.ixloo.com/dms/settings/website#general");
        return PageFactory.initElements(driver, Website.class);
    }

    /*click Add user button*/
    public UserEditor clickAddUser(){
        addUserBtn.click();
        return PageFactory.initElements(driver, UserEditor.class);
    }


    /*delete the last user in the tree*/
    public void deleteLastUser(){
        lastUser.click();
        deleteUserBtn.click();
    }

    /*open the last user in the tree*/
    public UserEditor openLastUserEditor(){
        Actions action = new Actions(driver);
        Action moveToElem = action.doubleClick(lastUser).build();
        moveToElem.perform();
        return PageFactory.initElements(driver, UserEditor.class);
    }
}
