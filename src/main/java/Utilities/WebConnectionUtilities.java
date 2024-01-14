package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class WebConnectionUtilities {
    public WebDriver rdriver = null;
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

    public  WebDriver initializeWebDriver() {
        String browserName = prop.getProperty("browserName");
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",prop.getProperty("chromepath"));
            rdriver = new ChromeDriver();
        }

        else if (browserName.equalsIgnoreCase( "firefox")){
            System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxpath"));
            rdriver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase( "edge")){
            System.setProperty("webdriver.edge.driver", prop.getProperty("edgepath"));
            rdriver = new EdgeDriver();

        }

        return rdriver;
    }
}
