package dataProviders;

import org.testng.annotations.DataProvider;
import utility.PropertyLoader;

/**
 * Created by Julia on 14.02.2017.
 */
public class DataProviderSet1 {

    @DataProvider(name = "wows1")
    public static Object[][] getWow() {
        return new Object[][]{/*{PropertyLoader.loadProperty("animValueDisabled"),PropertyLoader.loadProperty("animValueDisabled2")},*/
                {PropertyLoader.loadProperty("animValueBounceIn"),PropertyLoader.loadProperty("animValueBounceIn2")},
                {PropertyLoader.loadProperty("animValueBounceInDown"), PropertyLoader.loadProperty("animValueBounceInDown2")},
                {PropertyLoader.loadProperty("animValueBounceInLeft"), PropertyLoader.loadProperty("animValueBounceInLeft2")},
                {PropertyLoader.loadProperty("animValueBounceInRight"), PropertyLoader.loadProperty("animValueBounceInRight2")},
                {PropertyLoader.loadProperty("animValueFadeIn"), PropertyLoader.loadProperty("animValueFadeIn2")},
                {PropertyLoader.loadProperty("animValueFadeInDown"), PropertyLoader.loadProperty("animValueFadeInDown2")},
                {PropertyLoader.loadProperty("animValueFadeInDownBig"), PropertyLoader.loadProperty("animValueFadeInDownBig2")},
                {PropertyLoader.loadProperty("animValueFadeInLeft"), PropertyLoader.loadProperty("animValueFadeInLeft2")},
                {PropertyLoader.loadProperty("animValueFadeInLeftBig"), PropertyLoader.loadProperty("animValueFadeInLeftBig2")},
                {PropertyLoader.loadProperty("animValueFadeInRight"), PropertyLoader.loadProperty("animValueFadeInRight2")},
                {PropertyLoader.loadProperty("animValueFadeInRightBig"), PropertyLoader.loadProperty("animValueFadeInRightBig2")},
                {PropertyLoader.loadProperty("animValueFadeInUp"), PropertyLoader.loadProperty("animValueFadeInUp2")},
                {PropertyLoader.loadProperty("animValueFadeInUpBig"), PropertyLoader.loadProperty("animValueFadeInUpBig2")},
                {PropertyLoader.loadProperty("animValueFlipInX"), PropertyLoader.loadProperty("animValueFlipInX2")},
                {PropertyLoader.loadProperty("animValueFlipInY"), PropertyLoader.loadProperty("animValueFlipInY2")},
                {PropertyLoader.loadProperty("animValueLightSpeedIn"), PropertyLoader.loadProperty("animValueLightSpeedIn2")},
                {PropertyLoader.loadProperty("animValueRotateIn"), PropertyLoader.loadProperty("animValueRotateIn2")},
                {PropertyLoader.loadProperty("animValueRotateInDownLeft"), PropertyLoader.loadProperty("animValueRotateInDownLeft2")},
                {PropertyLoader.loadProperty("animValueRotateInDownRight"), PropertyLoader.loadProperty("animValueRotateInDownRight2")},
                {PropertyLoader.loadProperty("animValueRotateInUpLeft"), PropertyLoader.loadProperty("animValueRotateInUpLeft2")},
                {PropertyLoader.loadProperty("animValueRotateInUpRight"), PropertyLoader.loadProperty("animValueRotateInUpRight2")},
                {PropertyLoader.loadProperty("animValueRollIn"), PropertyLoader.loadProperty("animValueRollIn2")}};
    }

