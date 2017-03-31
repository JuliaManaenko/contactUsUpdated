/*Contact Us dws page*/
package dwsPages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import page.Page;
import utility.LogFactory;
import utility.PropertyLoader;

import java.util.Arrays;
import java.util.List;


/**
 * Created by Julia on 30.12.2016.
 */
public class FormsPage extends Page {

    private static final Logger LOG = LogFactory.getLogger(FormsPage.class);

    /*declare elements on the page*/

    @FindBy(how = How.XPATH, using = "//div[@class='panel-title']")
    private WebElement widgetTitle;

    @FindBy(how = How.XPATH, using = "//legend[contains(text(), 'Contact Information')]")
    private WebElement contactInfoTitle;

    @FindBy(how = How.XPATH, using = "//legend[contains(text(), 'Vehicle Information')]")
    private WebElement vehicleInfoTitle;

    @FindBy(how = How.XPATH, using = "//legend[contains(text(), 'Upload Photo')]")
    private WebElement uploadPhotoTitle;

    @FindBy(how = How.XPATH, using = "//legend[contains(text(), 'Questions or Comments')]")
    private WebElement questionTitle;

    @FindBy(how = How.XPATH, using = "//legend[contains(text(), 'Comments')]")
    private WebElement commentsTitle;

    @FindBy(how = How.XPATH, using = "//legend[contains(text(), 'Security')]")
    private WebElement securityTitle;

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

    @FindBy(how = How.NAME, using = "vin")
    private WebElement vinInput;

    @FindBy(how = How.NAME, using = "year")
    private WebElement yearSelect;

    @FindBy(how = How.NAME, using = "motorized_type")
    private WebElement motorizedTypeSelect;

    @FindBy(how = How.NAME, using = "make")
    private WebElement makeSelect;

    @FindBy(how = How.NAME, using = "model")
    private WebElement modelSelect;

    @FindBy(how = How.NAME, using = "trim")
    private WebElement trimSelect;

    @FindBy(how = How.NAME, using = "price")
    private WebElement askingPriceInput;

    @FindBy(how = How.NAME, using = "mileage")
    private WebElement odometerInput;

    @FindBy(how = How.NAME, using = "comments")
    private WebElement commentTextArea;

    @FindBy(how = How.XPATH, using = "//span[@class='help-block']")
    private WebElement helpText;

    @FindBy(how = How.XPATH, using = "//span[@class='label label-primary comments_counter']")
    private WebElement counter;

    @FindBy(how = How.XPATH, using = "//p[@class='text-muted text-center']")
    private WebElement astericsText;

    @FindBy(how = How.XPATH, using = "//div[@class='text-center']//p")
    private WebElement uploadPhotoText;

    @FindBy(how = How.XPATH, using = "//span[@class='glyphicon glyphicon-asterisk form-control-feedback text-danger']")
    private WebElement astericsInput;

    @FindBy(how = How.XPATH, using = "//span[@class='glyphicon glyphicon-asterisk form-control-feedback text-danger']")
    private List<WebElement> astericsInputList;

    @FindBy(how = How.XPATH, using = "//span[@class='glyphicon glyphicon-asterisk text-danger pull-right']")
    private WebElement astericsCaptcha;

    @FindBy(how = How.XPATH, using = "//span[@class='glyphicon glyphicon-asterisk text-danger']")
    private WebElement astericsNote;

