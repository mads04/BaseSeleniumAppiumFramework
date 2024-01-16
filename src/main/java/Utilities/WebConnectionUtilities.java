package Utilities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class WebConnectionUtilities {
    public WebDriver rdriver = null;
    public AndroidDriver driver = null;
    public static Properties prop = null;

    public WebConnectionUtilities() {
        prop = new Properties();
        try {
            FileInputStream input = new FileInputStream("src/main/resources/config.properties");
            prop.load(input);
        } catch (Exception e) {
            System.out.println(e);
        }


    }


    public WebDriver initializeWebDriver() {
        String browserName = prop.getProperty("browserName");
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
            rdriver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxpath"));
            rdriver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", prop.getProperty("edgepath"));
            rdriver = new EdgeDriver();

        }
        return rdriver;
    }


    public AndroidDriver initializeAppiumDriver() {
        // TODO Auto-generated method stub
        File f = new File("src/main/resources/AppiumResources");
        File fs = new File(f, "goibibo_17.4.3.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Pixel4");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "12.0");
        cap.setCapability("app", fs.getAbsolutePath());
        cap.setCapability("appium:automationName", "Appium");
        cap.setCapability("appium:newCommandTimeout", "5");
        try {
            rdriver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        } catch (Exception e) {

        }
        return (AndroidDriver) rdriver;
    }


}

