package map2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import page.Page;

/**
 * Created by Julia on 25.01.2017.
 */
public class ContactUsWidgetSettings extends Page {
    public ContactUsWidgetSettings(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how= How.XPATH, using ="//div[@data-option='wow']//select")
    private WebElement wowAnimSelect;

    @FindBy(how= How.XPATH, using ="//div[@data-option='colorTheme']//select")
    private WebElement colorSelect;

    @FindBy(how= How.XPATH, using ="//div[@data-option='staff_email_notification']//select")
    private WebElement staffEmailSelect;

    @FindBy(how= How.XPATH, using ="//div[@data-option='submit_message']//input")
    private WebElement submitInput;

    @FindBy(how= How.XPATH, using ="//div[@data-option='title']//input")
    private WebElement widgetTitleInput;

    @FindBy(how= How.XPATH, using ="//div[@class='pull-left mapx-input-group widget-editor-searchbox']//input[@class='mapx-form-control']")
    private WebElement searchInput;

    @FindBy(how= How.XPATH, using ="(//span[contains(text(), 'Ok')])[1]")
    private WebElement okBtn;

    @FindBy(how= How.XPATH, using ="//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']/span[contains(text(), 'Cancel')]")
    private WebElement cancelBtn;

    @FindBy(how= How.XPATH, using ="//span[@class='ui-icon ui-icon-closethick']")
    private WebElement cross;

    public ContactEditor clickOK(){
      okBtn.click();
      return PageFactory.initElements(driver, ContactEditor.class);
    }

    public ContactEditor clickCancel(){
        cancelBtn.click();
        return PageFactory.initElements(driver, ContactEditor.class);
    }
    public ContactEditor clickCross(){
        cross.click();
        return PageFactory.initElements(driver, ContactEditor.class);
    }

    public void setAnimationDisabled(){
        WebElement select = wowAnimSelect;
        Select options = new Select(select);
        options.selectByValue("nowow");
    }

    public void setAnimation(String animation){
        WebElement select = wowAnimSelect;
        Select options = new Select(select);
        options.selectByValue(animation);
    }

    public HTMLEditor openHtmlEditor(){
        submitInput.click();
        return PageFactory.initElements(driver, HTMLEditor.class);
    }

    public void setColorVariation(String colorVariation){
        WebElement select = colorSelect;
        Select options = new Select(select);
        options.selectByValue(colorVariation);
    }

    public void fillWidgetTitle(String title){
        widgetTitleInput.clear();
        widgetTitleInput.sendKeys(title);
    }
}
