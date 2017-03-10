package dmsInventory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import page.Page;

import java.util.List;

/**
 * Created by Julia on 07.03.2017.
 */
public class UploadWizard extends Page {

    public UploadWizard(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how = How.ID, using = "MTSelect")
    private WebElement motorizedTypeSelect;

    @FindBy(how = How.ID, using = "MakeSelect")
    private WebElement makeSelect;

    @FindBy(how = How.ID, using = "ModelSelect")
    private WebElement modelSelect;

    @FindBy(how = How.ID, using = "TrimSelect")
    private WebElement trimSelect;

    /*methods for getting all options from select*/

    public List<WebElement> getVehicleTypeSelectOptions() {
        WebElement select = motorizedTypeSelect;
        Select options = new Select(select);
        List<WebElement> allOptionsMotorizedType = options.getOptions();
        return allOptionsMotorizedType;
    }

    public List<WebElement> getMakeSelectOptions() {
        WebElement select = makeSelect;
        Select options = new Select(select);
        List<WebElement> allOptionsMake = options.getOptions();
        return allOptionsMake;
    }

    public String getMakeSelectOptionsText() {
        WebElement select = makeSelect;
        Select options = new Select(select);
        List<WebElement> allOptionsMake = options.getOptions();
        String option = null;
        for (int i = 0; i < allOptionsMake.size(); i++) {
            option = allOptionsMake.get(i).getText();
        }
        return option;
    }

    /*Methods for getting selected option of select*/

    public String getMotorizedTypeSelectValue() {
        WebElement select = motorizedTypeSelect;
        Select options = new Select(select);
        WebElement selectedOptionMotorizedType = options.getFirstSelectedOption();
        return selectedOptionMotorizedType.getText();
    }

   /*Select values in selects*/

    public void selectMotorizedType(String motorizedType) {
        WebElement select = motorizedTypeSelect;
        Select options = new Select(select);
        options.selectByVisibleText(motorizedType);
    }
}
