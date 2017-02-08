/*dms Localization page*/
package settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import page.Page;

/**
 * Created by Julia on 11.01.2017.
 */
public class Localization extends Page {
    public Localization(WebDriver webDriver) {
        super(webDriver);
    }

    /*declare elements on the page*/
    @FindBy(how = How.XPATH, using = "//tr[@id='localization_phone_validata']//a[@class='button-style b_edit notranslate']")
    private WebElement forceValidEditBtn;

    @FindBy(how = How.XPATH, using = "//tr[@id='localization_phone_validata']//a[@class='button-style b_save']")
    private WebElement forceValidSaveBtn;

    @FindBy(how = How.XPATH, using = "//tr[@id='localization_phone_validata']//a[@class='button-style b_close']")
    private WebElement forceValidCancelBtn;

    @FindBy(how = How.XPATH, using = "//tr[@id='localization_phone_validata']//input[@value='0']")
    private WebElement activeCheckbox;

    @FindBy(how = How.XPATH, using = "//tr[@id='localization_phone_validata']//input[@value='1']")
    private WebElement inactiveCheckbox;

    @FindBy(how = How.XPATH, using = "//tr[@id='localization_phone_mask_input']//a[@class='button-style b_edit notranslate']")
    private WebElement phoneInputMaskEditBtn;

    @FindBy(how = How.XPATH, using = "//tr[@id='localization_phone_mask_input']//a[@class='button-style b_save']")
    private WebElement phoneInputMaskSaveBtn;

    @FindBy(how = How.XPATH, using = "//tr[@id='localization_phone_mask_input']//a[@class='button-style b_close']")
    private WebElement phoneInputMaskCancelBtn;

    @FindBy(how = How.XPATH, using = "//tr[@id='localization_phone_mask_input']//input")
    private WebElement phoneInputMask;

    @FindBy(how = How.XPATH, using = "//tr[@id='localization_website_characters']//a[@class='button-style b_edit notranslate']")
    private WebElement minNumZipEditBtn;

    @FindBy(how = How.XPATH, using = "//tr[@id='localization_website_characters']//select[@id='characters_website']")
    private WebElement minNumZipSelect;

    @FindBy(how = How.XPATH, using = "//tr[@id='localization_website_characters']//a[@class='button-style b_save']")
    private WebElement minNumZipSaveBtn;

    @FindBy(how = How.XPATH, using = "//tr[@id='localization_zipcode_system']//a[@class='button-style b_edit notranslate']")
    private WebElement letterZipEditBtn;

    @FindBy(how = How.XPATH, using = "//tr[@id='localization_zipcode_system']//a[@class='button-style b_save']")
    private WebElement letterZipSaveBtn;

    @FindBy(how = How.XPATH, using = "//tr[@id='localization_zipcode_system']//input[@value='0']")
    private WebElement zipNumRadio;

    @FindBy(how = How.XPATH, using = "//tr[@id='localization_zipcode_system']//input[@value='1']")
    private WebElement zipCharNumRadio;

    /*turn on Force Validation setting*/
    public void turnOnForceValid() {
        forceValidEditBtn.click();
        activeCheckbox.click();
        forceValidSaveBtn.click();
    }

    /*turn off Force Validation setting*/
    public void turnOffForceValid() {
        forceValidEditBtn.click();
        inactiveCheckbox.click();
        forceValidSaveBtn.click();
    }

    /*fill Phone Input Mask with all numbers (3-3-3)*/
    public void fillInputMaskNum1() {
        phoneInputMaskEditBtn.click();
        phoneInputMask.clear();
        phoneInputMask.sendKeys("999 999 999");
        phoneInputMaskSaveBtn.click();
    }

    /*fill Phone Input Mask with all numbers (4-5-6)*/
    public void fillInputMaskNum2() {
        phoneInputMaskEditBtn.click();
        phoneInputMask.sendKeys("9999 99999 999999");
        phoneInputMaskSaveBtn.click();
    }

    /*fill Phone Input Mask with all letters (3-3-3)*/
    public void fillInputMaskLet1() {
        phoneInputMaskEditBtn.click();
        phoneInputMask.clear();
        phoneInputMask.sendKeys("aaa aaa aaa");
        phoneInputMaskSaveBtn.click();
    }

    /*fill Phone Input Mask with all letters (4-5-6)*/
    public void fillInputMaskLet2() {
        phoneInputMaskEditBtn.click();
        phoneInputMask.clear();
        phoneInputMask.sendKeys("aaaa aaaaa aaaaaa");
        phoneInputMaskSaveBtn.click();
    }

