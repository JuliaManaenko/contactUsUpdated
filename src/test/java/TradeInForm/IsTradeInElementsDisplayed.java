package TradeInForm;

import org.testng.Assert;
import org.testng.annotations.Test;
import testcase.TradeInTestBase2;

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
}
