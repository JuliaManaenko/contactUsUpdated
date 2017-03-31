package webmail;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page.Page;

import java.util.List;

/**
 * Created by Julia on 03.02.2017.
 */
public class EmailDetails extends Page {
    public EmailDetails(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(how = How.ID, using = "fr")
    private WebElement iframe;

    @FindBy(how = How.ID, using = "first_name")
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

    @FindBy(how = How.ID, using = "rcmbtn106")
    private WebElement backBtn;

    @FindBy(how = How.ID, using = "rcmbtn111")
    private WebElement deleteBtn;

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

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Make:')]//../following-sibling::td//span")
    private WebElement make;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Model:')]//../following-sibling::td//span")
    private WebElement model;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Trim:')]//../following-sibling::td//span")
    private WebElement trim;

    @FindBy(how = How.XPATH, using = "(//b[contains(text(),'User Image')]/../../../../../../../../../../../following-sibling::tr)[2]//img")
    private List<WebElement> userImage;

    @FindBy(how = How.XPATH, using = "//b[contains(text(),'User Image')]/../../../../../../../../../../..")
    private WebElement userImageTitle;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Request Time:')]//../following-sibling::td//span")
    private WebElement requestTime;

    public EmailsList backToList(){
        backBtn.click();
        return PageFactory.initElements(driver,EmailsList.class);
    }

    public EmailsList removeEmail(){
        deleteBtn.click();
        return PageFactory.initElements(driver,EmailsList.class);
    }

    public EmailsList removeEmail2(){
        driver.switchTo().frame(iframe);
        deleteBtn.click();
        return PageFactory.initElements(driver,EmailsList.class);
    }

    public String getFirstName(){
        driver.switchTo().frame(iframe);
        return firstName.getText();
    }

    public String getLastName(){
        driver.switchTo().frame(iframe);
        return lastName.getText();
    }

    public String getPhone(){
        driver.switchTo().frame(iframe);
        return phoneNum.getText();
    }

    public String getIntPhone(){
        driver.switchTo().frame(iframe);
        return intPhoneNum.getText();
    }

    public String getEmail(){
        driver.switchTo().frame(iframe);
        return email.getText();
    }

    public String getStreet(){
        driver.switchTo().frame(iframe);
        return street.getText();
    }

    public String getCity(){
        driver.switchTo().frame(iframe);
        return city.getText();
    }

    public String getState(){
        driver.switchTo().frame(iframe);
        return state.getText();
    }

    public String getZip(){
        driver.switchTo().frame(iframe);
        return zip.getText();
    }

    public String getComments(){
        driver.switchTo().frame(iframe);
        return comments.getText();
    }

    public String getTradeInComments(){
        driver.switchTo().frame(iframe);
        return tradeInComments.getText();
    }

    public String getVin(){
        driver.switchTo().frame(iframe);
        return vin.getText();
    }

    public String getYear(){
        driver.switchTo().frame(iframe);
        return year.getText();
    }

    public String getAskingPrice(){
        driver.switchTo().frame(iframe);
        return askingPrice.getText();
    }

    public String getOdometer() {
        driver.switchTo().frame(iframe);
        return odometer.getText();
    }

    public String getMotorizedType() {
        driver.switchTo().frame(iframe);
        return motorizedType.getText();
    }

    public String getMake() {
        driver.switchTo().frame(iframe);
        return make.getText();
    }

    public String getModel() {
        driver.switchTo().frame(iframe);
        return model.getText();
    }

    public String getTrim() {
        driver.switchTo().frame(iframe);
        return trim.getText();
    }

    public String getRequestTime() {
        driver.switchTo().frame(iframe);
        return requestTime.getText();
    }

    public boolean isCommentsFieldExist(){
        try {
            comments.isDisplayed();
            return true;
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isTradeInCommentsFieldExist(){
        try {
            tradeInComments.isDisplayed();
            return true;
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public int getUserImageNumber() {
        driver.switchTo().frame(iframe);
        try {
            return userImage.size();
        } catch (NoSuchElementException ex) {
            return 0;
        }
    }

    public boolean isUserImageTitleExist() {
        try {
            userImageTitle.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

}
