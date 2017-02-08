/*Class for initializing browsers*/
package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 30.12.2016.
 */
public class WebDriverFactory {
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String IE = "ie";

    private static WebDriver driver;

    private WebDriverFactory() {

    }

    public static WebDriver getInstance(String browser) {
        if (driver == null) { //if no driver is starting before
            // for chrome browser
            if (CHROME.equals(browser)) {
                setChromeDriver();
                driver = new ChromeDriver();
                // for firefox browser
            } else if (FIREFOX.equals(browser)) {
                // System.setProperty("webdriver.gecko.driver", "src/main/drivers/firefox-win/geckodriver.exe");
                System.setProperty("webdriver.gecko.driver", "D://geckodriver.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                driver = new FirefoxDriver(capabilities);
               // driver = new FirefoxDriver();
               // FirefoxDriver driver=new FirefoxDriver();

                // for ie browser
            } else if (IE.endsWith(browser)) {
                String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
                String ieBinary = "src/main/resources/drivers/ie-win/IEDriverServer" + (os.equals("win") ? ".exe" : "");
                System.setProperty("webdriver.ie.driver", ieBinary);
                driver = new InternetExplorerDriver();

            } else
                throw new RuntimeException("Invalid browser property set in configuration file");

            driver.manage().window().maximize(); //open browser in full window view
            driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS); //wait for each webElement is loaded
        }

        return driver;
    }

    /*close the browser*/
    public static void killDriverInstance() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    /*method for running chrome browser depending of operation system*/
    private static void setChromeDriver() {
        String osName = System.getProperty("os.name").toLowerCase();
        StringBuffer chromeBinaryPath = new StringBuffer(
                "src/main/resources/drivers/");

        if (osName.startsWith("win")) {
            chromeBinaryPath.append("chrome-win/chromedriver.exe");
        } else if (osName.startsWith("lin")) {
            chromeBinaryPath.append("chrome-lin/chromedriver");
        } else if (osName.startsWith("mac")) {
            chromeBinaryPath.append("chrome-mac/chromedriver");
        } else
            throw new RuntimeException("Your OS is invalid for webdriver tests");

        System.setProperty("webdriver.chrome.driver",
                chromeBinaryPath.toString());
    }
}
