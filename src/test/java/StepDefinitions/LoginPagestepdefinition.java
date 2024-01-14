package StepDefinitions;

import Pages.WebPages.LoginPage;
import io.cucumber.java.en.Given;

public class LoginPagestepdefinition {


    @Given("User is in login page")
    public void userIsInLoginPage() {
        LoginPage loginpage = new LoginPage();
        // Add your code to navigate to the login page or perform any necessary setup
        System.out.println("User is in login page");
        loginpage.LaunchWebPage();
    }
}
