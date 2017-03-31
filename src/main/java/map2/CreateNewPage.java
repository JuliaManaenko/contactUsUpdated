package map2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page.Page;

/**
 * Created by Julia on 04.01.2017.
 * for MAP1
 */
public class CreateNewPage extends Page {
    @FindBy(how= How.ID, using ="input-pg-name")
    private WebElement nameInput;

    @FindBy(how= How.ID, using ="input-pg-url")
    private WebElement pageURLInput;

    @FindBy(how= How.ID, using ="input-pg-title")
    private WebElement titleInput;

    @FindBy(how= How.XPATH, using ="(//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all  ui-draggable']//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'])[1]")
    private WebElement createBtn;

    public CreateNewPage(WebDriver webDriver) {
        super(webDriver);
    }

    public map2PageEditor createPage() {
        nameInput.sendKeys("contactauto");
        pageURLInput.sendKeys("contactauto");
        titleInput.sendKeys("contactauto");
        createBtn.click();
        return PageFactory.initElements(driver, map2PageEditor.class);
    }
}
