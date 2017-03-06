/*Lead Details dms page*/
package customers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import page.Page;
import utility.LogFactory;

/**
 * Created by Julia on 11.01.2017.
 */
public class LeadDetails extends Page {

    private static final Logger LOG = LogFactory.getLogger(LeadDetails.class); //declare a variable for logger

    public LeadDetails(WebDriver webDriver) {
        super(webDriver);
    }

    /*declare elements on the page*/

    @FindBy(how = How.XPATH, using = "//span[@class='FormName']/b")
    private WebElement formName;

    @FindBy(how = How.XPATH, using = "//span[@id='first_name']")
    private WebElement firstName;

    @FindBy(how = How.ID, using = "last_name")
    private WebElement lastName;

    @FindBy(how = How.ID, using = "phone")
    private WebElement phoneNum;

    @FindBy(how = How.XPATH, using = "//div[contains(text(), 'International Phone Number:')]//../following-sibling::td//span")
    private WebElement intPhoneNum;

    @FindBy(how = How.XPATH, using = "//span[@id='email']/a/b")
    private WebElement email;

    @FindBy(how = How.XPATH, using = "((//table[@class='templateMail']//table)[15]//td)[4]/span")
    private WebElement street;

    @FindBy(how = How.XPATH, using = "((//table[@class='templateMail']//table)[17]//td)[4]/span")
    private WebElement city;

    @FindBy(how = How.XPATH, using = "((//table[@class='templateMail']//table)[19]//td)[4]/span")
    private WebElement state;

    @FindBy(how = How.XPATH, using = "((//table[@class='templateMail']//table)[21]//td)[4]/span")
    private WebElement zip;

    @FindBy(how = How.XPATH, using = "(//table[@class='templateMail']//table)[27]//span")
    private WebElement comments;

    @FindBy(how = How.XPATH, using = "(//table[@class='templateMail']//table)[43]//span")
    private WebElement tradeInComments;

    @FindBy(how = How.XPATH, using = "//b[contains(text(), 'Comments')]")
    private WebElement tradeInCommentsTitle;

    @FindBy(how = How.XPATH, using = "(//table[@class='templateMail']//table)[35]//span")
    private WebElement source;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Vin:')]//../following-sibling::td//span")
    private WebElement vin;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Year:')]//../following-sibling::td//span")
    private WebElement year;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Asking Price:')]//../following-sibling::td//span")
    private WebElement askingPrice;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Mileage:')]//../following-sibling::td//span")
    private WebElement odometer;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Motorized Type:')]//../following-sibling::td//span")
    private WebElement motorizedType;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Make:'')]//../following-sibling::td//span")
    private WebElement make;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Model:'')]//../following-sibling::td//span")
    private WebElement model;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Trim:'')]//../following-sibling::td//span")
    private WebElement trim;

    /*methods for getting values of fields*/

    public String getFirstName(){
       LOG.info("First Name is " + firstName.getText()); //log to console
       return firstName.getText();
    }

    public String getLastName()
    {
       return lastName.getText();
    }

    public String getPhoneNum()
    {
        return phoneNum.getText();
    }

    public String getIntPhoneNum()
    {
        return intPhoneNum.getText();
    }

    public String getEmail()
    {
        return email.getText();
    }

    public String getZip() { return zip.getText();  }

    public String getStreet()
    {
        return street.getText();
    }

    public String getCity()
    {
        return city.getText();
    }

    public String getState()
    {
        return state.getText();
    }

    public String getSource()
    {
        return source.getText();
    }

    public String getComments()
    {
        return comments.getText();
    }

    public String getTradeInComments()
    {
        return tradeInComments.getText();
    }

    public String getVin() {return vin.getText();}

    public String getYear() { return year.getText(); }

    public String getAskingPrice() { return askingPrice.getText(); }

    public String getOdometer() {
        return odometer.getText();
    }

    public String getMotorizedType() {
        return motorizedType.getText();
    }

    public String getMake() {
        return make.getText();
    }

    public String getModel() {
        return model.getText();
    }

    public String getTrim() {
        return trim.getText();
    }

    public boolean isIntPhoneFieldExist(){
        try {
            intPhoneNum.isDisplayed();
            return true;
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isTradeInCommentsExist(){
        try {
            tradeInCommentsTitle.isDisplayed();
            return true;
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }

}
