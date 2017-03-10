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
public class Inventory extends Page {

    public Inventory(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how = How.ID, using = "vehicle_type")
    private WebElement vehicleTypeSelect;

    @FindBy(how = How.ID, using = "make")
    private WebElement makeSelect;

    @FindBy(how = How.ID, using = "model")
    private WebElement modelSelect;

    @FindBy(how = How.ID, using = "trim")
    private WebElement trimSelect;

    /*methods for getting all options from select*/

    public List<WebElement> getVehicleTypeSelectOptions() {
        WebElement select = vehicleTypeSelect;
        Select options = new Select(select);
        List<WebElement> allOptionsVehicleType = options.getOptions();
        return allOptionsVehicleType;
    }

    public List<WebElement> getMakeSelectOptions() {
        WebElement select = vehicleTypeSelect;
        Select options = new Select(select);
        List<WebElement> allOptionsMake = options.getOptions();
        return allOptionsMake;
    }

    /*Methods for getting selected option of select*/

    public String getVehicleTypeSelectValue() {
        WebElement select = vehicleTypeSelect;
        Select options = new Select(select);
        WebElement selectedOptionVehicleType = options.getFirstSelectedOption();
        return selectedOptionVehicleType.getText();
    }

   /*Select values in selects*/

    public void selectVehicleType(String vehicleType) {
        WebElement select = vehicleTypeSelect;
        Select options = new Select(select);
        options.selectByVisibleText(vehicleType);
    }
}
