/*Login to dms page*/
package dms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page.Page;
import utility.PropertyLoader;

/**
 * Created by Julia on 03.01.2017.
 */
public class dmsHome extends Page {
    public dmsHome(WebDriver webDriver) {
        super(webDriver);
    }

    /*declare elements on the page*/

    @FindBy(how = How.ID, using = "login")
    private WebElement loginInput;

    @FindBy(how = How.ID, using = "password")
    private WebElement pwInput;

    @FindBy(how = How.ID, using = "login2")
    private WebElement signInButton;

    /*method of logging to dms*/
    public dmsHome2 loginToDms() {
        loginInput.sendKeys(PropertyLoader.loadProperty("super.login")); //login is taken from environment.properties file
        pwInput.sendKeys(PropertyLoader.loadProperty("super.pw")); //password is taken from environment.properties file
        signInButton.click();
        return PageFactory.initElements(driver, dmsHome2.class);
    }
}
