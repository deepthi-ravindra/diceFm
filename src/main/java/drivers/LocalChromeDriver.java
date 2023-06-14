package drivers;

import log.Log;
import net.thucydides.core.webdriver.DriverSource;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class LocalChromeDriver implements DriverSource {
    public WebDriver newDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");

        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        options.setCapability(CapabilityType.PLATFORM_NAME, "MAC");
        options.setAcceptInsecureCerts(true);

        Logger.getRootLogger().setLevel(Level.INFO);
//        System.setProperty("browser", "chrome");
//        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        Log.info("Webdriver for browser: chrome running");

        return driver;
    }

    public boolean takesScreenshots() {
        return true;
    }
}

