package dmsInventory;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import page.Page;
import utility.LogFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julia on 07.03.2017.
 */
public class UploadWizard extends Page {
    private static final Logger LOG = LogFactory.getLogger(UploadWizard.class);

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

    public List<String> getMakeSelectOptionsText() {
        WebElement select = makeSelect;
        Select options = new Select(select);
        List<WebElement> allOptionsMake = options.getOptions();
        List<String> option = new ArrayList<>();
        for (int i = 0; i < allOptionsMake.size(); i++) {
            option.add(allOptionsMake.get(i).getText());
        }
        return option;
    }

    public List<String> getModelSelectOptionsText() {
        WebElement select = modelSelect;
        Select options = new Select(select);
        List<WebElement> allOptionsModel = options.getOptions();
        List<String> option = new ArrayList<>();
        for (int i = 0; i < allOptionsModel.size(); i++) {
            option.add(allOptionsModel.get(i).getText());
        }
        return option;
    }

    public List<String> getTrimSelectOptionsText() {
        WebElement select = trimSelect;
        Select options = new Select(select);
        List<WebElement> allOptionsTrim = options.getOptions();
        List<String> option = new ArrayList<>();
        for (int i = 0; i < allOptionsTrim.size(); i++) {
            option.add(allOptionsTrim.get(i).getText());
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

    public void selectMake(int index) {
        WebElement select = makeSelect;
        Select options = new Select(select);
        try {
            options.selectByIndex(index);
        } catch (NoSuchElementException ex) {
            options.selectByIndex(0);
            LOG.info("No makes in the list");
        }
    }

    public void selectModel(int index) {
        WebElement select = modelSelect;
        Select options = new Select(select);
        try {
            options.selectByIndex(index);
        } catch (NoSuchElementException ex) {
            options.selectByIndex(0);
            LOG.info("No makes in the list");
        }
    }
}
