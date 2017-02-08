package webmail;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page.Page;

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

    @FindBy(how = How.ID, using = "rcmbtn106")
    private WebElement backBtn;

    @FindBy(how = How.ID, using = "rcmbtn111")
    private WebElement deleteBtn;

    public EmailsList backToList(){
        backBtn.click();
        return PageFactory.initElements(driver,EmailsList.class);
    }

    public EmailsList removeEmail(){
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

    public boolean isCommentsFieldExist(){
        try {
            comments.isDisplayed();
            return true;
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }


}