    @DataProvider(name = "wows2")
    public static Object[][] getWow2() {
        return new Object[][]{{PropertyLoader.loadProperty("animValueDisabled"), PropertyLoader.loadProperty("animClassDisabled")},
                {PropertyLoader.loadProperty("animValueBounceIn"), PropertyLoader.loadProperty("animClassBounceIn")},
                {PropertyLoader.loadProperty("animValueBounceInDown"), PropertyLoader.loadProperty("animClassBounceInDown")},
                {PropertyLoader.loadProperty("animValueBounceInLeft"), PropertyLoader.loadProperty("animClassBounceInLeft")},
                {PropertyLoader.loadProperty("animValueBounceInRight"), PropertyLoader.loadProperty("animClassBounceInRight")},
                {PropertyLoader.loadProperty("animValueFadeIn"), PropertyLoader.loadProperty("animClassFadeIn")},
                {PropertyLoader.loadProperty("animValueFadeInDown"), PropertyLoader.loadProperty("animClassFadeInDown")},
                {PropertyLoader.loadProperty("animValueFadeInDownBig"), PropertyLoader.loadProperty("animClassFadeInDownBig")},
                {PropertyLoader.loadProperty("animValueFadeInLeft"), PropertyLoader.loadProperty("animClassFadeInLeft")},
                {PropertyLoader.loadProperty("animValueFadeInLeftBig"), PropertyLoader.loadProperty("animClassFadeInLeftBig")},
                {PropertyLoader.loadProperty("animValueFadeInRight"), PropertyLoader.loadProperty("animClassFadeInRight")},
                {PropertyLoader.loadProperty("animValueFadeInRightBig"), PropertyLoader.loadProperty("animClassFadeInRightBig")},
                {PropertyLoader.loadProperty("animValueFadeInUp"), PropertyLoader.loadProperty("animClassFadeInUp")},
                {PropertyLoader.loadProperty("animValueFadeInUpBig"), PropertyLoader.loadProperty("animClassFadeInUpBig")},
                {PropertyLoader.loadProperty("animValueFlipInX"), PropertyLoader.loadProperty("animClassFlipInX")},
                {PropertyLoader.loadProperty("animValueFlipInY"), PropertyLoader.loadProperty("animClassFlipInY")},
                {PropertyLoader.loadProperty("animValueLightSpeedIn"), PropertyLoader.loadProperty("animClassLightSpeedIn")},
                {PropertyLoader.loadProperty("animValueRotateIn"), PropertyLoader.loadProperty("animClassRotateIn")},
                {PropertyLoader.loadProperty("animValueRotateInDownLeft"), PropertyLoader.loadProperty("animClassRotateInDownLeft")},
                {PropertyLoader.loadProperty("animValueRotateInDownRight"), PropertyLoader.loadProperty("animClassRotateInDownRight")},
                {PropertyLoader.loadProperty("animValueRotateInUpLeft"), PropertyLoader.loadProperty("animClassRotateInUpLeft")},
                {PropertyLoader.loadProperty("animValueRotateInUpRight"), PropertyLoader.loadProperty("animClassRotateInUpRight")},
                {PropertyLoader.loadProperty("animValueRollIn"), PropertyLoader.loadProperty("animClassRollIn")}};
    }

    @DataProvider(name = "colors")
    public static Object[][] getColor() {
        return new Object[][]{{PropertyLoader.loadProperty("colorVarValueDefault"), PropertyLoader.loadProperty("colorClassDefault")},
                {PropertyLoader.loadProperty("colorVarValuePrimary"), PropertyLoader.loadProperty("colorClassPrimary")},
                {PropertyLoader.loadProperty("colorVarValueSuccess"), PropertyLoader.loadProperty("colorClassSuccess")},
                {PropertyLoader.loadProperty("colorVarValueDanger"), PropertyLoader.loadProperty("colorClassDanger")},
                {PropertyLoader.loadProperty("colorVarValueWarnint"), PropertyLoader.loadProperty("colorClassWarningt")},
                {PropertyLoader.loadProperty("colorVarValueInfo"), PropertyLoader.loadProperty("colorClassInfo")},
                {PropertyLoader.loadProperty("colorVarValueFlat"), PropertyLoader.loadProperty("colorClassFlat")},
                {PropertyLoader.loadProperty("colorVarValueTransparent"), PropertyLoader.loadProperty("colorClassTransparent")}};
    }

    @DataProvider(name = "text")
    public static Object[][] setText() {
        return new Object[][]{{PropertyLoader.loadProperty("text1")},
                {PropertyLoader.loadProperty("text20")},
                {PropertyLoader.loadProperty("text50")},
                {PropertyLoader.loadProperty("textAll")}};
    }

    @DataProvider(name = "fName")
    public static Object[][] getPhone() {
        return new Object[][]{{PropertyLoader.loadProperty("text1")},
                {PropertyLoader.loadProperty("text20")},
                {PropertyLoader.loadProperty("textAll")}};
    }
}
