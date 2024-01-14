package Pages.WebPages;

import Utilities.WebConnectionUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends WebConnectionUtilities {

   public static WebDriver driver = null;


    WebConnectionUtilities connectionutility;
    @FindBy(xpath = "//input[@name='ide_username']")
    WebElement Username;
    @FindBy(xpath = "//input[@name = 'ide_password']")
    WebElement Password;

    public LoginPage(){
        connectionutility =new WebConnectionUtilities();
        driver = connectionutility.initializeWebDriver();
        PageFactory.initElements(driver,this);

    }

    public void LaunchWebPage(){
        driver.get(String.valueOf(prop.getProperty("pageurl")));
    }

}
