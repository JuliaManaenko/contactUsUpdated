package dms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page.Page;

/**
 * Created by Julia on 06.01.2017.
 */
public class Page3 extends Page {
    public Page3(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (how= How.XPATH, using = ("/div"))
    private WebElement div1;

    public void test1(){

    }
}