    /*fill Phone Input Mask with all stars (3-3-3)*/
    public void fillInputMaskStar1() {
        phoneInputMaskEditBtn.click();
        phoneInputMask.clear();
        phoneInputMask.sendKeys("*** *** ***");
        phoneInputMaskSaveBtn.click();
    }

    /*fill Phone Input Mask with all stars (4-5-6)*/
    public void fillInputMaskStar2() {
        phoneInputMaskEditBtn.click();
        phoneInputMask.clear();
        phoneInputMask.sendKeys("**** ***** ******");
        phoneInputMaskSaveBtn.click();
    }

    /*fill Phone Input Mask with number-letter-star (3-3-3)*/
    public void fillInputMaskNLS1() {
        phoneInputMaskEditBtn.click();
        phoneInputMask.clear();
        phoneInputMask.sendKeys("999 aaa *** ");
        phoneInputMaskSaveBtn.click();
    }

    /*fill Phone Input Mask with number-letter-star (4-5-6)*/
    public void fillInputMaskNLS2() {
        phoneInputMaskEditBtn.click();
        phoneInputMask.clear();
        phoneInputMask.sendKeys("9999 aaaaa ****** ");
        phoneInputMaskSaveBtn.click();
    }

    /*fill Phone Input Mask with letter-star-number (3-3-3)*/
    public void fillInputMaskLSN1() {
        phoneInputMaskEditBtn.click();
        phoneInputMask.clear();
        phoneInputMask.sendKeys("aaa *** 999 ");
        phoneInputMaskSaveBtn.click();
    }

    /*fill Phone Input Mask with letter-star-number (4-5-6)*/
    public void fillInputMaskLSN2() {
        phoneInputMaskEditBtn.click();
        phoneInputMask.clear();
        phoneInputMask.sendKeys("aaaa ***** 999999 ");
        phoneInputMaskSaveBtn.click();
    }

    /*fill Phone Input Mask with mixed chars (3-3-3)(9a* *9a a*9)*/
    public void fillInputMaskMix1() {
        phoneInputMaskEditBtn.click();
        phoneInputMask.clear();
        phoneInputMask.sendKeys("9a* *9a a*9");
        phoneInputMaskSaveBtn.click();
    }

    /*fill Phone Input Mask with mixed chars (4-5-6)(9a*9 *9a*9 a*9a*9)*/
    public void fillInputMaskMix2() {
        phoneInputMaskEditBtn.click();
        phoneInputMask.clear();
        phoneInputMask.sendKeys("9a*9 *9a*9 a*9a*9");
        phoneInputMaskSaveBtn.click();
    }

    /*Select MIN number of characters in ZIP Codes - 3*/
    public void setMinZip3() {
        minNumZipEditBtn.click();
        WebElement select = minNumZipSelect;
        Select options = new Select(select);
        options.selectByValue("36");
        minNumZipSaveBtn.click();
    }

    /*Select MIN number of characters in ZIP Codes - 4*/
    public void setMinZip4() {
        minNumZipEditBtn.click();
        WebElement select = minNumZipSelect;
        Select options = new Select(select);
        options.selectByValue("46");
        minNumZipSaveBtn.click();
    }

    /*Select MIN number of characters in ZIP Codes - 5*/
    public void setMinZip5() {
        minNumZipEditBtn.click();
        WebElement select = minNumZipSelect;
        Select options = new Select(select);
        options.selectByValue("56");
        minNumZipSaveBtn.click();
    }

    /*Select MIN number of characters in ZIP Codes - 6*/
    public void setMinZip6() {
        minNumZipEditBtn.click();
        WebElement select = minNumZipSelect;
        Select options = new Select(select);
        options.selectByValue("66");
        minNumZipSaveBtn.click();
    }

    /*Select Allow Letters in ZIP Codes - Numbers*/
    public void allowNumZip() {
        letterZipEditBtn.click();
        zipNumRadio.click();
        letterZipSaveBtn.click();
    }

    /*Select Allow Letters in ZIP Codes - Characters and Numbers*/
    public void allowCharNumZip() {
        letterZipEditBtn.click();
        zipCharNumRadio.click();
        letterZipSaveBtn.click();
    }

    //MIN number of characters in ZIP Codes button is active
    public boolean isZipMinNumButtonActive() {
        return minNumZipEditBtn.isEnabled();
    }

    public ExpectedCondition<WebElement> isLetterZipEditBtnVisible() {
        return ExpectedConditions.visibilityOf(letterZipEditBtn);
    }

    public ExpectedCondition<WebElement> isMinNumZipEditBtnVisible() {
        return ExpectedConditions.visibilityOf(minNumZipEditBtn);
    }

    public ExpectedCondition<WebElement> isPhoneInputMaskEditBtnVisible() {
        return ExpectedConditions.visibilityOf(phoneInputMaskEditBtn);
    }
}
