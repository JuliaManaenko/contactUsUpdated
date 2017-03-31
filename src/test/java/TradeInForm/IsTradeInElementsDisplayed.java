package TradeInForm;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Julia on 14.02.2017.
 */
public class IsTradeInElementsDisplayed extends TradeInTestBase2 {

    @Test
    public void tradeInTitleDisplayed(){
        Assert.assertTrue(tradeIn.isWidgetTitleDisplayed());
    }

    @Test
    public void tradeInVehicleInfoTitleDisplayed(){
        Assert.assertTrue(tradeIn.isVehicleInfoTitleDisplayed());
    }

    @Test
    public void tradeInVinInputDisplayed(){
        Assert.assertTrue(tradeIn.isVinInputDisplayed());
    }

    @Test
    public void tradeInYearSelectDisplayed(){
        Assert.assertTrue(tradeIn.isYearSelectDisplayed());
    }

    @Test
    public void tradeInMotorTypeSelectDisplayed(){
        Assert.assertTrue(tradeIn.isMotorizedTypeaDisplayed());
    }

    @Test
    public void tradeInMakeSelectDisplayed(){
        Assert.assertTrue(tradeIn.isMakeSelectDisplayed());
    }

    @Test
    public void tradeInModelSelectDisplayed(){
        Assert.assertTrue(tradeIn.isModelSelectDisplayed());
    }

    @Test
    public void tradeInTrimSelectDisplayed(){
        Assert.assertTrue(tradeIn.isTrimSelectDisplayed());
    }

    @Test
    public void tradeInAskingPriceInputDisplayed(){
        Assert.assertTrue(tradeIn.isAskingPriceDisplayed());
    }

    @Test
    public void tradeInOdometerInputDisplayed(){
        Assert.assertTrue(tradeIn.isOdometerInputDisplayed());
    }

    @Test
    public void tradeInContactInfoTitleDisplayed(){
        Assert.assertTrue(tradeIn.isContactInfoTitleDisplayed());
    }

    @Test
    public void tradeInFirstNameDisplayed(){
        Assert.assertTrue(tradeIn.isFirstNameInputDisplayed());
    }

    @Test
    public void tradeInLastNameInputDisplayed(){
        Assert.assertTrue(tradeIn.isLastNameInputDisplayed());
    }

    @Test
    public void tradeInPhoneNumInputDisplayed(){
        Assert.assertTrue(tradeIn.isLastNameInputDisplayed());
    }

    @Test
    public void tradeInEmailInputDisplayed(){
        Assert.assertTrue(tradeIn.isEmailInputDisplayed());
    }

    @Test
    public void tradeInIntPhoneNumInputDisplayed(){
        Assert.assertTrue(tradeIn.isIntPhonelnputDisplayed());
    }

    @Test
    public void tradeInCommentsTitleDisplayed(){
        Assert.assertTrue(tradeIn.isCommentsTitleDisplayed());
    }

    @Test
    public void tradeInCounterDisplayed(){
        Assert.assertTrue(tradeIn.isCounterDisplayed());
    }

    @Test
    public void tradeInCommentsTextAreaDisplayed(){
        Assert.assertTrue(tradeIn.isCommentTextAreaDisplayed());
    }

    @Test
    public void tradeInUploadPhotoTitleDisplayed(){
        Assert.assertTrue(tradeIn.isUploadPhotoTitleDisplayed());
    }

    @Test
    public void tradeInUploadPhotoBtnDisplayed(){
        Assert.assertTrue(tradeIn.isUploadButtonDisplayed());
    }

    @Test
    public void tradeInRemoveBtnDisplayed(){
        Assert.assertTrue(tradeIn.isRemoveButtonDisplayed());
    }

    @Test
    public void tradeInUploadPhotoTextDisplayed(){
        Assert.assertEquals(tradeIn.getUploadPhotoText(), "* Image file size should not exceed 1 MB\n" +
                "* Image file types to be *.jpeg; *.jpg; *.png; *.gif");
    }

    @Test
    public void tradeInAstericsTextDisplayed(){
        Assert.assertTrue(tradeIn.isAstericsTextDisplayed());
    }

    @Test
    public void tradeInSubmitButtonDisplayed(){
        Assert.assertTrue(tradeIn.isTradeInSubmitButtonDisplayed());
    }

    @Test
    public void tradeInVinLabelDisplayed(){
        Assert.assertTrue(tradeIn.isVinLabelDisplayed());
    }

    @Test
    public void tradeInYearLabelDisplayed(){
        Assert.assertTrue(tradeIn.isYearLabelDisplayed());
    }

    @Test
    public void tradeInMotorizedTypeLabelDisplayed(){ Assert.assertTrue(tradeIn.isMotorTypeLabelDisplayed()); }

    @Test
    public void tradeInMakeLabelDisplayed(){
        Assert.assertTrue(tradeIn.isMakeLabelDisplayed());
    }

    @Test
    public void tradeInModelLabelDisplayed(){
        Assert.assertTrue(tradeIn.isModelLabelDisplayed());
    }

    @Test
    public void tradeInTrimLabelDisplayed(){
        Assert.assertTrue(tradeIn.isTrimLabelDisplayed());
    }

    @Test
    public void tradeInAskingPriceLabelDisplayed(){ Assert.assertTrue(tradeIn.isAskingPriceLabelDisplayed()); }

    @Test
    public void tradeInOdometerLabelDisplayed(){
        Assert.assertTrue(tradeIn.isOdometerLabelDisplayed());
    }

    @Test
    public void tradeInFirstNameLabelDisplayed(){
        Assert.assertTrue(tradeIn.isFirstNameLabelDisplayed());
    }

    @Test
    public void tradeInLastNameLabelDisplayed(){
        Assert.assertTrue(tradeIn.isLastNameLabelDisplayed());
    }

    @Test
    public void tradeInPhoneNumLabelDisplayed(){
        Assert.assertTrue(tradeIn.isPhoneNumLabelDisplayed());
    }

    @Test
    public void tradeInEmailLabelDisplayed(){
        Assert.assertTrue(tradeIn.isEmailLabelDisplayed());
    }

    @Test
    public void tradeInIntPhoneLabelDisplayed() {
        Assert.assertTrue(tradeIn.isIntPhoneLabelDisplayed());
    }

    @Test
    public void tradeInAstericsInputNumberIs4() {
        Assert.assertEquals(tradeIn.getAstericsInputNumber(), 4);
    }
}
