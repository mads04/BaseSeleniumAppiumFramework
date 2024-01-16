package Runner;

import Utilities.WebConnectionUtilities;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static Pages.WebPages.LoginPage.driver;

@CucumberOptions(
        features = "src/test/java/Features", // path to your feature files
        glue = "StepDefinitions",       // package where your step definitions are located
        plugin = {"pretty",
                "html:test-output/cucumber.html",
                "rerun:target/failedrerun.txt"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

    public static String browsertype;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        // Set up logic if needed
        System.out.println("Control is in before class");
    }


    @BeforeClass
    @Parameters({"browserType"})
    public void setUp(String browserType) {
        browsertype = browserType;
        System.out.println("Test Suite started successfully");
    }

    @AfterSuite
    public void AfterSuiteMethod() {
        System.out.println("Test Suite ran successfully");
        try {
            driver.quit();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
