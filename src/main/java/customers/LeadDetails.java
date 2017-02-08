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

    @FindBy(how = How.XPATH, using = "((//table[@class='templateMail']//table)[11]//td)[4]/span")
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

    @FindBy(how = How.XPATH, using = "(//table[@class='templateMail']//table)[35]//span")
    private WebElement source;

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

    public boolean isIntPhoneFieldExist(){
        try {
            intPhoneNum.isDisplayed();
            return true;
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }

}
