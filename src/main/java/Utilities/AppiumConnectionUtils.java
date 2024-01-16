package Utilities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class AppiumConnectionUtils {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        // TODO Auto-generated method stub
        AndroidDriver driver = null;
        File f = new File("src/main/resources/AppiumResources/goibibo_17.4.3.apk");
        File fs = new File(f, "goibibo_17.4.3.apk");


        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Pixel4");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "12.0");
        cap.setCapability("app", fs.getAbsolutePath());
        cap.setCapability("appium:automationName", "Appium");
        cap.setCapability("appium:newCommandTimeout", "5");
        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);

        }catch(Exception e){

        }
        //Android UI automator
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@text='Enter Mobile Number']")));
        System.out.println(driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Mobile Number']")).isDisplayed());
        driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Mobile Number']")).sendKeys("12344");
        driver.quit();
    }

}
