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

import java.util.*;

/**
 * Created by Julia on 07.03.2017.
 */
public class Inventory extends Page {

    private static final Logger LOG = LogFactory.getLogger(Inventory.class);

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

    @FindBy(how = How.CLASS_NAME, using = "ui-pg-selbox")
    private WebElement vehPerPageSelect;

    @FindBy(how = How.ID, using = "sp_1")
    private WebElement numberOfPages;

    @FindBy(how = How.CLASS_NAME, using = "ui-icon-seek-next")
    private WebElement nextArrow;

    @FindBy(how = How.ID, using = "jqgh_Body")
    private WebElement bodyColumnTitle;

    @FindBy(how = How.ID, using = "jqgh_Year")
    private WebElement yearColumnTitle;

    @FindBy(how = How.ID, using = "inventory-list_Year")
    private WebElement yearColumnTitle2;

    @FindBy(how = How.XPATH, using = "//span[@id='edit_fields']//a")
    private WebElement editFieldsBtn;

    @FindBy(how = How.XPATH, using = "//li[@class='ui-state-default ui-element ui-draggable'][contains(text(), 'Body')]/a")
    private WebElement bodyItemPlus;

    @FindBy(how = How.XPATH, using = "//li[@class='ui-state-default ui-element ui-draggable'][contains(text(), 'Year')]/a")
    private WebElement yearItemPlus;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'ui-button')]/span[contains(text(), 'Apply')]")
    private WebElement applyBtn;

    @FindBy(how = How.XPATH, using = "//td[@aria-describedby='inventory-list_Body']")
    private List<WebElement> bodyCell;

    @FindBy(how = How.XPATH, using = "//td[@aria-describedby='inventory-list_Year']")
    private List<WebElement> yearCell;

    @FindBy(how = How.XPATH, using = "//input[@value='inv']")
    private WebElement invRadioBtn;



    /*methods for getting all options from select*/

    public List<WebElement> getVehicleTypeSelectOptions() {
        WebElement select = vehicleTypeSelect;
        Select options = new Select(select);
        List<WebElement> allOptionsVehicleType = options.getOptions();
        return allOptionsVehicleType;
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

    public List<String> getMakeSelectOptionsValue() {
        WebElement select = makeSelect;
        Select options = new Select(select);
        List<WebElement> allOptionsMake = options.getOptions();
        List<String> option = new ArrayList<>();
        for (int i = 0; i < allOptionsMake.size(); i++) {
            option.add(allOptionsMake.get(i).getAttribute("value"));
        }
        return option;
    }

    public List<String> getModelSelectOptionsText() {
        WebElement select = makeSelect;
        Select options = new Select(select);
        WebElement selectModel = modelSelect;
        Select optionsModel = new Select(modelSelect);
        List<WebElement> allOptionsMake = options.getOptions();

        List<String> option = new ArrayList<>();
        for (int i = 1; i < allOptionsMake.size(); i++) {
            allOptionsMake.get(i).click();
            waitForJSandJQueryToLoad();
            List<WebElement> allOptionsModel = optionsModel.getOptions();
            for (int j = 1; j < allOptionsModel.size(); j++) {
                option.add(allOptionsModel.get(j).getText());
                LOG.info("Model in inventory is " + allOptionsModel.get(j).getText());
            }
        }

        return option;
    }

    public List<String> getModelSelectOptionsValue() {
        WebElement select = makeSelect;
        Select options = new Select(select);
        WebElement selectModel = modelSelect;
        Select optionsModel = new Select(modelSelect);
        List<WebElement> allOptionsMake = options.getOptions();

        List<String> option = new ArrayList<>();
        for (int i = 1; i < allOptionsMake.size(); i++) {
            allOptionsMake.get(i).click();
            waitForJSandJQueryToLoad();
            List<WebElement> allOptionsModel = optionsModel.getOptions();
            for (int j = 1; j < allOptionsModel.size(); j++) {
                option.add(allOptionsModel.get(j).getText());
                LOG.info("Model in inventory is " + allOptionsModel.get(j).getAttribute("value"));
            }
        }

        return option;
    }


    /*Methods for getting selected option of select*/

    public String getVehicleTypeSelectedValue() {
        WebElement select = vehicleTypeSelect;
        Select options = new Select(select);
        WebElement selectedOptionVehicleType = options.getFirstSelectedOption();
        return selectedOptionVehicleType.getText();
    }

    public String getModelSelectedValue(int indexMake, int indexModel) {
        WebElement select = makeSelect;
        Select options = new Select(select);
        WebElement selectModel = modelSelect;
        Select optionsModel = new Select(modelSelect);
        options.selectByIndex(indexMake);
        waitForJSandJQueryToLoad();
        optionsModel.selectByIndex(indexModel);
        waitForJSandJQueryToLoad();
        WebElement selectedOptionModel = optionsModel.getFirstSelectedOption();
        return selectedOptionModel.getAttribute("value");
    }

   /*Select values in selects*/

    public void selectVehicleType(String vehicleType) {
        WebElement select = vehicleTypeSelect;
        Select options = new Select(select);
        options.selectByVisibleText(vehicleType);
    }

    public void selectMake(int index) {
        WebElement select = makeSelect;
        Select options = new Select(select);
        options.selectByIndex(index);
    }

    public void selectVehiclesPerPage(String value) {
        WebElement select = vehPerPageSelect;
        Select options = new Select(select);
        options.selectByValue(value);
    }

    /*work with pages number*/

    public void getAllPagesNumber() {
        numberOfPages.getText();
    }

    public void clickOnNextPage() {
        nextArrow.click();
    }

    /*add column*/

    public void addBodyColumn() {
        try {
            bodyColumnTitle.isDisplayed();
        } catch (NoSuchElementException ex) {
            editFieldsBtn.click();
            waitForJSandJQueryToLoad();
            bodyItemPlus.click();
            applyBtn.click();

        }
    }

    public void addYearColumn() {
        LOG.info("year title attribute is " + yearColumnTitle2.getCssValue("display"));
        if (yearColumnTitle2.getCssValue("display").equals("none")) {

            editFieldsBtn.click();
            waitForJSandJQueryToLoad();
            yearItemPlus.click();
            applyBtn.click();

        }
    }

    /*get values from columns*/

    public List<String> getAllBodies() {
        List<String> bodies = new ArrayList<>();
        for (int i = 0; i < bodyCell.size(); i++) {
            bodies.add(bodyCell.get(i).getText());
        }
        return bodies;
    }

    public List<String> getAllBodiesOnAllPages() {
        List<String> bodies = new ArrayList<>();
        int pagesNumber = Integer.parseInt(numberOfPages.getText());
        for (int i = 0; i < pagesNumber; i++) {
            for (int j = 0; j < bodyCell.size(); j++) {
                bodies.add(bodyCell.get(j).getText());

            }
            nextArrow.click();
            waitForJSandJQueryToLoad();
        }
        return bodies;
    }

    public List<String> getBodies() {
        List<String> bodies = new ArrayList<>();
        int pagesNumber = Integer.parseInt(numberOfPages.getText());
        //  LOG.info("number of pages is " + pagesNumber);
        for (int i = 0; i < pagesNumber; i++) {
            //  LOG.info("bodyCell size is " + bodyCell.size());
            for (int j = 0; j < bodyCell.size(); j++) {
                bodies.add(bodyCell.get(j).getText());
                //LOG.info("added body is " + bodyCell.get(j).getText());
            }
            nextArrow.click();
            waitForJSandJQueryToLoad();
        }
      /*  String[] bodiesArray = bodies.toArray(new String[bodies.size()]);
        int bodiesSize = bodiesArray.length;
        LOG.info("bodiesSize is " + bodiesSize);
        int duplBound = bodiesSize - 1;
        for (int k = 0; k < duplBound; k++){
            LOG.info("k = " + k);
            for (int l = k + 1; l <= duplBound; l++){
                LOG.info("l = " + l);
                LOG.info("first body is " + bodies.get(k));
                LOG.info("next body is " + bodies.get(l));
                if(bodies.get(k).equals(bodies.get(l))){
                    String tmp = bodiesArray[l];
                    LOG.info("tmp is " + tmp);
                    System.arraycopy(bodiesArray, l + 1, bodiesArray, l, (duplBound - l));
                    bodiesArray[duplBound] = tmp;
                    duplBound--;
                    l--;
                }
            }
        };
        String[] bodiesArray2 = Arrays.copyOf(bodiesArray, duplBound + 1);
        List<String> bodiesList = new ArrayList<String>(Arrays.asList(bodiesArray2));
        for (int p = 0; p < bodiesList.size(); p++){
            LOG.info("New array is " + bodiesList.get(p));
        }
        return bodiesList;*/

        Set<String> singleBodies = new LinkedHashSet<>();
        singleBodies.addAll(bodies);
        bodies.clear();
        bodies.addAll(singleBodies);
        Collections.sort(bodies);
        return bodies;
    }

    public List<String> getEachBodyNumber() {
        List<String> bodies = new ArrayList<>();
        int pagesNumber = Integer.parseInt(numberOfPages.getText());
        List<String> bodyNumber = new ArrayList<>();
        for (int i = 0; i < pagesNumber; i++) {
            for (int j = 0; j < bodyCell.size(); j++) {
                bodies.add(bodyCell.get(j).getText());
            }
            nextArrow.click();
            waitForJSandJQueryToLoad();
        }
        for (int k = 0; k < bodies.size(); k++) {
            String number = String.valueOf(Collections.frequency(bodies, bodies.get(k)));
            bodyNumber.add(bodies.get(k) + " (" + number + ")");
        }
        Set<String> singleBodyNumber = new LinkedHashSet<>();
        singleBodyNumber.addAll(bodyNumber);
        bodyNumber.clear();
        bodyNumber.addAll(singleBodyNumber);
        Collections.sort(bodyNumber);
        return bodyNumber;
        //TODO: add cut for commercial truck (ex. heavy duty truck - ambulance = heavy duty truck)
    }

    public void clickInventoryRadioBtn() {
        invRadioBtn.click();
    }

    public String getMinYear() {
        yearColumnTitle.click();
        waitForJSandJQueryToLoad();
        String firstYear1 = yearCell.get(0).getText();
        yearColumnTitle.click();
        waitForJSandJQueryToLoad();
        String firstYear2 = yearCell.get(0).getText();
        if (Integer.parseInt(firstYear1) < Integer.parseInt(firstYear2)) {
            return firstYear1;
        } else return firstYear2;
    }

    public String getMaxYear() {
        yearColumnTitle.click();
        waitForJSandJQueryToLoad();
        String firstYear1 = yearCell.get(0).getText();
        yearColumnTitle.click();
        waitForJSandJQueryToLoad();
        String firstYear2 = yearCell.get(0).getText();
        if (Integer.parseInt(firstYear1) > Integer.parseInt(firstYear2)) {
            return firstYear1;
        } else return firstYear2;
    }
}
