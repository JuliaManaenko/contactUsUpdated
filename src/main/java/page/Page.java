/*parent class for all page objects*/
package page;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import utility.LogFactory;


/**
 * Created by Julia on 30.12.2016.
 */
public class Page {
    private static final Logger LOG = LogFactory.getLogger(Page.class);

    protected WebDriver driver;

        /*
         * Constructor injecting the WebDriver interface
         *
         * @param webDriver
         */

    public Page(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        String pageUrl = driver.getCurrentUrl();
        LOG.info("Current page url is: " + pageUrl);
        return pageUrl;
    }
}
