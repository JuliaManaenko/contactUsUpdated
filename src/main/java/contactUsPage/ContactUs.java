/*Contact Us dws page*/
package contactUsPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page.Page;
import utility.LogFactory;
import utility.PropertyLoader;
import org.slf4j.Logger;


/**
 * Created by Julia on 30.12.2016.
 */
public class ContactUs extends Page {

    private static final Logger LOG = LogFactory.getLogger(ContactUs.class);

    /*declare elements on the page*/

    @FindBy(how = How.XPATH, using = "//div[@class='panel-title']")
    private WebElement widgetTitle;

    @FindBy(how = How.XPATH, using = "//legend[contains(text(), 'Contact Information')]")
    private WebElement contactInfoTitle;

    @FindBy(how = How.NAME, using = "first_name")
    private WebElement firstNameInput;

    @FindBy(how = How.NAME, using = "last_name")
    private WebElement lastNameInput;

    @FindBy(how = How.NAME, using = "phone")
    private WebElement phoneNumInput;

    @FindBy(how = How.NAME, using = "email")
    private WebElement emailInput;

    @FindBy(how = How.NAME, using = "international_phone")
    private WebElement intPhoneInput;

    @FindBy(how = How.NAME, using = "street")
    private WebElement streetInput;

    @FindBy(how = How.NAME, using = "city")
    private WebElement cityInput;

    @FindBy(how = How.NAME, using = "state")
    private WebElement stateInput;

    @FindBy(how = How.NAME, using = "zip")
    private WebElement zipInput;

    @FindBy(how = How.XPATH, using = "//legend[contains(text(), 'Questions or Comments')]")
    private WebElement questionTitle;

    @FindBy(how = How.XPATH, using = "//span[@class='help-block']")
    private WebElement helpText;

    @FindBy(how = How.XPATH, using = "//span[@class='label label-primary comments_counter']")
    private WebElement counter;

    @FindBy(how = How.NAME, using = "comments")
    private WebElement commentTextArea;

    @FindBy(how = How.XPATH, using = "//legend[contains(text(), 'Security')]")
    private WebElement securityTitle;

    @FindBy(how = How.XPATH, using = "//p[@class='text-muted text-center']")
    private WebElement astericsText;

    @FindBy(how = How.XPATH, using = "//span[@class='glyphicon glyphicon-asterisk form-control-feedback text-danger']")
    private WebElement astericsInput;

    @FindBy(how = How.XPATH, using = "//span[@class='glyphicon glyphicon-asterisk text-danger pull-right']")
    private WebElement astericsCaptcha;

    @FindBy(how = How.XPATH, using = "//span[@class='glyphicon glyphicon-asterisk text-danger']")
    private WebElement astericsNote;

    @FindBy(how = How.XPATH, using = "//div[@class='btn btn-primary btn-submit']")
    private WebElement submitButton;