    @FindBy(how = How.XPATH, using = "//div[@class='btn btn-primary btn-submit']")
    private WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'trade-submit')]")
    private WebElement tradeInSubmitButton;

    @FindBy(how = How.CLASS_NAME, using = "modul-r-contact_us")
    private WebElement widget;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'modul-r-contact_us')]/div")
    private WebElement widget2;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'modul-r-tradein')]/div")
    private WebElement tradeInWidget;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'modul-r-tradein')]")
    private WebElement tradeInWidget2;

    @FindBy(how = How.ID, using = "main_form")
    private WebElement formInWidget;

    @FindBy(how = How.XPATH, using = "(//div[@class='panel-body']//div[@class='text-center'])[1]")
    private WebElement postForm;

    @FindBy(how = How.CLASS_NAME, using = "btn-message-ok")
    private WebElement postFormOkBtn;

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

    @FindBy(how = How.ID, using = "img_upload")
    private WebElement uploadBtn;

    @FindBy(how = How.ID, using = "remove-selected-upload")
    private WebElement removeBtn;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Vin:')]")
    private WebElement vinLabel;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Year:')]")
    private WebElement yearLabel;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Motorized Type:')]")
    private WebElement motorizedTypeLabel;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Make:')]")
    private WebElement makeLabel;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Model:')]")
    private WebElement modelLabel;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Trim:')]")
    private WebElement trimLabel;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Asking Price:')]")
    private WebElement askingPriceLabel;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Odometer:')]")
    private WebElement odometerLabel;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'First Name:')]")
    private WebElement firstNameLabel;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Last Name:')]")
    private WebElement lastNameLabel;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Phone Number:')]")
    private WebElement phoneNumLabel;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Email Address:')]")
    private WebElement emailLabel;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Int. Phone Number:')]")
    private WebElement intPhoneLabel;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'trade-submit')]//span[@class='fa fa-check']")
    private WebElement tradeInSubmitBtnCheckMark;

    @FindBy(how = How.ID, using = "editProgress")
    private WebElement uploadSuccessText;

    @FindBy(how = How.XPATH, using = "//img[@class='thumbnail img-responsive']")
    private List<WebElement> uploadedImage;

    @FindBy(how = How.XPATH, using = "//span[@class='fa fa-upload']")
    private WebElement tradeInUploadBtnIcon;

    @FindBy(how = How.XPATH, using = "//span[@class='fa fa-trash']")
    private WebElement tradeInRemoveBtnIcon;

    @FindBy(how = How.ID, using = "upload_image")
    private WebElement uploadBtnDiv;

    @FindBy(how = How.XPATH, using = "//div[@id='idBackCont']/img")
    private WebElement loadingImage;

    @FindBy(how = How.XPATH, using = "//div[@id='idBackCont']/font")
    private WebElement loadingText;

    @FindBy(how = How.XPATH, using = "(//div[@id='idBackRect']/div)[2]")
    private WebElement loadingBg;


    public FormsPage(WebDriver webDriver) {
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

    public boolean isVehicleInfoTitleDisplayed() {
        try {
            vehicleInfoTitle.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isCommentsTitleDisplayed() {
        try {
            commentsTitle.isDisplayed();
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

    public boolean isTradeInSubmitButtonDisplayed() {
        try {
            tradeInSubmitButton.isDisplayed();
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

    public boolean isVinInputDisplayed() {
        try {
            vinInput.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isYearSelectDisplayed() {
        try {
            yearSelect.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isMotorizedTypeaDisplayed() {
        try {
            motorizedTypeSelect.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isMakeSelectDisplayed() {
        try {
            makeSelect.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isModelSelectDisplayed() {
        try {
            modelSelect.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isTrimSelectDisplayed() {
        try {
            trimSelect.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isAskingPriceDisplayed() {
        try {
            askingPriceInput.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isOdometerInputDisplayed() {
        try {
            odometerInput.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isUploadPhotoTitleDisplayed() {
        try {
            uploadPhotoTitle.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isUploadButtonDisplayed() {
        try {
            uploadBtn.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isRemoveButtonDisplayed() {
        try {
            removeBtn.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isVinLabelDisplayed() {
        try {
            vinLabel.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isYearLabelDisplayed() {
        try {
            yearLabel.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isMotorTypeLabelDisplayed() {
        try {
            motorizedTypeLabel.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isMakeLabelDisplayed() {
        try {
            makeLabel.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isModelLabelDisplayed() {
        try {
            modelLabel.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isTrimLabelDisplayed() {
        try {
            trimLabel.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isAskingPriceLabelDisplayed() {
        try {
            askingPriceLabel.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isOdometerLabelDisplayed() {
        try {
            odometerLabel.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isFirstNameLabelDisplayed() {
        try {
            firstNameLabel.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isLastNameLabelDisplayed() {
        try {
            lastNameLabel.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isPhoneNumLabelDisplayed() {
        try {
            phoneNumLabel.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isEmailLabelDisplayed() {
        try {
            emailLabel.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isIntPhoneLabelDisplayed() {
        try {
            intPhoneLabel.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isTradeInUploadBtnIconDisplayed() {
        try {
            tradeInUploadBtnIcon.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isTradeInRemoveBtnIconDisplayed() {
        try {
            tradeInRemoveBtnIcon.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isTradeInFormInWidgetDisplayed() {
        try {
            formInWidget.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /*method click on button*/

    public void clickOnSubmit() {
        submitButton.click();
    }

    public void clickOnTradeInSubmit() {
        tradeInSubmitButton.click();
    }

    public void clickOKinPostForm() {
        postFormOkBtn.click();
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

    public String getVINInputBorderColor() {
        return vinInput.getCssValue("border-color");
    }

    public String getYearSelectBorderColor() {
        return yearSelect.getCssValue("border-color");
    }

    public String getAskingPriceInputBorderColor() {
        return askingPriceInput.getCssValue("border-color");
    }

    public String getOdometerInputBorderColor() {
        return odometerInput.getCssValue("border-color");
    }

    public String getMotorizedTypeSelectBorderColor() {
        return motorizedTypeSelect.getCssValue("border-color");
    }

    public String getMakeSelectBorderColor() {
        return makeSelect.getCssValue("border-color");
    }

    public String getModelSelectBorderColor() {
        return modelSelect.getCssValue("border-color");
    }

    public String getTrimSelectBorderColor() {
        return trimSelect.getCssValue("border-color");
    }

    /*methods for getting background color of elements*/

    public String getTradeInSubmitBtnBgColor() {
        return tradeInSubmitButton.getCssValue("background-color");
    }

    /*methods for getting class name of elements*/

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

    public String getWidgetClass() {return widget.getAttribute("class"); }

    public boolean getWidgetClassWow(String wowClass) {
        return widget.getAttribute("class").contains(wowClass);
    }

    public boolean getTradeInWidgetClassWow(String wowClass) { return tradeInWidget2.getAttribute("class").contains(wowClass);}

    public String getWidgetClassColor() {
        return widget2.getAttribute("class");
    }

    public String getTradeinWidgetClassColor() {
        return tradeInWidget.getAttribute("class");
    }

    public String getRecaptcha2CheckboxClass() {
        return reCaptcha2Checkbox.getAttribute("class");
    }

    public boolean getMotionCaptchaClass(String motionClass) { return motionCaptchaCanvas.getAttribute("class").contains(motionClass);}

    public String getVINInputClass() {
        return vinInput.getAttribute("class");
    }

    public String getYearSelectClass() {
        return yearSelect.getAttribute("class");
    }

    public String getAskingPriceInputClass() {
        return askingPriceInput.getAttribute("class");
    }

    public String getOdometerClass() {
        return odometerInput.getAttribute("class");
    }

    public String getTradeInSubmitBtnClass() {
        return tradeInSubmitButton.getAttribute("class");
    }

    public String getMotorizedTypeSelectClass() {
        return motorizedTypeSelect.getAttribute("class");
    }

    public String getMakeSelectClass() {
        return makeSelect.getAttribute("class");
    }

    public String getModelSelectClass() {
        return modelSelect.getAttribute("class");
    }

    public String getTrimSelectClass() {
        return trimSelect.getAttribute("class");
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

    public boolean isVINSelected() { return driver.switchTo().activeElement().equals(vinInput); }

    public boolean isYearSelected() {
        return driver.switchTo().activeElement().equals(yearSelect);
    }

    public boolean isAskingPriceSelected() {
        return driver.switchTo().activeElement().equals(askingPriceInput);
    }

    public boolean isOdometerSelected() {
        return driver.switchTo().activeElement().equals(odometerInput);
    }

    public boolean isMotorizedTypeSelected() {
        return driver.switchTo().activeElement().equals(motorizedTypeSelect);
    }

    public boolean isMakeSelected() {
        return driver.switchTo().activeElement().equals(makeSelect);
    }

    public boolean isModelSelected() {
        return driver.switchTo().activeElement().equals(modelSelect);
    }

    public boolean isTrimSelected() {
        return driver.switchTo().activeElement().equals(trimSelect);
    }

    /*methods for getting font-color of labels*/
    public String getFirstNameLabelFontColor() {
        return firstNameLabel.getCssValue("color");
    }

    public String getLastNameLabelFontColor() {
        return lastNameLabel.getCssValue("color");
    }

    public String getPhoneNumLabelFontColor() {
        return phoneNumLabel.getCssValue("color");
    }

    public String getEmailLabelFontColor() {
        return emailLabel.getCssValue("color");
    }

    public String getVINLabelFontColor() {
        return vinLabel.getCssValue("color");
    }

    public String getAskingPriceLabelFontColor() {
        return askingPriceLabel.getCssValue("color");
    }

    public String getOdometerLabelFontColor() {
        return odometerLabel.getCssValue("color");
    }

    public String getTradeInSubmitBtnFontColor() {
        return tradeInSubmitButton.getCssValue("color");
    }

    public String getMotorizedTypeLabelFontColor() {
        return motorizedTypeLabel.getCssValue("color");
    }

    public String getMakeLabelFontColor() {
        return makeLabel.getCssValue("color");
    }

    public String getModelLabelFontColor() {
        return modelLabel.getCssValue("color");
    }

    public String getTrimLabelFontColor() {
        return trimLabel.getCssValue("color");
    }


    /*methods for filling inputs with some values*/

    public void fillFirstName() {
        firstNameInput.clear();
        firstNameInput.sendKeys("John");
    }

    public void fillFirstNameVar(String name) {
        firstNameInput.clear();
        firstNameInput.sendKeys(name);
    }

    public void fillLastName() {
        lastNameInput.clear();
        lastNameInput.sendKeys("Smith");
    }

    public void fillLastNameVar(String name) {
        lastNameInput.clear();
        lastNameInput.sendKeys(name);
    }

    public void fillPhoneNum() {
        phoneNumInput.clear();
        phoneNumInput.sendKeys("9587123698");
    }

    public void fillPhoneNum1() {
        phoneNumInput.clear();
        phoneNumInput.sendKeys(PropertyLoader.loadProperty("phoneL1"));
    }

    public void fillPhoneNumVar(String phone) {
        phoneNumInput.clear();
        phoneNumInput.sendKeys(phone);
    }

    public void fillEmail() {
        emailInput.clear();
        emailInput.sendKeys("test_2@dxloo.com");
    }

    public void fillEmail2() {
        emailInput.clear();
        emailInput.sendKeys(PropertyLoader.loadProperty("Email1"));
    }

    public void fillEmailVar(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
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

    public void fillCommentsVar(String comment) {
        commentTextArea.clear();
        commentTextArea.sendKeys(comment);
    }

    public void fillIntPhoneVar(String intPhone) {
        intPhoneInput.clear();
        intPhoneInput.sendKeys(intPhone);
    }

    public void fillVINVar(String vin) {
        vinInput.clear();
        vinInput.sendKeys(vin);
    }

    public void fillAskPriceVar(String price) {
        askingPriceInput.clear();
        askingPriceInput.sendKeys(price);
    }

    public void fillOdometerVar(String odometer) {
        odometerInput.clear();
        odometerInput.sendKeys(odometer);
    }

    /*Select values in selects*/

    public void selectYear(String year){
        WebElement select = yearSelect;
        Select options = new Select(select);
        options.selectByVisibleText(year);
    }

    public void selectMotorizedType(String motorizedType) {
        WebElement select = motorizedTypeSelect;
        Select options = new Select(select);
        options.selectByVisibleText(motorizedType);
    }

    public void selectMakeByText(String make) {
        WebElement select = makeSelect;
        Select options = new Select(select);
        options.selectByVisibleText(make);
    }

    public void selectMakeByIndex(int index) {
        WebElement select = makeSelect;
        Select options = new Select(select);
        try {
            options.selectByIndex(index);
        } catch (NoSuchElementException ex) {
            options.selectByIndex(0);
            LOG.info("No makes in the list");
        }
    }

    public void selectModelByText(String model) {
        WebElement select = modelSelect;
        Select options = new Select(select);
        options.selectByVisibleText(model);
    }

    public void selectModelByIndex(int index) {
        WebElement select = modelSelect;
        Select options = new Select(select);
        try {
            options.selectByIndex(index);
        } catch (NoSuchElementException ex) {
            options.selectByIndex(0);
            LOG.info("No makes in the list");
        }
    }

    public void selectTrimByText(String trim) {
        WebElement select = trimSelect;
        Select options = new Select(select);
        options.selectByVisibleText(trim);
    }

    public void selectTrimByIndex(int index) {
        WebElement select = trimSelect;
        Select options = new Select(select);
        options.selectByIndex(index);
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

    public boolean isTradeInWidgetExists() {
        try {
            tradeInWidget2.isDisplayed();
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

    public String vinGetValue() {
        return vinInput.getAttribute("value");
    }

    public String odometerGetValue() {
        return odometerInput.getAttribute("value");
    }

    public String firstNameGetValue() {
        return firstNameInput.getAttribute("value");
    }

    public String lastNameGetValue() {
        return lastNameInput.getAttribute("value");
    }

    public String phoneNumGetValue() {
        return phoneNumInput.getAttribute("value");
    }

    public String emailGetValue() {
        return emailInput.getAttribute("value");
    }

    public String askingPriceGetValue() {
        return askingPriceInput.getAttribute("value");
    }


    /*Get text from elements*/
    public String postFormGetText() {
        return postForm.getText();
    }

    public String getWidgetTitleText() {
        return widgetTitle.getText();
    }

    public String getUploadPhotoText() {
        return uploadPhotoText.getText();
    }

    public void clickRecaptcha2() {
        reCaptcha2Frame.click();
    }

    public String getMotionCaptchaText() {
        return motionCaptchaText.getText();
    }

    public String getYearLabelText() {
        return yearLabel.getText();
    }

    public String getAskingPriceLabelText() {
        return askingPriceLabel.getText();
    }

    public String getOdometerLabelText() {
        return odometerLabel.getText();
    }

    public String getMotorizedTypeLabelText() {
        return motorizedTypeLabel.getText();
    }

    public String getMakeLabelText() {
        return makeLabel.getText();
    }

    public String getModelrLabelText() {
        return modelLabel.getText();
    }

    public String getTrimLabelText() {
        return trimLabel.getText();
    }

    /*Methods for getting text of other elements*/

    public String getTradeInSubmitBtnText() {
        return tradeInSubmitButton.getText();
    }

    /*Methods for getting selected option of select*/

    public String getYearSelectValue() {
        WebElement select = yearSelect;
        Select options = new Select(select);
        WebElement selectedOption = options.getFirstSelectedOption();
        return selectedOption.getText();
    }

    public String getMotorizedTypeSelectValue() {
        WebElement select = motorizedTypeSelect;
        Select options = new Select(select);
        WebElement selectedOption = options.getFirstSelectedOption();
        return selectedOption.getText();
    }

    public String getMakeSelectValue() {
        WebElement select = makeSelect;
        Select options = new Select(select);
        WebElement selectedOption = options.getFirstSelectedOption();
        return selectedOption.getText();
    }

    public String getModelSelectValue() {
        WebElement select = modelSelect;
        Select options = new Select(select);
        WebElement selectedOption = options.getFirstSelectedOption();
        return selectedOption.getText();
    }

    public String getTrimSelectValue() {
        WebElement select = trimSelect;
        Select options = new Select(select);
        WebElement selectedOption = options.getFirstSelectedOption();
        return selectedOption.getText();
    }

    /*methods for getting all options from select*/

    public List<WebElement> getYearSelectOptions() {
        WebElement select = yearSelect;
        Select options = new Select(select);
        List<WebElement> allOptions = options.getOptions();
        return allOptions;
    }

    public List<WebElement> getMotorizedTypeSelectOptions() {
        WebElement select = motorizedTypeSelect;
        Select options = new Select(select);
        List<WebElement> allOptionsMotorizedType = options.getOptions();
        return allOptionsMotorizedType;
    }

    public List<String> getMotorizedTypeSelectOptionsManually() {
        List<String> motorizedTypeList = Arrays.asList("Select Motorized Type", "AGRICULTURAL EQUIPMENT", "AIRCRAFT", "ATVs", "BOAT", "CARS & TRUCKS & VANS", "COMMERCIAL TRUCKS", "CONSTRUCTION EQUIPMENT", "DISMANTLED MACHINE", "GO KARTS & SCOOTERS", "LIGHT TRUCK", "MILITARY VEHICLES", "MOTORCYCLE", "OTHER", "PWC/ATV", "RVs & CAMPERS", "SAVING PLANS (CARS)", "SNOWMOBILES", "TRAILERS");
        return motorizedTypeList;
    }

    public List<WebElement> getMakeSelectOptions() {
        WebElement select = makeSelect;
        Select options = new Select(select);
        List<WebElement> allOptionsMake = options.getOptions();
        return allOptionsMake;
    }

    public List<WebElement> getModelSelectOptions() {
        WebElement select = modelSelect;
        Select options = new Select(select);
        List<WebElement> allOptionsModel = options.getOptions();
        return allOptionsModel;
    }

    public List<WebElement> getTrimSelectOptions() {
        WebElement select = trimSelect;
        Select options = new Select(select);
        List<WebElement> allOptionsTrim = options.getOptions();
        return allOptionsTrim;
    }

    /*methods for moving mouse on element*/

    public void moveMouseToTradeInSubmitBtn() {
        Actions action = new Actions(driver);
        Action moveToElem = action.moveToElement(tradeInSubmitButton).build();
        moveToElem.perform();
    }

    /*Methods for click in input*/

    public void clickAskingPriceInput(){askingPriceInput.click();}

    public void clickOdometerInput() {
        odometerInput.click();
    }

    public boolean isTradeInSubmitHasCheckMark() {
        try {
            tradeInSubmitBtnCheckMark.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /*if element is enable*/

    public boolean isTradeInSubmitBtnEnabled() {
        return tradeInSubmitButton.isEnabled();
    }

    public boolean isMotorizedTypeSelectEnabled() {
        return motorizedTypeSelect.isEnabled();
    }

    public boolean isYearSelectEnabled() {
        return yearSelect.isEnabled();
    }

    public boolean isMakeSelectEnabled() {
        return makeSelect.isEnabled();
    }

    public boolean isModelSelectEnabled() {
        return modelSelect.isEnabled();
    }

    public boolean isTrimSelectEnabled() {
        return trimSelect.isEnabled();
    }

    public boolean isUploadBtnDisabled() {
        return uploadBtnDiv.getAttribute("class").contains("disabled");
    }

    public boolean isRemoveBtnDisabled() {
        return removeBtn.getAttribute("class").contains("disabled");
    }

    /*get cursor kind in element*/

    public String getTradeInSubmitBtnCursorKind() {
        return tradeInSubmitButton.getCssValue("cursor");
    }

    /*number of elements*/
    public int getAstericsInputNumber() {
        return astericsInputList.size();
    }

    /*methods for working with upload file*/

    public void addImageToTradeIn(String path) {
        uploadBtn.sendKeys(path);
    }

    public boolean uploadSuccessTextDisplayed() {
        try {
            uploadSuccessText.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public int getUploadImagesNumber() {
        try {
            return uploadedImage.size();
        } catch (NoSuchElementException ex) {
            return 0;
        }
    }

    public void tradeInClickOnImage(int index) {
        uploadedImage.get(index).click();
    }

    public void clickRemoveBtn() {
        removeBtn.click();
    }

/*get loading properties*/

    public String getLoadingDWSText() {
        return loadingText.getText();
    }

    public boolean isLoadingImgExists() {
        try {
            loadingImage.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public String getLoadingBg() {
        try {
            return loadingBg.getCssValue("background-image");
        } catch (NoSuchElementException ex) {
            return "No loading background found";
        }
    }

}


