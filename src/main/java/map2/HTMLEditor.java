package map2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page.Page;
import utility.PropertyLoader;

/**
 * Created by Julia on 02.02.2017.
 */
public class HTMLEditor extends Page {
    public HTMLEditor(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how= How.XPATH, using ="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
    private WebElement textarea;

    @FindBy(how= How.ID, using ="cke_105")
    private WebElement sourceButton;

    @FindBy(how= How.XPATH, using ="(//span[contains(text(), 'Ok')])[2]")
    private WebElement okEditorButton;

   @FindBy(how= How.XPATH, using ="//iframe[@class='cke_wysiwyg_frame cke_reset']")
    private WebElement iFrame;

    public void addText(){
        driver.switchTo().frame(iFrame);
        textarea.sendKeys(PropertyLoader.loadProperty("text50"));
        driver.switchTo().defaultContent();
    }

    public ContactUsWidgetSettings clickEditorOk(){
        okEditorButton.click();
        return PageFactory.initElements(driver, ContactUsWidgetSettings.class);
    }

}