    @FindBy(how = How.CLASS_NAME, using = "modul-r-contact_us")
    private WebElement widget;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'modul-r-contact_us')]/div")
    private WebElement widget2;

    @FindBy(how = How.XPATH, using = "(//div[contains(@class, 'modul-r-contact_us')]//div[@class='text-center'])[1]")
    private WebElement postForm;

    @FindBy(how = How.XPATH, using = "//div[@class='row captcha_container capchaB']")
    private WebElement captcha;

    @FindBy(how = How.CLASS_NAME, using = "capchaImgWrap")
    private WebElement captchaImg;

    @FindBy(how = How.CLASS_NAME, using = "captcha_input")
    private WebElement captchaInput;

    @FindBy(how = How.CLASS_NAME, using = "captcha_refresh")
    private WebElement captchaRefresh;

    @FindBy(how = How.XPATH, using = "//div[@class='recaptcha_v2_div_wrapper']/div[@class='recaptcha-v2-container']//iframe")
    private WebElement reCaptcha2Frame;

    @FindBy(how = How.ID, using = "recaptcha-anchor")
    private WebElement reCaptcha2Checkbox;

    @FindBy(how = How.CLASS_NAME, using = "motion-captcha")
    private WebElement motionCaptcha;

    @FindBy(how = How.XPATH, using = "//div[@class='motion-captcha col-lg-12']/p")
    private WebElement motionCaptchaText;

    @FindBy(how = How.XPATH, using = "//div[@class='motion-captcha col-lg-12']//canvas")
    private WebElement motionCaptchaCanvas;


    public ContactUs(WebDriver webDriver) {
        super(webDriver);
    }

    /*methods for check if element exists*/

    public boolean isWidgetTitleDisplayed() {
        try {
            widgetTitle.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isContactInfoTitleDisplayed() {
        try {
            contactInfoTitle.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isFirstNameInputDisplayed() {
        try {
            firstNameInput.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isLastNameInputDisplayed() {
        try {
            lastNameInput.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isPhoneNumInputDisplayed() {
        try {
            phoneNumInput.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isEmailInputDisplayed() {
        try {
            emailInput.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isIntPhonelnputDisplayed() {
        try {
            intPhoneInput.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isStreetlnputDisplayed() {
        try {
            streetInput.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isCitylnputDisplayed() {
        try {
            cityInput.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isStatelnputDisplayed() {
        try {
            stateInput.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isZipInputDisplayed() {
        try {
            zipInput.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isQuestionTitleDisplayed() {
        try {
            questionTitle.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isHelpTextDisplayed() {
        try {
            helpText.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isCounterDisplayed() {
        try {
            counter.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isSecurityTitleDisplayed() {
        try {
            securityTitle.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isCommentTextAreaDisplayed() {
        try {
            commentTextArea.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isAstericsTextDisplayed() {
        try {
            astericsText.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isAstericsInputDisplayed() {
        try {
            astericsInput.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public Dimension astericsInputSize() {
        return astericsInput.getSize();
    }

    public boolean isAstericsCaptchaDisplayed() {
        try {
            astericsCaptcha.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isAstericsNoteDisplayed() {
        try {
            astericsNote.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isSubmitButtonDisplayed() {
        try {
            submitButton.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isPostFormDisplayed() {
        try {
            postForm.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isCaptchaImgDisplayed() {
        try {
            captchaImg.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isCapthaInputDispalyed() {
        try {
            captchaInput.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isCaptchaRefreshDispalyed() {
        try {
            captchaRefresh.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isRecaptcha2Displayed() {
        try {
            reCaptcha2Frame.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isMotionCaptchaDisplayed() {
        try {
            motionCaptcha.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /*method click on submit button*/

    public void clickOnSubmit() {
        submitButton.click();
    }

   /*methods for getting border color of input elements*/

    public String getFirstNameInputBorderColor() {
        return firstNameInput.getCssValue("border-color");
    }

    public String getLastNameInputBorderColor() {
        return lastNameInput.getCssValue("border-color");
    }

    public String getPhoneNumInputBorderColor() {
        return phoneNumInput.getCssValue("border-color");
    }

    public String getEmailInputBorderColor() {
        return emailInput.getCssValue("border-color");
    }

    public String getZipInputBorderColor() {
        return zipInput.getCssValue("border-color");
    }

    public String getIntPhoneInputBorderColor() {
        return intPhoneInput.getCssValue("border-color");
    }

    public String getStateInputBorderColor() {
        return stateInput.getCssValue("border-color");
    }

    public String getCityInputBorderColor() {
        return cityInput.getCssValue("border-color");
    }

    public String getStreetInputBorderColor() {
        return streetInput.getCssValue("border-color");
    }

    public String getCommentInputBorderColor() {
        return commentTextArea.getCssValue("border-color");
    }

    /*methods for getting class name of input elements*/

    public String getFirstNameInputClass() {
        return firstNameInput.getAttribute("class");
    }

    public String getEmailInputClass() {
        return emailInput.getAttribute("class");
    }

    public String getLastNameInputClass() {
        return lastNameInput.getAttribute("class");
    }

    public String getPhoneNumInputClass() {
        return phoneNumInput.getAttribute("class");
    }

    public String getZipInputClass() {
        return zipInput.getAttribute("class");
    }

    public String getIntPhoneInputClass() {
        return intPhoneInput.getAttribute("class");
    }

    public String getStateInputClass() {
        return stateInput.getAttribute("class");
    }

    public String getCityInputClass() {
        return cityInput.getAttribute("class");
    }

    public String getStreetInputClass() {
        return streetInput.getAttribute("class");
    }

    public String getCommentInputClass() {
        return commentTextArea.getAttribute("class");
    }

    public String getWidgetClass() { return widget.getAttribute("class");  }

    public boolean getWidgetClassWow(String wowClass)
    {
        return widget.getAttribute("class").contains(wowClass);
    }

    public String getWidgetClassColor() {
        return widget2.getAttribute("class");
    }

    public String getRecaptcha2CheckboxClass() {
        return reCaptcha2Checkbox.getAttribute("class");
    }

    public boolean getMotionCaptchaClass(String motionClass)
    {
        return motionCaptchaCanvas.getAttribute("class").contains(motionClass);
    }

    /*methods for check if cursor is in input*/

    public boolean isFirstNameSelected() {
        return driver.switchTo().activeElement().equals(firstNameInput);
    }

    public boolean isLastNameSelected() {
        return driver.switchTo().activeElement().equals(lastNameInput);
    }

    public boolean isPhoneNumSelected() {
        return driver.switchTo().activeElement().equals(phoneNumInput);
    }

    public boolean isEmailSelected() {
        return driver.switchTo().activeElement().equals(emailInput);
    }

    public boolean isZipSelected() {
        return driver.switchTo().activeElement().equals(zipInput);
    }

    /*methods for filling inputs with some values*/

    public void fillFirstName() {
        firstNameInput.clear();
        firstNameInput.sendKeys("John");
    }

    public void fillLastName() {
        lastNameInput.clear();
        lastNameInput.sendKeys("Smith");
    }

    public void fillPhoneNum() {
        phoneNumInput.clear();
        phoneNumInput.sendKeys("9587123698");
    }

    public void fillPhoneNum1() {
        phoneNumInput.clear();
        phoneNumInput.sendKeys(PropertyLoader.loadProperty("phoneL1"));
    }

    public void fillEmail() {
        emailInput.clear();
        emailInput.sendKeys("test_2@dxloo.com");
    }

    public void fillEmail2() {
        emailInput.clear();
        emailInput.sendKeys(PropertyLoader.loadProperty("Email1"));
    }

    public void fillZip() {
        zipInput.clear();
        zipInput.sendKeys("100001");
    }

    public void fillComments1() {
        commentTextArea.clear();
        commentTextArea.sendKeys("1");
    }

    public void fillComments1000() throws InterruptedException {
        commentTextArea.clear();
        Thread.sleep(1000);
        commentTextArea.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. orem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore");
    }

    public void fillComments2000() throws InterruptedException {
        commentTextArea.clear();
        Thread.sleep(1000);
        commentTextArea.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. orem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore  commentTextArea.sendKeys(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor i");
    }

    public void fillComments2001() {
        commentTextArea.clear();
        commentTextArea.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. orem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore commentTextArea.sendKeys(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor isa");
    }


    /*Method for check if widget exists or doesn't exist*/

    public boolean isWidgetExists() {
        try {
            widget.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /*Methods for getting text from input*/

    public String intPhoneGetValue() {
        return intPhoneInput.getAttribute("value");
    }

    public String stateGetValue() {
        return stateInput.getAttribute("value");
    }

    public String zipGetValue() {
        return zipInput.getAttribute("value");
    }

    public String commentsCounterGetValue() {
        return counter.getText();
    }

    public String commentsGetValue() {
        return commentTextArea.getAttribute("value");
    }

    /*Get text from Post Form Notification*/
    public String postFormGetText() {
        return postForm.getText();
    }

    public void clickRecaptcha2() {
        reCaptcha2Frame.click();
    }

    public String getMotionCaptchaText() {
        return motionCaptchaText.getText();
    }
}


