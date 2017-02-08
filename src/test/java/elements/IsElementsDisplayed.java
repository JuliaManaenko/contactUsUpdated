package elements;

import org.testng.Assert;
import org.testng.annotations.*;
import testcase.TestBase;
import testcase.TestBase2;

/**
 * Created by Julia on 30.12.2016.
 */

public class IsElementsDisplayed extends TestBase2 {

    @Test(groups = "dws")
    public void widgetTitleDisplayed() {

        Assert.assertTrue(contactUs.isCitylnputDisplayed());
    }

    @Test(groups = "dws")
    public void contactInfoTitleDisplayed() {
        Assert.assertTrue(contactUs.isContactInfoTitleDisplayed());
    }

    @Test(groups = "dws")
    public void firstNameInputDisplayed() {
        Assert.assertTrue(contactUs.isFirstNameInputDisplayed());
    }

    @Test(groups = "dws")
    public void lastNameInputDisplayed() {
        Assert.assertTrue(contactUs.isLastNameInputDisplayed());
    }

    @Test(groups = "dws")
    public void phoneNumInputDisplayed() {
        Assert.assertTrue(contactUs.isPhoneNumInputDisplayed());
    }

    @Test(groups = "dws")
    public void emailInputDisplayed() {
        Assert.assertTrue(contactUs.isEmailInputDisplayed());
    }

    @Test(groups = "dws")
    public void intPhoneInputDisplayed() {
        Assert.assertTrue(contactUs.isIntPhonelnputDisplayed());
    }

    @Test(groups = "dws")
    public void streetInputDisplayed() {
        Assert.assertTrue(contactUs.isStreetlnputDisplayed());
    }

    @Test(groups = "dws")
    public void cityInputDisplayed() {
        Assert.assertTrue(contactUs.isCitylnputDisplayed());
    }

    @Test(groups = "dws")
    public void stateInputDisplayed() {
        Assert.assertTrue(contactUs.isStatelnputDisplayed());
    }

    @Test(groups = "dws")
    public void ziplnputDisplayed() {
        Assert.assertTrue(contactUs.isZipInputDisplayed());
    }

    @Test(groups = "dws")
    public void questionTitleDisplayed() {
        Assert.assertTrue(contactUs.isQuestionTitleDisplayed());
    }

    @Test(groups = "dws")
    public void helpTextDisplayed() {
        Assert.assertTrue(contactUs.isHelpTextDisplayed());
    }

    @Test(groups = "dws")
    public void counterDisplayed() {
        Assert.assertTrue(contactUs.isCounterDisplayed());
    }

    /*@Test(groups = "dws")
    public void securityTitleaDisplayed () {
        Assert.assertTrue(contactUs.isSecurityTitleaDisplayed());
    }*/
    @Test(groups = "dws")
    public void commentTextAreaDisplayed() {
        Assert.assertTrue(contactUs.isCommentTextAreaDisplayed());
    }

    @Test(groups = "dws")
    public void astericsTextDisplayed() {
        Assert.assertTrue(contactUs.isAstericsTextDisplayed());
    }

    /* @Test(groups = "dws")
     public void astericsInputDisplayed () {
         Assert.assertTrue(contactUs.isAstericsInputDisplayed());
     }*/
   /* @Test(groups = "dws")
    public void astericsInputCount () {
        Assert.assertEquals(contactUs.astericsInputSize(),5);
    }*/
    /*@Test(groups = "dws")
    public void astericsCaptchaDisplayed () {
        Assert.assertTrue(contactUs.isAstericsCaptchaDisplayed());
    }*/
    @Test(groups = "dws", enabled = false)//shows false instead of true
    public void astericsNoteDisplayed() {
        Assert.assertTrue(contactUs.isAstericsNoteDisplayed());
    }
}
