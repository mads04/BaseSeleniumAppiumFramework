package StepDefinitions;

import Pages.WebPages.LoginPage;
import Utilities.WebConnectionUtilities;
import io.cucumber.java.en.Given;

import static Pages.WebPages.LoginPage.driver;
import static Runner.TestRunner.browsertype;

public class LoginPagestepdefinition {


    @Given("User is in login page")
    public void userIsInLoginPage() {
        LoginPage loginpage = new LoginPage();
        WebConnectionUtilities connectionutility = new WebConnectionUtilities();
        System.out.println("User is in login page");
        if(browsertype.equalsIgnoreCase("web")) {
            driver = connectionutility.initializeWebDriver();
            loginpage.LaunchWebPage();
        }else{
            driver = connectionutility.initializeAppiumDriver();
            System.out.println("appium params called");
        }
    }


}
