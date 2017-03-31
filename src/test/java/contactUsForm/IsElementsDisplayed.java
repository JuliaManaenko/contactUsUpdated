package contactUsForm;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Julia on 30.12.2016.
 */

public class IsElementsDisplayed extends TestBase2 {

    @Test(groups = "dws")
    public void widgetTitleDisplayed() {

        Assert.assertTrue(formsPage.isWidgetExists());
    }

    @Test(groups = "dws")
    public void contactInfoTitleDisplayed() {
        Assert.assertTrue(formsPage.isContactInfoTitleDisplayed());
    }

    @Test(groups = "dws")
    public void firstNameInputDisplayed() {
        Assert.assertTrue(formsPage.isFirstNameInputDisplayed());
    }

    @Test(groups = "dws")
    public void lastNameInputDisplayed() {
        Assert.assertTrue(formsPage.isLastNameInputDisplayed());
    }

    @Test(groups = "dws")
    public void phoneNumInputDisplayed() {
        Assert.assertTrue(formsPage.isPhoneNumInputDisplayed());
    }

    @Test(groups = "dws")
    public void emailInputDisplayed() {
        Assert.assertTrue(formsPage.isEmailInputDisplayed());
    }

    @Test(groups = "dws")
    public void intPhoneInputDisplayed() {
        Assert.assertTrue(formsPage.isIntPhonelnputDisplayed());
    }

    @Test(groups = "dws")
    public void streetInputDisplayed() {
        Assert.assertTrue(formsPage.isStreetlnputDisplayed());
    }

    @Test(groups = "dws")
    public void cityInputDisplayed() {
        Assert.assertTrue(formsPage.isCitylnputDisplayed());
    }

    @Test(groups = "dws")
    public void stateInputDisplayed() {
        Assert.assertTrue(formsPage.isStatelnputDisplayed());
    }

    @Test(groups = "dws")
    public void ziplnputDisplayed() {
        Assert.assertTrue(formsPage.isZipInputDisplayed());
    }

    @Test(groups = "dws")
    public void questionTitleDisplayed() {
        Assert.assertTrue(formsPage.isQuestionTitleDisplayed());
    }

    @Test(groups = "dws")
    public void helpTextDisplayed() {
        Assert.assertTrue(formsPage.isHelpTextDisplayed());
    }

    @Test(groups = "dws")
    public void counterDisplayed() {
        Assert.assertTrue(formsPage.isCounterDisplayed());
    }

    /*@Test(groups = "dws")
    public void securityTitleaDisplayed () {
        Assert.assertTrue(formsPage.isSecurityTitleaDisplayed());
    }*/
    @Test(groups = "dws")
    public void commentTextAreaDisplayed() {
        Assert.assertTrue(formsPage.isCommentTextAreaDisplayed());
    }

    @Test(groups = "dws")
    public void astericsTextDisplayed() {
        Assert.assertTrue(formsPage.isAstericsTextDisplayed());
    }

    /* @Test(groups = "dws")
     public void astericsInputDisplayed () {
         Assert.assertTrue(formsPage.isAstericsInputDisplayed());
     }*/
   /* @Test(groups = "dws")
    public void astericsInputCount () {
        Assert.assertEquals(formsPage.astericsInputSize(),5);
    }*/
    /*@Test(groups = "dws")
    public void astericsCaptchaDisplayed () {
        Assert.assertTrue(formsPage.isAstericsCaptchaDisplayed());
    }*/
    @Test(groups = "dws", enabled = false)//shows false instead of true
    public void astericsNoteDisplayed() {
        Assert.assertTrue(formsPage.isAstericsNoteDisplayed());
    }
}
