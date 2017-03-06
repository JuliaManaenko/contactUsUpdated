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
    public static Object[][] getName() {
        return new Object[][]{{PropertyLoader.loadProperty("text1")},
                {PropertyLoader.loadProperty("text20")},
                {PropertyLoader.loadProperty("textAll")}};
    }

    /*1st element - phone input mask (diff variants), 2nd element - phone number in form and lead details*/
    @DataProvider(name = "phones")
    public static Object[][] getPhone() {
        return new Object[][]{{PropertyLoader.loadProperty("inputMaskL1"), PropertyLoader.loadProperty("phoneL1")},
                {PropertyLoader.loadProperty("inputMaskL2"), PropertyLoader.loadProperty("phoneL2")},
                {PropertyLoader.loadProperty("inputMaskN1"), PropertyLoader.loadProperty("phoneN1")},
                {PropertyLoader.loadProperty("inputMaskN2"), PropertyLoader.loadProperty("phoneN2")},
                {PropertyLoader.loadProperty("inputMaskS1"), PropertyLoader.loadProperty("phoneS1")},
                {PropertyLoader.loadProperty("inputMaskS2"), PropertyLoader.loadProperty("phoneS2")},
                {PropertyLoader.loadProperty("inputMaskNLS1"), PropertyLoader.loadProperty("phoneNLS1")},
                {PropertyLoader.loadProperty("inputMaskNLS2"), PropertyLoader.loadProperty("phoneNLS2")},
                {PropertyLoader.loadProperty("inputMaskLSN1"), PropertyLoader.loadProperty("phoneLSN1")},
                {PropertyLoader.loadProperty("inputMaskLSN2"), PropertyLoader.loadProperty("phoneLSN2")},
                {PropertyLoader.loadProperty("inputMaskMix1"), PropertyLoader.loadProperty("phoneMix1")},
                {PropertyLoader.loadProperty("inputMaskMix2"), PropertyLoader.loadProperty("phoneMix2")}};
    }

    @DataProvider(name = "incorrectPhones")
    public static Object[][] getIncorrectPhone() {
        return new Object[][]{{PropertyLoader.loadProperty("inputMaskL1"), PropertyLoader.loadProperty("phoneMix1")},
                {PropertyLoader.loadProperty("inputMaskL2"), PropertyLoader.loadProperty("phoneLSN2")},
                {PropertyLoader.loadProperty("inputMaskN1"), PropertyLoader.loadProperty("phoneL2")},
                {PropertyLoader.loadProperty("inputMaskN2"), PropertyLoader.loadProperty("phoneS2")},
                {PropertyLoader.loadProperty("inputMaskNLS1"), PropertyLoader.loadProperty("phoneS1")},
                {PropertyLoader.loadProperty("inputMaskNLS2"), PropertyLoader.loadProperty("phoneLSN1")},
                {PropertyLoader.loadProperty("inputMaskLSN1"), PropertyLoader.loadProperty("phoneNLS2")},
                {PropertyLoader.loadProperty("inputMaskLSN2"), PropertyLoader.loadProperty("phoneL2")},
                {PropertyLoader.loadProperty("inputMaskMix1"), PropertyLoader.loadProperty("phoneL1")},
                {PropertyLoader.loadProperty("inputMaskMix2"), PropertyLoader.loadProperty("phoneN1")}};
    }

    @DataProvider(name = "incorrectEmail")
    public static Object[][] getIncorrectEmail() {
        return new Object[][]{{PropertyLoader.loadProperty("nEmail1")},
                {PropertyLoader.loadProperty("nEmail2")},
                {PropertyLoader.loadProperty("nEmail3")},
                {PropertyLoader.loadProperty("nEmail4")},
                {PropertyLoader.loadProperty("nEmail5")},
                {PropertyLoader.loadProperty("nEmail6")},
                {PropertyLoader.loadProperty("nEmail7")},
                {PropertyLoader.loadProperty("nEmail8")},
                {PropertyLoader.loadProperty("nEmail9")},
                {PropertyLoader.loadProperty("nEmail10")},
                {PropertyLoader.loadProperty("nEmail11")},
                {PropertyLoader.loadProperty("nEmail12")},
                {PropertyLoader.loadProperty("nEmail13")},
                {PropertyLoader.loadProperty("nEmail14")},
                {PropertyLoader.loadProperty("nEmail15")},
                {PropertyLoader.loadProperty("nEmail16")},
                {PropertyLoader.loadProperty("nEmail17")},
                {PropertyLoader.loadProperty("nEmail18")},
                {PropertyLoader.loadProperty("nEmail19")},
                {PropertyLoader.loadProperty("nEmail20")},
                {PropertyLoader.loadProperty("nEmail21")},
                {PropertyLoader.loadProperty("nEmail22")},
                {PropertyLoader.loadProperty("nEmail23")},
                {PropertyLoader.loadProperty("nEmail24")},};
    }

    @DataProvider(name = "intPhones")
    public static Object[][] getIntPhone() {
        return new Object[][]{{PropertyLoader.loadProperty("intPhone0"), PropertyLoader.loadProperty("intPhone0")},
                {PropertyLoader.loadProperty("intPhone1"), PropertyLoader.loadProperty("intPhone1")},
                {PropertyLoader.loadProperty("intPhone10"), PropertyLoader.loadProperty("intPhone10")},
                {PropertyLoader.loadProperty("intPhone20"), PropertyLoader.loadProperty("intPhone20")},
                {PropertyLoader.loadProperty("intPhone21"), PropertyLoader.loadProperty("intPhone20")}};
    }

    @DataProvider(name = "comments")
    private static Object[][] putComments() {
        return new Object[][]{{PropertyLoader.loadProperty("comment1"), PropertyLoader.loadProperty("comment1")},
                {PropertyLoader.loadProperty("comment1000"), PropertyLoader.loadProperty("comment1000")},
                {PropertyLoader.loadProperty("comment2000"), PropertyLoader.loadProperty("comment2000")},
                {PropertyLoader.loadProperty("comment2001"), PropertyLoader.loadProperty("comment2000")},
                {PropertyLoader.loadProperty("commentTag"), PropertyLoader.loadProperty("comment1")}};
    }

    @DataProvider(name = "commentsCount")
    private static Object[][] putCommentsCount() {
        return new Object[][]{{PropertyLoader.loadProperty("comment1"), PropertyLoader.loadProperty("count1999")},
                {PropertyLoader.loadProperty("comment1000"), PropertyLoader.loadProperty("count1000")},
                {PropertyLoader.loadProperty("comment2000"), PropertyLoader.loadProperty("count0")},
                {PropertyLoader.loadProperty("comment2001"), PropertyLoader.loadProperty("count0")},
                {PropertyLoader.loadProperty("commentTag"), PropertyLoader.loadProperty("count1999")}};
    }

    @DataProvider(name = "correctVin")
    public static Object[][] putVin() {
        return new Object[][]{{PropertyLoader.loadProperty("vin0"), PropertyLoader.loadProperty("vin0")},
                {PropertyLoader.loadProperty("vin17"), PropertyLoader.loadProperty("vin17")},
                {PropertyLoader.loadProperty("vin18"), PropertyLoader.loadProperty("vin17")},
                {PropertyLoader.loadProperty("vinNum"), PropertyLoader.loadProperty("vinNum")},
                {PropertyLoader.loadProperty("vinLet"), PropertyLoader.loadProperty("vinLet")},
                {PropertyLoader.loadProperty("vinMix"), PropertyLoader.loadProperty("vinMix")}};
    }

    @DataProvider(name = "incorrectVin")
    public static Object[][] putIncorrectVin() {
        return new Object[][]{{PropertyLoader.loadProperty("vin1")},
                {PropertyLoader.loadProperty("vin2")},
                {PropertyLoader.loadProperty("vin3")},
                {PropertyLoader.loadProperty("vin4")},
                {PropertyLoader.loadProperty("vin5")},
                {PropertyLoader.loadProperty("vin6")},
                {PropertyLoader.loadProperty("vin7")},
                {PropertyLoader.loadProperty("vin8")},
                {PropertyLoader.loadProperty("vin9")},
                {PropertyLoader.loadProperty("vin10")},
                {PropertyLoader.loadProperty("vin11")},
                {PropertyLoader.loadProperty("vin12")},
                {PropertyLoader.loadProperty("vin13")},
                {PropertyLoader.loadProperty("vin14")},
                {PropertyLoader.loadProperty("vin15")},
                {PropertyLoader.loadProperty("vin16")},
                {PropertyLoader.loadProperty("vinRus")},
                {PropertyLoader.loadProperty("nVin1")},
                {PropertyLoader.loadProperty("nVin2")},
                {PropertyLoader.loadProperty("nVin3")},
                {PropertyLoader.loadProperty("nVin4")},
                {PropertyLoader.loadProperty("nVin5")},
                {PropertyLoader.loadProperty("nVin6")},
                {PropertyLoader.loadProperty("nVin7")},
                {PropertyLoader.loadProperty("nVin8")},
                {PropertyLoader.loadProperty("nVin9")},
                {PropertyLoader.loadProperty("nVin10")},
                {PropertyLoader.loadProperty("nVin11")},
                {PropertyLoader.loadProperty("nVin12")},
                {PropertyLoader.loadProperty("nVin13")},
                {PropertyLoader.loadProperty("nVin14")},
                {PropertyLoader.loadProperty("nVin15")},
                {PropertyLoader.loadProperty("nVin16")},
                {PropertyLoader.loadProperty("nVin17")},
                {PropertyLoader.loadProperty("nVin18")},
                {PropertyLoader.loadProperty("nVin19")},
                {PropertyLoader.loadProperty("nVin20")},
                {PropertyLoader.loadProperty("nVin21")},
                {PropertyLoader.loadProperty("nVin22")},
                {PropertyLoader.loadProperty("nVin23")},
                {PropertyLoader.loadProperty("nVin24")},
                {PropertyLoader.loadProperty("nVin25")},
                {PropertyLoader.loadProperty("nVin26")},
                {PropertyLoader.loadProperty("nVin27")},
                {PropertyLoader.loadProperty("nVin28")},
                {PropertyLoader.loadProperty("nVin29")},
                {PropertyLoader.loadProperty("nVin30")}};
    }

    @DataProvider(name = "years")
    public static Object[][] getYear() {
        return new Object[][]{{"Select Year"},{"2018"},{"2017"},{"2016"},{"2015"},{"2014"},{"2013"},{"2012"},{"2011"},{"2010"},{"2009"},
               // {"2008"},{"2007"},{"2006"},{"2005"},{"2004"},{"2003"},{"2002"},{"2001"},{"2000"},{"1999"},{"1998"},{"1997"},
               // {"1996"},{"1995"},{"1994"},{"1993"},{"1992"},{"1991"},{"1990"},{"1989"},{"1988"},{"1987"},{"1986"},{"1985"},
        };
    }

    //TODO: finish with all years
    @DataProvider(name = "yearsLead")
    public static Object[][] getYearLead() {
        return new Object[][]{{"Select Year", ""},{"2018", "2018"},{"2017", "2017"},{"2016", "2016"},{"2015", "2015"},
                                 {"2014", "2014"},{"2013", "2013"},{"2012", "2012"},{"2011", "2011"},{"2010", "2010"},
                                 {"2009", "2009"},{"2008", "2008"},{"2007", "2007"},{"2006", "2006"},{"2005", "2005"},
                                 {"2004", "2004"},{"2003", "2003"},{"2002", "2002"},{"2001", "2001"},{"2000", "2000"},
                                 {"1999", "1999"},{"1998", "1998"},{"1997", "1997"},{"1996", "1996"},{"1995", "1995"},
                                 {"1994", "1994"},{"1993", "1993"},{"1992", "1992"},{"1991", "1991"},{"1990", "1990"},
                                 {"1989", "1989"},{"1988", "1988"},{"1987", "1987"},{"1986", "1986"},{"1985", "1985"},
                {"1984", "1984"}, {"1983", "1983"}, {"1982", "1982"}, {"1981", "1981"}, {"1980", "1980"},
                {"1979", "1979"}, {"1978", "1978"}, {"1977", "1977"}, {"1976", "1976"}, {"1975", "1975"},
                {"1974", "1974"}, {"1973", "1973"}, {"1972", "1972"}, {"1971", "1971"}, {"1970", "1970"},
                {"1969", "1969"}, {"1968", "1968"}, {"1967", "1967"}, {"1966", "1966"}, {"1965", "1965"},
                {"1964", "1964"}, {"1963", "1963"}, {"1962", "1962"}, {"1961", "1961"}, {"1960", "1960"},
                {"1959", "1959"}, {"1958", "1958"}, {"1957", "1957"}, {"1956", "1956"}, {"1955", "1955"},
                {"1954", "1954"}, {"1953", "1953"}, {"1952", "1952"}, {"1951", "1951"}, {"1950", "1950"},
                {"1949", "1949"}, {"1948", "1948"}, {"1947", "1947"}, {"1946", "1946"}, {"1945", "1945"},
                {"1944", "1944"}, {"1943", "1943"}, {"1942", "1942"}, {"1941", "1941"}, {"1940", "1940"},
                {"1939", "1939"}, {"1938", "1938"}, {"1937", "1937"}, {"1936", "1936"}, {"1935", "1935"},
                {"1934", "1934"}, {"1933", "1933"}, {"1932", "1932"}, {"1931", "1931"}, {"1930", "1930"},
                {"1929", "1929"}, {"1928", "1928"}, {"1927", "1927"}, {"1926", "1926"}, {"1925", "1925"},
                {"1924", "1924"}, {"1923", "1923"}, {"1922", "1922"}, {"1921", "1921"}, {"1920", "1920"},
                {"1919", "1919"}, {"1918", "1918"}, {"1917", "1917"}, {"1916", "1916"}, {"1915", "1915"},
                {"1914", "1914"}, {"1913", "1913"}, {"1912", "1912"}, {"1911", "1911"}, {"1910", "1910"},
                {"1909", "1909"}, {"1908", "1908"}, {"1907", "1907"}, {"1906", "1906"}, {"1905", "1905"},
                {"1904", "1904"}, {"1903", "1903"}, {"1902", "1902"}, {"1901", "1901"}};
    }

    @DataProvider(name = "incorrectPrice")
    public static Object[][] getIncorrectPrice() {
        return new Object[][]{{PropertyLoader.loadProperty("char1")},
                {PropertyLoader.loadProperty("char2")},
                {PropertyLoader.loadProperty("char3")},
                {PropertyLoader.loadProperty("char4")},
                {PropertyLoader.loadProperty("char5")},
                {PropertyLoader.loadProperty("char6")},
                {PropertyLoader.loadProperty("char7")},
                {PropertyLoader.loadProperty("char8")},
                {PropertyLoader.loadProperty("char9")},
                {PropertyLoader.loadProperty("char10")},
                {PropertyLoader.loadProperty("char11")},
                {PropertyLoader.loadProperty("char12")},
                {PropertyLoader.loadProperty("char13")},
                {PropertyLoader.loadProperty("char14")},
                {PropertyLoader.loadProperty("char15")},
                {PropertyLoader.loadProperty("char16")},
                {PropertyLoader.loadProperty("char17")},
                {PropertyLoader.loadProperty("char18")},
                {PropertyLoader.loadProperty("char19")},
                {PropertyLoader.loadProperty("char20")},
                {PropertyLoader.loadProperty("char21")},
                {PropertyLoader.loadProperty("char22")},
                {PropertyLoader.loadProperty("char23")},
                {PropertyLoader.loadProperty("char24")},
                {PropertyLoader.loadProperty("char25")},
                {PropertyLoader.loadProperty("char26")},
                {PropertyLoader.loadProperty("char27")},
                {PropertyLoader.loadProperty("char28")},
                {PropertyLoader.loadProperty("char29")},
                {PropertyLoader.loadProperty("char30")},
                {PropertyLoader.loadProperty("let1")},
                {PropertyLoader.loadProperty("let2")},
                {PropertyLoader.loadProperty("let3")},
                {PropertyLoader.loadProperty("let4")},
                {PropertyLoader.loadProperty("let5")},
                {PropertyLoader.loadProperty("let6")},
                {PropertyLoader.loadProperty("let7")},
                {PropertyLoader.loadProperty("let8")},
                {PropertyLoader.loadProperty("let9")},
                {PropertyLoader.loadProperty("let10")},
                {PropertyLoader.loadProperty("let11")},
                {PropertyLoader.loadProperty("let12")},
                {PropertyLoader.loadProperty("let13")},
                {PropertyLoader.loadProperty("let14")},
                {PropertyLoader.loadProperty("let15")},
                {PropertyLoader.loadProperty("let16")},
                {PropertyLoader.loadProperty("let17")},
                {PropertyLoader.loadProperty("let18")},
                {PropertyLoader.loadProperty("let19")},
                {PropertyLoader.loadProperty("let20")},
                {PropertyLoader.loadProperty("let21")},
                {PropertyLoader.loadProperty("let22")},
                {PropertyLoader.loadProperty("let23")},
                {PropertyLoader.loadProperty("let24")},
                {PropertyLoader.loadProperty("let25")},
                {PropertyLoader.loadProperty("let26")}};
    }

    @DataProvider(name = "correctPrice")
    public static Object[][] getCorrectPrice() {
        return new Object[][]{{PropertyLoader.loadProperty("number0"), PropertyLoader.loadProperty("number00")},
                {PropertyLoader.loadProperty("number1"), PropertyLoader.loadProperty("number1")},
                {PropertyLoader.loadProperty("number10"), PropertyLoader.loadProperty("number10L")}};
    }

    @DataProvider(name = "correctOdometer")
    public static Object[][] getCorrectOdometer() {
        return new Object[][]{{PropertyLoader.loadProperty("number0"), PropertyLoader.loadProperty("number00")},
                {PropertyLoader.loadProperty("number1"), PropertyLoader.loadProperty("number1")},
                {PropertyLoader.loadProperty("number10"), PropertyLoader.loadProperty("number10L")},
                {PropertyLoader.loadProperty("number11"), PropertyLoader.loadProperty("number10L")}};
    }

    @DataProvider(name = "motorizedType")
    public static Object[][] getMotorizedType() {
        return new Object[][]{{"Select Motorized Type", ""},
                {PropertyLoader.loadProperty("AGRICULTURAL_EQUIPMENT"), PropertyLoader.loadProperty("AGRICULTURAL_EQUIPMENT")},
                {PropertyLoader.loadProperty("AIRCRAFT"), PropertyLoader.loadProperty("AIRCRAFT")},
                {PropertyLoader.loadProperty("ATVs"), PropertyLoader.loadProperty("ATVs")},
                {PropertyLoader.loadProperty("BOAT"), PropertyLoader.loadProperty("BOAT")},
                {PropertyLoader.loadProperty("CARS_TRUCKS_VANS"), PropertyLoader.loadProperty("CARS_TRUCKS_VANS")},
                {PropertyLoader.loadProperty("COMMERCIAL_TRUCKS"), PropertyLoader.loadProperty("COMMERCIAL_TRUCKS")},
                {PropertyLoader.loadProperty("CONSTRUCTION_EQUIPMENT"), PropertyLoader.loadProperty("CONSTRUCTION_EQUIPMENT")},
                {PropertyLoader.loadProperty("DISMANTLED_MACHINE"), PropertyLoader.loadProperty("DISMANTLED_MACHINE")},
                {PropertyLoader.loadProperty("GO_KARTS_COOTERS"), PropertyLoader.loadProperty("GO_KARTS_COOTERS")},
                {PropertyLoader.loadProperty("LIGHT_TRUCK"), PropertyLoader.loadProperty("LIGHT_TRUCK")},
                {PropertyLoader.loadProperty("MILITARY_VEHICLES"), PropertyLoader.loadProperty("MILITARY_VEHICLES")},
                {PropertyLoader.loadProperty("MOTORCYCLE"), PropertyLoader.loadProperty("MOTORCYCLE")},
                {PropertyLoader.loadProperty("OTHER"), PropertyLoader.loadProperty("OTHER")},
                {PropertyLoader.loadProperty("PWC/ATV"), PropertyLoader.loadProperty("PWC/ATV")},
                {PropertyLoader.loadProperty("RVs_CAMPERS"), PropertyLoader.loadProperty("RVs_CAMPERS")},
                {PropertyLoader.loadProperty("SAVING_PLANS_(CARS)"), PropertyLoader.loadProperty("SAVING_PLANS_(CARS)")},
                {PropertyLoader.loadProperty("SNOWMOBILES"), PropertyLoader.loadProperty("SNOWMOBILES")},
                {PropertyLoader.loadProperty("TRAILERS"), PropertyLoader.loadProperty("TRAILERS")},
        };
    }
}
