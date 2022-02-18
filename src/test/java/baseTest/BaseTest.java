package baseTest;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext context) throws MalformedURLException {
        String host = "localhost";
        MutableCapabilities capabilities;

        if (System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            capabilities = new FirefoxOptions();
        } else {
            capabilities = new ChromeOptions();
        }

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://" + host + ":4444/wd/hub";
        capabilities.setCapability("name", context.getCurrentXmlTest().getName());
        this.driver = new RemoteWebDriver(new URL(completeUrl), capabilities);
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}